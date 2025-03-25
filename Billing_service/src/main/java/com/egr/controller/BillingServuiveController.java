package com.egr.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/billing")
public class BillingServuiveController 
{
	
	private static final Logger logger = LoggerFactory.getLogger(BillingServuiveController.class);
	@GetMapping("/info")
	public String getBillInfo()
	{
		
		logger.info("Getting billing details from Billing micro service");
		
		return "We accept card payment, UPI and net Banking paymentand COD";		
	}
}
