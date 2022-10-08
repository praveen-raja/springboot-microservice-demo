package com.praveen;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private Environment environment;

	@Autowired
	private CurrencyExchangeRepository repository;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
		
		logger.info("Retrieving exchange value from {} -> {}", from, to);
		
		// obtaining server port details thru environment
		// save it in environmentPort
		String environmentPort = environment.getProperty("local.server.port");

		CurrencyExchange currencyExchange = repository.findByFromAndTo(from, to);

		if (currencyExchange == null) {
			throw new RuntimeException("Unable to retrive data for " + from + " and " + to);
		}
		currencyExchange.setEnvironment(environmentPort);
		return currencyExchange;
	}

}
