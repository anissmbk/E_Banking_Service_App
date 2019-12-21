package com.example.ebankingspg.java.request;

public class CreateTransactionRequest {
    private String account;
    private String recipient;
    private double amount;

    public CreateTransactionRequest(String account, String recipient, double amount) {
        this.account = account;
        this.recipient = recipient;
        this.amount = amount;
    }

    public CreateTransactionRequest() {
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
