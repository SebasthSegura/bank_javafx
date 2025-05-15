package com.sebasth.bank;

import com.sebasth.bank.controllers.CreditCardController;
import com.sebasth.bank.controllers.UserController;
import com.sebasth.bank.objects.CreditCard;
import com.sebasth.bank.objects.User;
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

        scene.getStylesheets().add(getClass().getResource("styles/MainStyle.css").toExternalForm());

        //damos un nombre
        stage.setTitle("MeBank");
        stage.setScene(scene);

        //mostramos
        stage.show();

        /*creamos un usuario para mostrar la vista del usuario*/
        User usuarioActual = new User("Sebasth");
        usuarioActual.setFirstName("Sebastian");
        usuarioActual.setLastName("Segura");
        usuarioActual.setAge(20);
        usuarioActual.setWalletBalance(150.0);
        showUserView(usuarioActual);

        /*llamamos la funcion showCreditCardView y creamos una nueva tarjeta de credito para que
         se muestre con la nueva vista*/
        showCreditCardView(new CreditCard("1231-1213-3431", "10/25", "Visa"));
    }

    /*creamos los metodos para poder visualizar las vistas*/
    /*Vista Tarjetas de creditos*/
    public void showCreditCardView(CreditCard creditCard) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("creditCard-view.fxml"));
        javafx.scene.layout.AnchorPane creditCardPane = loader.load();

        //llamamos el controlador
        CreditCardController controller = loader.getController();

        //añadimos nuestra nueva variable al controlador como parametro principal
        controller.setCreditCard(creditCard);

        //limpamos el contenedor principal para llamar una nueva vista
        mainPane.getChildren().clear();
        mainPane.getChildren().add(creditCardPane);

    }
    /*Vista Usuario*/
    public void showUserView(User user) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("user-view.fxml"));
        javafx.scene.layout.VBox userPane = loader.load();

        //llamamos el controlador
        UserController userController= loader.getController();

        //añadimos nuestra nueva variable al controlador como parametro principal
        userController.setUser(user);

        //limpamos el contenedor principal para llamar una nueva vista
        mainPane.getChildren().clear();
        mainPane.getChildren().add(userPane);
    }

/*Vista añadir tarjetas de credito*/
public void showAddCreditCardView(CreditCard credit) throws IOException {

    FXMLLoader loader = new FXMLLoader(getClass().getResource("add-Credit-Card-view.fxml"));
    javafx.scene.layout.AnchorPane addCreditCardPane = loader.load();

    //llamamos el controlador
    CreditCardController controller = loader.getController();

    //añadimos nuestra nueva variable al controlador como parametro principal
    controller.setCreditCard(credit);

    //limpamos el contenedor principal para llamar una nueva vista
    mainPane.getChildren().clear();
    mainPane.getChildren().add(addCreditCardPane);
}

/*Vista Cartera*/
public void showWalletView(User wallet) throws IOException {

    FXMLLoader loader = new FXMLLoader(getClass().getResource("wallet-view.fxml"));
    javafx.scene.layout.AnchorPane walletPane = loader.load();

    //llamamos el controlador
    UserController userController = loader.getController();

    //añadimos nuestra nueva variable al controlador como parametro principal
    userController.setUser(wallet);

    //limpamos el contenedor principal para llamar una nueva vista
    mainPane.getChildren().clear();
    mainPane.getChildren().add(walletPane);
}


    public static void main(String[] args) {
        launch();
    }
}