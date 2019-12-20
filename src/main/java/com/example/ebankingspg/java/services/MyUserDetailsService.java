package com.example.ebankingspg.java.services;

import com.example.ebankingspg.java.Repository.UserRepository;
import com.example.ebankingspg.java.daoImpl.CustomUser;
import com.example.ebankingspg.java.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByEmail(username);
        optionalUser.orElseThrow(()->new UsernameNotFoundException("email not found"));
        return optionalUser.get();
    }
    
}
