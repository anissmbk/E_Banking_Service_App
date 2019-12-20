package com.example.ebankingspg.java.services;

import com.example.ebankingspg.java.Repository.AgenceRepository;
import com.example.ebankingspg.java.model.Agency;
import org.springframework.stereotype.Service;

@Service
public class AgenceService extends AbstractService<Long, AgenceRepository, Agency>{
    public AgenceService(AgenceRepository repository) {
        super(repository);
    }
}
