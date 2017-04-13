package com.tykj.eureka.ribbon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@org.springframework.stereotype.Service
public class Service {

	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "serviceFallback")
	public String service() {
		return restTemplate.getForEntity("http://CLIENT/service?str1=for&str2=test", String.class).getBody();
	}

	public String serviceFallback() {
		return "error";
	}

}
