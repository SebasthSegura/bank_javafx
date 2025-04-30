package com.sebasth.bank;

import com.sebasth.bank.controllers.CreditCardController;
import com.sebasth.bank.objects.CreditCard;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class SistemBank extends Application {
    private StackPane mainPane; //panel Principal a usar

    private Label balanceLabel;
    private TextField descriptionInput;
    private TextField priceInput;
    private TextArea purchasesArea;

    @Override
    public void start(Stage stage) throws IOException {

        /*FXMLLoader mainPanel decimos que va a ser como una variable que la inicializaremos con
         la vista a mostrar para que se pueda llamar el panel*/
        FXMLLoader mainPanel = new FXMLLoader(SistemBank.class.getResource("main-view.fxml"));

        /*llamamos nuestra variable mainPane para que sea igual a lo que contiene mainPanel y lo cargue
         con la funcion load()*/
        mainPane = mainPanel.load();

        //damos parametros de tamaño
        Scene scene = new Scene(mainPane, 320, 240);

        //damos un nombre
        stage.setTitle("MeBank");
        stage.setScene(scene);

        //mostramos
        stage.show();

        /*llamamos la funcion showCreditCardView y creamos una nueva tarjeta de credito para que
         se muestre con la nueva vista*/
        showCreditCardView(new CreditCard("1231-1213-3431", "10/25"));
    }

    /*creamos el metodo para que exista y no genere errores ademas poder usarlo*/
    public void showCreditCardView(CreditCard creditCard) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("creditCard-view.fxml"));
        javafx.scene.layout.VBox creditCardPane = loader.load();

        //llamamos el controlador
        CreditCardController controller = loader.getController();

        //añadimos nuestra nueva variable al controlador como parametro principal
        controller.setCreditCard(creditCard);

        //limpamos el contenedor principal para llamar una nueva vista
        mainPane.getChildren().clear();
        mainPane.getChildren().add(creditCardPane);

    }

    public static void main(String[] args) {
        launch();
    }
}