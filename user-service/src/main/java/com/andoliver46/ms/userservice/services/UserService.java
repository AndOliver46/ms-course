package com.andoliver46.ms.userservice.services;

import com.andoliver46.ms.userservice.models.UserModel;
import com.andoliver46.ms.userservice.producers.EmailProducer;
import com.andoliver46.ms.userservice.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final EmailProducer emailProducer;

    public UserService(UserRepository userRepository, EmailProducer emailProducer){
        this.userRepository = userRepository;
        this.emailProducer = emailProducer;
    }

    @Transactional
    public void save(UserModel userModel){
        userRepository.save(userModel);
        emailProducer.publishMailMessage(userModel);
    }

}
