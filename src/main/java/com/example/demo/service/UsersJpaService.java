package com.example.demo.service;

import com.example.demo.controller.model.MockUser;
import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class UsersJpaService {

    private final UserRepository userRepository;

    public UsersJpaService(@Autowired UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public MockUser findUserById(String userId) {

        //UserEntity userEntity = userRepository.findByExternalId(userId).getFirst();
        UserEntity userEntity = userRepository.findByExternalId(userId).get(0);
        log.info("Found user {}", userEntity);
        return new MockUser(String.valueOf(userEntity.getAge()), userEntity.getEmail(), UUID.fromString(userEntity.getExternalId()));

    }

}
