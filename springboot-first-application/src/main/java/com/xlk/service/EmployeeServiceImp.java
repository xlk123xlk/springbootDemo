package com.xlk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xlk.dao.EmployeeMapper;
import com.xlk.entity.Employee;

@Service
public class EmployeeServiceImp implements IEmployeeService{

	@Autowired
	EmployeeMapper employeeMapper;
	@Override
	public void add(Employee e) {
		employeeMapper.add(e);
	}

	@Override
	public void update(Employee e) {
		employeeMapper.update(e);
	}

	@Override
	public Employee getEmployeeById(Long id) {
		return employeeMapper.getEmployeeById(id);
	}

	@Override
	public List<Employee> getEmployees() {
		return employeeMapper.getEmployees();
	}

	@Override
	public void deleteEmployeeById(Long id) {
		employeeMapper.deleteEmployeeById(id);
	}

}
