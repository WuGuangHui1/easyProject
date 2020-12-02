package com.webtest.demo;

import org.testng.annotations.Test;

public class pointLog extends LoginDemo{
	//清空积分日志
		@Test(priority=30)
		public void test42() throws InterruptedException {
			webtest.pause(3000);
			webtest.mouseToElement("xpath=//i[@class='icon-laptop']");
			webtest.click("link=积分日志");
			webtest.click("xpath=//button[text()='清空日志']");
			webtest.alertAccept();
			Thread.sleep(1000);
		}
		//导出积分日志
		@Test(priority=29)
		public void test43() throws InterruptedException {
			webtest.pause(3000);
			webtest.mouseToElement("xpath=//i[@class='icon-laptop']");
			webtest.click("link=积分日志");
			webtest.click("xpath=//button[text()='导出CSV']");
			webtest.alertAccept();
			Thread.sleep(1000);
		}
	
}
