package com.example.ebankingspg.java.Controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.annotation.PostConstruct;

import com.example.ebankingspg.java.Repository.*;
import com.example.ebankingspg.java.response.AccountResponse;
import com.example.ebankingspg.java.response.ChartResponse;
import com.example.ebankingspg.java.services.GestClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.ebankingspg.java.model.*;

@CrossOrigin(origins = "*")
@RestController
public class ClientController {
    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private AccountRepository accountRepository;


    @Autowired
    private ClientRepository clientRepository;

    @GetMapping(produces = "application/json")
    @RequestMapping(value = "/client/getClient",method = RequestMethod.GET)
    public ResponseEntity<?> getclientAccounts(@RequestParam String id) throws Exception {
        Optional<Client> client = clientRepository.findById(Long.parseLong(id));
        client.orElseThrow(()->new Exception("User not found"));
        return ResponseEntity.ok(client.get());
    }

}
