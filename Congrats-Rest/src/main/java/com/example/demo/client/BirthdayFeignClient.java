package com.example.demo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("BIRTHDAY-RESTFUL")
public interface BirthdayFeignClient {
	
	
	@GetMapping("/wishes")
	public String getBirthdayWishes();

}
