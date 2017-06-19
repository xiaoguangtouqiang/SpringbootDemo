package com.example.springbootDemo.controller;

import com.example.springbootDemo.domain.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/6/18 0018.
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public User index() {
        User user = new User();
        user.setPassword("ssssss");
        user.setUserName("gggggg");
        return user;
    }
}
