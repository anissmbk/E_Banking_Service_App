package com.example.ebankingspg.java.response;

import com.example.ebankingspg.java.model.User;

import java.util.Set;

public class ChartResponse {
    private Set<User> users;

    public ChartResponse() {
    }

    public ChartResponse(Set<User> users) {
        this.users = users;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
