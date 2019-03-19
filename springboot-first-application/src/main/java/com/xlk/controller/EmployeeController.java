package com.xlk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xlk.entity.Employee;
import com.xlk.service.IEmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	IEmployeeService employeeService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Employee getAccountById(@PathVariable("id") Long id) {
        return employeeService.getEmployeeById(id);
    }
}
