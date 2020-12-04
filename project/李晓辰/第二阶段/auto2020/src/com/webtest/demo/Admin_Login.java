package com.webtest.demo;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.NSDataProvider;
import com.webtest.dataprovider.TxtDataProvider;
import com.webtest.freemarker.GenerateReporter;
import com.webtest.listen.JavaMailTestListener;


public class Admin_Login  extends BaseTest{
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
//		assertTrue(webtest.isTextPresent("退出"));
	}
	@Test(priority = 2)
	public void testOut() throws InterruptedException {
		//回到主页
		webtest.click("class=first-a");
		Thread.sleep(2000);
		webtest.click("xpath=//img[@class='avatar-img nav-img']");
		Thread.sleep(2000);
		webtest.click("xpath=//i[@class='os-icon-logout']");
		Thread.sleep(2000);
	}
}
