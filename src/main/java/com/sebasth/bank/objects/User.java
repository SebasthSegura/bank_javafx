package com.sebasth.bank.objects;

public class User {
    private String username;
    private String  listCrediCards;
    private int age;
    private int numberId;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getListCrediCards() {
        return listCrediCards;
    }

    public void setListCrediCards(String listCrediCards) {
        this.listCrediCards = listCrediCards;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNumberId() {
        return numberId;
    }

    public void setNumberId(int numberId) {
        this.numberId = numberId;
    }
}
