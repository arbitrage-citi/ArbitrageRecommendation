package com.citi.service.impl;

import java.sql.SQLException;

import com.citi.dao.UserDao;
import com.citi.dao.impl.UserDaoImpl;
import com.citi.service.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public boolean isValidUser(String username, String password) throws SQLException {
		UserDaoImpl userDao = new UserDaoImpl();
		System.out.println("In isValidUser() of UserServiceImpl");
		return userDao.isValidUser(username, password);
	}

}
