package com.example.ebankingspg.java.services;

import com.example.ebankingspg.java.Repository.ClientRepository;
import com.example.ebankingspg.java.Repository.DebitRepository;
import com.example.ebankingspg.java.model.Client;
import com.example.ebankingspg.java.model.Debit;
import org.springframework.stereotype.Service;

@Service
public class DebitService extends AbstractService<Long, DebitRepository, Debit>{
    public DebitService(DebitRepository repository) {
        super(repository);
    }
}
