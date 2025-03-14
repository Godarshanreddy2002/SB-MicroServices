package com.egr.client;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BillingServiceConsumerClient 
{
	@Autowired
	private LoadBalancerClient client;
	
	
	public String getBillInfo()
	{
		ServiceInstance serviceInstance = client.choose("Billing-Service-LBC");
		
		URI uri=serviceInstance.getUri();	
		
		String url=uri.toString()+"/billing/info";
		
		RestTemplate template=new RestTemplate();
		
		ResponseEntity<String> resp = template.getForEntity(url, String.class);
		
		String ResponseContent = resp.getBody();
		return ResponseContent;
		
	}
}
