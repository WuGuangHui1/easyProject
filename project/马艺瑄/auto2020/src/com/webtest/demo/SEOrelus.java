package com.webtest.demo;

import org.testng.annotations.Test;

public class SEOrelus extends LoginDemo{
	//����SEO
	@Test(priority=47)
	public void test89() throws InterruptedException {
		webtest.pause(3000);
		webtest.mouseToElement("xpath=//i[@class='icon-laptop']");
		webtest.click("link=SEO�������");
		webtest.click("link=����");
		webtest.type("xpath=//form[@class='form-horizontal']/div[2]/input","aaaa");
		
		
		webtest.click("xpath=//button[text()='ȷ��']");
		webtest.alertAccept();
		Thread.sleep(1000);
	}
	//ɾ��seo
	@Test(priority=48)
	public void test90() throws InterruptedException {
		webtest.pause(3000);
		webtest.mouseToElement("xpath=//i[@class='icon-laptop']");
		webtest.click("link=SEO�������");
		
		webtest.click("xpath=//tbody/tr[1]/td[1]/input");
		Thread.sleep(1000);
		webtest.click("xpath=//button[text()='ɾ��']");
		webtest.alertAccept();
		Thread.sleep(1000);
	}
	//����seo
	@Test(priority=49)
	public void test92() throws InterruptedException {
		webtest.pause(3000);
		webtest.mouseToElement("xpath=//i[@class='icon-laptop']");
		webtest.click("link=SEO�������");
		webtest.click("xpath=//tbody/tr[1]/td[1]/input");
		webtest.click("xpath=//button[text()='����']");
		webtest.alertAccept();
		Thread.sleep(1000);
	}
	//����seo
	@Test(priority=50)
	public void test91() throws InterruptedException {
		webtest.mouseToElement("xpath=//i[@class='icon-laptop']");
		webtest.click("link=SEO�������");
		webtest.click("xpath=//tbody/tr[1]/td[1]/input");
		webtest.click("xpath=//button[text()='����']");
		webtest.alertAccept();
		Thread.sleep(1000);
	}
}
