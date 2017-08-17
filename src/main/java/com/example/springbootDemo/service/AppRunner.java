package com.example.springbootDemo.service;

import com.example.springbootDemo.dto.GitHubUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

/**
 * Created by wangdi on 2017/8/17.
 */
@Component
public class AppRunner implements CommandLineRunner {


    private final GitHubLookupService gitHubLookupService;

    public AppRunner(GitHubLookupService gitHubLookupService) {
        this.gitHubLookupService = gitHubLookupService;
    }

    private static final Logger logger = LoggerFactory.getLogger(AppRunner.class);

    @Override
    public void run(String... args) throws Exception {
        long start = System.currentTimeMillis();

        // Kick of multiple, asynchronous lookups
        CompletableFuture<GitHubUser> page1 = gitHubLookupService.findUser("PivotalSoftware");
        CompletableFuture<GitHubUser> page2 = gitHubLookupService.findUser("CloudFoundry");
        CompletableFuture<GitHubUser> page3 = gitHubLookupService.findUser("Spring-Projects");

        // Wait until they are all done
//        CompletableFuture.allOf(page1, page2, page3).join();
        CompletableFuture.anyOf(page1, page2, page3).join();
        // Print results, including elapsed time
        logger.info("Elapsed time: " + (System.currentTimeMillis() - start));
        logger.info("--> " + page1.get());
        logger.info("--> " + page2.get());
        logger.info("--> " + page3.get());
    }
}
