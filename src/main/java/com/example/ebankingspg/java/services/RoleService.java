package com.example.ebankingspg.java.services;

import com.example.ebankingspg.java.Repository.RoleRepository;
import com.example.ebankingspg.java.model.Role;
import org.springframework.stereotype.Service;

@Service
public class RoleService extends AbstractService<Long, RoleRepository, Role>{
    public RoleService(RoleRepository repository) {
        super(repository);
    }

    public Role findByRole(String role){
        return repository.findByRole(role);
    }
}
