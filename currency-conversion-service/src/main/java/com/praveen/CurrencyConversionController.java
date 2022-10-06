package com.praveen;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@RestController
public class CurrencyConversionController {
	
//	@Autowired
//	private WebClient webClient;
	
	@Autowired
	private CurrencyExchangeProxy currencyExchangeProxy;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	/*
	 * Calling CurrencyExchange Microservice to retrieve the value.
	 * */
	
//	public CurrencyExchangeResponse getCurrencyExchange(String from, String to) {
//		
//		Mono<CurrencyExchangeResponse> currencyExchangeResponse = webClient.
//			get().
//			uri("/currency-exchange/from/{from}/to/{to}", from, to).
//			retrieve().
//			bodyToMono(CurrencyExchangeResponse.class);
//		
//		return currencyExchangeResponse.block();
//	}
	
	
//	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
//	public CurrencyConversion calculateCurrencyConversion(@PathVariable String from, @PathVariable String to,
//			@PathVariable BigDecimal quantity) {
//		
//		CurrencyExchangeResponse response = getCurrencyExchange(from, to);
//		logger.info("Calling getCurrencyExchange method : "+ getCurrencyExchange(from, to));
//		
//		
//	/*
//	 	RESPONSE ORDER OF OUTPUT
//	 
//		private Long id;
//
//		private String from;
//		
//		private String to;
//			
//		private BigDecimal quantity;
//		
//		private BigDecimal conversionMultiple;
//			
//		private BigDecimal totalCalculatedAmount;
//			
//		private String environment;
//			
//	*/
//		BigDecimal totalCalculatedAmount = response.getConversionMultiple().multiply(quantity);
//		return new CurrencyConversion(response.getId(),
//									  response.getFrom(),
//									  response.getTo(), 
//									  quantity,
//									  response.getConversionMultiple(),
//									  totalCalculatedAmount,
//									  response.getEnvironment());
//	}
	
	@GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateCurrencyConversionByFeign(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {
		
		CurrencyExchangeResponse response = currencyExchangeProxy.calculateCurrencyConversion(from, to);
		logger.info("Calling CurrencyExchange method : "+ response);
		
	/*
	 	RESPONSE ORDER OF OUTPUT
	 	
		private Long id;
		
		private String from;
		
		private String to;
			
		private BigDecimal quantity;
		
		private BigDecimal conversionMultiple;
			
		private BigDecimal totalCalculatedAmount;
		
		private String environment;
	*/
		BigDecimal totalCalculatedAmount = response.getConversionMultiple().multiply(quantity);
		return new CurrencyConversion(response.getId(),
									  response.getFrom(),
									  response.getTo(), 
									  quantity,
									  response.getConversionMultiple(),
									  totalCalculatedAmount,
									  response.getEnvironment());
	}
}
