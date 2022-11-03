package core;
import java.io.*;
import  java.net.*;
import java.util.*;

public class GameServer implements Runnable {
    private DatagramSocket socket;
    private DatagramPacket receivePacket, sendPacket;
    byte[] bufSend;
    private List<DatagramPacket> clients = new ArrayList<DatagramPacket>(3);
    private List<Player> players = new ArrayList<Player>(3);

    public GameServer (int port) throws SocketException {
        socket = new DatagramSocket(port);
    }

    public void start() throws IOException, ClassNotFoundException {
        for (int i = 0; i < 3; i ++) {
            System.out.println("Server: Waiting for players...\n");
            byte[] bufReceived = new byte[1024];
            receivePacket = new DatagramPacket(bufReceived, bufReceived.length);
            socket.receive(receivePacket);
            clients.add(receivePacket); // Add to  list of player clients
            String receivedMessage = (String) Data.fromByteArray(receivePacket.getData());
            Player newPlayer = new Player(receivedMessage);
            System.out.println(players.size());
            System.out.println("Player Entered game: " + receivedMessage);
        }
        while (true) {
            for(int i =0; i < 3; i ++) {
                receivePacket = clients.get(i);
                String message = new String("Response from server");
                bufSend = Data.toByteArray(message);
                sendPacket = new DatagramPacket(bufSend, bufSend.length,
                        receivePacket.getAddress(), receivePacket.getPort());
                socket.send(sendPacket);
            }
        }
    }

    public void closeSocket () {
        socket.close();
        System.out.println("Closing game server...");
    }

    public List getPlayerList () {
        return this.players;
    }

    @Override
    public void run() {
        try {
            start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
