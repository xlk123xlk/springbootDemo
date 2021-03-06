package com.xlk.service;

import java.util.List;

import com.xlk.entity.Employee;

public interface IEmployeeService {

	//新增
	public void add(Employee e);
	
	//修改
	public void update(Employee e);
	
	//查询
	public Employee getEmployeeById(Long id);
	
	public  List<Employee> getEmployees();
	
	public void deleteEmployeeById(Long id);
}
