package com.sprinboot.api.emp.springbootDemo.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprinboot.api.emp.springbootDemo.entity.Employee;
import com.sprinboot.api.emp.springbootDemo.exp.ResourceNotFoundException;
import com.sprinboot.api.emp.springbootDemo.repo.EmployeeRepo;
import com.sprinboot.api.emp.springbootDemo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	 private EmployeeRepo employeeRepo;

	@Override
	public Employee saveEmployee(Employee employee) {
		
		return this.employeeRepo.save(employee);
	}
  // buil get all employee restapi
	@Override
	public List<Employee> getAllEmployee() {
		
		return this.employeeRepo.findAll();
	}
      // build get employee by id restapi
	@Override
	public Employee getEmployeebyId(Employee employee ,long id) {
		Employee emplo=this.employeeRepo.findById(id).orElseThrow(( )-> new ResourceNotFoundException("Employee","id","id"));
		return emplo;
	}
	@Override
	public Employee updateEmployee(Employee employee, long id) {
		Employee updateEmployee=this.employeeRepo.findById(id).orElseThrow(( )-> new ResourceNotFoundException("Employee","id","id"));
		updateEmployee.setName(employee.getName());
		updateEmployee.setLastName(employee.getLastName());
		updateEmployee.setEmial(employee.getEmial());
		this.employeeRepo.save(updateEmployee);
		return updateEmployee;
	}
	@Override
	public void DeleteEmployee(long id) {
		this.employeeRepo.findById(id).orElseThrow(( )-> new ResourceNotFoundException("Employee","id","id"));
		 this.employeeRepo.deleteById(id);
		
	}
	

}
