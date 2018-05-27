package com.example.springbootDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wangdi on 2017/8/17.
 */
@RestController
public class GreetingController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/hello-socket")
    @SendTo("/topic/greetings")
    public String greeting(@RequestParam String name) throws InterruptedException {
        Thread.sleep(1000); // simulated delay
        String s = "Hello, " + name + "!";
        return s;
//        simpMessagingTemplate.convertAndSend("/topic/greetings",s);
    }
}
