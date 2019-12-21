package com.example.ebankingspg.java.services;

import com.example.ebankingspg.java.Repository.AccountRepository;
import com.example.ebankingspg.java.Repository.RoleRepository;
import com.example.ebankingspg.java.Repository.TransactionRepository;
import com.example.ebankingspg.java.model.Account;
import com.example.ebankingspg.java.model.Role;
import com.example.ebankingspg.java.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService extends AbstractService<Long, TransactionRepository, Transaction> {
    @Autowired
    private AccountRepository accountRepository;


    public TransactionService(TransactionRepository repository) {
        super(repository);
    }

    public String transfer(Account account, Account recipient, double amount, String recipientRib) {
        //verification de recipient in bank or dehors?
        if (recipient == null) {
            //augmenter ammount
            amount = amount + amount * (account.getTypecontrat().getRate()) / 100;
        }
        //verification Solde
        String msg;

        if (account.getBalance() >= amount) {
            account.setBalance(account.getBalance() - amount);
            Transaction transaction;
            if (recipient == null) {
                transaction = Transaction.builder().account(account).recipientOutOfBank(recipientRib).amount(amount).active(true).build();
            } else {
                //TODO FUNCTION MRYEM
                transaction = Transaction.builder().account(account).accountTarget(recipient).amount(amount).active(true).build();
                // if not validate
                // transaction = Transaction.builder().account(account).accountTarget(recipient).amount(amount).active(false).build();
                recipient.setBalance(recipient.getBalance()+amount);
                accountRepository.save(recipient);
            }
            accountRepository.save(account);
            repository.save(transaction);

        } else {
            return "not enough money in your account!!";
        }
        return "Your Transaction is successful";
    }
}
