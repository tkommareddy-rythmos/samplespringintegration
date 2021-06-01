package com.example.sample2app.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.example.sample2app.model.Student;
import com.example.sample2app.repository.StudentRepository;

@EnableMongoRepositories(basePackageClasses = StudentRepository.class)
@Configuration
public class MongoConfig {
	  @Bean
	    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
	        return string -> {
	            studentRepository.save(new Student(1, "teju", "mvr"));
	            
	        };
	    }
}
