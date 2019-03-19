package com.xlk.dao;

import java.util.List;

import com.xlk.entity.Student1;

public interface IStudentDao {

	int add(Student1 s);

    int update(Student1 s);

    int delete(Long id);

    Student1 findAccountById(Long id);

    List<Student1> findAccountList();
}
