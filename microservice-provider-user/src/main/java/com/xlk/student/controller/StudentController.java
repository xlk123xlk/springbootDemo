package com.xlk.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xlk.student.entity.Student;
import com.xlk.student.repository.StudentRepository;

@RestController
public class StudentController {

	@Autowired
	StudentRepository studentRepository;
	
	@RequestMapping("/save")
	public void save() {
		Student s = new Student();
		s.setName("aa");
		s.setAge(12);
		s.setAddress("jiading");
		s.setBirthday(java.sql.Date.valueOf("2011-12-12"));
		studentRepository.save(s);
	}
	
	@RequestMapping("/query")
	public Student find(Long id) {
		Student s = studentRepository.findOne(id);
		return s;
	}

}
