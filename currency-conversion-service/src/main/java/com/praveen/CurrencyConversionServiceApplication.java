package com.praveen;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableFeignClients
public class CurrencyConversionServiceApplication {
	
//	@Value("${service.url.currency-exchange}")
//	private String currencyExchangeUrl;


	public static void main(String[] args) {
		SpringApplication.run(CurrencyConversionServiceApplication.class, args);
	}

//	@Bean
//	public WebClient webClient() {
//		WebClient webClient = WebClient.builder().baseUrl(currencyExchangeUrl).build();
//		return webClient;
//	}
}
