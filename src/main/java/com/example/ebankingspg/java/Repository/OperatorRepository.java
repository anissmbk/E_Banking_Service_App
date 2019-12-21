package com.example.ebankingspg.java.Repository;

import com.example.ebankingspg.java.model.Operator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperatorRepository extends JpaRepository<Operator, Long> {

}
