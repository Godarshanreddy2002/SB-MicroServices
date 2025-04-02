package com.egr.controller;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.egr.client.BillingServiceRestConsumer;

@RestController
@RequestMapping("/Shopping")
public class ShoppingServiceOperationsController 
{
	@Autowired
	private BillingServiceRestConsumer client;
	
	private static final Logger logger = LoggerFactory.getLogger(ShoppingServiceOperationsController.class);
	
	@GetMapping("/cart")
	public ResponseEntity<String> showBillDetails()
	{
		
		
		logger.info("Received request for billing details.");
        
        logger.info("Fetching Billing information from Billing-Service...");
        String resultBody = client.getBillInfo();
        logger.debug("Billing-Service response: {}", resultBody);
        
        logger.info("Generating random bill amount...");
        String billInfo = "Bill amount::" + new Random().nextInt(100000);
        logger.debug("Generated Bill Info: {}", billInfo);
        
        String finalResponse = billInfo + " ..... " + resultBody;
        logger.info("Final response prepared successfully.");

        return new ResponseEntity<>(finalResponse, HttpStatus.OK);
	}
	

}
