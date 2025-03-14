package com.egr.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/billing")
public class BillingInfoServiceController
{
	@Value("${server.port}")
	private int port;
	
	@Value("${eureka.instance.instance-id}")
	private String instanceId;
	
	@GetMapping("/info")
	public ResponseEntity<String> getBillInfo()
	{	
		return new  ResponseEntity<String>("Final_bill_amount =Bill_amount-discount(10%):: Using instance::"+instanceId+"  port::"+port,HttpStatus.OK);		
	}
}
