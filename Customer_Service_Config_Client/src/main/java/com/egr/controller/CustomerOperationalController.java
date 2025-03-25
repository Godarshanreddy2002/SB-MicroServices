package com.egr.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cust")

public class CustomerOperationalController 
{
	@Value("${spring.datasource.username}")
	private String userName;
	
	@Value("${spring.datasource.password}")
	private String password;
	
	@Value("${spring.datasource.driver-class-name}")
	private String dbDriver;		
	
	
	@GetMapping("/display")
	public String displayData()
	{
		return "(Customer)Data collected through the config server /nUser name:"+userName+" /n Password is : "+password+"/n DriverName: "+dbDriver;
	}

}
