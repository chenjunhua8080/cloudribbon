package com.cloudribbon.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@Api(value="城市服务接口",tags="城市服务接口")
@RestController
@RequestMapping("/location")
public class LocationControl {

	@Autowired
	LocationService locationService;

	@ApiOperation(value="根据关键字搜索相关城市")
	@ApiImplicitParam(value="地名关键字",name="location",paramType="path",required=true)
	@GetMapping("/search/{location}")
	public String search(@PathVariable("location") String location) {
		return locationService.search(location);
	}

}
