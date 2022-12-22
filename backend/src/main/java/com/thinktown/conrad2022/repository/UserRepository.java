package com.thinktown.conrad2022.repository;

import com.thinktown.conrad2022.dao.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    public User findByEmail(String email);
}
