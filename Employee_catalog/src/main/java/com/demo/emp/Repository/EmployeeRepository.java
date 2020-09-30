package com.demo.emp.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.emp.model.Employee;


@Repository
public interface EmployeeRepository<employeeId> extends JpaRepository<Employee,Integer>{
	
	Optional<Employee> findByEmployeeId(Integer employeeId);


}
