package com.demo.emp.model;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name="employee")

public class Employee {

	
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="employee_id")
	private Integer employeeId;
	
	@Column(name="employee_name")
	private String employeeName;
	
	@Column(name="dept")
	private String department;

	
		
}
