package com.webtest.demo;

import java.io.IOException;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.NSDataProvider;

public class Admin_Switch extends BaseTest{
	@Test(dataProvider="excel",dataProviderClass=NSDataProvider.class)
	public void testLogin(String a,String b) throws InterruptedException, IOException {
		webtest.open("http://localhost:8888/index.php");
		webtest.click("xpath=//a[@data-login='do_login']");
		Thread.sleep(3000);
		webtest.type("id=inputEmail",a);
		Thread.sleep(3000);
		System.out.println("aa");
		webtest.type("id=inputPassword",b);
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(3000);
//		assertTrue(webtest.isTextPresent("ÍË³ö"));
	}
	@Test(priority = 2)
	public void testToBack() throws InterruptedException {
		webtest.mouseToElementandClick("xpath=//i[@class='iconfont icon-caidan']");
		Thread.sleep(2000);
		webtest.click("xpath=//ul[@class='dropdown-menu  drop-self nav-menu']/li[6]");
		Thread.sleep(2000);
		webtest.switchWidow(1);
		Thread.sleep(2000);
	}
	@Test(priority = 2)
	public void testToFront() throws InterruptedException {
		webtest.click("xpath=//ul[@class='nav navbar-nav navbar-right']/li[2]");
		Thread.sleep(2000);
		webtest.switchWidow(2);
		Thread.sleep(2000);
	}
}
