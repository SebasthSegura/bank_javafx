package com.sebasth.bank.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import com.sebasth.bank.objects.Login;
import javafx.scene.control.TextField;
import java.awt.*;


public class LoginController {

    @FXML
    private javafx.scene.control.TextField passwordTextField;

    @FXML
    private javafx.scene.control.TextField userNameTextField;

    @FXML
    private javafx.scene.control.TextField emailTextField;

    @FXML
    private Button loginButton;

    @FXML
    private Button registerButton;

    @FXML
    private void handleLoginAction() {
        String userName = userNameTextField.getText();
        String password = passwordTextField.getText();
        String email = emailTextField.getText();

        // Manipular el inicio de sesion
        System.out.println("Usuario: " + userName);
        System.out.println("Contraseña: " + password);
        System.out.println("Email: " + email);
    }
}