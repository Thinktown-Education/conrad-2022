package com.thinktown.conrad2022.service;

import com.thinktown.conrad2022.dao.Session;

public interface SessionService {
    Session createSession(int userid, String token);

    void deleteSession(int userid);

    Session findSessionByToken(String token);
}
