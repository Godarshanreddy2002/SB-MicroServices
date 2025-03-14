package com.egr.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.egr.client.BillingServiceConsumerClient;

@RestController
@RequestMapping("/shopping")
public class ShoopingServiceController
{
	@Autowired
	private BillingServiceConsumerClient client;
	
	@GetMapping("/cart")
	public ResponseEntity<String> doShopping()
	{
		String resultMsg=client.getBillInfo();
		
		try {
			Thread.sleep(10000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return new ResponseEntity<String>("Shopping the items... (shirt, Trouser"+resultMsg,HttpStatus.OK);
	}
}
