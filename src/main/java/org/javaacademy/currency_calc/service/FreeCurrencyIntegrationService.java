package org.javaacademy.currency_calc.service;

import lombok.RequiredArgsConstructor;
import org.javaacademy.currency_calc.config.FreeCurrencyProperties;
import org.javaacademy.currency_calc.dto.CurrencyDtoRq;
import org.javaacademy.currency_calc.dto.CurrencyDtoRs;
import org.javaacademy.currency_calc.dto.FreeCurrencyDtoRs;
import org.javaacademy.currency_calc.exception.IntegrationException;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
@RequiredArgsConstructor
public class FreeCurrencyIntegrationService {
    private static final String CURRENCY_NAME = "RUB";
    private static final String POSTFIX_URL_GET_RUB_TEMPLATE = "/latest?base_currency=%s&currencies=%s";
    private final RestTemplate restTemplate;
    private final FreeCurrencyProperties properties;

    public CurrencyDtoRs convertCurrency(CurrencyDtoRq currencyDtoRq) {
        String postfixUrl = POSTFIX_URL_GET_RUB_TEMPLATE.formatted(currencyDtoRq.getToCurrencyName(), CURRENCY_NAME);
        RequestEntity<Void> request = RequestEntity
                .get(properties.getBaseUrl() + postfixUrl)
                .header(properties.getHeaderTokenName(), properties.getToken())
                .build();
        ResponseEntity<FreeCurrencyDtoRs> response;
        try {
            response = restTemplate.exchange(request, FreeCurrencyDtoRs.class);
        } catch (Throwable throwable) {
            throw new IntegrationException();
        }

        FreeCurrencyDtoRs freeCurrencyDtoRs = response.getBody();
        BigDecimal dollarRate = freeCurrencyDtoRs.getData().get(CURRENCY_NAME);
        BigDecimal dollarAmount = currencyDtoRq.getAmountRub().divide(dollarRate, 2, RoundingMode.CEILING);
        return new CurrencyDtoRs(currencyDtoRq.getToCurrencyName(), dollarAmount, dollarRate);
    }
}
