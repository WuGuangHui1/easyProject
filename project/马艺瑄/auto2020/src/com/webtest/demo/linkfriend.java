package com.webtest.demo;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.freemarker.GenerateReporter;

@Listeners(GenerateReporter.class)
public class linkfriend extends LoginDemo{
//	添加友情链接  (记得改文件地址)
	@Test(priority=1)
	public void test5() throws InterruptedException {
	
		
		webtest.mouseToElement("xpath=//ul[@class='nav navbar-nav top-menu']/li[3]/a");
		webtest.click("link=友情链接");
		webtest.click("link=新增");
		webtest.type("xpath=//input[@name='title']", "title");
		webtest.pause(2000);
		webtest.type("xpath=//input[@name='link']", "https://www.baidu.com/");
		webtest.pause(2000);
		webtest.type("xpath=//input[@name='file']", "D:\\demo\\1.jpg");
		webtest.pause(2000);
		webtest.click("xpath=//form[@id='form']/div[2]/input[1]");
		webtest.pause(2000);
		Thread.sleep(1000);
	}
//	启用友情链接
	@Test(priority=3)
	public void test6() throws InterruptedException {
		Thread.sleep(1000);
		webtest.mouseToElement("xpath=//ul[@class='nav navbar-nav top-menu']/li[3]/a");
		webtest.click("link=友情链接");
		webtest.click("xpath=//tbody/tr[1]/td[1]/input");
		webtest.click("xpath=//button[text()='启用']");
		webtest.alertAccept();
		Thread.sleep(1000);
	}
//	禁用友情链接
	@Test(priority=2)
	public void test7() throws InterruptedException {
		webtest.pause(3000);
		webtest.mouseToElement("xpath=//ul[@class='nav navbar-nav top-menu']/li[3]/a");
		webtest.click("link=友情链接");
		webtest.click("xpath=//tbody/tr[2]/td[1]/input");
		webtest.click("xpath=//button[text()='禁用']");
		webtest.alertAccept();
		Thread.sleep(1000);
	}
//	删除友情链接
	@Test(priority=4)
	public void test8() throws InterruptedException {
		webtest.pause(3000);
		webtest.mouseToElement("xpath=//ul[@class='nav navbar-nav top-menu']/li[3]/a");
		webtest.click("link=友情链接");
		webtest.click("xpath=//tbody/tr[1]/td[1]/input");
		webtest.click("xpath=//button[text()='删除']");
		webtest.alertAccept();
		webtest.alertAccept();
		Thread.sleep(1000);

	}
}
