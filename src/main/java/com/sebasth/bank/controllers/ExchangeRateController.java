package com.sebasth.bank.controllers;

import com.sebasth.bank.api.CurrencyService;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.lang.annotation.Target;

public class ExchangeRateController {
    @FXML
    private ComboBox<String> baseCurrencyComboBox;

    @FXML
    private ComboBox<String> targetCurrencyComboBox;

    @FXML
    private Label exchangeRateLabel;

    private CurrencyService currencyService = new CurrencyService();

    @FXML
    public void initialize(){

        /*inicializamos los comboBox con las monedas de mi preferencia*/
        baseCurrencyComboBox.getItems().addAll("COP","USD", "EUR", "GBP", "JPY", "AUD");
        targetCurrencyComboBox.getItems().addAll("COP","USD", "EUR", "GBP", "JPY", "AUD");
    }
    @FXML
    private void getRateButtonClicked(){
        String baseCurrency = baseCurrencyComboBox.getValue();
        String targetCurrency = targetCurrencyComboBox.getValue();

        if (baseCurrency != null && targetCurrency != null){
            currencyService.getExchangeRate(baseCurrency, targetCurrency);
        }else {
            exchangeRateLabel.setText("Por favor selecciona ambas monedas.");
        }
    }
    @FXML
    private void getAllRatesButtonClicked(){
        String baseCurrency = baseCurrencyComboBox.getValue();
        if (baseCurrency != null){
            currencyService.getExchangeRate(baseCurrency);
        }else {
            exchangeRateLabel.setText("Por favor selecciona una moneda base.");
        }
    }

}

