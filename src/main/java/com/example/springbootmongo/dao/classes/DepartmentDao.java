package com.example.springbootmongo.dao.classes;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.springbootmongo.model.classes.DepartmentDetails;

public interface DepartmentDao extends MongoRepository<DepartmentDetails, String> {

}
