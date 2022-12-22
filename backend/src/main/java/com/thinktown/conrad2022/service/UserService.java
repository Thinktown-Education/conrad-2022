package com.thinktown.conrad2022.service;

import com.thinktown.conrad2022.dao.User;

public interface UserService {
    public boolean hasEmail(String email);

    public User login(String email, String password);

    public User register(String email, String password);
}
