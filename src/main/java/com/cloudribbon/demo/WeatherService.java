package com.cloudribbon.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class WeatherService {

	@Autowired
	RestTemplate restTemplate;

	/**
	 * 断熔，不能直接写在control，会报找不到fallbackMethod
	 * 
	 * @param location
	 * @return
	 */
	@HystrixCommand(fallbackMethod = "error")
	public String now(String location) {
		return restTemplate.getForObject("http://SERVICE-WEATHER/weather/now/" + location, String.class);
	}

	@HystrixCommand(fallbackMethod = "error")
	public String daily(String location) {
		return restTemplate.getForObject("http://SERVICE-WEATHER/weather/daily/" + location, String.class);
	}

	@HystrixCommand(fallbackMethod = "error")
	public String life(String location) {
		return restTemplate.getForObject("http://SERVICE-WEATHER/weather/life/" + location, String.class);
	}

	public String error(String name) {
		return "天气服务调用失败!";
	}

}
