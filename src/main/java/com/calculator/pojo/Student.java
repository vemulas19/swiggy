package com.calculator.pojo;

import java.util.List;

public class Student {

	private int stdId;
	private String name;
	private String collegeName;
	private String city;
	private List<String> subjects;
	private Passport pport;

	public Student() {
		System.out.println("no arg constructor of student!!");
	}

	public Student(String collegeName, String city, Passport pport) {
		System.out.println("3 arg student constructor!!");
		this.collegeName = collegeName;
		this.city = city;
		this.pport = pport;
	}
	
	public Student(int stdId, String name, String collegeName, String city, Passport pport) {
		System.out.println("argument constructor of student!!");
		this.stdId = stdId;
		this.name = name;
		this.collegeName = collegeName;
		this.city = city;
		this.pport = pport;
	}

	public int getStdId() {
		return stdId;
	}

	public void setStdId(int stdId) {
		this.stdId = stdId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<String> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<String> subjects) {
		this.subjects = subjects;
	}

	public Passport getPport() {
		return pport;
	}

	public void setPport(Passport pport) {
		this.pport = pport;
	}

}
