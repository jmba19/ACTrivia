package org.academiadecodigo.argicultores;

import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ServerHandler implements Runnable {
    private String name;
    private BufferedReader br;
    private BufferedWriter bw;
    private Socket player;
    private Server server;
    private InputStream inputToServer;
    private OutputStream outputFromServer;
    String matriz1[][] = {{"1          ", "2         ", "3         "}, {"4          ", "5         ", "6          ",}};
    String matriz[][] = {{"Paris          ", "londres        ", "Rio            "}, {"Luanda         ", "Nova iorque    ", "Roma           ",}};
    BufferedReader bufferedReader;
    PrintWriter serverPrintOut;

    public ServerHandler(Socket player, Server server) {
        this.player = player;
        this.server = server;
    }

    @Override
    public void run() {
        openStreams();

        welcomeMessage();
        try {
            fisrtBlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    public void openStreams() {
        try {
            inputToServer = player.getInputStream();
            Scanner scanner = new Scanner(System.in);
            outputFromServer = player.getOutputStream();
            bufferedReader = new BufferedReader(new InputStreamReader(inputToServer));
            serverPrintOut = new PrintWriter(outputFromServer, true);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void welcomeMessage() {
        serverPrintOut.println("WELCOME TO THE END OF THE FUCKING WORLD");
        StringInputScanner username = new StringInputScanner();
        serverPrintOut.println("--------------------\n" +
                "\n" +
                "\n" +
                "\n" +
                "ARE YOU WILLING TO RISK?" +
                "\n" +
                "\n" +
                "\n" +
                "-------------------------");


    }

    public void printMatriz() {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                serverPrintOut.printf(matriz[i][j] + " ");
            }
            serverPrintOut.println(" ");
        }
    }


    public void fisrtBlock() throws InterruptedException {
        memoriseMessage();
        Thread.sleep(5000);
        printingFirstMap();
        Thread.sleep(5000);
        firstAnswer();
        Thread.sleep(4000);
        serverPrintOut.println("YOU ARE GOING OK");
    }

    public void memoriseMessage() {
        serverPrintOut.println("MEMORISE");
        StringInputScanner username = new StringInputScanner();
        serverPrintOut.println("--------------------\n" +
                "\n" +

                "\n" +
                "-------------------------");
    }

    public void printingFirstMap() {
        printMatriz();
    }

    public void firstAnswer() {
        question1();
        printMatriz1();
        gettinganswer();

    }

    public void question1() {
        serverPrintOut.println("" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "WHICH ONE IS THE CAPITAL OF FRANCE");

        serverPrintOut.println("--------------------" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n " +
                "\n" +
                "-------------------------");
    }
    public void printMatriz1() {
        for (int i = 0; i < matriz1.length; i++) {
            for (int j = 0; j < matriz1[0].length; j++) {
                serverPrintOut.printf(matriz1[i][j] + " ");
            }
            serverPrintOut.println(" ");
        }
    }
    public void gettinganswer() {

        serverPrintOut.println("" +
                "\n" +
                "\n" +
                "\n" +
                "TYPE YOUR ANSWER");
        try {

            String firstans = bufferedReader.readLine();
            if (firstans.equals("1")) {
                serverPrintOut.println("YEAHHHHHHHHHHHHHHHH");
            }
            if (!firstans.equals("1")) {

                serverPrintOut.println("WRONG ANSWER");
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void secondBlock(){
        memoriseMessage();
        Thread.sleep(4000);


    }
}
