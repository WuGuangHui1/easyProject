package com.webtest.myx;

import org.testng.annotations.Test;

import com.webtest.demo.Admin_Login;

public class pointType extends Admin_Login{
	//������������
	@Test(priority=21)
	public void test44() throws InterruptedException {
		webtest.pause(3000);
		webtest.mouseToElement("xpath=//i[@class='icon-laptop']");
		webtest.click("link=��������");
		webtest.click("link=����");
		webtest.type("xpath=//div[@class='tab-wrap tabbable-custom']/div/form/div[2]/input","Ǯ");
		webtest.type("xpath=//div[@class='tab-wrap tabbable-custom']/div/form/div[3]/input","Ԫ");
		webtest.click("xpath=//button[text()='ȷ��']");
		webtest.alertAccept();
		Thread.sleep(1000);
		webtest.goBack();
	}
	//���û�������
//	@Test(priority=22)
	public void test45() throws InterruptedException {
		webtest.pause(3000);
		webtest.mouseToElement("xpath=//i[@class='icon-laptop']");
		webtest.click("link=��������");
		webtest.click("xpath=//input[@value='1']");
		webtest.click("xpath=//button[text()='����']");
		webtest.alertAccept();
		Thread.sleep(1000);
	}
	//���û�������
	@Test(priority=23)
	public void test46() throws InterruptedException {
		webtest.pause(3000);
		webtest.mouseToElement("xpath=//i[@class='icon-laptop']");
		webtest.click("link=��������");
		webtest.click("xpath=//input[@value='1']");
		webtest.click("xpath=//button[text()='����']");
		webtest.alertAccept();
		Thread.sleep(1000);
	}
//	ɾ����������
	@Test(priority=24)
	public void test47() throws InterruptedException {
		webtest.pause(3000);
		webtest.mouseToElement("xpath=//i[@class='icon-laptop']");
		webtest.click("link=��������");
		webtest.click("xpath=//tbody/tr[5]/td[1]/input");
		webtest.click("xpath=//button[text()='ɾ��']");
		webtest.alertAccept();
		Thread.sleep(1000);
	}
}
