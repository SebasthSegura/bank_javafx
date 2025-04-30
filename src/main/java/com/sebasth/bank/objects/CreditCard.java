package com.sebasth.bank.objects;

public class CreditCard {
    private String number;
    private double limit;
    private double balance;
    private String expirateDate;

    public CreditCard(String number, String expirateDate){
        this.number = number;
        this.expirateDate = expirateDate;
        this.limit = 100;
        this.balance = 100;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getExpirateDate() {
        return expirateDate;
    }

    public void setExpirateDate(String expirateDate) {
        this.expirateDate = expirateDate;
    }

    public boolean makePurchase(double amount){
        if(balance >= amount){
            limit -= amount;
            return true;
        }
        return false;
    }
}
