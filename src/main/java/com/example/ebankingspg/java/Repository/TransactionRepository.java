package com.example.ebankingspg.java.Repository;

import com.example.ebankingspg.java.model.Transaction;
import com.example.ebankingspg.java.model.User;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    @Query("select u from Transaction u where u.account.id = :accountId or u.accountTarget.id = :accountId")
    List<Transaction> findByAccountOrAccountTargetAndSort(@Param("accountId") Long accountId,Sort sort);

    List<Transaction> findByActiveIsFalse();

}
