package com.webtest.myx;

import org.testng.annotations.Test;

public class behaviorlog extends LoginDemo{
	//ɾ����Ϊ��־
	@Test(priority=31)
	public void test60() throws InterruptedException {
		webtest.pause(3000);
		webtest.mouseToElement("xpath=//i[@class='icon-laptop']");
		webtest.click("link=��Ϊ��־");
		webtest.click("xpath=//tbody/tr[1]/td[1]/input");
		webtest.click("xpath=//button[text()='ɾ ��']");
		webtest.alertAccept();
		webtest.alertAccept();
		Thread.sleep(1000);
	}
	//������Ϊ��־
		@Test(priority=32)
		public void test63() throws InterruptedException {
			webtest.pause(3000);
			webtest.mouseToElement("xpath=//i[@class='icon-laptop']");
			webtest.click("link=��Ϊ��־");
			webtest.click("xpath=//div[@class='col-xs-8 pd0']/button[4]");
			webtest.alertAccept();
			
			Thread.sleep(3000);
		}
		//ɸѡ��Ϊ��־
		@Test(priority=33)
		public void test62() throws InterruptedException {
			webtest.pause(5000);
			webtest.mouseToElement("xpath=//i[@class='icon-laptop']");
			webtest.click("link=��Ϊ��־");
			webtest.click("xpath=//button[text()='ɸѡ']");
			webtest.selectByVisibleText("xpath=//select[@name='select']", "�û���¼");
			webtest.click("xpath=//button[@value='ȷ��']");
			Thread.sleep(1000);
		}
		//������Ϊ��־
		@Test(priority=34)
		public void test65() throws InterruptedException {
			webtest.pause(3000);
			webtest.mouseToElement("xpath=//i[@class='icon-laptop']");
			webtest.click("link=��Ϊ��־");
			webtest.type("class=search-input form-control", "admin1");
			webtest.click("class='btn btn-default'");
			Thread.sleep(1000);
		}
}
