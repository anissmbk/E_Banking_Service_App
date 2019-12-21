package com.example.ebankingspg.java.Repository;

import com.example.ebankingspg.java.model.Account;
import com.example.ebankingspg.java.model.User;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    //aniss
    Optional<Account> findByRib(String rib);

}
