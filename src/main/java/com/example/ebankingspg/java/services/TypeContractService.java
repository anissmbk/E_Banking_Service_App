package com.example.ebankingspg.java.services;

import com.example.ebankingspg.java.Repository.TransactionRepository;
import com.example.ebankingspg.java.Repository.TypeContratRepository;
import com.example.ebankingspg.java.model.Transaction;
import com.example.ebankingspg.java.model.TypeContrat;
import org.springframework.stereotype.Service;

@Service
public class TypeContractService extends AbstractService<Long, TypeContratRepository, TypeContrat>{
    public TypeContractService(TypeContratRepository repository) {
        super(repository);
    }
}
