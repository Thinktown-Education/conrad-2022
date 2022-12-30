package com.thinktown.conrad2022.service.impl;

import com.thinktown.conrad2022.dao.Session;
import com.thinktown.conrad2022.repository.SessionRepository;
import com.thinktown.conrad2022.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionServiceImpl implements SessionService {
    @Autowired
    private SessionRepository sessionRepository;

    @Override
    public Session createSession(int userid, String token) {
        Session old = sessionRepository.findByUserid(userid);
        if (old != null) {
            sessionRepository.delete(old);
        }
        Session session = new Session(userid, token);
        sessionRepository.save(new Session(userid, token));
        return session;
    }

    @Override
    public void deleteSession(int userid) {
        sessionRepository.deleteById(userid);
    }

    @Override
    public Session findSessionByToken(String token) {
        return sessionRepository.findByToken(token);
    }
}
