package com.webtest.demo;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.ExcelDataProvider;
import com.webtest.dataprovider.NSDataProvider;

public class RegisterTest extends BaseTest{
	@Test(dataProvider="excel" ,dataProviderClass=NSDataProvider.class)
	public void test2(String usernamemail,String nickname,String password) {
		webtest.open(" ");
		webtest.click("link=зЂВс");
		webtest.type("name=username", usernamemail);
		webtest.type("name=nickname", nickname);
		webtest.type("name=password", password);
		webtest.click("xpath=//button[@type='submit']");
		System.out.println(usernamemail+nickname+" "+password);
	
		
	}
}
