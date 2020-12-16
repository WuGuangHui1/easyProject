package com.webtest.myx;

import org.testng.annotations.Test;

public class behaviorlog extends LoginDemo{
	//删除行为日志
	@Test(priority=31)
	public void test60() throws InterruptedException {
		webtest.pause(3000);
		webtest.mouseToElement("xpath=//i[@class='icon-laptop']");
		webtest.click("link=行为日志");
		webtest.click("xpath=//tbody/tr[1]/td[1]/input");
		webtest.click("xpath=//button[text()='删 除']");
		webtest.alertAccept();
		webtest.alertAccept();
		Thread.sleep(1000);
	}
	//导出行为日志
		@Test(priority=32)
		public void test63() throws InterruptedException {
			webtest.pause(3000);
			webtest.mouseToElement("xpath=//i[@class='icon-laptop']");
			webtest.click("link=行为日志");
			webtest.click("xpath=//div[@class='col-xs-8 pd0']/button[4]");
			webtest.alertAccept();
			
			Thread.sleep(3000);
		}
		//筛选行为日志
		@Test(priority=33)
		public void test62() throws InterruptedException {
			webtest.pause(5000);
			webtest.mouseToElement("xpath=//i[@class='icon-laptop']");
			webtest.click("link=行为日志");
			webtest.click("xpath=//button[text()='筛选']");
			webtest.selectByVisibleText("xpath=//select[@name='select']", "用户登录");
			webtest.click("xpath=//button[@value='确定']");
			Thread.sleep(1000);
		}
		//搜索行为日志
		@Test(priority=34)
		public void test65() throws InterruptedException {
			webtest.pause(3000);
			webtest.mouseToElement("xpath=//i[@class='icon-laptop']");
			webtest.click("link=行为日志");
			webtest.type("class=search-input form-control", "admin1");
			webtest.click("class='btn btn-default'");
			Thread.sleep(1000);
		}
}
