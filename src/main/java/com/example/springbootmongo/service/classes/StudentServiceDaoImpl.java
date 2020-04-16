package com.example.springbootmongo.service.classes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springbootmongo.dao.classes.StudentDao;
import com.example.springbootmongo.model.classes.StudentDetails;

@Service
@Transactional
public class StudentServiceDaoImpl implements StudentServiceDao{
	
	@Autowired
	StudentDao dao;

	@Override
	public boolean addStudent(StudentDetails studentDetails) {
		return dao.insert(studentDetails) != null;
	}

	@Override
	public List<StudentDetails> getAllstudents() {
		return dao.findAll();
	}
	
	

}
