package com.thinktown.conrad2022.auth;

import com.thinktown.conrad2022.dao.Session;
import com.thinktown.conrad2022.repository.SessionRepository;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;


/**
 * 摆设，所有逻辑在filter处理
 * 用户第一次登录会从/auth/login注入Authentication
 */
public class AuthProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        return authentication;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }
}
