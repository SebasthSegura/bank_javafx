package com.sebasth.bank.objects;

public class Wallet {
    private String accountID;
    private double balance;
    private double limit;

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    public Wallet(String accountID){
        this.limit = 100;
        this.balance = 100;
    }
}
