package com.webtest.demo;

import org.testng.annotations.Test;

public class sensitiveword extends LoginDemo{
//	�������дʻ�
	@Test(priority=1)
	public void test9() throws InterruptedException {
		
		webtest.mouseToElement("xpath=//i[@class='icon-laptop']");
		webtest.click("link=���д��б�");
		webtest.click("link=����");
		webtest.type("xpath=//input[@name='title']", "С��");
		webtest.click("xpath=//button[text()='ȷ��']");
		webtest.alertAccept();
		Thread.sleep(1000);
	}
//	�������дʻ�
	@Test(priority=2)
	public void test10() throws InterruptedException {
		webtest.pause(3000);
		webtest.mouseToElement("xpath=//i[@class='icon-laptop']");
		webtest.click("link=���д��б�");
		webtest.click("xpath=//tbody/tr[1]/td[1]/input");
		webtest.click("xpath=//button[text()='����']");
	    webtest.alertAccept();
	    Thread.sleep(1000);
	}
//	�������дʻ�
	@Test(priority=3)
	public void test11() throws InterruptedException {
		webtest.pause(3000);
		webtest.mouseToElement("xpath=//i[@class='icon-laptop']");
		webtest.click("link=���д��б�");
		webtest.click("xpath=//input[@value='1']");
		webtest.click("xpath=//button[text()='����']");
	   webtest.alertAccept();
	   Thread.sleep(1000);
	}
//	ɾ�����дʻ�
	@Test(priority=4)
	public void test12() throws InterruptedException {
		webtest.pause(3000);
		webtest.mouseToElement("xpath=//i[@class='icon-laptop']");
		webtest.click("link=���д��б�");
		webtest.click("xpath=//input[@value='1']");
		webtest.click("xpath=//button[text()='ɾ��']");
		webtest.alertAccept();
		Thread.sleep(1000);
	}
//	����������дʻ�
	@Test(priority=5)
	public void test13() throws InterruptedException {
		webtest.pause(3000);
		webtest.mouseToElement("xpath=//i[@class='icon-laptop']");
		webtest.click("link=�������");
		webtest.type("xpath=//textarea[@name='titles']", "����|������|������");
		webtest.click("xpath=//button[text()='ȷ��']");
		webtest.alertAccept();
		Thread.sleep(1000);
	}
}
