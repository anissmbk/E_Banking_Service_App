package com.example.ebankingspg.java.Repository;

import com.example.ebankingspg.java.model.Debit;
import com.example.ebankingspg.java.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    public Role findByRole(String role);

}
