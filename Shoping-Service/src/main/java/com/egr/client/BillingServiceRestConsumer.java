package com.egr.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BillingServiceRestConsumer 
{
	@Autowired
	private DiscoveryClient client;
	
	public String getBillInfo()
	{
		List<ServiceInstance> sIList = client.getInstances("Billing-Service");
		ServiceInstance sI = sIList.get(0);
		
		String URL=sI.getUri()+"/billing/info";
		
		RestTemplate template= new RestTemplate();
		String resp=template.getForObject(URL, String.class);
		
		return resp;
		
	}
}
