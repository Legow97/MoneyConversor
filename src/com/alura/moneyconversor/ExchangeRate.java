package com.alura.moneyconversor;

import java.util.Map;

public record ExchangeRate(String base_code, Map<String,Double> conversion_rates) {
}
