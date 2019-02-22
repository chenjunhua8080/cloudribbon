package com.cloudribbon.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@Api(value="天气服务接口",tags="天气服务接口")
@RestController
@RequestMapping("/weather")
public class WeatherControl {

	@Autowired
	WeatherService weatherService;

	@ApiOperation(value="查询城市实时天气")
	@ApiImplicitParam(value="城市名",name="location",paramType="path",required=true)
	@GetMapping("/now/{location}")
	public String search(@PathVariable("location") String location) {
		return weatherService.now(location);
	}

	@ApiOperation(value="查询城市近三天天气情况")
	@ApiImplicitParam(value="城市名",name="location",paramType="path",required=true)
	@GetMapping("/daily/{location}")
	public String daily(@PathVariable("location") String location) {
		return weatherService.daily(location);
	}

	@ApiOperation(value="查询城市生活指数")
	@ApiImplicitParam(value="城市名",name="location",paramType="path",required=true)
	@GetMapping("/life/{location}")
	public String life(@PathVariable("location") String location) {
		return weatherService.life(location);
	}

}
