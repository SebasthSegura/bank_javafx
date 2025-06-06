package com.sebasth.bank.controllers;

import com.sebasth.bank.SistemBank;
import com.sebasth.bank.objects.User;
import com.sebasth.bank.objects.CreditCard;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.Node;
import javafx.scene.control.Button;

import java.io.IOException;

public class BankController {
    @FXML
    private Label bankLabelText;
    private Label serviceLabelText;

    @FXML
    private BorderPane mainPane;

    private SistemBank mainApp;

    private User currentUser;

    public void setMainApp(SistemBank mainApp){
        this.mainApp = mainApp;
    }
    public void  setCurrentUser(User user){
        this.currentUser = user;
    }

    @FXML
    public void initialize() {
        if (mainPane == null) {
            System.out.println("mainPane no está inicializado.");
        } else {
            System.out.println("mainPane inicializado correctamente.");
        }
    }

    @FXML
    private void navigateToUserView(){
        if (mainApp != null && currentUser != null){
            mainPane.getChildren().clear();
            try {
                mainApp.showUserView(currentUser);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    @FXML
    private  void  navigateToWalletView(){
        if (mainApp != null && currentUser != null){
            mainPane.getChildren().clear();
            try{
                mainApp.showWalletView(currentUser);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void navigateToAddCreditCardView(){
        if(mainApp != null){
            mainPane.getChildren().clear();
            try{
                mainApp.showAddCreditCardView(new CreditCard("XXXX-XXXX-XXXX-4381", "9/29", "MasterCard"));
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void navigateToCreditCardView(){
        if (mainApp != null){
            mainPane.getChildren().clear();
            CreditCard sampleCard = new CreditCard("XXXX-XXXX-XXXX-6361", "12/29", "Visa");
            try {
                mainApp.showCreditCardView(sampleCard);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
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

    @FXML
    private  void navegateToLoginView(){
        if (mainApp != null){
            mainPane.getChildren().clear();
            try {
                mainApp.showLoginView();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void navegateToRegisterView(){
        if (mainApp != null){
            mainPane.getChildren().clear();
            try {
                mainApp.showRegisterView();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}