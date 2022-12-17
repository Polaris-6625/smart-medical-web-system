package example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerListener extends Thread{
    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            while (true){
                Socket socket = serverSocket.accept();//这个会阻塞线程
                // 将socket传递给新的线程

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
