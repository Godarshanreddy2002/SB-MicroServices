package com.egr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ShopingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopingServiceApplication.class, args);
	}

}
