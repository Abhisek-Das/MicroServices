package com.practise.exchange.currencyexchangeservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

@RestController
public class CircuitBreakerController {
//	@Autowired
//	private Environment env;
	
	private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);
	
	@GetMapping("/sample")
//	@Retry(name="sample", fallbackMethod="staticResponse")
	@CircuitBreaker(name="sample", fallbackMethod="staticResponse")
	@RateLimiter(name="sample")
	public String sampleApi() {
		
logger.info("daabhis - *********************** - in Sample api");
//	    String port = env.getProperty("server.port");

//		return "Sample" + port;
		
		ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8080/abcd", String.class);
			
		return forEntity.getBody();
	}
	
	public String staticResponse(Exception ex) {
		return "fallback-response";
	}

}
