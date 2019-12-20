package com.example.ebankingspg.java.Repository;

import com.example.ebankingspg.java.model.Agency;
import com.example.ebankingspg.java.model.Beneficiary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeneficiaryRepository extends JpaRepository<Beneficiary, Long> {
}
