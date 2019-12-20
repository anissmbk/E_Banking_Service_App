package com.example.ebankingspg.java.Controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ebankingspg.java.Repository.GestTransacRepository;
import com.example.ebankingspg.java.Repository.RoleRepository;
import com.example.ebankingspg.java.Repository.UserRepository;
import com.example.ebankingspg.java.model.*;
@CrossOrigin()
@RestController
@RequestMapping({ "/gesttransacs" })
public class GesttransacController {
  @Autowired
   private GestTransacRepository gesttransrep;

   @Autowired
   private RoleRepository rolerep;

   @GetMapping(produces = "application/json")
   public List<GestTransac> firstPage() {
       List<GestTransac> gesttrans = gesttransrep.findAll();
       return gesttrans;
   }


   @Autowired
   private BCryptPasswordEncoder bCryptPasswordEncoder;

   @PostMapping
   public GestTransac create(@RequestBody GestTransac gestTransac) {
    String pass = gestTransac.getPassword();

    String newpass = bCryptPasswordEncoder.encode(pass);
    gestTransac.setPassword(newpass);
    Set<Role> roles1 = new HashSet<Role>();
    roles1.add(rolerep.findByRole("ROLE_TRANSACTION_MANAGER"));
    gestTransac.setRoles(roles1);
       gesttransrep.save(gestTransac);

       return gestTransac;
   }



}
