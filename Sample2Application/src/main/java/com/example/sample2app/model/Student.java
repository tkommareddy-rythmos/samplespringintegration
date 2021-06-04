package com.example.sample2app.model;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.annotation.Id;
@XmlRootElement
public class Student {

	
    @Id
    private String id;
	private String name;
	private String school;
	
	 public Student(String id, String name, String school) {
	        this.id = id;
	        this.name = name;
	        this.school = school;
	        
	    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", school=" + school + "]";
	}

	
}