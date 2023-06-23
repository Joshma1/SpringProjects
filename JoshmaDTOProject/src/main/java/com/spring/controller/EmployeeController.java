package com.spring.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.spring.ExceptionHandler.UserException;
import com.spring.entity.Employee;
import com.spring.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired EmployeeService employeeService;
	//it is use to fetch the data from database
	@GetMapping("/employee")
	public ResponseEntity<List<Employee>> getAll()
	{
		List<Employee> li=this.employeeService.getAll();
		return ResponseEntity.of(Optional.of(li));
	}
	//it is use to fetch the data from database
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getById(@PathVariable("id") int id) throws UserException
	{
		Employee emp=this.employeeService.getById(id);
		return ResponseEntity.of(Optional.of(emp));
	}
	//using add method to add the data
	@PostMapping("/employee")
	public ResponseEntity<Employee> add(@Valid @RequestBody Employee emp)
	{
		Employee result=this.employeeService.addEmployee(emp);
		return ResponseEntity.of(Optional.of(result));
	}
	//using Delete method to Delete the data
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<String> delete(@PathVariable("id")int id)
	{
		this.employeeService.deleteEmployee(id);
		return ResponseEntity.ok("Deleted");
	}
	//using update method to update the data
	@PutMapping("/employee/{id}")
	public ResponseEntity<String> update(@RequestBody Employee emp,@PathVariable("id") int id)
	{
		this.employeeService.updateEmployee(emp, id);
		return ResponseEntity.ok("Updated");
	}

}
