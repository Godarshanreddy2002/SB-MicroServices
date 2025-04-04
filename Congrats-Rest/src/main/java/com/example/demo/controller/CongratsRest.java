package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.client.BirthdayFeignClient;

@RestController
public class CongratsRest {
	
	@Autowired
	private BirthdayFeignClient birthdayFeignClient;
	
	@GetMapping("/congrats")
	public String getCongratsMsg() {
		
		String birthdayWishes = birthdayFeignClient.getBirthdayWishes();
		return birthdayWishes+" Congrats GodRSHAN";
	}

}
