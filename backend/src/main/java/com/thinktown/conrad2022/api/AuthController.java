package com.thinktown.conrad2022.api;

import com.thinktown.conrad2022.dao.Session;
import com.thinktown.conrad2022.dao.User;
import com.thinktown.conrad2022.service.SessionService;
import com.thinktown.conrad2022.service.UserService;
import com.thinktown.conrad2022.utils.AuthUtils;
import com.thinktown.conrad2022.utils.MD5;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("auth")
public class AuthController {
    @Autowired
    public UserService userService;

    @Autowired
    public SessionService sessionService;

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
    public ResponseEntity<String> login(
            @RequestBody User body,
            HttpServletResponse httpServletResponse) throws Exception {
        String email = body.getEmail();
        String password = MD5.getString(body.getPassword());
        if (StringUtils.isBlank(email) || StringUtils.isBlank(password)) {
            AuthUtils.removeAuthToken(httpServletResponse);
            return ResponseEntity.badRequest().body("Email or password should not be blank");
        }
        User user = userService.login(email, password);
        if (user == null) {
            AuthUtils.removeAuthToken(httpServletResponse);
            return ResponseEntity.badRequest().body("Incorret email or password");
        }

        String token = AuthUtils.generateToken();
        sessionService.createSession(user.getId(), token);
        AuthUtils.setAuthToken(httpServletResponse, token);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "Log out", notes = "Submit email and password to log in")
    @PostMapping("/logout")
    public ResponseEntity<String> logout(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse) {
        String token = AuthUtils.getAuthToken(httpServletRequest);
        Session session = sessionService.findSessionByToken(token);
        sessionService.deleteSession(session.getUserid());

        AuthUtils.removeAuthToken(httpServletResponse);
        return ResponseEntity.ok().build();
    }
}
