package com.example.ebankingspg.java.response;

import com.example.ebankingspg.java.model.Account;
import com.example.ebankingspg.java.model.Transaction;

import java.util.List;
//aniss
public class AccountResponse {
    private Account account;
    private List<Transaction> transactions;

    public AccountResponse(Account account, List<Transaction> transactions) {
        this.account = account;
        this.transactions = transactions;
    }

    public Account getAccount() {
        return account;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
//aniss-fin
