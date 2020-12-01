package com.webtest.demo;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.NSDataProvider;
import com.webtest.freemarker.GenerateReporter;


@Listeners(GenerateReporter.class)
public class Admin_Login  extends BaseTest{
	
	@Test(dataProvider="excel" ,dataProviderClass=NSDataProvider.class,priority = 0)
	public void testLogin(String name ,String pw) throws InterruptedException {
		
		webtest.open("index.php");
		webtest.click("xpath=//a[@data-login='do_login']");
		webtest.type("name=username", name);
		webtest.type("name=password",pw);
		webtest.click("xpath=//button[@type='submit']");
		System.out.println(name+pw);
	}
	
	
	
	

}
