package com.sebasth.bank.objects;

import java.util.Objects;
import java.time.LocalDateTime;
import java.util.Date;

public class Authentication {
    private long userId;
    private String userName;
    private String hashedPassword;
    private LocalDateTime lastLogin;
    private String password;
    private Boolean isActive;

    /*constructor*/
    public Authentication(){

    }

    /*creamos su metodo de verficacion y obtencion de datos*/
    public Authentication(long userId, String userName, String hashedPassword){
        this.userId = userId;
        this.userName = userName;
        this.hashedPassword = hashedPassword;
        this.isActive = true;
        this.lastLogin = null;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
    /*creamos metodos adicionales*/


}
