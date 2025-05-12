package com.sebasth.bank.objects;

import java.util.Objects;

public class CreditCard {
    private Long cardId;
    private String number;
    private double creditLimit;
    private double aviableBalance;
    private String expirateDate;
    private long userId;
    private String cardType;


    /*agregamos los constructores (builders)*/
    public CreditCard(String number, String expirateDate, String cardType){
        this.number = number;
        this.expirateDate = expirateDate;
        this.cardType = cardType;
        this.creditLimit = 100.0;
        this.aviableBalance = 100.0;
    }

    public CreditCard(Long cardId, String number, double creditLimit, double aviableBalance, String expirateDate, Long userId, String cardType){
        this.cardId = cardId;
        this.number = number;
        this.creditLimit = creditLimit;
        this.aviableBalance = aviableBalance;
        this.expirateDate = expirateDate;
        this.userId = userId;
        this.cardType = cardType;
    }

    /*ageregamos los getters y setters*/
    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public double getAviableBalance() {
        return aviableBalance;
    }

    public void setAviableBalance(double aviableBalance) {
        this.aviableBalance = aviableBalance;
    }

    public String getExpirateDate() {
        return expirateDate;
    }

    public void setExpirateDate(String expirateDate) {
        this.expirateDate = expirateDate;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    /*metodos de las tarjetas comprar y pagar*/
    public boolean makePurchase(double amount){
        if(aviableBalance >= amount){
            creditLimit -= amount;
            return true;
        }
        return false;
    }

    public void makePayment(double amount){
        if(amount > 0){
            aviableBalance += amount;
            if(aviableBalance > creditLimit){
                aviableBalance = creditLimit;
            }
        }
    }

    /*sobre escribimos los metodos equals, hash y toString para verificar si la tarjeta es valida*/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreditCard that = (CreditCard) o;
        return Double.compare(that.creditLimit, creditLimit) == 0 && Double.compare(that.aviableBalance, aviableBalance) == 0 && Objects.equals(number,that.number) && Objects.equals(expirateDate, that.expirateDate) && Objects.equals(userId,that.userId) && Objects.equals(cardType, that.cardType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardId, number, creditLimit, aviableBalance, expirateDate, userId, cardType);
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "cardId=" + cardId +
                ", number='" + number + '\'' +
                ", creditLimit=" + creditLimit +
                ", aviableBalance=" + aviableBalance +
                ", expirateDate='" + expirateDate + '\'' +
                ", userId=" + userId +
                ", cardType='" + cardType + '\'' +
                '}';
    }
}
