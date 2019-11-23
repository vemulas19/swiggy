package com.calculator.controllers;

import javax.servlet.http.HttpSession;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.calculator.pojo.User;
import com.calculator.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService service;

	final static Logger logger = Logger.getLogger(UserController.class);

	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public String saveUser(User user, Model m) {
		logger.info("Executing UserController :: saveUser");
		System.out.println(user.getName() + "--" + user.getMobile() + "--" + user.getMailId() + "--"
				+ user.getPassword() + "--" + user.getCity());

		String res = service.saveUser(user, m);

		logger.info("Exit UserController :: saveUser");
		return res;
	}

	@RequestMapping(value = "/loginUser", method = RequestMethod.POST)
	public String loginUser(@RequestParam("userName") String userName, @RequestParam("pwd") String password,
			Model model, HttpSession httpSession) {
		logger.info("executing UserController :: loginUser method!!");

		String res = service.loginUser(userName, password, model, httpSession);

		logger.info("exit UserController :: loginUser!!");
		return res;
	}
	
	@RequestMapping(value="/logout")
	public String logoutUser(Model model, HttpSession httpSession) {
		httpSession.removeAttribute("userName");
		model.addAttribute("message", "logout successfully completed!!");
		return "login";
	}

}
