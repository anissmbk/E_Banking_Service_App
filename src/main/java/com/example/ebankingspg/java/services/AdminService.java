package com.example.ebankingspg.java.services;

import com.example.ebankingspg.java.Repository.AccountRepository;
import com.example.ebankingspg.java.Repository.AdminRepository;
import com.example.ebankingspg.java.model.Account;
import com.example.ebankingspg.java.model.Admin;
import org.springframework.stereotype.Service;

@Service
public class AdminService extends AbstractService<Long, AdminRepository, Admin>{
    public AdminService(AdminRepository repository) {
        super(repository);
    }
}
