package com.example.ebankingspg.java.Repository;

import com.example.ebankingspg.java.model.Debit;
import com.example.ebankingspg.java.model.Devise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DeviseRepository extends JpaRepository<Devise, Long> {

    Optional<Devise> findByName(String name);
}
