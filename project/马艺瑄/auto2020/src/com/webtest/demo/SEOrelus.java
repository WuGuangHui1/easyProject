package com.webtest.demo;

import org.testng.annotations.Test;

public class SEOrelus extends LoginDemo{
	//新增SEO
	@Test(priority=47)
	public void test89() throws InterruptedException {
		webtest.pause(3000);
		webtest.mouseToElement("xpath=//i[@class='icon-laptop']");
		webtest.click("link=SEO规则管理");
		webtest.click("link=新增");
		webtest.type("xpath=//form[@class='form-horizontal']/div[2]/input","aaaa");
		
		
		webtest.click("xpath=//button[text()='确定']");
		webtest.alertAccept();
		Thread.sleep(1000);
	}
	//删除seo
	@Test(priority=48)
	public void test90() throws InterruptedException {
		webtest.pause(3000);
		webtest.mouseToElement("xpath=//i[@class='icon-laptop']");
		webtest.click("link=SEO规则管理");
		
		webtest.click("xpath=//tbody/tr[1]/td[1]/input");
		Thread.sleep(1000);
		webtest.click("xpath=//button[text()='删除']");
		webtest.alertAccept();
		Thread.sleep(1000);
	}
	//启用seo
	@Test(priority=49)
	public void test92() throws InterruptedException {
		webtest.pause(3000);
		webtest.mouseToElement("xpath=//i[@class='icon-laptop']");
		webtest.click("link=SEO规则管理");
		webtest.click("xpath=//tbody/tr[1]/td[1]/input");
		webtest.click("xpath=//button[text()='启用']");
		webtest.alertAccept();
		Thread.sleep(1000);
	}
	//禁用seo
	@Test(priority=50)
	public void test91() throws InterruptedException {
		webtest.mouseToElement("xpath=//i[@class='icon-laptop']");
		webtest.click("link=SEO规则管理");
		webtest.click("xpath=//tbody/tr[1]/td[1]/input");
		webtest.click("xpath=//button[text()='禁用']");
		webtest.alertAccept();
		Thread.sleep(1000);
	}
}
