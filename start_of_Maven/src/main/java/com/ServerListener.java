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
                System.out.println("����һ��");
                //��Ϊÿ��Socket Ҫ��������һ���ͻ��˽���ͨ�ţ���������һ���̡߳�
                ChatSocket chatSocket =new ChatSocket(socket);
                chatSocket.start();
                ChatManager.getChatManager().add(chatSocket);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
