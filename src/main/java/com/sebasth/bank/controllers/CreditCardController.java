package com.sebasth.bank.controllers;

import com.sebasth.bank.objects.CreditCard;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class CreditCardController {
    @FXML
    private Label numberCard;

    @FXML
    private Label expiryDate;

    public void setCreditCard(CreditCard card) {
        numberCard.setText(card.getNumber());
        expiryDate.setText(card.getExpirateDate());
    }
}
