package com.egr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.egr.client.IBillingConsumerClient;

@RestController
@RequestMapping("/shopping")
public class ShoppingController 
{
	@Autowired
	private IBillingConsumerClient consumer;
	@GetMapping("/details")
	public String displayShoppingDetails()
	{
		System.out.println("Client component class name"+consumer.getClass());
		return "Pongal shopping for family"+consumer.getBillingInfo();
	}
}
