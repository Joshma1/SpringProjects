package com.spring.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.dto.DepartmentDto;
import com.spring.entity.Department;
import com.spring.repo.DepartmentRepo;

@Component //By using component annotation we can easily connect classes and  interfaces
public class DepartmentService {

	@Autowired DepartmentRepo departmentRepo;  //automatically its create the connection with department repository
	@Autowired ModelMapper model; //it is used to mappe the Entity Class to Dto Class and Vis versa .
	//Get All
		public List<Department> getAll()
		{
			List<Department> li=(List<Department>)this.departmentRepo.findAll();
			return li;
		}
		// Get By Id
		
		public Department getById(int id)
		{
			Department dpm=this.departmentRepo.findById(id);
			return dpm;
		}
		// Add Department
		public Department addDepartment(Department dpm)
		{
			Department result=this.departmentRepo.save(dpm);
			return result;
		}
		
		// delete By Id
		public void deleteDepartment(int id)
		{
			this.departmentRepo.deleteById(id);
		}
		
		// update by id
		public void updateDepartment(Department dpm,int id)
		{
			dpm.setDid(id);
			this.departmentRepo.save(dpm);
		}
		
		
	
		
		// ModelMapper Class.
		public DepartmentDto entityToDto(Department dpm)
		{
			DepartmentDto dto=model.map(dpm, DepartmentDto.class);
			return dto;
		}
		
		public Department dtoToEntity(DepartmentDto dto)
		{
			Department dpm=model.map(dto, Department.class);
			return dpm;
		}
		
}
