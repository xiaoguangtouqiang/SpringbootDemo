package com.example.springbootDemo.controller;

import com.example.springbootDemo.dto.GitHubUser;
import com.example.springbootDemo.service.GitHubLookupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Created by wangdi on 2017/8/17.
 */
@RestController
public class GitHubController {

    @Autowired
    private GitHubLookupService gitHubLookupService;

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;


    @MessageMapping("/github")
    public void github(@RequestParam String user) throws InterruptedException, ExecutionException {
        CompletableFuture<GitHubUser> user1 = gitHubLookupService.findUser(user);
        CompletableFuture<GitHubUser> uCompletableFuture = user1.thenCompose(u -> CompletableFuture.supplyAsync(() -> {
            {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                u.setName(u.getName() + "eeee");
                return u;
            }
        }));

        simpMessagingTemplate.convertAndSend("/topic/greetings", "ssssss");
        uCompletableFuture.thenAccept(gitHubUser -> simpMessagingTemplate.convertAndSend("/topic/greetings", gitHubUser));
    }

}
