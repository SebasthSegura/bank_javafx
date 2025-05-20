package com.sebasth.bank.objects;

import kotlin.random.URandomKt;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {
    private Long userId;
    private String userName;
    private String firstName;
    private String lastName;
    private List<CreditCard> creditCards;
    private int age;
    private String numberId;
    private double walletBalance;


    // metodo para poder ingresar un usuario y los parametros que recibira
    public User(String userName){
        this.userName = userName;
        this.creditCards = new ArrayList<>();
        this.walletBalance = new Wallet(0).getBalance();
    }

    // constructor para crear un usuario con todos los datos
    public User(Long userId, String userName, String firstName, String lastName, List<CreditCard> creditCards, int age, String numberId, double walletBalance) {
        this.userId = userId;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.creditCards = new ArrayList<>(creditCards);
        this.age = age;
        this.numberId = numberId;
        this.walletBalance = walletBalance;
    }


    //añadimos los getters
    public String getUserName() {
        return userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<CreditCard> getCreditCards() {
        return creditCards;
    }

    public int getAge() {
        return age;
    }

    public String getNumberId() {
        return numberId;
    }

    public double getWalletBalance() {
        return walletBalance;
    }

    //setter para poder modificar los datos del usuario


    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCreditCards(List<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setNumberId(String numberId) {
        this.numberId = numberId;
    }

    public void setWalletBalance(double walletBalance) {
        this.walletBalance = walletBalance;
    }


    //metodo para añadir al usuario una card y los parametros que recibira.
    public void addCreditCard(CreditCard card){
        creditCards.add(card);
    }
    public void depositToWallet(double amount){
        if (amount > 0 && amount <= 10000) {
            walletBalance += amount;
        } else {
            System.out.println("Monto inválido. Por favor ingrese un valor entre 0 y 10000.");
        }
    }
    public boolean withdrawFromWallet(double amount){
        if (amount > 0 && this.walletBalance >= amount){
            this.walletBalance -= amount;
            return true;
        } else {
            System.out.println("Monto inválido o saldo insuficiente.");
            return false;
        }
    }

    /*sobreescribimos los metodos Hash, toString y equals
    * yaque el nombre de usuario es unico
    */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return  age == user.age && Double.compare(user.walletBalance, walletBalance) == 0 && Objects.equals(userName, user.userName) && Objects.equals(numberId, user.numberId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName,age, numberId, walletBalance);
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", creditCards=" + creditCards +
                ", age=" + age +
                ", numberId='" + numberId + '\'' +
                ", walletBalance=" + walletBalance +
                '}';
    }
}
