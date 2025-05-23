package com.sebasth.bank.api;

import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Iterator;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.json.JSONException;
import org.json.JSONObject;

import javax.print.DocFlavor;

public class CurrencyService {
    private static final String BASE_API = "https://v6.exchangerate-api.com/v6/";
    private static final String API_KEY = "832dcf71d9f56b2a19bc98d7";
    private static HttpClient httpClient = HttpClient.newHttpClient();

    public void getExchangeRate(String baseCurrency) {
        String url = BASE_API + API_KEY + "/latest/" + baseCurrency;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenAccept(response -> {
                    try {
                        if (response.statusCode() == 200) {
                            String responseBody = response.body();
                            JSONObject jsonResponse = new JSONObject(responseBody);
                            if ("success".equals(jsonResponse.getString("result"))) {
                                JSONObject rates = jsonResponse.getJSONObject("rates");
                                // Imprimir las tasas de cambio
                                System.out.println("Exchange rates for " + baseCurrency + ":");
                                for (Iterator<String> it = rates.keys(); it.hasNext(); ) {
                                    String currencyCode = it.next();
                                    System.out.println(currencyCode + ": " + rates.getDouble(currencyCode));
                                }
                            } else {
                                System.out.println("Error: " + jsonResponse.getString("error-type"));
                            }
                        } else {
                            System.out.println("Error: " + response.statusCode());
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                })
                .exceptionally(e -> {
                    e.printStackTrace();
                    return null;
                });
    }
    public void getExchangeRate(String baseCurrency, String targetCurrency){
        String url = BASE_API + API_KEY + "/pair/" + baseCurrency + "/" + targetCurrency;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenAccept(response -> {
                    try {
                        if (response.statusCode() == 200) {
                            String responseBody = response.body();
                            JSONObject jsonResponse = new JSONObject(responseBody);
                            if ("success".equals(jsonResponse.getString("result"))) {
                                double rate = jsonResponse.getDouble("conversion_rate");
                                System.out.println("Exchange rate from " + baseCurrency + " to " + targetCurrency + ": " + rate);
                            } else {
                                System.out.println("Error: " + jsonResponse.getString("error-type"));
                            }
                        } else {
                            System.out.println("Error: " + response.statusCode());
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                })
                .exceptionally(e -> {
                    e.printStackTrace();
                    return null;
                });
        }
}
