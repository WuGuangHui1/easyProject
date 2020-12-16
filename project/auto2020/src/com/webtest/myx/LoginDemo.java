package com.webtest.myx;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.ExcelDataProvider;
import com.webtest.dataprovider.NSDataProvider;
import com.webtest.utils.ReadProperties;
//@Listeners(GenerateReporter.class)
public class LoginDemo  extends BaseTest{
	@Test(dataProvider="excel",dataProviderClass=NSDataProvider.class,priority = 0)
	public void testLogin(String a,String b) throws IOException, InterruptedException {
		String back_url=ReadProperties.getPropertyValue("back_url");
		webtest.open(back_url);
		Thread.sleep(2000);
		webtest.type("name=username", a);
		webtest.type("name=password", b);
		Thread.sleep(1000);
		webtest.click("class=on");
	
	}
//	/html/body/div[1]/div/div/section[2]/div/div[2]/div/div[3]/form/table/tbody/tr[1]/td[1]/a
//	���ı��༭�������ı�
//	@Test(priority=1)
//	public void why21test() throws InterruptedException {
//		webtest.mouseToElement("xpath=//i[@class='icon-windows']");
//		webtest.click("link=��Ϣģ��");
//		webtest.click("xpath=//table[@class='table table-bordered table-striped table-hover']/tbody/tr[1]/td[1]/a");
//		driver.switchTo().frame("ueditor_0");
//		webtest.click("xpath=//body[@class='view']");
//		webtest.typeAndClear("xpath=//body[@class='view']", "�������ÿ�");
//        driver.switchTo().defaultContent();
//        webtest.click("id=submit");
//        webtest.alertAccept();
//	}
//	���ı��༭���Ӵ�
//	@Test(priority=2)
//	public void why22test() throws InterruptedException {
//		webtest.mouseToElement("xpath=//i[@class='icon-windows']");
//		webtest.click("link=��Ϣģ��");
//		webtest.click("xpath=//table[@class='table table-bordered table-striped table-hover']/tbody/tr[1]/td[1]/a");
//		driver.switchTo().frame("ueditor_0");
//		webtest.click("xpath=//body[@class='view']");
//		webtest.type("xpath=//body[@class='view']",Keys.LEFT_CONTROL + "a" );
//        driver.switchTo().defaultContent();
//        webtest.click("id=edui157_body");
//        webtest.click("id=submit");
//        webtest.alertAccept();
//	}

}
