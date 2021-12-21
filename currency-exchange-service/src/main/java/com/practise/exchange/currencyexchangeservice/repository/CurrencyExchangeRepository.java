package com.practise.exchange.currencyexchangeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practise.exchange.currencyexchangeservice.bean.CurrencyExchange;

public interface CurrencyExchangeRepository 
	extends JpaRepository<CurrencyExchange, Long>{
	CurrencyExchange findByFromAndTo(String from, String to);

}
