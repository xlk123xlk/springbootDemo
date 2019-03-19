package com.xlk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xlk.entity.Student;
import com.xlk.entity.User;

@RestController
public class MiyaController {

	//@ConfigurationProperties和@Component将properties属性和Bean关联，再@Autowired注入
	@Autowired
	Student s;
	
	//读取配置文件的值只需要加@Value
	@Value("${my.name}")
	private String name;
	@Value("${my.age}")
	private int age;
	
	@RequestMapping("/hello")
	public String getString() {
		return name+":"+age;
	}
	
	@RequestMapping("/test")
	public String getString1() {
		return s.getId()+"-"+s.getName()+"-"+s.getAge()+"-"+s.getAddress()+"-"+s.getBirthday();
	}
	
	@Autowired
	User user;
	@RequestMapping("/user")
	public String getString2() {
		return user.getAa()+user.getBb();
	}
}
