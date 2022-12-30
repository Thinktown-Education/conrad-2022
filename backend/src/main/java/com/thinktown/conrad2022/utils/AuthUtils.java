package com.thinktown.conrad2022.utils;

import org.apache.commons.lang3.RandomStringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthUtils {
    private static final String tokenName = "Conrad_Token";

    public static String getAuthToken(HttpServletRequest httpServletRequest) {
        Cookie[] cookies = httpServletRequest.getCookies();
        if (cookies == null) {
            return null;
        }
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(tokenName)) {
                return cookie.getValue();
            }
        }
        return null;
    }

    public static void setAuthToken(HttpServletResponse httpServletResponse, String token) {
        Cookie cookie = new Cookie(tokenName, token);
        cookie.setPath("/");
        httpServletResponse.addCookie(cookie);
    }

    public static void removeAuthToken(HttpServletResponse httpServletResponse) {
        Cookie cookie = new Cookie(tokenName, null);
        cookie.setPath("/");
        cookie.setMaxAge(0);
        httpServletResponse.addCookie(cookie);
    }

    public static String generateToken() {
        String token = RandomStringUtils.randomAlphanumeric(64);
        return token;
    }
}
