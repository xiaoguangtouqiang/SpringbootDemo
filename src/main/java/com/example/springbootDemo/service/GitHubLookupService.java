package com.example.springbootDemo.service;

import com.example.springbootDemo.dto.GitHubUser;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

/**
 * Created by wangdi on 2017/8/17.
 */
@Service
public class GitHubLookupService {

    private final RestTemplate restTemplate;

    public GitHubLookupService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Async
    public CompletableFuture<GitHubUser> findUser(String user) throws InterruptedException {
        String url = String.format("https://api.github.com/users/%s", user);
        GitHubUser results = restTemplate.getForObject(url, GitHubUser.class);
        // Artificial delay of 1s for demonstration purposes
        Thread.sleep(3000L);
        return CompletableFuture.completedFuture(results);
    }

}
