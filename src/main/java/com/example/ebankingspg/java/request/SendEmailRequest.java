package com.example.ebankingspg.java.request;

public class SendEmailRequest {

    private String email;

    public SendEmailRequest(String email) {
        this.email = email;
    }

    public SendEmailRequest() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
