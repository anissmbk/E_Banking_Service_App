package com.example.ebankingspg.java.response;

import com.example.ebankingspg.java.model.Account;
import com.example.ebankingspg.java.model.User;

import java.util.Set;

public class ClientResponse {

    private Set<Account> account;

    public ClientResponse(Set<Account> account) {
        this.account = account;
    }

    public Set<Account> getAccount() {
        return account;
    }

    public void setAccount(Set<Account> account) {
        this.account = account;
    }
}
