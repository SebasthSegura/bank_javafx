package com.sebasth.bank;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class BankController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Bienvenido a JavaFX Application usada por sebasth 1!");
    }
}