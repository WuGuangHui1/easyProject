package com.webtest.demo.view;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class Back_Login extends BaseTest{
	
	@Test
	public void testLogin() {

		webtest.open("http://localhost:8033//admin.php");
		webtest.type("name=username", "admin");
		webtest.type("name=password", "123456");
		webtest.click("class=login-btn");
		assertTrue(webtest.isTextPresent("admin"));
	}

	

}
