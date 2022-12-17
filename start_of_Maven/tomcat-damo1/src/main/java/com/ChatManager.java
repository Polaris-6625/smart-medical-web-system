package com;

import java.util.Vector;

public class ChatManager {
    private ChatManager(){

    }
    private static final ChatManager cm = new ChatManager();
    public static ChatManager getChatManager(){
        return cm;
    }
    Vector<ChatSocket> vector = new Vector<ChatSocket>();
    public void add(ChatSocket chatSocket){
        vector.add(chatSocket);
    }
    public void publish(ChatSocket chatSocket,String out){
        for(int i = 0;i < vector.size();i++){
            ChatSocket cs = vector.get(i);
            if(!cs.equals(chatSocket)){
                cs.out(out);
            }
        }
    }
}
