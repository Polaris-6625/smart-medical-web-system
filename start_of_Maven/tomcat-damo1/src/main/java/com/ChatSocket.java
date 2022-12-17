package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ChatSocket extends Thread{
    Socket socket;
    public ChatSocket(Socket s){
        this.socket = s;

    }
    public void out(String out){
        try {
            socket.getOutputStream().write(out.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
            String line = null;
            while ((line=bufferedReader.readLine())!=null){
                ChatManager.getChatManager().publish(this,line);
            }
            bufferedReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
