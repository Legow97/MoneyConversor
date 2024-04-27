package com.alura.moneyconversor;

import com.alura.moneyconversor.validerrors.ValidOptionException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {


     public static void main(String[] args) throws InterruptedException {

         Gson gson = new GsonBuilder()
                 .setPrettyPrinting()
                 .create();

         System.out.println("Conversor de Moneda\n");

         while(true){

             Thread.sleep(2000);

             try {
                 System.out.println("""
                         1) Dólar --> Peso Argentino
                         2) Peso Argentino --> Dolar
                         3) Dólar --> Real Brasileño
                         4) Real Brasileñp --> Dólar
                         5) Dólar --> Peso Colombiano
                         6) Peso Colombiano --> Dólar
                         7) Salir
                         """);
                 System.out.println("***************************************************");

                 UsrInterface usrInterface = new UsrInterface();
                 try {
                     usrInterface.chooseOpc();
                 } catch (ValidOptionException e) {
                     System.out.println(e.getMessage());
                     continue;
                 }

                 if (usrInterface.getOpc() == 7) {
                     break;
                 }


                 //validación de que el monto sea correcto
                 boolean mt = true;

                 while (mt) {
                     try {
                         usrInterface.setValue();
                         mt = false;
                     } catch (ValidOptionException e) {
                         System.out.println(e.getMessage());
                     }
                 }

                 String direction = usrInterface.getDirection();

                 HttpClient client = HttpClient.newHttpClient();

                 HttpRequest request = HttpRequest.newBuilder()
                         .uri(URI.create("https://v6.exchangerate-api.com/v6/8ed0fbfcf3ba8d92b80c8bff/latest/" + direction))
                         .build();

                 HttpResponse<String> response = client
                         .send(request, HttpResponse.BodyHandlers.ofString());


                 String json = response.body();
                 ExchangeRate exchangeRate = gson.fromJson(json, ExchangeRate.class);

                 Rate myRate = new Rate(exchangeRate);

                 Double mountConvert = myRate.convertMoney(usrInterface.getValue(), usrInterface.getToConvert());

                 System.out.println("El valor" + usrInterface.getValue()+"["+usrInterface.getDirection() + "]+"
                                    + "corresponde al valor final de =>>>"+mountConvert+"["+usrInterface.getToConvert()+"]");


                 System.out.println("***************************************************\n");
             }catch (IllegalArgumentException e){
             System.out.println("La opción no es válida");
             } catch (Exception e) {
                 System.out.println("Se produjo un Error intente nuevamente");
             }
         }



    }

    /*
    ARS - Peso argentino
    BOB - Boliviano boliviano
    BRL - Real brasileño
    CLP - Peso chileno
    COP - Peso colombiano
    USD - Dólar estadounidense
    */
}
