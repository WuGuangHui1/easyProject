package com.webtest.demo;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.freemarker.GenerateReporter;


@Listeners(GenerateReporter.class)
public class Public extends LoginDemo{
//	新增公告
	@Test(priority=1)
	public void test1() throws InterruptedException {
		webtest.mouseToElement("xpath=//i[@class='icon-laptop']");
		webtest.click("link=公告列表");
        webtest.click("link=新增");
        webtest.type("xpath=//input[@name='title']","Baidu");
        webtest.type("xpath=//input[@name='link']", "https://www.baidu.com/");
        driver.switchTo().frame("ueditor_0");
		webtest.click("xpath=//body[@class='view']");
		webtest.type("xpath=//body[@class='view']", "你今天真好看");
        driver.switchTo().defaultContent();
        JavascriptExecutor js=(JavascriptExecutor)driver;
    	js.executeScript("scrollTo(0,10000)");
    	webtest.click("xpath=//button[text()='确定']");
    	webtest.alertAccept();
    	Thread.sleep(1000);
	}
//	启动公告  value的值应该就是那个id
	@Test(priority=2)
	public void test2() throws InterruptedException {
		webtest.pause(3000);
		webtest.mouseToElement("xpath=//i[@class='icon-laptop']");
		webtest.click("link=公告列表");
		webtest.click("xpath=//tbody/tr[1]/td[1]/input");
		webtest.click("xpath=//button[text()='启用']");
		webtest.alertAccept();
		Thread.sleep(1000);
	}
//	禁用公告
	@Test(priority=3)
	public void test3() throws InterruptedException {
		webtest.pause(3000);
		webtest.mouseToElement("xpath=//i[@class='icon-laptop']");
		webtest.click("link=公告列表");
		webtest.click("xpath=//tbody/tr[1]/td[1]/input");
		webtest.click("xpath=//button[text()='禁用']");
		webtest.alertAccept();
		Thread.sleep(1000);
	}
//  删除公告
	@Test(priority=4)
	public void test4() throws InterruptedException {
		webtest.pause(3000);
		webtest.mouseToElement("xpath=//i[@class='icon-laptop']");
		webtest.click("link=公告列表");
		webtest.click("xpath=//tbody/tr[1]/td[1]/input");
		webtest.click("xpath=//button[text()='删除']");
		webtest.alertAccept();
		Thread.sleep(1000);
	}




//	@Test(priority=21)(未成功）
//	public void test36() throws InterruptedException {
//		webtest.mouseToElement("xpath=//i[@class='icon-laptop']");
//		webtest.click("link=图片水印设置");
//		Thread.sleep(1000);
//		webtest.enter();
//		Thread.sleep(1000);
//		webtest.click("xpath=//input[text()='开启']");
//		webtest.click("xpath=//input[@value='10001']");
//		webtest.click("xpath=//button[text()='确定']");
//		webtest.alertAccept();
//	}

	
	
	
	
	
	
	

}
