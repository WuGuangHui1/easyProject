package com.webtest.demo;

import java.io.IOException;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.ExcelDataProvider;
import com.webtest.dataprovider.NSDataProvider;

public class Admin_Login  extends BaseTest{
	@Test(dataProvider="mysql",dataProviderClass=NSDataProvider.class)
	public void testfront_login(String a,String b) throws IOException, InterruptedException {
		System.out.println(123);
		webtest.open("http://localhost:9999/");
		webtest.click("link=µÇÂ¼");
		webtest.type("name=username", a);
		webtest.type("name=password",b);
		webtest.click("xpath=//button[@type='submit']");
		webtest.mouseToElement("class=user-name");
		webtest.click("class=os-icon-logout");
	}
//	@Test
//	public void testLogin() throws InterruptedException {
//		
//		webtest.open("http://localhost:9999/index.php?s=/admin/public/login.html");
//		Thread.sleep(2000);
//		webtest.type("name=username", "wgh123");
//		webtest.type("name=password", "wgh123");
//		Thread.sleep(2000);
//		webtest.click("class=on");
//	}

}
