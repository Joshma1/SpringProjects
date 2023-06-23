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

import com.spring.entity.Department;
import com.spring.service.DepartmentService;

@Controller  //
public class DepartmentController {

	@Autowired DepartmentService departmentservice;
	//it is use to fetch the date from the database
	@GetMapping("/department")
	public ResponseEntity<List<Department>> getAll()
	{
		List<Department> li=this.departmentservice.getAll();
		return ResponseEntity.of(Optional.of(li));
	}
	//it is use to fetch the date from the database
	@GetMapping("/department/{id}")
	public ResponseEntity<Department> getById(@PathVariable("id") int id)
	{
		Department dpm=this.departmentservice.getById(id);
		return ResponseEntity.of(Optional.of(dpm));
	}
	//using add  method to add the date
	@PostMapping("/department")
	public ResponseEntity<Department> add(@Valid @RequestBody Department dpm)
	{
		Department result=this.departmentservice.addDepartment(dpm);
		return ResponseEntity.of(Optional.of(result));
	}
	//using delete method to delete the date
	@DeleteMapping("/department/{id}")
	public ResponseEntity<String> delete(@PathVariable("id")int id)
	{
		this.departmentservice.deleteDepartment(id);
		return ResponseEntity.ok("Deleted");
	}
	//using update method to update the date
	@PutMapping("/department/{id}")
	public ResponseEntity<String> Update(@RequestBody Department dpm,@PathVariable("id") int id)
	{
		this.departmentservice.updateDepartment(dpm, id);
		return ResponseEntity.ok("Updated");
	}
	
}
