package com.calculator.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Calculator {
	
	@RequestMapping(value="/addNums")
	public String sum(@RequestParam("num1") int n1, @RequestParam("num2") int n2, Model m) {
		System.out.println("testing sum method!!");
		System.out.println("Number1 is  : " + n1);
		System.out.println("Number2 is  : " + n2);
		int c = n1+n2;
		System.out.println("The sum is : " + c);
		m.addAttribute("s", c);
		return "result";
	}
	
	@RequestMapping(value="/subNums")
	public String substract(@RequestParam("num1") int n1, @RequestParam("num2") int n2, Model m) {
		System.out.println("Number1 is  : " + n1);
		System.out.println("Number2 is  : " + n2);
		int res = n1-n2;
		System.out.println("The sub is : " + res);
		m.addAttribute("sub", res);
		return "result";
	}
}
