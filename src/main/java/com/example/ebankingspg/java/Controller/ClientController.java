package com.example.ebankingspg.java.Controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.annotation.PostConstruct;

import com.example.ebankingspg.java.Repository.*;
import com.example.ebankingspg.java.request.CreateRecipientRequest;
import com.example.ebankingspg.java.request.UpdateClientRequest;
import com.example.ebankingspg.java.response.AccountResponse;
import com.example.ebankingspg.java.response.ChartResponse;
import com.example.ebankingspg.java.response.StringResponse;
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

    @Autowired
    private BeneficiaryRepository beneficiaryRepository;

    @GetMapping(produces = "application/json")
    @RequestMapping(value = "/client/getClient",method = RequestMethod.GET)
    public ResponseEntity<?> getClientAccounts(@RequestParam String id) throws Exception {
        Optional<Client> client = clientRepository.findById(Long.parseLong(id));
        client.orElseThrow(()->new Exception("User not found"));
        return ResponseEntity.ok(client.get());
    }

    @GetMapping(produces = "application/json")
    @RequestMapping(value = "/client/createRecipient",method = RequestMethod.POST)
    public ResponseEntity<?> createRecipient(@RequestBody CreateRecipientRequest createRecipientRequest) throws Exception {
        Optional<Client> client = clientRepository.findById(createRecipientRequest.getClientId());
        client.orElseThrow(()->new Exception("User not found"));
        Client client1 = client.get();
        Beneficiary beneficiary=new Beneficiary();
        beneficiary.setClient(client1);
        beneficiary.setRib(createRecipientRequest.getRib());
        beneficiary.setName(createRecipientRequest.getFullName());
        beneficiaryRepository.save(beneficiary);
        return ResponseEntity.ok(new StringResponse("recipient added successfully"));
    }

}
