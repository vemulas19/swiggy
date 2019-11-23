package com.calculator.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.calculator.pojo.College;
import com.calculator.pojo.Passport;
import com.calculator.pojo.Student;

@Controller
public class TestController {

	@Autowired
	private Student s1;
	
	@Autowired
	Student s2;
	
	@Qualifier(value = "aurObj")
	@Autowired
	College c1;
	
	@Qualifier(value = "aurObj")
	@Autowired
	College c2;
	
	@Qualifier(value = "cbiObj")
	@Autowired
	College c3;
	
	@Qualifier(value = "cbiObj")
	@Autowired
	College c4;

	@RequestMapping(value = "/testIoc")
	public String testIoc() {
		System.out.println("Triggred testIoc method");
		
		System.out.println("-----college-------");
		c1.setLocation("Ramanthapur");
		c2.setLocation("Ramanthapur");
		c3.setLocation("Gachibowli");
		System.out.println(c1.getCollegeName() + "---" + c1.getLocation());
		System.out.println(c2.getCollegeName() + "---" + c2.getLocation());
		System.out.println(c3.getCollegeName() + "---" + c3.getLocation());
		
		System.out.println("-----college-------");
		
		s2.setStdId(101);
		s2.setName("Raju");
		
		s2.getPport().setPptId(1234);
		s2.getPport().setIssuedCity("Pune");
		/*
		 * s2.setCollegeName("Aurora"); s2.setCity("Hyderabad");
		 */

		s1.setStdId(100);
		s1.setName("Ravi");
		
		s1.getPport().setPptId(5678);
		s1.getPport().setIssuedCity("Melbourne");
		/*
		 * s1.setCollegeName("Aurora"); s1.setCity("Hyderabad");
		 */

		System.out.println(s1.getStdId() + "--" + s1.getName() + "--" + s1.getCollegeName() + "--" + s1.getCity() + "--" + s1.getPport().getPptId()  + "--" + s1.getPport().getIssuedCity() + "--" + s1.getPport().getCountry());
		System.out.println(s2.getStdId() + "--" + s2.getName() + "--" + s2.getCollegeName() + "--" + s2.getCity() + "--" + s2.getPport().getPptId()  + "--" + s2.getPport().getIssuedCity() + "--" + s2.getPport().getCountry());
		return "register";
	}

	public static void main(String[] args) {
		/*
		 * IAnimal animal = new Human(); animal.getNoice(); animal.getLegs();
		 * animal.database();
		 */
		Student std1 = new Student();
		
		Passport pp1 = new Passport();
		pp1.setPptId(23093894);
		pp1.setIssuedCity("Pune");
		pp1.setCountry("India");
		
		std1.setName("Ravi");
		std1.setStdId(100);
		std1.setCity("Hyderabad");
		std1.setCollegeName("Aurora");
//		std1.setPport(pp1);
		
		System.out.println("----------------------------");
		
		System.out.println(std1.getPport().getIssuedCity());
		System.out.println(std1.getPport().getCountry());
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
