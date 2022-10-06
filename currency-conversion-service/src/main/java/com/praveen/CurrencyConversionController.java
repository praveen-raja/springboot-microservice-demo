package com.praveen;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyConversionController {

	@Autowired
	private CurrencyExchangeProxy currencyExchangeProxy;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateCurrencyConversionByFeign(
			@PathVariable String from, 
			@PathVariable String to,
			@PathVariable BigDecimal quantity) {

		CurrencyExchangeResponse response = currencyExchangeProxy.calculateCurrencyConversion(from, to);

		logger.info("Calling CurrencyExchange method : " + response);

		/*
		 * RESPONSE ORDER OF OUTPUT
		 * 
		 * private Long id;
		 * 
		 * private String from;
		 * 
		 * private String to;
		 * 
		 * private BigDecimal quantity;
		 * 
		 * private BigDecimal conversionMultiple;
		 * 
		 * private BigDecimal totalCalculatedAmount;
		 * 
		 * private String environment;
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