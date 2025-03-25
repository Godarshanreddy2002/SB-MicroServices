package com.egr.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/billing")
public class BillingServiceController 
{
	@Value("${server.port}")
	private int port;
	
	@Value("${eureka.instance.instance-id}")
	private String instanceId;
	
	 private static final Logger logger = LoggerFactory.getLogger(BillingServiceController.class);
	
	@GetMapping("/info")
	public ResponseEntity<String> getBillInfo()
	{	
		
		logger.info("Getting billing details form the billing service");
		return new  ResponseEntity<String>("Final_bill_amount =Bill_amount-discount(10%):: Using instance::"+instanceId+"  port::"+port,HttpStatus.OK);		
	}
}
