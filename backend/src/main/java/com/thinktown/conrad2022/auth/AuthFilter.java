package com.thinktown.conrad2022.auth;

import com.thinktown.conrad2022.dao.Session;
import com.thinktown.conrad2022.repository.SessionRepository;
import com.thinktown.conrad2022.utils.AuthUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 第一层filter
 */
public class AuthFilter extends OncePerRequestFilter {
    private SessionRepository sessionRepository;

    public AuthFilter(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String token = AuthUtils.getAuthToken(httpServletRequest);
        if (token != null) {
            Session session = sessionRepository.findByToken(token);
            if (session != null) {
                Authentication authentication = new UsernamePasswordAuthenticationToken(token, token, new ArrayList<>());
                SecurityContextHolder.getContext().setAuthentication(authentication);
                GlobalUsercontext.setUserId(session.getUserid());
            }
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
