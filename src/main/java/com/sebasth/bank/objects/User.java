package com.sebasth.bank.objects;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private List<CreditCard> creditCards;
    private int age;
    private int numberId;
    private double wallet;


    // metodo para poder ingresar un usuario y los parametros que recibira
    public User(String username){
        this.username = username;
        this.creditCards = new ArrayList<>(creditCards);
        this.wallet = new Wallet(0).getBalance();
    }

    //añadimos los getters
    public String getUsername() {
        return username;
    }

    public List<CreditCard> getCreditCards() {
        return creditCards;
    }

    public int getAge() {
        return age;
    }

    public int getNumberId() {
        return numberId;
    }

    public double getWallet() {
        return wallet;
    }

    //metodo para añadir al usuario una card  y los parametros que recibira.
    public void addCreditCard(CreditCard card){
        creditCards.add(card);
    }
}
