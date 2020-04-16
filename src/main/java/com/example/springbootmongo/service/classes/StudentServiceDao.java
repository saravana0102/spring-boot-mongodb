package com.example.springbootmongo.service.classes;

import java.util.List;

import com.example.springbootmongo.model.classes.StudentDetails;

public interface StudentServiceDao {
	
	public boolean addStudent(StudentDetails studentDetails);
	
	public List<StudentDetails> getAllstudents();
	

}
