package com.egr.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/billing")
public class BillingServuiveController 
{
	@GetMapping("/info")
	public String getBillInfo()
	{
		return "We accept card payment, UPI and net Banking paymentand COD";		
	}
}
