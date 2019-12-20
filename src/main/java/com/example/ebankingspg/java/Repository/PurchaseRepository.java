package com.example.ebankingspg.java.Repository;

import com.example.ebankingspg.java.model.Operator;
import com.example.ebankingspg.java.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

}
