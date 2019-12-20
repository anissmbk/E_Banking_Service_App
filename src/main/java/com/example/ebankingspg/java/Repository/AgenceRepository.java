package com.example.ebankingspg.java.Repository;

import com.example.ebankingspg.java.model.Agency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AgenceRepository extends JpaRepository<Agency, Long> {

}
