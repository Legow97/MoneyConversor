package com.alura.moneyconversor;

import java.util.Scanner;

public class UsrInterface {

    public Double value;

    public Integer opc;
    public String direction;
    public String toConvert;

    public UsrInterface(){

    }

    public void chooseOpc()throws Exception{

        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce una Opción válida:");
        this.opc = scanner.nextInt();

        if(opc<0 | opc>7){
            throw new ValidOptionException("La opción no es válida");
        }

        switch (opc){
            case 1:
                this.direction = "USD";
                this.toConvert = "ARS";
                break;
            case 2:
                this.direction = "ARS";
                this.toConvert = "USD";
                break;
            case 3:
                this.direction = "USD";
                this.toConvert = "BRL";
                break;
            case 4:
                this.direction = "BRL";
                this.toConvert = "USD";
                break;
            case 5:
                this.direction = "USD";
                this.toConvert = "COP";
                break;
            case 6:
                this.direction = "COP";
                this.toConvert = "USD";
                break;
            case 7:
                break;

        }
    }

    public Double getValue() {
        return value;
    }

    public int getOpc() {
        return opc;
    }

    public String getDirection() {
        return direction;
    }

    public String getToConvert() {
        return toConvert;
    }

    public void setValue() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el valor que desea convertir:");
        Double value = scanner.nextDouble();
        if( value == null | value<0){
            throw new ValidOptionException("Error al ingresar el valor del monto");
        }
        this.value = value;
    }
}
