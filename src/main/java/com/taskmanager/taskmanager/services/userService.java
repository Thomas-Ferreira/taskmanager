package com.taskmanager.taskmanager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskmanager.taskmanager.model.user;
import com.taskmanager.taskmanager.repositories.userRepository;

@Service
public class userService {

    private final userRepository UserRepository;

    @Autowired
    public userService(userRepository UserRepository){
        this.UserRepository = UserRepository;
    }

    public user getUserById(Integer userId){
        return UserRepository.findById(userId).orElse(null);
    }
    
}
