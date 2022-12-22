package com.thinktown.conrad2022.controller;

import com.thinktown.conrad2022.dao.User;
import com.thinktown.conrad2022.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    public UserService userService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User body) {
        if (StringUtils.isBlank(body.getEmail()) || StringUtils.isBlank(body.getPassword())) {
            return ResponseEntity.badRequest().body("Email or password should not be blank");
        }
        User user = userService.login(body.getEmail(), body.getPassword());
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Incorret email or password");
        }
        return ResponseEntity.ok(user.getEmail());
    }

    @GetMapping("/canRegister")
    public boolean canRegister(@RequestParam(name = "email") String email) {
        return !userService.hasEmail(email);
    }
}
