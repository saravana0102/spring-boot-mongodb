package com.example.springbootmongo.dao.classes;

import java.util.List;

import com.example.springbootmongo.model.classes.DepartmentDetails;

public interface DepartmentCustomDao {
	
	public List<DepartmentDetails> getDepartmentDetails();
	
	public boolean deleteDepartmentDetailsById(String deptId);
}
