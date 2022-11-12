package core;
import java.io.*;
import  java.net.*;
import java.util.*;

import static core.Global.NUMPLAYER;

public class GameServer implements Runnable {
    private DatagramSocket socket;
    private DatagramPacket receivePacket, sendPacket;
    byte[] bufSend, bufReceived;
    private List<DatagramPacket> clients = new ArrayList<DatagramPacket>(3);
    private List<Player> players = new ArrayList<Player>(3);
    private int checkWin = 0;

    public GameServer (int port) throws SocketException {
        socket = new DatagramSocket(port);
    }

    public void start() throws ClassNotFoundException, IOException {
        for (int i = 0; i < NUMPLAYER; i ++) {
            System.out.println("Server: Waiting for players...\n");
            // receive player name
            bufReceived = new byte[1024];
            receivePacket = new DatagramPacket(bufReceived, bufReceived.length);
            socket.receive(receivePacket);
            clients.add(receivePacket); // Add to  list of player clients
            String receivedMessage = (String) Data.fromByteArray(receivePacket.getData());
            Player newPlayer = new Player(receivedMessage);
            players.add(newPlayer);
            System.out.println("Player Entered game: " + receivedMessage);
        }
        while (true) {
            for(int i =0; i < NUMPLAYER; i ++) {
                Player player = players.get(i);
                receivePacket = clients.get(i);

                // send player object
                bufSend = Data.toByteArray(player);
                sendPacket = new DatagramPacket(bufSend, bufSend.length,
                        receivePacket.getAddress(), receivePacket.getPort());
                socket.send(sendPacket);
                System.out.println("Sent player: " + player.getName());

                // receive player object
                bufReceived = new byte[1024];
                receivePacket = new DatagramPacket(bufReceived, bufReceived.length);
                socket.receive(receivePacket);

                Player receivedPlayer = (Player) Data.fromByteArray(receivePacket.getData());
                System.out.println("Received player: " + receivedPlayer.getName());
                players.remove(player);
                players.add(i, receivedPlayer);

                // check if island of skulls
                if(receivedPlayer.getIslandOfSkulls()) {
                    int scoreToDeduct = receivedPlayer.lastScore;
                    for (int j =0; j < 3; j ++) {
                        if (j != i) {
                            players.get(j).deductScore(scoreToDeduct);
                            System.out.println("Deducted " + scoreToDeduct + " from " + players.get(j).getName());
                        }
                    }
                    receivedPlayer.setIslandOfSkulls(false);
                }

                for (Player p : players) {
                    System.out.println("Score of" + p.getName() + ": " + p.getScore());
                }
                // check score
                if(receivedPlayer.getScore() >= 3000 || checkWin != 0) {
                    this.checkWin++;
                    if (this.checkWin == NUMPLAYER) {
                        break;
                    }
                }
            }
            for (Player p : players) {
                System.out.println("Score of" + p.getName() + ": " + p.getScore());
            }
            if (checkWin == NUMPLAYER) {
                Player p = Global.highestScore(players);
                if (p.getScore() >= 3000) {
                    System.out.println(p.getName() + " won the game");
                    for(int i =0; i < NUMPLAYER; i ++) {
                        Player player = players.get(i);
                        player.gameover = true;
                        receivePacket = clients.get(i);

                        // send player object
                        bufSend = Data.toByteArray(player);
                        sendPacket = new DatagramPacket(bufSend, bufSend.length,
                                receivePacket.getAddress(), receivePacket.getPort());
                        socket.send(sendPacket);
                        System.out.println("Sent game over to player: " + player.getName());
                    }
                    break;
                } else {
                    this.checkWin = 0;
                }
            }
        }
        closeSocket();
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

    public static void main(String args[]) throws IOException, InterruptedException, ClassNotFoundException {
        GameServer gc = new GameServer(8080);
        gc.start();
    }
}
