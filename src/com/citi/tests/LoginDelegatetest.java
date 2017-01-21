package com.citi.tests;


import junit.framework.TestCase;
//import static org.junit.Assert.*;
import java.sql.SQLException;

import com.citi.delegate.LoginDelegate;
public class LoginDelegatetest extends TestCase {
//@Test
public void testisvaliduser() throws SQLException {
LoginDelegate logindelegate=new LoginDelegate();
String line;
if(logindelegate.isValidUser("dbuser1","12345")){
			System.out.println("In login controller if-login successful");
			line="Successful";
			
		}
		else
		{
			System.out.println("In login controller else-login unsuccessful");
			line="unsuccessful";
			
		}
      
      String expected="Successful";
      String actual=line;
      assertEquals(expected,actual);


} 





}


