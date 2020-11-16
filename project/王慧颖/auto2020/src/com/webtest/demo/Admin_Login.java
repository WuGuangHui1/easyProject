package com.webtest.demo;
import java.io.IOException;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.TxtDataProvider;



public class Admin_Login  extends BaseTest{
	
	@Test
	public void testLogin() throws InterruptedException, IOException {
		String filepath="D:\\demo\\1.txt";
		TxtDataProvider tdp=new TxtDataProvider();
		tdp.getTxtUser(filepath);
		String username=tdp.getValue("username");
		String password=tdp.getValue("password");
		
		webtest.open("http://localhost:8989/index.php");
		webtest.click("xpath=//a[@data-login='do_login']");
		Thread.sleep(3000);
		webtest.type("id=inputEmail", username);
		Thread.sleep(3000);
		System.out.println("aa");
		webtest.type("id=inputPassword", password);
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(3000);
//		assertTrue(webtest.isTextPresent("�˳�"));
	}

}
