package com.alura.moneyconversor.validerrors;

public class InvalidInputException extends Exception{
    public InvalidInputException() {
    }

    public InvalidInputException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "Error "+ this.getClass().getName()+"\n"+
                "Mensaje: "+this.getMessage()+"\n";
    }
}
