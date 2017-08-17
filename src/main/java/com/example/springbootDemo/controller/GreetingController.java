package com.example.springbootDemo.controller;

import com.example.springbootDemo.dto.HelloMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

/**
 * Created by wangdi on 2017/8/17.
 */
@Controller
public class GreetingController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/hello")
//    @SendToUser("/topic/greetings")
    public void greeting(HelloMessage message) throws InterruptedException {
        Thread.sleep(1000); // simulated delay
        String s = "Hello, " + message.getName() + "!";
//        return new Greeting(s);
        simpMessagingTemplate.convertAndSend("/topic/greetings",s);
    }


}
