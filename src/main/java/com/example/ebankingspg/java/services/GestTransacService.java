package com.example.ebankingspg.java.services;

import com.example.ebankingspg.java.Repository.GestTransacRepository;
import com.example.ebankingspg.java.model.GestTransac;
import org.springframework.stereotype.Service;

@Service
public class GestTransacService extends AbstractService<Long, GestTransacRepository, GestTransac>{
    public GestTransacService(GestTransacRepository repository) {
        super(repository);
    }
}
