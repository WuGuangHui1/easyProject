package com.webtest.demo;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.NSDataProvider;

public class Admin_DomainName extends BaseTest{
	@Test(dataProvider="excel",dataProviderClass=NSDataProvider.class,priority = 1)
	public void testLogin(String a,String b) throws InterruptedException {
		webtest.open("http://localhost:8888/index.php");
		webtest.click("xpath=//a[@data-login='do_login']");
		Thread.sleep(3000);
		webtest.type("id=inputEmail",a);
		Thread.sleep(3000);
		System.out.println("aa");
		webtest.type("id=inputPassword",b);
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(3000);
	}
	@Test(priority = 2)
	public void testSeturl() throws InterruptedException {
		webtest.click("xpath=//img[@class='avatar-img nav-img']");
		Thread.sleep(2000);
		webtest.click("xpath=//i[@class='os-icon-settings']");
		Thread.sleep(2000);
		webtest.click("id=short_url");
		Thread.sleep(2000);
		webtest.typeAndClear("id=short", "test123");
		Thread.sleep(2000);
		webtest.click("xpath=//button[@class='btn btn-primary']");
		Thread.sleep(2000);
	}
	@Test(priority = 3)
	public void testOprenurl() throws InterruptedException {
		webtest.open("http://localhost:8888/u/test123");
		Thread.sleep(5000);
	}
}
