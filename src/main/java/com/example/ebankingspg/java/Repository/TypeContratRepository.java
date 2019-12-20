package com.example.ebankingspg.java.Repository;

import com.example.ebankingspg.java.model.Transaction;
import com.example.ebankingspg.java.model.TypeContrat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeContratRepository extends JpaRepository<TypeContrat, Long> {

}
