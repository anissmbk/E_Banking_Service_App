package com.example.ebankingspg.java.response;

public class StringResponse {

    private String message;

    public StringResponse(String message) {
        this.message = message;
    }

    public StringResponse() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
