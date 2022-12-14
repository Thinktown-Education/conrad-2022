package com.thinktown.conrad2022.controller;

import com.thinktown.conrad2022.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    public UserService userService;

    @RequestMapping("/login")
    public String login() {
        return "Hello this is a message from Spring Boot service";
    }
}
