package com.citi.delegate;

import java.sql.SQLException;

import com.citi.service.impl.UserServiceImpl;

public class LoginDelegate
{

		public boolean isValidUser(String username, String password) throws SQLException
    {
			UserServiceImpl userService=new UserServiceImpl();
			System.out.println("In isValidUser() of LoginDelegate");
		    return userService.isValidUser(username, password);
    }
}
