package com.example.ebankingspg.java.services;

import com.example.ebankingspg.java.Repository.RoleRepository;
import com.example.ebankingspg.java.Repository.TransactionRepository;
import com.example.ebankingspg.java.model.Role;
import com.example.ebankingspg.java.model.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService extends AbstractService<Long, TransactionRepository, Transaction>{
    public TransactionService(TransactionRepository repository) {
        super(repository);
    }
}
