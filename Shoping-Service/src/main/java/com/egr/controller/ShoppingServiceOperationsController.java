package com.egr.controller;

import java.util.Random;

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
	
	
	@GetMapping("/details")
	public ResponseEntity<String> showBillDetails()
	{
		String resultBody=client.getBillInfo();
		
		String billInfo="Bill amount::"+new Random().nextInt(100000);		
		return new ResponseEntity<String>(billInfo+" ..... "+resultBody,HttpStatus.OK);
	}
	

}
