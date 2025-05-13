package com.sebasth.bank.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import com.sebasth.bank.objects.User;

public class UserController {
    private User currentUser; // variable para almacenar el usuario actual u objeto modelo

    @FXML
    private Label userNameLabel; // etiqueta para mostrar el nombre del usuario

    @FXML
    private Label walletBalanceLabel; // etiqueta para mostrar el saldo del usuario

    /*metodo para recibir el objeto user (este podria ser llamado al cargar la vista)*/

    public void setUser(User user) {
        this.currentUser = user;
        updateView();
    }

    /*creamos el metodo que vamos a llamar arriba para actualizar la vista*/
    private void updateView() {
        if (currentUser != null) {
            userNameLabel.setText("Usuario: " + currentUser.getUserName());
            walletBalanceLabel.setText("Saldo: $" + String.format("%.2f ", currentUser.getWalletBalance()));
        } else {
            userNameLabel.setText("Usuario no ENCONTRADO");
            walletBalanceLabel.setText("saldo: $0.00");
        }

    }

    /*creamos metodos para manejar eventos de la interfaz de usuario*/
    @FXML
    private void handleDepositButtonAction() {
        // obtener el monto del deposito desde la interfaz de usuario
        double depositAmount = 50.0;
        currentUser.depositToWallet(depositAmount);
        updateView();
    }
    @FXML
    private void handleWithdrawButtonAction() {
        // obtener el monto del retiro desde la interfaz de usuario
        double withdrawAmount = 20.0;
        if (currentUser.withdrawFromWallet(withdrawAmount)) {
            updateView();
        }else {
            walletBalanceLabel.setText("Saldo insuficiente");
        }
    }
}