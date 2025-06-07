package com.sebasth.bank.controllers;
import com.sebasth.bank.SistemBank;
import com.sebasth.bank.objects.User;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import com.sebasth.bank.objects.User;
import  javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;

import javax.swing.*;

public class UserController {
    private User currentUser; // variable para almacenar el usuario actual u objeto modelo

    @FXML
    private Label userNameLabel; // etiqueta para mostrar el nombre del usuario

    @FXML
    private Label walletBalanceLabel; // etiqueta para mostrar el saldo del usuario

    @FXML
    private Label nameInfo,
            lastNameInfo,
            ageInfo,
            userInfo,
            descriptionLabel,
            emailInfo,
            numberIdInfo;

    @FXML
    private TextField nameInfoText,
            lastNameInfoText,
            ageInfoText,
            emailInfoText,
            numberIdInfoTex,
            userNameText,
            userInfoText;

    @FXML
    private TextArea descriptionTextInfo;

    @FXML
    private Button bBack, bUpdate;

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
            nameInfoText.setText("Nombre: " + currentUser.getFirstName());
            lastNameInfoText.setText("Apellido: " + currentUser.getLastName());
            ageInfoText.setText("Edad: " + currentUser.getAge());
            emailInfoText.setText("Email: " + currentUser.getEmail());
            descriptionTextInfo.setText("Descripción: " + currentUser.getDescription());
            numberIdInfoTex.setText("ID: " + currentUser.getUserId());
        } else {
            userNameLabel.setText("Usuario no ENCONTRADO");
            walletBalanceLabel.setText("saldo: $0.00");
        }
    }

    /*creamos metodos para manejar eventos de la interfaz de usuario*/
    @FXML
    private void handleDepositButtonAction() {
        // obtener el monto del deposit desde la interfaz de usuario
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

    @FXML
    public void handleUpdateButtonAction() {
        if (currentUser != null){
            currentUser.setFirstName(nameInfoText.getText());
            currentUser.setLastName(lastNameInfoText.getText());
            currentUser.setAge(Integer.parseInt(ageInfoText.getText()));
            currentUser.setEmail(emailInfoText.getText());
            currentUser.setDescription(descriptionTextInfo.getText());
            currentUser.setUserName(userNameText.getText());
            currentUser.setNumberId(numberIdInfoTex.getText());
            updateView();
        }
    }

    @FXML
    private
    void handleBackButtonAction() {
        System.out.println("Volviendo a la vista anterior...");
    }

    @FXML
    public  void initialize() {
        if(userNameLabel != null){
            userNameLabel.setText("Cargando usuario...");
        } else {
            System.out.println("userNameLabel no está inicializado.");
        }
        if (walletBalanceLabel != null){
            walletBalanceLabel.setText("Cargando saldo...");
        } else {
            System.out.println("walletBalanceLabel no está inicializado.");
        }
    }
}