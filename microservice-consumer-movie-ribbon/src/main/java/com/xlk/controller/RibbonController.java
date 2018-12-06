package com.xlk.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.xlk.entity.Student;

@RestController
public class RibbonController {

	@Autowired
	RestTemplate restTemplate;
	
	
	@RequestMapping("/ribbon")
	@HystrixCommand(fallbackMethod="fallback")
	public Student queryById(Long id) {
		Student s = restTemplate.getForObject("http://microservice-provider-user/query?id="+id, Student.class);//返回值类型
		return s;
	}
	//fallbackMethod方法要与注解上的方法有相同的返回值
	public Student fallback(Long id) {
		Student s = new Student();
		s.setId(Long.valueOf("12"));
		s.setName("xlk");
		s.setAge(13);
		s.setAddress("shanghai");
		s.setBirthday(Date.valueOf("2011-09-09"));
		return s;
	}

	
}
