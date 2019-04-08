package com.tasktodo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tasktodo.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
