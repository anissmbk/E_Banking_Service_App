package com.example.ebankingspg.java.response;

public class StatistiqueResponse {

    private long totalClient;
    private long totalAgences;
    private double tauxDeChange;
    private double commissionTransfert;

    public StatistiqueResponse(int totalClient, int totalAgences, float tauxDeChange, float commissionTransfert) {
        this.totalClient = totalClient;
        this.totalAgences = totalAgences;
        this.tauxDeChange = tauxDeChange;
        this.commissionTransfert = commissionTransfert;
    }

    public StatistiqueResponse(long totalClient, long totalAgences, double exchangeRate, double transfert) {
        this.totalAgences = totalAgences;
        this.totalClient = totalClient;
        this.tauxDeChange = exchangeRate;
        this.commissionTransfert = transfert;
    }

    public long getTotalClient() {
        return totalClient;
    }

    public void setTotalClient(int totalClient) {
        this.totalClient = totalClient;
    }

    public long getTotalAgences() {
        return totalAgences;
    }

    public void setTotalAgences(int totalAgences) {
        this.totalAgences = totalAgences;
    }

    public double getTauxDeChange() {
        return tauxDeChange;
    }

    public void setTauxDeChange(float tauxDeChange) {
        this.tauxDeChange = tauxDeChange;
    }

    public double getCommissionTransfert() {
        return commissionTransfert;
    }

    public void setCommissionTransfert(double commissionTransfert) {
        this.commissionTransfert = commissionTransfert;
    }
}
