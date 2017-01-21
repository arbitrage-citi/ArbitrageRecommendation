package com.citi.tests;

import junit.framework.TestCase;
//import static org.junit.Assert.*;
import java.sql.SQLException;

import com.citi.dao.impl.UserDaoImpl;
public class UserDaoimpltest extends TestCase {
// @Test
public void testisValidUser() throws SQLException {
  UserDaoImpl userimpl=new UserDaoImpl();
  boolean expected=true;
  boolean actual=userimpl.isValidUser("dbuser1","12345");
  assertEquals("Entering correct username and password",expected,actual);
  
}

public void testDriver() {
  
  try {
    Class.forName("oracle.driver.OracleDriver");
    fail("Should have thrown an exception!");
  }
  catch (ClassNotFoundException e) {
    System.out.println("Caught an exception!The test has been passed");
  }
}

}

