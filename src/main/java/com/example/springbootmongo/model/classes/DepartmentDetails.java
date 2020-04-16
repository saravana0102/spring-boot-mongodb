package com.example.springbootmongo.model.classes;


import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "department")
public class DepartmentDetails {
	
	@Id
	private String _id;
	
	private String departmentName;
	
	private String departmentId;
	
	private List<Object> students;
	
	@Transient
	private long studentCount;
	
	public String getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
	
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public List<Object> getStudents() {
		return students;
	}
	public void setStudents(List<Object> students) {
		this.students = students;
	}
	public long getStudentCount() {
		return studentCount;
	}
	public void setStudentCount(long studentCount) {
		this.studentCount = studentCount;
	}

}
