package com.practise.microservices.limitsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practise.microservices.limitsservice.bean.Limit;

import com.practise.microservices.limitsservice.configuration.Configuration;

@RestController
public class LimitsController {
	
	@Autowired
	Configuration configuration;
	
	@GetMapping("/Limits")
	public Limit retrieveLimits() {
		return new Limit(1,1000);
	}
	
	@GetMapping("/ConfigLimits")
	public Limit retrieveConfigLimits() {
		return new Limit(configuration.getMinimum(), 
				    	 configuration.getMaximum());
	}
}
