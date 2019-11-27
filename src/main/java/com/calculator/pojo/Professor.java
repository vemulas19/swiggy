package com.calculator.pojo;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class Professor {

	private String collegeName;
	private String subject;
	private double experience;

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public double getExperience() {
		return experience;
	}

	public void setExperience(double experience) {
		this.experience = experience;
	}

}
