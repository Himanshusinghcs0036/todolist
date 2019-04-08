package com.tasktodo.service;

import java.util.List;

import com.tasktodo.model.Employee;

public interface EmployeeService {

	void sendMessageToQueue(Employee emp);

	List<Employee> getEmployees();
}
