package com.calculator.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.calculator.dao.interf.IUserDao;
import com.calculator.pojo.User;
import com.calculator.validation.SwiggyValidation;

public class UserService {

	@Autowired
	IUserDao dao;

	final static Logger logger = Logger.getLogger(UserService.class);

	public String saveUser(User user, Model m) {
		logger.info("Executing UserService :: saveUser");
		logger.debug("Request came for registration : " + user.getMailId() + "--" + user.getMobile() + "--"
				+ user.getCity() + "--" + user.getName() + "--" + user.getPassword());
		// validation logic here
		boolean isValidMail = SwiggyValidation.isValidMail(user.getMailId());
		logger.debug("Mail validation check : " + isValidMail);
		if (!isValidMail) {
			logger.debug("Invalid mail id entered!!" + user.getMailId());
			m.addAttribute("message", "Invalid mail id entered!! Please try with valid one!!");
			return "register";
		}

		boolean isValidMobile = SwiggyValidation.isValidMobile(user.getMobile());
		if (!isValidMobile) {
			logger.debug("Entered invalid mobile number!!" + user.getMobile());
			m.addAttribute("message", "Invalid mobile number entered!! Please try with valid one!!");
			return "register";
		}
		// validation logic ends here

		try {
			logger.debug("saving user to database : " + user.getMailId());
			dao.saveUser(user);			
		} catch(Exception e) {
			logger.error("Exceptio while registration : ", e);
		}

		logger.info("Exiting UserService :: saveUser");
		return "login";
	}

	public String loginUser(String userName, String password, Model model, HttpSession httpSession) {
		logger.info("executing UserService :: loginUser!!");

		List<User> list = dao.loginUser(userName, password);

		logger.debug("parsing list of user and printing to console!!");
		if (list == null || list.isEmpty()) { // if list is empty means, username or password is not matching with
												// database
			logger.debug("User entered invalid credentials : " + userName);
			model.addAttribute("message", "Invalid Username or password entered!! Please try again!!");
			return "login";
		}
		System.out.println("login for " + userName);
		httpSession.setAttribute("userName", userName); // adding userName to session object
//		httpSession.setMaxInactiveInterval(10);
		for (User user : list) {
			logger.debug(user.getName() + "--" + user.getMobile() + "--" + user.getMailId() + "--" + user.getPassword()
					+ "--" + user.getCity());
		}
		logger.debug("parsing is done!!");

		logger.info("exit UserService :: loginUser!!");
		return "Home";
	}
}
