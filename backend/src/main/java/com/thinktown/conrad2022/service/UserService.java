package com.thinktown.conrad2022.service;

import com.thinktown.conrad2022.dao.User;

public interface UserService {
    boolean hasEmail(String email);

    User login(String email, String password);

    User register(String email, String password);
}
