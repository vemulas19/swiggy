package com.calculator.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BaseController {

	@RequestMapping(value="/goToHomePage")
	public String goToHome() {
		System.out.println("executing BaseController::goToHome method");
		return "Home";
	}
}
