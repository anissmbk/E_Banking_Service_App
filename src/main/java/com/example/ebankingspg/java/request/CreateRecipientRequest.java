package com.example.ebankingspg.java.request;

//aniss
public class CreateRecipientRequest {
    private long clientId;
    private String fullName;
    private String rib;

    public CreateRecipientRequest(long clientId, String fullName, String rib) {
        this.clientId = clientId;
        this.fullName = fullName;
        this.rib = rib;
    }

    public CreateRecipientRequest() {
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRib() {
        return rib;
    }

    public void setRib(String rib) {
        this.rib = rib;
    }
}
