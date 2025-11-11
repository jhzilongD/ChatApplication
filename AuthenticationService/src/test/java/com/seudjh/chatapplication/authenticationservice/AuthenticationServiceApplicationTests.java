package com.seudjh.chatapplication.authenticationservice;

import com.seudjh.chatapplication.authenticationservice.model.User;
import com.seudjh.chatapplication.authenticationservice.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AuthenticationServiceApplicationTests {
    @Autowired
    private UserService userService;



    @Test
    void contextLoads() {
    }

    @Test
    void getUserById() {
        User user = userService.getById(1);
        System.out.println("fuck" + user);
    }
    @Test
    void getUserByEmail() {}


}
