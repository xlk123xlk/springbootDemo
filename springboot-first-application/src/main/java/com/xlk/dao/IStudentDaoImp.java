package com.xlk.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.xlk.entity.Student1;

@Repository
public class IStudentDaoImp implements IStudentDao{

	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int add(Student1 s) {
		jdbcTemplate.update("insert into student values(7,'xlk1',12,'shanghai','1998-10-09')");
		return 0;
	}

	@Override
	public int update(Student1 s) {
		
		return 0;
	}

	@Override
	public int delete(Long id) {
		
		return 0;
	}

	@Override
	public Student1 findAccountById(Long id) {
		//jdbcTemplate.query("select * from student where id =?")
		return null;
	}

	@Override
	public List<Student1> findAccountList() {
		
		return null;
	}

}
