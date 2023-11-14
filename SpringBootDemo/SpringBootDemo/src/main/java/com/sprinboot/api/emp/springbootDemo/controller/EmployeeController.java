package com.sprinboot.api.emp.springbootDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprinboot.api.emp.springbootDemo.entity.Employee;
import com.sprinboot.api.emp.springbootDemo.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employService;
	@PostMapping("/")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
		Employee emp=this.employService.saveEmployee(employee);
		return new ResponseEntity<Employee>(emp,HttpStatus.CREATED);
		
	}
	@GetMapping("/")
 public  List<Employee>getAllEmployee(){
	 return  this.employService.getAllEmployee();
	
	}
 
 @GetMapping("/id{userId}")
 public ResponseEntity<Employee> getEmployeeById( @PathVariable Long userId, Employee employee){
	 return new ResponseEntity<Employee>(this.employService.getEmployeebyId(employee, userId),HttpStatus.OK);
	 
 }
@PutMapping("/update")
public ResponseEntity<Employee>updateEmployee(@RequestBody Employee employee,Long id){
	return new ResponseEntity<Employee>(this.employService.updateEmployee( employee, id),HttpStatus.OK);
	
	
}
@DeleteMapping("/id")
 public ResponseEntity<String> DeleteEmployee(long id){
	this.employService.DeleteEmployee(id);
	return new ResponseEntity<String>("EmployeeId deleted successfuly",HttpStatus.OK);
	   
	 
 }
}
