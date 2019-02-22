package com.cloudribbon.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class LocationService {

	@Autowired
	RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "error")
	public String search(String location) {
		return restTemplate.getForObject("http://SERVICE-LOCATION/location/search/" + location, String.class);
	}

	public String error(String name) {
		return "城市服务调用失败!";
	}

}
