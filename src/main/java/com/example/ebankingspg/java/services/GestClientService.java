package com.example.ebankingspg.java.services;

import com.example.ebankingspg.java.Repository.DebitRepository;
import com.example.ebankingspg.java.Repository.GestClientRepository;
import com.example.ebankingspg.java.model.Debit;
import com.example.ebankingspg.java.model.GestClient;
import org.springframework.stereotype.Service;

@Service
public class GestClientService extends AbstractService<Long, GestClientRepository, GestClient>{
    public GestClientService(GestClientRepository repository) {
        super(repository);
    }
}
