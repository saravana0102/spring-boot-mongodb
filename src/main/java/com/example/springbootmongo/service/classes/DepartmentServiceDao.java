package com.example.springbootmongo.service.classes;

import java.util.List;

import com.example.springbootmongo.model.classes.DepartmentDetails;

public interface DepartmentServiceDao {
	
	public boolean addDepartment(DepartmentDetails departmentDetails);
	
	public boolean removeDepartment(String deptId);
	
	public boolean updateDepartmentDetails(DepartmentDetails departmentDetails);
	
	public List<DepartmentDetails> getAllDepartments();
	
	public List<DepartmentDetails> getAllDepartmentStudents();
	
}
