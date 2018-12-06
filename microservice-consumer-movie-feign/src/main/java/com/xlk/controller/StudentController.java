package com.xlk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xlk.entity.Student;
import com.xlk.inter.StudentFeignClient;

@RestController
public class StudentController {

	@Autowired
	StudentFeignClient studentFeignClient;
	
	@RequestMapping("/feign")
	public Student queryById(Long id) {
		return studentFeignClient.queryById(id);
	}
}
