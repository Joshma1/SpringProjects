package com.spring.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity  //to create the table
@Data  // it is a getter and setter method
@NoArgsConstructor  // it is an a NoArgsConstructor 
@AllArgsConstructor  // it is an a AllArgsConstructor 
@Table(name="department_table")
public class Department {

	@Id
	@NotNull(message="Department Id is not null.")
	private int did;
	@NotNull(message="Department Name is not null")
	private String dname;
	
	@OneToMany(mappedBy="dpm") // mapped OneTOMany.
	@JsonManagedReference // Json Manage Reference.
	private List<Employee> emp; // create List Employee objects.s 
}
