package com.spring.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // create table in database.
@Data // getter and setter.
@NoArgsConstructor // no argument constructor.
@AllArgsConstructor // all argument constructor.
@Table(name="employee_table") // create table by name as employee_table.
public class Employee { // class

	@Id // primary key.
	@NotNull(message="Employee Id is Not Null.")
	private int eid;
	@NotNull(message="Employee Name is Not Null")
	private String ename;
	@Email(message="Please Enter Currect Email.")
	private String email;
	@NotNull(message="Salary is not Null.")
	private int salary;
	@NotNull(message="Designation is not null.")
	private String des;
	@NotNull(message="Enter Valid Mobile No.")
	private long mobile;

	@ManyToOne // ManyToOne Mapping. 
	@JsonBackReference // it provide the Back reference from postman.
	private Department dpm; // create Department Object.
	
}
