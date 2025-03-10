package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BirthdayController {
	
	
	
	@GetMapping("/wishes")
	public String getBirthdayWishes() {
		return "Happy Birthday";
	}

}
