package com.example.springbootDemo.controller;

import com.example.springbootDemo.domain.MyException;
import com.example.springbootDemo.service.aspect.PermissionCheck;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/6/18 0018.
 */
@RestController
public class HelloController {


    @RequestMapping("/hello")
    @PermissionCheck("user:update")
    public String index() {
        System.out.printf("hello controller");
        return "Hello WorldCOMPANY";
    }

    @RequestMapping("/json")
    public String json() throws MyException {
        throw new MyException("发生错误2");
    }
}
