package com.sebasth.bank.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import com.sebasth.bank.SistemBank;
import com.sebasth.bank.objects.Register;
import com.sebasth.bank.objects.User;
import javafx.scene.control.*;
import javafx.scene.control.Alert;

public class RegisterController {
    @FXML
    private TextField nameLabel, lasNameLabel, userNameLabel, emailLabel;

    @FXML
    private PasswordField passwordLabel, repeatPasswordLabel;

    @FXML
    private SistemBank mainApp;

    @FXML
    private Button bRegister;

    @FXML
    private void init() {
        bRegister.setOnAction(event -> handleRegister());
    }
    public void setMainApp(SistemBank mainApp) {
        this.mainApp = mainApp;
    }

    private void handleRegister(){
        Register register = new Register(
                nameLabel.getText(),
                lasNameLabel.getText(),
                userNameLabel.getText(),
                emailLabel.getText(),
                passwordLabel.getText(),
                repeatPasswordLabel.getText()
        );

        /*validamos contaseñas*/
        if (!passwordLabel.getText().equals(repeatPasswordLabel.getText())){
            showAlert("Error", "Las contraseñas no coinciden");
            return;
        }

       /*creamos un objeto user apartir del registro*/
       User newUser = new User(
       );

       /*ponemos un alerta que se guardo el usuario*/
        showAlert("Registro exitoso", "Usuario registrado correctamente de: " + newUser.getUserName());
    }
    private void showAlert(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
