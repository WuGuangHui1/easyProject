package com.webtest.demo;

import org.testng.annotations.Test;

public class pointRule extends LoginDemo{
	//�������ֹ���
		@Test(priority=1)
		public void test49() throws InterruptedException {
			webtest.pause(3000);
			webtest.mouseToElement("xpath=//i[@class='icon-laptop']");
			webtest.click("link=���ֹ���");
			webtest.click("id=action_add");
			webtest.type("xpath=//div[@class='with-padding']/form/div[1]/div/input","name");
			Thread.sleep(1000);
			webtest.type("xpath=//div[@class='with-padding']/form/div[2]/div/input", "����");
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
		//���û��ֹ���
		@Test(priority=2)
		public void test51() throws InterruptedException {
			webtest.pause(3000);
			webtest.mouseToElement("xpath=//i[@class='icon-laptop']");
			webtest.click("link=���ֹ���");
			Thread.sleep(1000);
			webtest.click("xpath=//tbody/tr[1]/td[1]/input");
			Thread.sleep(1000);
			webtest.click("xpath=//button[text()='�� ��                ']");
			Thread.sleep(1000);
			webtest.alertAccept();
			Thread.sleep(1000);
		}
		//���û��ֹ���
		@Test(priority=3)
		public void test50() throws InterruptedException {
			webtest.pause(3000);
			webtest.mouseToElement("xpath=//i[@class='icon-laptop']");
			webtest.click("link=���ֹ���");
			Thread.sleep(1000);
			webtest.click("xpath=//tbody/tr[1]/td[1]/input");
			Thread.sleep(1000);
			webtest.click("xpath=//button[text()='�� ��                ']");
			Thread.sleep(1000);
			webtest.alertAccept();
			Thread.sleep(1000);
		}
		//ɾ�����ֹ���
		@Test(priority=4)
		public void test52() throws InterruptedException {
			webtest.pause(3000);
			webtest.mouseToElement("xpath=//i[@class='icon-laptop']");
			webtest.click("link=���ֹ���");
			Thread.sleep(1000);
			webtest.click("xpath=//tbody/tr[1]/td[1]/input");
			Thread.sleep(1000);
			webtest.click("xpath=//button[text()='ɾ ��                ']");
			Thread.sleep(1000);
			webtest.alertAccept();
			Thread.sleep(1000);
		}
}
