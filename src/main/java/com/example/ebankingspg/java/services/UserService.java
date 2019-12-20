package com.example.ebankingspg.java.services;

import com.example.ebankingspg.java.Repository.UserRepository;
import com.example.ebankingspg.java.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService extends AbstractService<Long, UserRepository, User> {

    public UserService(UserRepository repository) {
        super(repository);
    }

}
