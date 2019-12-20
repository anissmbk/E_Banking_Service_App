package com.example.ebankingspg.java.services;

import com.example.ebankingspg.java.Repository.AccountRepository;
import com.example.ebankingspg.java.model.Account;
import org.springframework.stereotype.Service;

@Service
public class AccountService extends AbstractService<Long, AccountRepository, Account>{
    public AccountService(AccountRepository repository) {
        super(repository);
    }
}
