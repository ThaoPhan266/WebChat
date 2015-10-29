/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.na.model;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

/**
 *
 * @author Thao
 */
public class ChatMessageEncoder implements Encoder.Text<ChatMessage>{

    @Override
    public String encode(ChatMessage msg) throws EncodeException {
        return msg.getJson().toString();
    }

    @Override
    public void init(EndpointConfig config) {
        System.out.println("Encoder Init");
    }

    @Override
    public void destroy() {
        System.out.println("Encoder Destroy");
    }    
}
