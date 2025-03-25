package com.egr.client;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private static final Logger logger = LoggerFactory.getLogger(BillingServiceRestConsumer.class);
	public String getBillInfo()
	{
		logger.info("Getting List of instances of Billing-Service");
		List<ServiceInstance> sIList = client.getInstances("Billing-Service");
		
		logger.info(" All instances of Billing-Service"+sIList);
		
		logger.info("Getting First instance of Billing-Service");
		ServiceInstance sI = sIList.get(0);
		logger.info("First instances of Billing-Service"+sI);
		String URL=sI.getUri()+"/billing/info";
		logger.info("Creating Rest template object to communicate with Billing-Service");
		RestTemplate template= new RestTemplate();
		String resp=template.getForObject(URL, String.class);
		
		return resp;
		
	}
}
