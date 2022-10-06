package com.praveen;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CircuitBreakerController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@GetMapping("/sample-api")
	@Retry(name = "sample-api", fallbackMethod="hardCodedResponse")
	public String sampleAPI() {

		logger.info("SAMPLE API CALL RECEIVED");
		return new RestTemplate().getForEntity("http://localhost:8080/url", String.class).getBody();
	}
	
	@GetMapping("/sample-api2")
	@RateLimiter(name = "sample-api2", fallbackMethod="hardCodedResponse")
	public String sampleAPI2() {

		logger.info("SAMPLE API-2 CALL RECEIVED");
		return "SAMPLE API 2";
	}
	
	
	public String hardCodedResponse(Exception e) {
		
		logger.info("FALLBACK RECEIVED");
		return "fall-back response";
	}
}
