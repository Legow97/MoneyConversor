package com.alura.moneyconversor.validerrors;

public class ValidOptionException extends Exception{
    public ValidOptionException() {
    }

    public ValidOptionException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "Error "+ this.getClass().getName()+"\n"+
                "Mensaje: "+this.getMessage()+"\n";
    }
}
