package org.javaacademy.currency_calc.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Map;

@Data
public class FreeCurrencyDtoRs {
    private Map<String, BigDecimal> data;
}
