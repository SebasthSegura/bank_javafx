package com.sebasth.bank.objects;

import java.util.Objects;

public class Wallet {
    private String accountID;
    private Long walletId;
    private double balance;
    private double limit;
    private Long userId;

    /*creamos un constructor generico que dara el saldo inicial de la billetera*/
    public Wallet(double initialbalance){
        this.balance = initialbalance;
    }

    /*creamos un constructor mas completo*/
    public Wallet(Long walletId, String accountID, double balance, double limit, long userId){
        this.walletId = walletId;
        this.accountID = accountID;
        this.balance = balance;
        this.limit = limit;
        this.userId = userId;
    }

    /*agregamos los getters y setters*/
    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public Long getWalletId() {
        return walletId;
    }

    public void setWalletId(Long walletId) {
        this.walletId = walletId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /*agregamos los metodos para gestionar la billetera (retirar y depositar)*/
    public boolean withdraw(double amount){
        if(balance >= amount){
            balance -= amount;
            return true;
        }
        return false;
    }
    public boolean deposit(double amount){
        if (amount > 0 && amount <= limit){
            balance += amount;
            return true;

        }else {
            return false;
        }
    }
    /*sobreescribimos los metodos equals, hashCode y toString para verificar si la billetera es valida*/

    @Override
    public int hashCode() {
        return Objects.hash(accountID, walletId, balance, limit, userId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null ||getClass() != o.getClass()) return false;
        Wallet wallet = (Wallet) o;
        return Double.compare(wallet.balance, balance) == 0 && Double.compare(wallet.limit, limit) == 0 && Objects.equals(accountID, wallet.accountID) && Objects.equals(walletId, wallet.walletId) && Objects.equals(userId, wallet.userId);
    }

    @Override
    public String toString() {
        return "wallet{" +
                "accountID=" + accountID
                + ", walletId=" + walletId
                + ", balance=" + balance + ", limit="
                + limit + ", userId=" + userId + '}';
    }
}
