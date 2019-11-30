package com.calculator.interceptors;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SessionValidationInterceptor extends HandlerInterceptorAdapter {

	final static Logger logger = Logger.getLogger(SessionValidationInterceptor.class);
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("executing SessionValidationInterceptor :: preHandle method!!");
		HttpSession httpSession = request.getSession();
		String userName = (String) httpSession.getAttribute("userName");
		
		logger.debug("User name in session is :  " + userName);
		if (userName == null || userName.isEmpty()) {
			logger.debug("userName not available in session!!");
			logger.debug("User trying to skip login page!!");

			ModelAndView mv = new ModelAndView("login");
			mv.addObject("message", "Please login to access this page!!");
			throw new ModelAndViewDefiningException(mv);
		} else {
			logger.debug("User name is available in session!!");
			logger.debug("User already loged in!!");
			return true;
		}
		
	}
}
