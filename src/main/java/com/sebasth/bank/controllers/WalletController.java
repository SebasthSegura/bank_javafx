package com.sebasth.bank.controllers;

import com.sebasth.bank.objects.User;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class WalletController {
    @FXML
    private Label currentBalanceLabel;

    private User currentUser; // variable para almacenar el usuario actual u objeto modelo

    public void setUser(User user){
        this.currentUser = user;
        updateBalanceLabel();
    }
    private void  updateBalanceLabel(){
        if (currentBalanceLabel != null && currentUser != null){
            currentBalanceLabel.setText("Saldo $" + String.format("%.2f", currentUser.getWalletBalance()));
        }
    }

    @FXML
    public void initialize() {
        // Este método se llama automáticamente al cargar la vista
        if (currentUser != null) {
            updateBalanceLabel();
        }
    }
}
