package com.webtest.wgh;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.ExcelDataProvider;
import com.webtest.dataprovider.NSDataProvider;
import com.webtest.freemarker.GenerateReporter;
import com.webtest.utils.ReadProperties;
@Listeners(GenerateReporter.class)
public class LoginDemo  extends BaseTest{
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
