package com.practise.exchange.currencyexchangeservice.controller;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import com.practise.exchange.currencyexchangeservice.bean.CurrencyExchange;
import com.practise.exchange.currencyexchangeservice.repository.CurrencyExchangeRepository;


@RestController
public class CurrencyExchangeController {
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private CurrencyExchangeRepository repo;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retrieveExchange(
			@PathVariable String from,
			@PathVariable String to) {
//		CurrencyExchange currencyExchange = new CurrencyExchange(1000L, from, to, BigDecimal.valueOf(65));
		CurrencyExchange currencyExchange = repo.findByFromAndTo(from, to);
		
		if(currencyExchange==null) {
			throw new RuntimeException("Unable to find data");
		}
		
		String port = environment.getProperty("server.port");
		currencyExchange.setEnvironment(port);
		
		return currencyExchange;
	}
}
