package com;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerListener extends Thread{
    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(8088);
            while (true){
                Socket socket = serverSocket.accept();
                System.out.println("来了一个");
                //因为每个Socket 要独立的与一个客户端进行通信，所以另起一个线程。
                ChatSocket chatSocket =new ChatSocket(socket);
                chatSocket.start();
                ChatManager.getChatManager().add(chatSocket);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
