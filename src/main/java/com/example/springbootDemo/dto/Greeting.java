package com.example.springbootDemo.dto;

/**
 * Created by wangdi on 2017/8/17.
 */
public class Greeting {

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Greeting(String content) {
        this.content = content;
    }
}
