package com.webtest.demo;

import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.NSDataProvider;

public class Admin_FollowsAndFans extends BaseTest{
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
	public void testChatFollows() throws InterruptedException {
		webtest.click("xpath=//img[@class='avatar-img nav-img']");
		Thread.sleep(2000);
		webtest.click("xpath=//div[@class='col-xs-6 l-p0']");
		Thread.sleep(2000);
		webtest.click("xpath=//ul[@class='nav navbar-nav new-nav']/li[2]");	
		Thread.sleep(2000);
		webtest.click("xpath=//a[@class='f-name']");
		Thread.sleep(3000);
		webtest.click("xpath=//div[@class='col-xs-4 bt-group']/button[2]");
		Thread.sleep(2000);
		webtest.type("id=chat_content", "ÄãºÃ");
		Thread.sleep(2000);
		webtest.click("xpath=//button[@class='pull-right btn btn-primary']");
		Thread.sleep(2000);
		webtest.click("xpath=//div[@class='control_btns pull-right']");
		Thread.sleep(2000);
	}
	@Test(priority = 3)
	public void testCancelFollows() throws InterruptedException {
		webtest.click("xpath=//img[@class='avatar-img nav-img']");
		Thread.sleep(2000);
		webtest.click("xpath=//div[@class='col-xs-6 l-p0']");
		Thread.sleep(2000);
		webtest.click("xpath=//ul[@class='nav navbar-nav new-nav']/li[2]");	
		Thread.sleep(2000);
		webtest.click("xpath=//a[@class='f-name']");
		Thread.sleep(3000);
		webtest.click("xpath=//div[@class='col-xs-4 bt-group']/button[1]");
		Thread.sleep(2000);
	}
	@Test(priority = 4)
	public void testChatFans() throws InterruptedException {
		webtest.click("xpath=//img[@class='avatar-img nav-img']");
		Thread.sleep(2000);
		webtest.click("xpath=//div[@class='col-xs-6 l-p0']");
		Thread.sleep(2000);
		webtest.click("xpath=//ul[@class='nav navbar-nav new-nav']/li[2]");	
		Thread.sleep(2000);
		webtest.click("xpath=//a[@class='my-num']");
		Thread.sleep(2000);
		webtest.click("xpath=//a[@class='f-name']");
		Thread.sleep(3000);
		webtest.click("xpath=//div[@class='col-xs-4 bt-group']/button[2]");
		Thread.sleep(2000);
		webtest.type("id=chat_content", "ÄãºÃ");
		Thread.sleep(2000);
		webtest.click("xpath=//button[@class='pull-right btn btn-primary']");
		Thread.sleep(2000);
		webtest.click("xpath=//div[@class='control_btns pull-right']");
		Thread.sleep(2000);
	}
	@Test(priority = 5)
	public void testFollowFans() throws InterruptedException {
		webtest.click("xpath=//img[@class='avatar-img nav-img']");
		Thread.sleep(2000);
		webtest.click("xpath=//div[@class='col-xs-6 l-p0']");
		Thread.sleep(2000);
		webtest.click("xpath=//ul[@class='nav navbar-nav new-nav']/li[2]");	
		Thread.sleep(2000);
		webtest.click("xpath=//a[@class='my-num']");
		Thread.sleep(2000);
		webtest.click("xpath=//a[@class='f-name']");
		Thread.sleep(3000);
		webtest.click("xpath=//div[@class='col-xs-4 bt-group']/button[1]");
		Thread.sleep(2000);
	}
	@Test(priority = 6)
	public void testChangeFollowName() throws InterruptedException {
		webtest.click("xpath=//img[@class='avatar-img nav-img']");
		Thread.sleep(2000);
		webtest.click("xpath=//div[@class='col-xs-6 l-p0']");
		Thread.sleep(2000);
		webtest.click("xpath=//ul[@class='nav navbar-nav new-nav']/li[2]");	
		Thread.sleep(2000);
		webtest.mouseToElement("xpath=//img[@class='avatar-img']");
		Thread.sleep(2000);
		webtest.mouseToElementandClick("xpath=//i[@class='icon-edit text-danger']");
		Alert alert=webtest.getAlert();
		Thread.sleep(2000);
		alert.sendKeys("êÇ³Æ1");
		Thread.sleep(2000);
		alert.accept();
		Thread.sleep(2000);
	}
	@Test(priority = 7)
	public void testChangeFanName() throws InterruptedException {
		webtest.click("xpath=//img[@class='avatar-img nav-img']");
		Thread.sleep(2000);
		webtest.click("xpath=//div[@class='col-xs-6 l-p0']");
		Thread.sleep(2000);
		webtest.click("xpath=//ul[@class='nav navbar-nav new-nav']/li[2]");	
		Thread.sleep(2000);
		webtest.click("xpath=//a[@class='my-num']");
		Thread.sleep(2000);
		webtest.mouseToElement("xpath=//img[@class='avatar-img']");
		Thread.sleep(2000);
		webtest.mouseToElementandClick("xpath=//i[@class='icon-edit text-danger']");
		Alert alert=webtest.getAlert();
		Thread.sleep(2000);
		alert.sendKeys("êÇ³Æ2");
		Thread.sleep(2000);
		alert.accept();
		Thread.sleep(2000);
	}
}
