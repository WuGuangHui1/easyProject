package com.webtest.demo;

import org.testng.annotations.Test;

public class sensitiveword extends LoginDemo{
//	新增敏感词汇
	@Test(priority=1)
	public void test9() throws InterruptedException {
		
		webtest.mouseToElement("xpath=//i[@class='icon-laptop']");
		webtest.click("link=敏感词列表");
		webtest.click("link=新增");
		webtest.type("xpath=//input[@name='title']", "小人");
		webtest.click("xpath=//button[text()='确定']");
		webtest.alertAccept();
		Thread.sleep(1000);
	}
//	启用敏感词汇
	@Test(priority=2)
	public void test10() throws InterruptedException {
		webtest.pause(3000);
		webtest.mouseToElement("xpath=//i[@class='icon-laptop']");
		webtest.click("link=敏感词列表");
		webtest.click("xpath=//tbody/tr[1]/td[1]/input");
		webtest.click("xpath=//button[text()='启用']");
	    webtest.alertAccept();
	    Thread.sleep(1000);
	}
//	禁用敏感词汇
	@Test(priority=3)
	public void test11() throws InterruptedException {
		webtest.pause(3000);
		webtest.mouseToElement("xpath=//i[@class='icon-laptop']");
		webtest.click("link=敏感词列表");
		webtest.click("xpath=//input[@value='1']");
		webtest.click("xpath=//button[text()='禁用']");
	   webtest.alertAccept();
	   Thread.sleep(1000);
	}
//	删除敏感词汇
	@Test(priority=4)
	public void test12() throws InterruptedException {
		webtest.pause(3000);
		webtest.mouseToElement("xpath=//i[@class='icon-laptop']");
		webtest.click("link=敏感词列表");
		webtest.click("xpath=//input[@value='1']");
		webtest.click("xpath=//button[text()='删除']");
		webtest.alertAccept();
		Thread.sleep(1000);
	}
//	批量添加敏感词汇
	@Test(priority=5)
	public void test13() throws InterruptedException {
		webtest.pause(3000);
		webtest.mouseToElement("xpath=//i[@class='icon-laptop']");
		webtest.click("link=批量添加");
		webtest.type("xpath=//textarea[@name='titles']", "嘻嘻|嘤嘤嘤|啧啧啧");
		webtest.click("xpath=//button[text()='确定']");
		webtest.alertAccept();
		Thread.sleep(1000);
	}
}
