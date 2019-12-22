package com.example.ebankingspg.java.response;

import com.example.ebankingspg.java.model.Account;
import com.example.ebankingspg.java.model.Client;
import com.example.ebankingspg.java.model.Transaction;

public class TransactionDetailsResponse {
    Transaction transaction;
    String account;
    String recipientRib;
    Client recipient;

    public TransactionDetailsResponse() {
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getRecipientRib() {
        return recipientRib;
    }

    public void setRecipientRib(String recipientRib) {
        this.recipientRib = recipientRib;
    }

    public Client getRecipient() {
        return recipient;
    }

    public void setRecipient(Client recipient) {
        this.recipient = recipient;
    }

    public TransactionDetailsResponse(Transaction transaction, String account, String recipientRib, Client recipient) {
        this.transaction = transaction;
        this.account = account;
        this.recipientRib = recipientRib;
        this.recipient = recipient;
    }

}
