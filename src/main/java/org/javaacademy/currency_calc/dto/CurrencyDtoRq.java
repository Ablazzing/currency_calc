package org.javaacademy.currency_calc.dto;

import lombok.Value;

import java.math.BigDecimal;

@Value
public class CurrencyDtoRq {
    String toCurrencyName; // to usd
    BigDecimal amountRub; // 1_000_000
}
