package com.example.ebankingspg.java.services;

import com.example.ebankingspg.java.Repository.ClientRepository;
import com.example.ebankingspg.java.model.Client;
import org.springframework.stereotype.Service;

@Service
public class ClientService extends AbstractService<Long, ClientRepository, Client>{
    public ClientService(ClientRepository repository) {
        super(repository);
    }
}
