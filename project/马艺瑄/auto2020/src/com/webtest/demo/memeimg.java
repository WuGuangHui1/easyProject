package com.webtest.demo;

import org.testng.annotations.Test;

public class memeimg extends LoginDemo{
	//���ı����״̬
		@Test(priority=1)
		public void test71() throws InterruptedException {
			webtest.pause(3000);
			webtest.mouseToElement("xpath=//i[@class='icon-laptop']");
			webtest.click("link=��������");
			webtest.clickandholdto("xpath=//div[text()=' Ĭ��ֵ ']",-250, 0);
			System.out.println("aa");
			Thread.sleep(1000);
			webtest.click("xpath=//button[text()='����']");
			webtest.alertAccept();
			Thread.sleep(1000);
		}
		//���ı��������
		@Test(priority=2)
		public void test72() throws InterruptedException {
			webtest.pause(3000);
			webtest.mouseToElement("xpath=//i[@class='icon-laptop']");
			webtest.click("link=��������");
			webtest.clickandholdto("xpath=//div[text()=' Ĭ��ֵ ']",0, 50);
			System.out.println("aa");
			Thread.sleep(1000);
			webtest.click("xpath=//button[text()='����']");
			webtest.alertAccept();
			Thread.sleep(1000);
		}
		//��������������
		@Test(priority=3)
		public void test73() throws InterruptedException {
			webtest.pause(3000);
			webtest.mouseToElement("xpath=//i[@class='icon-laptop']");
			webtest.click("link=����������");
			webtest.click("link=����");
			webtest.type("xpath=//form[@class='form-horizontal']/div[2]/input","aa");
			webtest.type("xpath=//form[@class='form-horizontal']/div[4]/div/input","60");
			webtest.type("xpath=//form[@class='form-horizontal']/div[5]/input","2");
			webtest.type("xpath=//form[@class='form-horizontal']/div[6]/div/input","60");
			webtest.click("xpath=//form[@class='form-horizontal']/div[7]/span/span[1]/span/ul/li/input");
			Thread.sleep(1000);
			webtest.click("xpath=//li[text()='��ͨ�û�']");
			Thread.sleep(1000);
			webtest.click("xpath=//form[@class='form-horizontal']/div[8]/span/span[1]/span/ul/li/input");
			Thread.sleep(1000);
			webtest.click("xpath=//li[text()='��ͨ�û�']");
			webtest.click("xpath=//button[text()='ȷ��']");
			webtest.alertAccept();
			Thread.sleep(1000);
			webtest.goBack();
			}
		//ɾ������������
		@Test(priority=4)
		public void test74() throws InterruptedException {
			webtest.pause(3000);
			webtest.mouseToElement("xpath=//i[@class='icon-laptop']");
			webtest.click("link=����������");
			webtest.click("xpath=//tbody/tr[5]/td[1]/input");
			webtest.click("xpath=//button[text()='ɾ��']");
			webtest.alertAccept();
			webtest.alertAccept();
			Thread.sleep(1000);
		}
		
}
