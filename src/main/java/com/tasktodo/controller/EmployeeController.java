package com.tasktodo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tasktodo.model.Employee;
import com.tasktodo.service.EmployeeService;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@PostMapping
	public String addEmployeeToQueue(@RequestBody Employee emp) {
		employeeService.sendMessageToQueue(emp);
		return "Details been pushed to RabbitMQ";
	}

	@GetMapping
	public List<Employee> getEmployees() {
		return employeeService.getEmployees();
	}

}
