package com.webtest.myx;

import org.testng.annotations.Test;

public class limit extends LoginDemo{
	//������Ϊ����
		@Test(priority=1)
		public void test67() throws InterruptedException {
			webtest.pause(3000);
			webtest.mouseToElement("xpath=//i[@class='icon-laptop']");
			webtest.click("link=�û���Ϊ");
			webtest.click("link=����");
			webtest.type("xpath=//input[@name='title']", "title");
			webtest.type("xpath=//input[@name='name']", "name");
			Thread.sleep(1000);

			webtest.click("xpath=//form[@class='form-horizontal']/div[7]/span/span[1]/span/ul/li/input");
			Thread.sleep(1000);
			webtest.click("xpath=//li[text()='���沢��ֹ']");
			Thread.sleep(1000);
			webtest.click("xpath=//form[@class='form-horizontal']/div[10]/span/span[1]/span/ul/li/input");
			webtest.click("xpath=//li[text()='�û�ע��']");
			webtest.click("xpath=//button[text()='ȷ��']");
			webtest.alertAccept();
			Thread.sleep(1000);
			webtest.goBack();
		}
		//������Ϊ����
		@Test(priority=2)
		public void test69() throws InterruptedException {
			webtest.pause(3000);
			webtest.mouseToElement("xpath=//i[@class='icon-laptop']");
			webtest.click("link=�û���Ϊ");
			webtest.click("xpath=//tbody/tr[7]/td[1]/input");
			webtest.click("xpath=//button[text()='����']");
			webtest.alertAccept();
			Thread.sleep(1000);
		}
		//������Ϊ����
		@Test(priority=3)
		public void test68() throws InterruptedException {
			webtest.pause(3000);
			webtest.mouseToElement("xpath=//i[@class='icon-laptop']");
			webtest.click("link=�û���Ϊ");
			webtest.click("xpath=//tbody/tr[7]/td[1]/input");
			webtest.click("xpath=//button[text()='����']");
			webtest.alertAccept();
			Thread.sleep(1000);
		}
		//ɾ����Ϊ����
		@Test(priority=4)
		public void test70() throws InterruptedException {
			webtest.pause(3000);
			webtest.mouseToElement("xpath=//i[@class='icon-laptop']");
			webtest.click("link=�û���Ϊ");
			webtest.click("xpath=//tbody/tr[7]/td[1]/input");
			webtest.click("xpath=//button[text()='ɾ��']");
			webtest.alertAccept();
			Thread.sleep(1000);
		}
}
