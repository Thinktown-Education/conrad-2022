package com.thinktown.conrad2022.service.impl;

import com.thinktown.conrad2022.dao.User;
import com.thinktown.conrad2022.repository.UserRepository;
import com.thinktown.conrad2022.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean hasEmail(String email) {
        User user = userRepository.findByEmail(email);
        return user != null;
    }

    @Override
    public User login(String email, String password) {
        User user = userRepository.findByEmail(email);
        // No such email
        if (user == null) {
            return null;
        }

        // Password incorrect
        if (!user.getPassword().equals(password)) {
            return null;
        }

        return user;
    }

    @Override
    public User register(String email, String password) {
        User user = new User(email, password);
        User registered = userRepository.save(user);
        return registered;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(s);
        if (user == null) {
            throw new UsernameNotFoundException(s);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("user"));
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
    }
}
