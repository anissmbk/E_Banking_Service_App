package com.example.ebankingspg.java.Repository;

import com.example.ebankingspg.java.model.Commission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommissionRepository extends JpaRepository<Commission, Long> {

    Commission findById(long id);
}
