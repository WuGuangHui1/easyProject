package com.webtest.demo;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.NSDataProvider;
import com.webtest.dataprovider.TxtDataProvider;



public class Admin_Login  extends BaseTest{
	@Test(dataProvider="mysql",dataProviderClass=NSDataProvider.class)
	public void testLogin(String a,String b) throws InterruptedException, IOException {
		webtest.open("http://localhost:8888/index.php");
		webtest.click("xpath=//a[@data-login='do_login']");
		Thread.sleep(3000);
		//webtest.type("id=inputEmail", "admin");
		webtest.type("id=inputEmail",a);
		Thread.sleep(3000);
		System.out.println("aa");
		//webtest.type("id=inputPassword", "admin");
		webtest.type("id=inputPassword",b);
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(3000);
//		assertTrue(webtest.isTextPresent("ÍË³ö"));
	}

}
