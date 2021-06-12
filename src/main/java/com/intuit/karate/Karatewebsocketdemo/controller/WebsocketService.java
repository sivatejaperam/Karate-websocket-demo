package com.intuit.karate.Karatewebsocketdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class WebsocketService {

    @Autowired
    SimpMessagingTemplate template;

    public void broadCast(Greeting message) {
        template.convertAndSend("/topic/greetings", message);
    }
}
