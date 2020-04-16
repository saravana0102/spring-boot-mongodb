package com.example.springbootmongo.controller.classes;

import java.util.List;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootmongo.model.classes.StudentDetails;
import com.example.springbootmongo.service.classes.StudentServiceDao;
import com.google.gson.Gson;

@Component
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = { "student" })
public class StudentController {
	
	@Autowired
	StudentServiceDao dao;

	@PostMapping(value = "/create",headers="Accept=application/json")
	public String create(@RequestBody StudentDetails studentDetails) {
		String response = "";
		final JSONObject jsonObject = new JSONObject();
		try {
			boolean isSuccess = dao.addStudent(studentDetails);
			if (isSuccess) {
				jsonObject.put("statusCode", 200);
				jsonObject.put("status", "Success");
				jsonObject.put("data", "Student added successfully.");
			} else {
				jsonObject.put("statusCode", 200);
				jsonObject.put("status", "Error");
				jsonObject.put("data", "Failed to add Student.");
			}
		} catch (Exception e) {
			jsonObject.put("statusCode", 500);
			jsonObject.put("status", "Error");
			jsonObject.put("data", "Failed to add student.");
		}
		response = new Gson().toJson(jsonObject);
		return response;
	}
	
	@GetMapping(value = "/getall")
	public String getAllStudentDetails() {
		String response = "";
		final JSONObject jsonObject = new JSONObject();
		try {
			List<StudentDetails> details = dao.getAllstudents();
			if (details.size()>0) {
				jsonObject.put("statusCode", 200);
				jsonObject.put("status", "Success");
				jsonObject.put("data", new Gson().toJson(details));
			} else {
				jsonObject.put("statusCode", 200);
				jsonObject.put("status", "Error");
				jsonObject.put("data", "No data found.");
			}
		} catch (Exception e) {
			jsonObject.put("statusCode", 500);
			jsonObject.put("status", "Error");
			jsonObject.put("data", "No data found.");
		}
		response = new Gson().toJson(jsonObject);
		return response;
	}
}
