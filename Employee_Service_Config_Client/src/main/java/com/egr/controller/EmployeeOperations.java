package com.egr.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emp")
public class EmployeeOperations 
{
	@Value("${spring.datasource.username}")
	private String userName;
	
	@Value("${spring.datasource.password}")
	private String password;
	
	@Value("${spring.datasource.driver-class-name}")
	private String dbDriver;
	
	@GetMapping("/show")
	public String showDbDetails()
	{
		return "(Employee)Data collected through Config server user name:"+userName+" /n Password is : "+password+"/n DriverName: "+dbDriver;
	}
}
