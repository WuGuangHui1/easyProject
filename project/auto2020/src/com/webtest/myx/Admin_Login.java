package com.webtest.myx;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.NSDataProvider;
import com.webtest.dataprovider.NSDataProvider;
/**
 * 
 * @author ÂíÒÕ¬u
 *
 */
public class Admin_Login  extends BaseTest{
	
	
	@Test(dataProvider="excel",dataProviderClass=NSDataProvider.class,priority = 0)
	
	public void testLogin(String a,String b) throws InterruptedException {
		
		webtest.open("http://localhost:8080/");
		webtest.click("xpath=//a[@data-login='do_login']");
		Thread.sleep(3000);
		
		webtest.type("id=inputEmail", a);
		Thread.sleep(3000);
		System.out.println("aa");
		webtest.type("id=inputPassword", b);
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(5000);
//		assertTrue(webtest.isTextPresent("ï¿½Ë³ï¿½"));
//		webtest.click("xpath=//span[@class='user-name text-ellipsis']");
//		Thread.sleep(3000);
//		webtest.click("xpath=//div[@style='cursor: pointer']");
//		Thread.sleep(3000);
	}

}
