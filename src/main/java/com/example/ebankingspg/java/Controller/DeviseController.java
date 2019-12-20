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

import com.example.ebankingspg.java.Repository.DeviseRepository;
import com.example.ebankingspg.java.Repository.UserRepository;
import com.example.ebankingspg.java.model.*;
@CrossOrigin()
@RestController
@RequestMapping({ "/devises" })
public class DeviseController {

  @Autowired
  DeviseRepository devrep;


  @GetMapping(produces = "application/json")
  public List<Devise> firstPage() {
      List<Devise> devises = devrep.findAll();
      return devises;
  }


  @PostMapping
  public Devise create(@RequestBody Devise devise) {

      devrep.save(devise);

      return devise;
  }

}
