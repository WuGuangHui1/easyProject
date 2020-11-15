package com.webtest.demo;

import static org.testng.Assert.assertTrue;


import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.NSDataProvider;



public class Admin_Login extends BaseTest{
	@Test(dataProvider="excel" ,dataProviderClass=NSDataProvider.class)
	public void testlogin(String name ,String pw) {
		webtest.open("index.php?s=/admin/public/login.html");
		webtest.type("name=username", name);
		webtest.type("name=password", pw);
		webtest.click("class=on");
//		webtest.click()
		System.out.println(name+pw);
	}
	

}
