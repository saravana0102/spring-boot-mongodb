package com.example.springbootmongo.dao.classes;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.springbootmongo.model.classes.StudentDetails;

public interface StudentDao extends MongoRepository<StudentDetails, String>{

}
