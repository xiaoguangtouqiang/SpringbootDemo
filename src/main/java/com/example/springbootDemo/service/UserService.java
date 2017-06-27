package com.example.springbootDemo.service;

import com.example.springbootDemo.domain.User;
import com.example.springbootDemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/6/24 0024.
 */
@Service
public class UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private UserRepository userRepository;

    public void create(String name, Integer age) {
        jdbcTemplate.update("insert into USER(NAME, AGE) values(?, ?)", name, age);
    }

    public User queryUser(String name) {
        User user = userRepository.findByName(name);
        return user;
    }

    public User saveUser(User user) {
        User save = userRepository.save(user);
        return save;
    }
}
