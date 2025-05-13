package com.sebasth.bank.controllers;

import com.sebasth.bank.objects.CreditCard;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class CreditCardController {
    @FXML
    private AnchorPane credicardPane;

    @FXML
    private Label numberCard;

    @FXML
    private Label expiryDate;

    private CreditCard card;

    public void setCreditCard(CreditCard card) {
        this.card = card;
        if(numberCard != null){
            numberCard.setText("Numero de Tarjeta: " + card.getNumber());
            numberCard.setStyle("-fx-font-size: 20px; -fx-text-fill: #000000; -fx-padding: 10px;");
        }
        if (expiryDate != null){
            expiryDate.setText("Fecha de Expiracion: " + card.getExpirateDate());
            expiryDate.setStyle("-fx-font-size: 20px; -fx-text-fill: #000000; -fx-padding: 10px;");
        }
    }
}
