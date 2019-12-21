package com.example.ebankingspg.java.Controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import com.example.ebankingspg.java.Repository.TransactionRepository;
import com.example.ebankingspg.java.response.AccountResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.ebankingspg.java.Repository.AccountRepository;
import com.example.ebankingspg.java.Repository.UserRepository;
import com.example.ebankingspg.java.model.*;

@CrossOrigin(origins = "*")
@RestController
public class AccountController {
    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping(produces = "application/json")
    @RequestMapping(value = "/account",method = RequestMethod.GET)
    public ResponseEntity<?> getTransactions(@RequestParam String id) throws Exception {
        Optional<Account> account = accountRepository.findById(Long.parseLong(id));
        account.orElseThrow(()->new Exception("Account not found"));
        Account account1=account.get();
        List<Transaction> transactions = transactionRepository.findByAccountOrAccountTargetAndSort(account1.getId(), Sort.by(Sort.Direction.DESC, "createdDate"));
        for(Transaction trs: transactions){
            String description;
            if(trs.getAccount().getId().equals(account1.getId())){
                trs.setAmount(-1*trs.getAmount());
                if(trs.getAccountTarget() == null){
                    description="Transaction sent To "+trs.getRecipientOutOfBank();
                }else{
                    description="Transaction sent To "+trs.getAccountTarget().getClient().getFirstname()+" "+trs.getAccountTarget().getClient().getLastname();
                }
            }else{
                if(trs.getAccount() == null){
                    description="Transaction Received (*) ";
                }else{
                    description="Transaction Received from "+trs.getAccount().getClient().getFirstname()+" "+trs.getAccount().getClient().getLastname();
                }
            }
            trs.setDescription(description);
        }
        return ResponseEntity.ok(new AccountResponse(account1,transactions));
    }
}
