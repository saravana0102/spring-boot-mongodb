package com.example.springbootmongo.service.classes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springbootmongo.dao.classes.DepartmentCustomDao;
import com.example.springbootmongo.dao.classes.DepartmentDao;
import com.example.springbootmongo.model.classes.DepartmentDetails;

@Service
@Transactional
public class DepartmentServiceDaoImpl implements DepartmentServiceDao {

	@Autowired
	DepartmentDao dao;
	
	@Autowired
	DepartmentCustomDao customDao;
	
	@Override
	public boolean addDepartment(DepartmentDetails departmentDetails) {
		DepartmentDetails details = dao.save(departmentDetails);
		if(details != null) {
			details.setDepartmentId(details.get_id());
			return dao.save(departmentDetails) != null;
		}
		return false;
	}

	@Override
	public boolean removeDepartment(String deptId) {
		return customDao.deleteDepartmentDetailsById(deptId);
	}

	@Override
	public boolean updateDepartmentDetails(DepartmentDetails departmentDetails) {
		return dao.save(departmentDetails) != null;
	}

	@Override
	public List<DepartmentDetails> getAllDepartments() {
		return dao.findAll();
	}

	@Override
	public List<DepartmentDetails> getAllDepartmentStudents() {
		return customDao.getDepartmentDetails();
	}

}
