package com.example.springbootDemo;

import com.example.springbootDemo.domain.User;
import com.example.springbootDemo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Administrator on 2017/6/24 0024.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DbTest {

    @Autowired
    private UserService userSerivce;

    @Test
    public void test() throws Exception {
        User user = new User();
        user.setAge("18");
        user.setName("di");
        User saveUser = userSerivce.saveUser(user);
        System.out.print("saveUser:"+saveUser.toString());
    }

}
