package com.sebasth.bank.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class BankController {
    @FXML
    private Label bankLabelText;
    private Label serviceLabelText;

    @FXML
    public void initialize() {
        bankLabelText.setText("welcome Bank aplication!");
    }

    @FXML
    private void handleBankServiceAction() {
        if (serviceLabelText == null) {
            serviceLabelText = new Label();
        }
        serviceLabelText.setText("Has seleccionado el servicio de banco");

        // Lógica adicional, como cambiar de vista o realizar una operación
        System.out.println("Servicio de banco activado");
    }
}