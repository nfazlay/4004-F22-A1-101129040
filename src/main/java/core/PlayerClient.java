package core;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class PlayerClient implements Runnable{
    private InetAddress ip;
    private DatagramSocket socket;
    private int port;
    byte[] bufSend;
    DatagramPacket sendPacket, receivePacket;

    String name = "";

    Player player;

    public PlayerClient () {
        try {
            // Construct a datagram socket and bind it to any available port on the local host machine.
            //This socket will be used to send and receive UDP Datagram packets.
            socket = new DatagramSocket();
            this.port = 8080;
            this.ip = InetAddress.getLocalHost();
        } catch (SocketException se) {
            se.printStackTrace();
            System.exit(1);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }

    public int getPort () {
        return this.port;
    }

    public void start() throws InterruptedException, IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);  // Create a Scanner object
        System.out.print("Please enter your name: ");
        String userResponse = sc.nextLine().toString();
        name = userResponse;
        bufSend = Data.toByteArray(userResponse);
        sendPacket = new DatagramPacket(bufSend, bufSend.length,
                ip, port);
        socket.send(sendPacket);
        while (true) { // Send connection request to server
            // Receive player
            byte[] bufReceived = new byte[1024];
            receivePacket = new DatagramPacket(bufReceived, bufReceived.length);
            socket.receive(receivePacket);

            Player receivedPlayer = (Player) Data.fromByteArray(receivePacket.getData());
            System.out.println("Received player: " + receivedPlayer.getName() + " from server");

            player = receivedPlayer;

            // Do magic here
            if (player.gameover) {
                System.out.println("Game over. Check server for winner");
                break;
            } else {
                player.play();
            }

            // sending updated player object
            bufSend = Data.toByteArray(player);
            sendPacket = new DatagramPacket(bufSend, bufSend.length,
                    ip, port);
            socket.send(sendPacket);
            System.out.println("Sent player: " + receivedPlayer.getName() + " to server");
        }
        closeSocket ();
    }

    public void closeSocket () {
        socket.close();
        System.out.println("Closing socket for player: " + name);
    }

    @Override
    public void run() {
        try {
            start();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String args[]) throws IOException, InterruptedException, ClassNotFoundException {
        PlayerClient pc = new PlayerClient();
        pc.start();
    }
}