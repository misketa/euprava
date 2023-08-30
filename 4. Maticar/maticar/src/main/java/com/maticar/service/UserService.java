package com.maticar.service;

import com.maticar.model.User;
import com.maticar.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserService {

    final private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public void save(User user){
        userRepository.save(user);
    }

    public User getLogged(Authentication authentication){
        return userRepository.findByUsername(authentication.getName());
    }


    public List<User> findAll() {
        return userRepository.findAll();
    }
}