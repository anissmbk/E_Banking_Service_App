package com.example.ebankingspg.java.Repository;

import com.example.ebankingspg.java.model.Debit;
import com.example.ebankingspg.java.model.GestClient;
import com.example.ebankingspg.java.model.GestTransac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GestTransacRepository extends JpaRepository<GestTransac, Long> {

}
