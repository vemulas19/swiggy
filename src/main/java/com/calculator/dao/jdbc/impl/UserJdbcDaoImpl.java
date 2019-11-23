package com.calculator.dao.jdbc.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

import org.apache.log4j.Logger;

import com.calculator.dao.impl.UserHibernateDaoImpl;
import com.calculator.dao.interf.IUserDao;
import com.calculator.pojo.User;

public class UserJdbcDaoImpl implements IUserDao {// Assume this is Cat

	final static Logger logger = Logger.getLogger(UserJdbcDaoImpl.class);
	
	public void saveUser(User user) {
		logger.info("executing UserJdbcDaoImpl :: saveUser");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			logger.debug("Loaded driver class!!");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "SYSTEM", "system");
			PreparedStatement ps = con.prepareStatement("insert into swiggyuser (mailId, name, mobile, password, city) values(?,?,?,?,?) ");
			ps.setString(1, user.getMailId());
			ps.setString(2, user.getName());
			ps.setString(3, user.getMobile());
			ps.setString(4, user.getPassword());
			ps.setString(5, user.getCity());
			ps.executeUpdate();
			logger.debug("Registration completed : " + user.getMailId());
			con.close();
		} catch (Exception ex) {
			logger.error("Exception occured while saving user to database!!", ex);
		}
		logger.info("exit UserJdbcDaoImpl :: saveUser");
	}

	public List<User> loginUser(String userName, String password) {
		logger.info("executing UserJdbcDaoImpl :: loginUser");
		logger.debug("TODO!!");
		logger.info("exit UserJdbcDaoImpl :: loginUser");
		return null;
	}

}
