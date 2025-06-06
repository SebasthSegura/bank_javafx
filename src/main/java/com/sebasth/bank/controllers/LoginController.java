package com.sebasth.bank.controllers;

import com.sebasth.bank.SistemBank;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import com.sebasth.bank.objects.Login;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.awt.*;


public class LoginController {

    @FXML
    private TextField userNameLabel, emailLabel;

    @FXML
    private BorderPane mainPane;

    private SistemBank mainApp;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button bLogin, bRegister;

    @FXML
    private void init() {
        bLogin.setOnAction(event -> handleLogin());
    }

    private void handleLogin() {
        Login login = new Login(
                userNameLabel.getText(),
                passwordField.getText(),
                emailLabel.getText()
        );

        /*Validamos las credenciales*/
        if (login.getUserName().isEmpty() || login.getPassword().isEmpty()) {
            showAlert("Error", "Por favor, ingrese su nombre de usuario y contraseña.");
            return;
        } else {
            showAlert("Ingreso exitoso", "Bienvenido " + login.getUserName() + "!");
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private boolean validateUser(Login login) {
        /*
        insertaremos aquí las validaciones a la base de datos para validar el usuario o una lista
         */
        return "usuario".equals(login.getUserName()) && "1234".equals(login.getPassword());
    }

    public void setMainApp(SistemBank mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void navigateToRegisterView(){
        if (mainApp != null){
            try {
                mainApp.showRegisterView();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}