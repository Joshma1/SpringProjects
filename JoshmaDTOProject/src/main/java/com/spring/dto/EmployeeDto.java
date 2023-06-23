package com.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  // it is a getter and setter method
@NoArgsConstructor  //it is NoArgsConstructor 
@AllArgsConstructor//it is a NoArgsConstructor 
public class EmployeeDto {

	
	// it is an a fields
	private int eid;
	
	private String ename;
	
	private String email;
	
	private int salary;
	
	private String des;
	
	private long mobile;
}
