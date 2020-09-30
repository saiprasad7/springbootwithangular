package com.demo.emp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.emp.Repository.EmployeeRepository;
import com.demo.emp.model.Employee;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EmpService {
	
	@Autowired
	EmployeeRepository employeeRepository;

	public List<Employee> getempInfo() {
		// TODO Auto-generated method stub
		log.info("employee service in call");
		return employeeRepository.findAll();
	}

	public Optional<Employee> getempInfoByid(Integer employeeId) {
		// TODO Auto-generated method stub
		log.info("employee service in call id"+employeeId);

		return employeeRepository.findByEmployeeId(employeeId);
	}


	public Object addEmpDetail(Employee emp) {
		//emp.setEmployeeId(11);
		// TODO Auto-generated method stub
		//return (Employee) employeeRepository.save(emp);
		return employeeRepository.save(emp);
	}
	
	public String removeEmpDetail(Integer employeeId) {
	//	emp.setEmployeeId(11);
		// TODO Auto-generated method stub
		//return (Employee) employeeRepository.save(emp);
		 employeeRepository.deleteById(employeeId);
		 return "deleted Successfully:";
	//	return employeeRepository.save(emp);
	}

}
