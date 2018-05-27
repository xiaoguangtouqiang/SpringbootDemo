package com.example.springbootDemo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by wangdi on 2017/8/17.
 */
public class GitHubUser {
    private String name;
    private String blog;
    private Greeting greeting;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getBlog() {
        return blog;
    }
    public void setBlog(String blog) {
        this.blog = blog;
    }

    public Greeting getGreeting() {
        return greeting;
    }

    public void setGreeting(Greeting greeting) {
        this.greeting = greeting;
    }

    public static void main(String[] args) throws JsonProcessingException {
        GitHubUser user = new GitHubUser();
        user.setBlog("ssss");
        Greeting greet = new Greeting();
        greet.setAbcd("aaaaaa");
        user.setGreeting(greet);
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        System.out.println(mapper.writeValueAsString(user));
    }
}
