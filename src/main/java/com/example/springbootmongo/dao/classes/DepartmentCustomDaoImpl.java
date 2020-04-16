package com.example.springbootmongo.dao.classes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.example.springbootmongo.model.classes.DepartmentDetails;
import com.mongodb.client.result.DeleteResult;

@Component
public class DepartmentCustomDaoImpl implements DepartmentCustomDao{
	
	private final MongoTemplate mongoTemplate;
	
	@Autowired
	public DepartmentCustomDaoImpl(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}
	
	//Below the function to get the department with student lists
	@Override
	public List<DepartmentDetails> getDepartmentDetails() {
		LookupOperation lookupOperation = LookupOperation.newLookup().from("student").
				localField("departmentId").foreignField("deptId").as("students");
		Aggregation agr = Aggregation.newAggregation(lookupOperation);
		List<DepartmentDetails> departmentDetails1 = mongoTemplate.aggregate(agr,DepartmentDetails.class, DepartmentDetails.class).getMappedResults();
		for (DepartmentDetails departmentDetails : departmentDetails1) {
			departmentDetails.setStudentCount(departmentDetails.getStudents().size());
			System.out.println(departmentDetails.getStudents());
		}
		return departmentDetails1;
	}

	@Override
	public boolean deleteDepartmentDetailsById(String deptId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("deptId").is(deptId));
		DeleteResult count = mongoTemplate.remove(query, DepartmentDetails.class);
		return count.getDeletedCount() > 0;
	}
}

