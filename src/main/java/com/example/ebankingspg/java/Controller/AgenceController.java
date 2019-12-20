package com.example.ebankingspg.java.Controller;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ebankingspg.java.Repository.AgenceRepository;
import com.example.ebankingspg.java.Repository.UserRepository;
import com.example.ebankingspg.java.model.*;
@CrossOrigin()
@RestController
@RequestMapping({ "/agences" })
public class AgenceController {

   @Autowired
   private AgenceRepository agencerep;

   @GetMapping(produces = "application/json")
   public List<Agency> firstPage() {
       List<Agency> agences = agencerep.findAll();
       return agences;
   }

   @PostMapping
   public Agency create(@RequestBody Agency agence) {

       agencerep.save(agence);

       return agence;
   }

}
