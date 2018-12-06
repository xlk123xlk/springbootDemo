package com.xlk.inter;

import java.sql.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.xlk.entity.Student;

@Component
public class StudentFeignClientImp implements StudentFeignClient{

	private static final Logger LOGGER = LoggerFactory.getLogger
			(StudentFeignClientImp.class);
	@Override
	public Student queryById(Long id) {
		Student s = new Student();
		s.setId(Long.valueOf("123"));
		s.setName("xlk333");
		s.setAge(13333);
		s.setAddress("shanghai1");
		s.setBirthday(Date.valueOf("2011-09-09"));
		LOGGER.info(s.toString());
		return s;
	}

}
