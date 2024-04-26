package org.javaacademy.currency_calc.dto;

import lombok.Value;

import java.math.BigDecimal;

@Value
public class CurrencyDtoRs {
    String currencyName;
    BigDecimal amount;
    BigDecimal rate;
}
