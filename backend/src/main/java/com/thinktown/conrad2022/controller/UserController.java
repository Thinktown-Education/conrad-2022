package com.thinktown.conrad2022.controller;

import com.thinktown.conrad2022.dao.User;
import com.thinktown.conrad2022.service.UserService;
import com.thinktown.conrad2022.utils.MD5;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    public UserService userService;

    @ApiOperation(value = "Register", notes = "Submit email and password to register")
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User body) throws Exception {
        String email = body.getEmail();
        String password = MD5.getString(body.getPassword());
        if (StringUtils.isBlank(email) || StringUtils.isBlank(password)) {
            return ResponseEntity.badRequest().body("Email or password should not be blank");
        }
        if (userService.hasEmail(email)) {
            return ResponseEntity.badRequest().body("Email already registered");
        }
        User user = userService.register(email, password);
        return ResponseEntity.ok(user.getEmail());
    }

    @ApiOperation(value = "Login", notes = "Submit email and password to log in")
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User body) throws Exception {
        String email = body.getEmail();
        String password = MD5.getString(body.getPassword());
        if (StringUtils.isBlank(email) || StringUtils.isBlank(password)) {
            return ResponseEntity.badRequest().body("Email or password should not be blank");
        }
        User user = userService.login(email, password);
        if (user == null) {
            return ResponseEntity.badRequest().body("Incorret email or password");
        }
        return ResponseEntity.ok(user.getEmail());
    }
}
