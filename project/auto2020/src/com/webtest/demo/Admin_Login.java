package com.webtest.demo;
import java.io.IOException;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.NSDataProvider;
import com.webtest.dataprovider.TxtDataProvider;
import com.webtest.utils.ReadProperties;



public class Admin_Login  extends BaseTest{
	
//	@Test
//	public void testLogin() throws InterruptedException, IOException {
////	String filepath="D:\\demo\\1.txt";
//		TxtDataProvider tdp=new TxtDataProvider();
//		tdp.getTxtUser(filepath);
//		String username=tdp.getValue("username");
//		String password=tdp.getValue("password");
//		
//		webtest.open("http://localhost:8989/index.php");
//		webtest.click("xpath=//a[@data-login='do_login']");
//		Thread.sleep(3000);
//		webtest.type("id=inputEmail", username);
//		Thread.sleep(3000);
//		System.out.println("aa");
//		webtest.type("id=inputPassword", password);
//		webtest.click("xpath=//button[@type='submit']");
//		Thread.sleep(3000);
////		assertTrue(webtest.isTextPresent("�˳�"));
		
//	}
	@Test(dataProvider="excel",dataProviderClass=NSDataProvider.class,priority = 0)
	public void testLogin(String a,String b) throws IOException, InterruptedException {
		String back_url=ReadProperties.getPropertyValue("back_url");
		webtest.open(back_url);
		Thread.sleep(1000);
		webtest.type("name=username", a);
		webtest.type("name=password", b);
		Thread.sleep(1000);
		webtest.click("class=on");
	
	}

}
