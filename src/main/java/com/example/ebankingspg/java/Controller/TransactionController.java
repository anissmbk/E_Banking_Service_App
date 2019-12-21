package com.example.ebankingspg.java.Controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import com.example.ebankingspg.java.Repository.*;
import com.example.ebankingspg.java.request.CreateRecipientRequest;
import com.example.ebankingspg.java.request.CreateTransactionRequest;
import com.example.ebankingspg.java.response.StringResponse;
import com.example.ebankingspg.java.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.ebankingspg.java.model.*;
@CrossOrigin(origins = "*")
@RestController
public class TransactionController {
    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private AccountRepository accountRepository;


    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private BeneficiaryRepository beneficiaryRepository;

    @Autowired
    private TransactionService transactionService;

    @GetMapping(produces = "application/json")
    @RequestMapping(value = "/transaction/createTransaction",method = RequestMethod.POST)
    public ResponseEntity<?> createTransaction(@RequestBody CreateTransactionRequest createTransactionRequest) throws Exception {
        //emetteur?
        Optional<Account> account = accountRepository.findByRib(createTransactionRequest.getAccount());
        account.orElseThrow(()->new Exception("User not found"));
        Account account1 = account.get();
        //recepteur?
        Optional<Account> recipient = accountRepository.findByRib(createTransactionRequest.getRecipient());
        String str;
        if(!recipient.isPresent()){
            str = transactionService.transfer(account1,null,createTransactionRequest.getAmount(),createTransactionRequest.getRecipient());
        }else{
            Account recipient1 = recipient.get();
            str = transactionService.transfer(account1,recipient1,createTransactionRequest.getAmount(),createTransactionRequest.getRecipient());
        }
        return ResponseEntity.ok(new StringResponse(str));
    }

}
