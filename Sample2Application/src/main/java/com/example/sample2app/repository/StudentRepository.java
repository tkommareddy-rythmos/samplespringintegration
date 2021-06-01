package com.example.sample2app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.sample2app.model.Student;

public interface StudentRepository extends MongoRepository<Student, Integer>{

}
