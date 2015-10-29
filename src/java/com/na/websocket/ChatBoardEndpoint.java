
package com.na.websocket;


import com.na.model.ChatMessage;
import com.na.model.ChatMessageDecoder;
import com.na.model.ChatMessageEncoder;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author Thao
 */
@ServerEndpoint(value = "/chatboardendpoint",
        encoders = {ChatMessageEncoder.class},
        decoders = {ChatMessageDecoder.class})
public class ChatBoardEndpoint {
    
    private static Set<Session> peers = Collections.synchronizedSet(new HashSet<Session>());

    @OnMessage
    public void broadcastMessage(ChatMessage msg, Session session) throws IOException, EncodeException{
        System.out.println("Broadcast Message: " + msg);
        for(Session peer : peers){
            if(!peer.equals(session)){
                peer.getBasicRemote().sendObject(msg);
            }
        }
    }
    @OnOpen
    public void onOpen(Session peer){
        peers.add(peer);
    }
    @OnClose
    public void onClose(Session peer){
        peers.remove(peer);
    }
    
}
