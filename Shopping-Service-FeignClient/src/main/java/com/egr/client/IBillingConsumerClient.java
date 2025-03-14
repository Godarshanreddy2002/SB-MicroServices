package com.egr.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("Billing-Service-FeignClient")
public interface IBillingConsumerClient {

	@GetMapping("/billing/info")
	public String getBillingInfo();
}
