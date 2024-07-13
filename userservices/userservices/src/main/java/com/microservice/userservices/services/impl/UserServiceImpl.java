package com.microservice.userservices.services.impl;

import com.microservice.userservices.entities.Hotel;
import com.microservice.userservices.entities.Rating;
import com.microservice.userservices.entities.User;
import com.microservice.userservices.exceptions.ResourceNotFoundException;
import com.microservice.userservices.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.microservice.userservices.services.UserService;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;


import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        //generate  unique userid
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        //implement RATING SERVICE CALL: USING REST TEMPLATE
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        //get user from database with the help  of user repository
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with given id is not found on server !! : " + userId));

        return user;
    }

    }
