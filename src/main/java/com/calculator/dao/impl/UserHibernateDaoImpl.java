package com.calculator.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.calculator.dao.interf.IUserDao;
import com.calculator.pojo.User;
import com.calculator.service.UserService;

public class UserHibernateDaoImpl implements IUserDao {//Assume this is Dog

	final static Logger logger = Logger.getLogger(UserHibernateDaoImpl.class);
	
	public void saveUser(User user) {
		logger.info("Executing UserHibernateDaoImpl :: saveUser");
		Configuration configure = new Configuration().configure("hibernate.cfg.xml");
		logger.debug("config created!!");
		SessionFactory sf = configure.buildSessionFactory();
		logger.debug("session factory created");
		Session session = sf.openSession();
		Transaction tc = session.beginTransaction();
		session.save(user);
		tc.commit();
		logger.debug("User registration completed!!" + user.getMailId());
		session.close();
		logger.info("Exiting UserHibernateDaoImpl :: saveUser");
	}
	
	public List<User> loginUser(String userName, String password) {
		logger.info("executing UserHibernateDaoImpl :: loginUser");
		Configuration configure = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sf = configure.buildSessionFactory();
		Session session = sf.openSession();
		Query userSelectQuery = session.createQuery("from User where mailid = :mail and password = :pwd");
		userSelectQuery.setParameter("mail", userName);
		userSelectQuery.setParameter("pwd", password);
		List<User> list = userSelectQuery.list();
		logger.info("exit UserHibernateDaoImpl :: loginUser");
		return list;
	}
}
