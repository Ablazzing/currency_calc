package org.javaacademy.currency_calc;

import org.javaacademy.currency_calc.config.FreeCurrencyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableCaching
public class CurrencyCalcApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(CurrencyCalcApplication.class, args);
		FreeCurrencyProperties properties = context.getBean(FreeCurrencyProperties.class);
	}

}
