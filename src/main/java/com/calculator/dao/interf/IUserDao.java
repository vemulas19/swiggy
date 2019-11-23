package com.calculator.dao.interf;

import java.util.List;

import com.calculator.pojo.User;

public interface IUserDao {//Assume this is IAnimal

	public void saveUser(User user);
	public List<User> loginUser(String userName, String password);
}