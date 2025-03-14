package com.egr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BillingServiceFeignClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillingServiceFeignClientApplication.class, args);
	}

}
