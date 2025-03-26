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
		logger.info("Fetching list of instances for Billing-Service...");
		List<ServiceInstance> sIList = client.getInstances("Billing-Service");

		logger.info("Total instances found: {}", sIList.size());
		logger.debug("List of Billing-Service instances: {}", sIList);

		if (sIList.isEmpty()) {
		    logger.error("No instances of Billing-Service found!");
		    return "No Billing-Service instances available";
		}

		logger.info("Selecting the first instance of Billing-Service...");
		ServiceInstance sI = sIList.get(0);
		logger.debug("Selected Billing-Service instance: {}", sI);

		String URL = sI.getUri() + "/billing/info";
		logger.info("Constructed Billing-Service URL: {}", URL);

		logger.info("Creating RestTemplate object for communication...");
		RestTemplate template = new RestTemplate();

		logger.info("Sending request to Billing-Service...");
		String resp = template.getForObject(URL, String.class);
		logger.debug("Response received from Billing-Service: {}", resp);

		return resp;

		
	}
}
