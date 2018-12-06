package com.xlk.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope  //不可少 否则即使调用/refresh，配置也不会刷新
public class ConfigClientController {

	@Value("${profile}")
	private String profile;
	@Value("${username}")
	private String username;
	
	@GetMapping("/hello")
	public String hello() {
	
		return profile+username;
	}

	
}
