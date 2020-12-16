package com.webtest.myx;

import org.testng.annotations.Test;

public class limit extends LoginDemo{
	//新增行为限制
		@Test(priority=1)
		public void test67() throws InterruptedException {
			webtest.pause(3000);
			webtest.mouseToElement("xpath=//i[@class='icon-laptop']");
			webtest.click("link=用户行为");
			webtest.click("link=新增");
			webtest.type("xpath=//input[@name='title']", "title");
			webtest.type("xpath=//input[@name='name']", "name");
			Thread.sleep(1000);

			webtest.click("xpath=//form[@class='form-horizontal']/div[7]/span/span[1]/span/ul/li/input");
			Thread.sleep(1000);
			webtest.click("xpath=//li[text()='警告并禁止']");
			Thread.sleep(1000);
			webtest.click("xpath=//form[@class='form-horizontal']/div[10]/span/span[1]/span/ul/li/input");
			webtest.click("xpath=//li[text()='用户注册']");
			webtest.click("xpath=//button[text()='确定']");
			webtest.alertAccept();
			Thread.sleep(1000);
			webtest.goBack();
		}
		//禁用行为限制
		@Test(priority=2)
		public void test69() throws InterruptedException {
			webtest.pause(3000);
			webtest.mouseToElement("xpath=//i[@class='icon-laptop']");
			webtest.click("link=用户行为");
			webtest.click("xpath=//tbody/tr[7]/td[1]/input");
			webtest.click("xpath=//button[text()='禁用']");
			webtest.alertAccept();
			Thread.sleep(1000);
		}
		//启用行为限制
		@Test(priority=3)
		public void test68() throws InterruptedException {
			webtest.pause(3000);
			webtest.mouseToElement("xpath=//i[@class='icon-laptop']");
			webtest.click("link=用户行为");
			webtest.click("xpath=//tbody/tr[7]/td[1]/input");
			webtest.click("xpath=//button[text()='启用']");
			webtest.alertAccept();
			Thread.sleep(1000);
		}
		//删除行为限制
		@Test(priority=4)
		public void test70() throws InterruptedException {
			webtest.pause(3000);
			webtest.mouseToElement("xpath=//i[@class='icon-laptop']");
			webtest.click("link=用户行为");
			webtest.click("xpath=//tbody/tr[7]/td[1]/input");
			webtest.click("xpath=//button[text()='删除']");
			webtest.alertAccept();
			Thread.sleep(1000);
		}
}
