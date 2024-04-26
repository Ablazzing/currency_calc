package org.javaacademy.currency_calc.controller;

import lombok.RequiredArgsConstructor;
import org.javaacademy.currency_calc.dto.CurrencyDtoRq;
import org.javaacademy.currency_calc.dto.CurrencyDtoRs;
import org.javaacademy.currency_calc.service.FreeCurrencyIntegrationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/currency")
@RequiredArgsConstructor
public class CurrencyController {
    private final FreeCurrencyIntegrationService calcService;

    @PostMapping("/transfer")
    public CurrencyDtoRs transferMoney(@RequestBody CurrencyDtoRq dto) {
        return calcService.convertCurrency(dto);
    }
}
