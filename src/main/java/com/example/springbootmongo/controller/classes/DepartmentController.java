package com.example.springbootmongo.controller.classes;

import java.util.List;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootmongo.model.classes.DepartmentDetails;
import com.example.springbootmongo.service.classes.DepartmentServiceDao;
import com.google.gson.Gson;

@Component
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = { "dept" })
public class DepartmentController {
	
	@Autowired
	DepartmentServiceDao dao;
	
	private static Logger logger = LoggerFactory.getLogger(DepartmentController.class);

	@PostMapping(value = "/create",headers="Accept=application/json")
	public String create(@RequestBody DepartmentDetails departmentDetails) {
		logger.info("DepartmentController(create) --> Enter");
		String response = "";
		final JSONObject jsonObject = new JSONObject();
		try {
			boolean isSuccess = dao.addDepartment(departmentDetails);
			if (isSuccess) {
				jsonObject.put("statusCode", 200);
				jsonObject.put("status", "Success");
				jsonObject.put("data", "Department added successfully.");
			} else {
				jsonObject.put("statusCode", 200);
				jsonObject.put("status", "Error");
				jsonObject.put("data", "Failed to add department.");
			}
		} catch (Exception e) {
			logger.error("Exception in DepartmentController(create) -->" + e);
			jsonObject.put("statusCode", 500);
			jsonObject.put("status", "Error");
			jsonObject.put("data", "Failed to add department.");
		}
		response = new Gson().toJson(jsonObject);
		logger.info("DepartmentController(create) --> Exit");
		return response;
	}

	@GetMapping(value = "/getall")
	public String getAllDepartmentDetails() {
		logger.info("DepartmentController(getAllDepartmentDetails) --> Enter");
		String response = "";
		final JSONObject jsonObject = new JSONObject();
		try {
			List<DepartmentDetails> details = dao.getAllDepartments();
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
			logger.error("Exception in DepartmentController(getAllDepartmentDetails) -->" + e);
			jsonObject.put("statusCode", 500);
			jsonObject.put("status", "Error");
			jsonObject.put("data", "No data found.");
		}
		response = new Gson().toJson(jsonObject);
		logger.info("DepartmentController(getAllDepartmentDetails) --> Exit");
		return response;
	}


	@PutMapping(value = "/update")
	public String update(@RequestBody DepartmentDetails DepartmentDetails) {
		logger.info("DepartmentController(update) --> Enter");
		String response = "";
		final JSONObject jsonObject = new JSONObject();
		try {
			boolean isSuccess = dao.updateDepartmentDetails(DepartmentDetails);
			if (isSuccess) {
				jsonObject.put("statusCode", 200);
				jsonObject.put("status", "Success");
				jsonObject.put("data", "Details updated successfully.");
			} else {
				jsonObject.put("statusCode", 200);
				jsonObject.put("status", "Error");
				jsonObject.put("data", "Failed to update details.");
			}
		} catch (Exception e) {
			logger.error("Exception in DepartmentController(update) -->" + e);
			jsonObject.put("statusCode", 500);
			jsonObject.put("status", "Error");
			jsonObject.put("data", "Failed to update details.");
		}
		response = new Gson().toJson(jsonObject);
		logger.info("DepartmentController(update) --> Exit");
		return response;
	}

	@DeleteMapping(value = "/delete/{deptId}")
	public String deleteDepartmentDetailsDetailsById(@PathVariable String deptId) {
		logger.info("DepartmentController(deleteDepartmentDetailsDetailsById) --> Enter");
		String response = "";
		final JSONObject jsonObject = new JSONObject();
		try {
			boolean isSuccess = dao.removeDepartment(deptId);
			if (isSuccess) {
				jsonObject.put("statusCode", 200);
				jsonObject.put("status", "Success");
				jsonObject.put("data", "Department deleted successfully.");
			} else {
				jsonObject.put("statusCode", 200);
				jsonObject.put("status", "Error");
				jsonObject.put("data", "Failed to delete department.");
			}
		} catch (Exception e) {
			logger.error("Exception in DepartmentController(deleteDepartmentDetailsDetailsById) -->" + e);
			jsonObject.put("statusCode", 500);
			jsonObject.put("status", "Error");
			jsonObject.put("data", "Failed to delete content.");
		}
		response = new Gson().toJson(jsonObject);
		logger.info("DepartmentController(deleteDepartmentDetailsDetailsById) --> Exit");
		return response;
	}
	
	@GetMapping(value = "/getallDeptStudent")
	public String getAllDepartmentStudentDetails() {
		logger.info("DepartmentController(getAllDepartmentStudentDetails) --> Enter");
		String response = "";
		final JSONObject jsonObject = new JSONObject();
		try {
			List<DepartmentDetails> details = dao.getAllDepartmentStudents();
			if (!details.isEmpty()){
				jsonObject.put("statusCode", 200);
				jsonObject.put("status", "Success");
				jsonObject.put("data", new Gson().toJson(details));
			} else {
				jsonObject.put("statusCode", 200);
				jsonObject.put("status", "Error");
				jsonObject.put("data", "No data found.");
			}
		} catch (Exception e) {
			logger.error("Exception in DepartmentController(getAllDepartmentStudentDetails) -->" + e);
			jsonObject.put("statusCode", 500);
			jsonObject.put("status", "Error");
			jsonObject.put("data", "No data found.");
		}
		response = new Gson().toJson(jsonObject);
		logger.info("DepartmentController(getAllDepartmentStudentDetails) --> Exit");
		return response;
	}

}
