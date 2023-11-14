package com.sprinboot.api.emp.springbootDemo.service;

import java.util.List;

import com.sprinboot.api.emp.springbootDemo.entity.Employee;

public interface EmployeeService {
	public Employee saveEmployee(Employee employee);
	public List<Employee>getAllEmployee();
	public Employee getEmployeebyId(Employee employee ,long id);
	public Employee updateEmployee(Employee employee, long id);
	public void DeleteEmployee(long id);

}
