package com.example.ebankingspg.java.request;

public class ForgotPasswordRequest {

    private String token;
    private String password;
    private String Confirmpassword;


    public ForgotPasswordRequest(String token, String password, String confirmpassword) {
        this.token = token;
        this.password = password;
        Confirmpassword = confirmpassword;
    }

    public ForgotPasswordRequest() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmpassword() {
        return Confirmpassword;
    }

    public void setConfirmpassword(String confirmpassword) {
        Confirmpassword = confirmpassword;
    }
}
