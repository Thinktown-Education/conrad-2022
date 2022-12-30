package com.thinktown.conrad2022.repository;

import com.thinktown.conrad2022.dao.Session;
import org.springframework.data.repository.CrudRepository;

public interface SessionRepository extends CrudRepository<Session, Integer> {
    Session findByUserid(int userid);
    Session findByToken(String token);
}
