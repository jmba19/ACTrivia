package org.academiadecodigo.argicultores;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    public final static int PORT=8040;
    public final static int MAXPLAYERS=2;
    private ServerSocket socket;
    private static  List<ServerHandler> players;
    private ExecutorService game;

    public Server(){
        try {
            socket = new ServerSocket(PORT);

        } catch (IOException e) {
            e.printStackTrace();
        }
        players= Collections.synchronizedList(new LinkedList<>());
        game = Executors.newFixedThreadPool(2);


    }

    public void start(int port){
        int connectedPlayers=0;
        try {
            while (true){
                System.out.println("Waiting for connection");
                Socket player = socket.accept();
                System.out.println("client accepted");
                connectedPlayers++;

                ServerHandler serverHandler = new ServerHandler(player,this);
                connectedPlayers++;
                game.submit(serverHandler);
                System.out.println(connectedPlayers);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void broadCast(String message){
        synchronized (players){
            for (ServerHandler serverHandler: players){
            }
        }
    }

    public static void main(String[] args) {

        Server server= new Server();
        server.start(PORT);
    }

}
