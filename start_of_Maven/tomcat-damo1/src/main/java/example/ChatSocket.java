package example;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ChatSocket extends Thread{
    Socket socket;
    public ChatSocket(Socket s){
        this.socket = s;
    }

    @Override
    public void run() {
        try {

            BufferedWriter bufferedWriter = new BufferedWriter(
                    new OutputStreamWriter(
                            socket.getOutputStream()));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
