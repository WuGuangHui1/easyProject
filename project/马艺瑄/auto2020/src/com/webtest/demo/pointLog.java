package com.webtest.demo;

import org.testng.annotations.Test;

public class pointLog extends LoginDemo{
	//��ջ�����־
		@Test(priority=30)
		public void test42() throws InterruptedException {
			webtest.pause(3000);
			webtest.mouseToElement("xpath=//i[@class='icon-laptop']");
			webtest.click("link=������־");
			webtest.click("xpath=//button[text()='�����־']");
			webtest.alertAccept();
			Thread.sleep(1000);
		}
		//����������־
		@Test(priority=29)
		public void test43() throws InterruptedException {
			webtest.pause(3000);
			webtest.mouseToElement("xpath=//i[@class='icon-laptop']");
			webtest.click("link=������־");
			webtest.click("xpath=//button[text()='����CSV']");
			webtest.alertAccept();
			Thread.sleep(1000);
		}
	
}
