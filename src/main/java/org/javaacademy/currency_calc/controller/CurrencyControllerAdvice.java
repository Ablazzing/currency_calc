package org.javaacademy.currency_calc.controller;

import org.javaacademy.currency_calc.exception.IntegrationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CurrencyControllerAdvice {

    @ExceptionHandler(IntegrationException.class)
    public ResponseEntity<String> handleIntegrationException(Exception e) {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                .body("Внешний сервис валют не доступен!");
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Сервис недоступен, но мы над этим работаем!");
    }
}
