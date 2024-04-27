package com.alura.moneyconversor;

import java.util.Map;

public class Rate {

    private String baseCode;

    private Map<String, Double> conversionRates;

    public Rate(){

    }

    public Rate(String baseCode, Map<String, Double> conversionRates) {
        this.baseCode = baseCode;
        this.conversionRates = conversionRates;
    }

    public Rate(ExchangeRate exchangeRate){
        this.baseCode = exchangeRate.base_code();
        this.conversionRates = exchangeRate.conversion_rates();

    }

    public String getBaseCode() {
        return baseCode;
    }

    public Map<String, Double> getConversionRates() {
        return conversionRates;
    }

    public Double searchRate(String type){
        return this.conversionRates.get(type);
    }

    public Double convertMoney(Double mount, String type){
        return mount*searchRate(type);
    }
}
