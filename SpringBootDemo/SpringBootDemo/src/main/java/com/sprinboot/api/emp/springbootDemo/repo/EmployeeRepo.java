package com.sprinboot.api.emp.springbootDemo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprinboot.api.emp.springbootDemo.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long>{
	

}
