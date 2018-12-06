package com.xlk.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xlk.student.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
