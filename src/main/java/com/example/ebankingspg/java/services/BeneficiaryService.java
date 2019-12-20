package com.example.ebankingspg.java.services;

import com.example.ebankingspg.java.Repository.BeneficiaryRepository;
import com.example.ebankingspg.java.model.Beneficiary;
import org.springframework.stereotype.Service;

@Service
public class BeneficiaryService extends AbstractService<Long, BeneficiaryRepository, Beneficiary>{
    public BeneficiaryService(BeneficiaryRepository repository) {
        super(repository);
    }
}
