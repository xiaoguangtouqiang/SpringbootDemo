package com.example.springbootDemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/6/18 0018.
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String index() {
        return "eee";
    }
}
