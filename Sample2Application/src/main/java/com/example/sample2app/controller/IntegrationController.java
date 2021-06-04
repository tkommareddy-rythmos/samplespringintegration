package com.example.sample2app.controller;

import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sample2app.config.StudentConfig;
import com.example.sample2app.model.Address;
import com.example.sample2app.model.Student;
import com.example.sample2app.repository.StudentRepository;
import com.example.sample2app.service.IntegrationGateway;

@RestController
@RequestMapping("/integrate")
public class IntegrationController {
	@Autowired
	private IntegrationGateway integrationGateway;
	 @Autowired
	    private RabbitTemplate template;
	 @Autowired
	 private StudentRepository studentRepository;
	
	@PostMapping("/student")
	public void processStudentDetails(@RequestBody Student student) {
		integrationGateway.process(student);
		studentRepository.save(student);
	}

	
	 @PostMapping("/{details}")
	    public String savedetails(@RequestBody Address address,@PathVariable String details) {
		 address.setAddressid(UUID.randomUUID().toString());
		 integrationGateway.process(address);
		 template.convertAndSend(StudentConfig.EXCHANGE, StudentConfig.ROUTING_KEY, address);
	        return "Success !!";
	    }

}
