package com.demo.emp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.emp.Repository.EmployeeRepository;
import com.demo.emp.model.Employee;
import com.demo.emp.service.EmpService;


import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EmpController {
	
	@Autowired
	EmpService employeeService;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@RequestMapping("/sample")
	public SampleResponse Sample(@RequestParam(value = "name",
	defaultValue = "Robot") String name) {
		SampleResponse response = new SampleResponse();
		response.setId(1);
		response.setMessage("Your name is "+name);
		return response;

	}

	@GetMapping(path = "/getEmp", produces = "application/json")
	public List <Employee> getEmployeeInfo() {
		log.info("inside contorller");
return employeeService.getempInfo();


	}

	@GetMapping(path = "/getEmpid", produces = "application/json")
	public Optional<Employee> getEmployeeInfobyid(@RequestParam("employeeId") Integer employeeId){
		log.info("Calling booked Request"+employeeId); 
		log.info("inside contorller");
return employeeService.getempInfoByid(employeeId);

	}
	@PostMapping(path = "/insertEmp")
	public Object addEmpDetail(@RequestBody Employee emp){
		log.info("Calling booked Request"+emp); 
		log.info("inside contorller");
return employeeService.addEmpDetail(emp);

	}
	 @PutMapping("/updateEmployees/{id}")
	    public ResponseEntity<Object> updateStudent(@RequestBody Employee emp, @PathVariable Integer id) {

	    	Optional<Employee> emptOptional = employeeService.getempInfoByid(id);

	    	if (!emptOptional.isPresent())
	    		return ResponseEntity.notFound().build();

	    	emp.setEmployeeId(id);
	    	employeeService.addEmpDetail(emp);
	    	return ResponseEntity.noContent().build();
	    }
	@DeleteMapping(path = "/removEmp", produces = "application/json")
	public String removeEmpDetail(@RequestParam Integer employeeId){
		log.info("Calling booked Request"+employeeId); 
		log.info("inside contorller");
return employeeService.removeEmpDetail(employeeId);

	}
}
