package com.spring.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.dto.EmployeeDto;
import com.spring.entity.Employee;
import com.spring.repo.EmployeeRepo;
import com.spring.ExceptionHandler.UserException;
@Component  //By using component annotation we can easily connect classes and  interfaces
public class EmployeeService {

	@Autowired EmployeeRepo employeeRepo; //automatically its create the connection with department repository
	@Autowired ModelMapper model;  //
	
	//Get All
	public List<Employee> getAll()
	{
		List<Employee> li=(List<Employee>)this.employeeRepo.findAll();
		return li;
	}
	// Get By Id
	
	public Employee getById(int id) throws UserException
	{
		Employee emp=this.employeeRepo.findById(id);
		if(emp!=null)
			return emp;
		else
			throw new UserException("User Not Found with id :"+id);
	}
	// Add Employee
	public Employee addEmployee(Employee emp)
	{
		Employee result=this.employeeRepo.save(emp);
			return result;
	}
	
	// delete By Id
	public void deleteEmployee(int id)
	{
		this.employeeRepo.deleteById(id);
	}
	
	// update by id
	public void updateEmployee(Employee emp,int id)
	{
		emp.setEid(id);
		this.employeeRepo.save(emp);
	}
	
	
	
	// ModelMapper Class.
	public EmployeeDto entityToDto(Employee emp)
	{
		EmployeeDto dto=model.map(emp, EmployeeDto.class);
		return dto;
	}
	// DTO class To Entity Class.
	public Employee dtoToEntity(EmployeeDto dto)
	{
		Employee emp=model.map(dto, Employee.class);
		return emp;
	}
	
}
