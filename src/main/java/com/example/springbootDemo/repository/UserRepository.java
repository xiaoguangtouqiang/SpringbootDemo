package com.example.springbootDemo.repository;

import com.example.springbootDemo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2017/6/24 0024.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByName(String name);
}
