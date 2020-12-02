package com.webtest.demo;

import org.testng.annotations.Test;

public class pointRule extends LoginDemo{
	//新增积分规则
		@Test(priority=1)
		public void test49() throws InterruptedException {
			webtest.pause(3000);
			webtest.mouseToElement("xpath=//i[@class='icon-laptop']");
			webtest.click("link=积分规则");
			webtest.click("id=action_add");
			webtest.type("xpath=//div[@class='with-padding']/form/div[1]/div/input","name");
			Thread.sleep(1000);
			webtest.type("xpath=//div[@class='with-padding']/form/div[2]/div/input", "名称");
			Thread.sleep(1000);
			webtest.type("xpath=//textarea[@name='remark']", "text");
			Thread.sleep(3000);


			webtest.type("xpath=//textarea[@name='log']", "log");
			Thread.sleep(3000);
			webtest.click("xpath=//button[@class='btn submit-btn ajax-post']");
			webtest.alertAccept();
			Thread.sleep(1000);
			webtest.goBack();
		}
		//禁用积分规则
		@Test(priority=2)
		public void test51() throws InterruptedException {
			webtest.pause(3000);
			webtest.mouseToElement("xpath=//i[@class='icon-laptop']");
			webtest.click("link=积分规则");
			Thread.sleep(1000);
			webtest.click("xpath=//tbody/tr[1]/td[1]/input");
			Thread.sleep(1000);
			webtest.click("xpath=//button[text()='禁 用                ']");
			Thread.sleep(1000);
			webtest.alertAccept();
			Thread.sleep(1000);
		}
		//启用积分规则
		@Test(priority=3)
		public void test50() throws InterruptedException {
			webtest.pause(3000);
			webtest.mouseToElement("xpath=//i[@class='icon-laptop']");
			webtest.click("link=积分规则");
			Thread.sleep(1000);
			webtest.click("xpath=//tbody/tr[1]/td[1]/input");
			Thread.sleep(1000);
			webtest.click("xpath=//button[text()='启 用                ']");
			Thread.sleep(1000);
			webtest.alertAccept();
			Thread.sleep(1000);
		}
		//删除积分规则
		@Test(priority=4)
		public void test52() throws InterruptedException {
			webtest.pause(3000);
			webtest.mouseToElement("xpath=//i[@class='icon-laptop']");
			webtest.click("link=积分规则");
			Thread.sleep(1000);
			webtest.click("xpath=//tbody/tr[1]/td[1]/input");
			Thread.sleep(1000);
			webtest.click("xpath=//button[text()='删 除                ']");
			Thread.sleep(1000);
			webtest.alertAccept();
			Thread.sleep(1000);
		}
}
