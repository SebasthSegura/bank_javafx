package com.sebasth.bank.controllers;

import com.sebasth.bank.objects.CreditCard;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class AddCreditCardController {

    @FXML
    private TextField cardNumberTextField;

    @FXML
    private TextField expiryDateTextField;

    @FXML
    private TextField cardTypeField;

    @FXML
    private void handleAddCardAction(){
        String cardNumber = cardNumberTextField.getText();
        String expireDate = expiryDateTextField.getText();
        String cardType = cardTypeField.getText();

        //messages create object
        CreditCard newCard = new CreditCard(cardNumber, expireDate, cardType);
        System.out.println("Nueva tarjeta agregada: " + newCard.getNumber());
        System.out.println("numero de tarjeta: " + newCard.getNumber());
        System.out.println("Expiracion: " + newCard.getExpirateDate());
        System.out.println("Tipo de tarjeta: " + newCard.getCardType());
    }
    //agregamos un metodo para limpiar los campos de texto
    private void clearFields(){
     cardNumberTextField.clear();
     expiryDateTextField.clear();
     cardTypeField.clear();
    }
    //agregamos el metodo de inicicializacion para que se limpie cuando se inicialice
    @FXML
    public void initialize() {
        // Este método se llama automáticamente al cargar la vista
        clearFields();
    }
}
