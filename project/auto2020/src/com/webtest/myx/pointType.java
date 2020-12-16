package com.webtest.myx;

import org.testng.annotations.Test;

import com.webtest.demo.Admin_Login;

public class pointType extends Admin_Login{
	//新增积分类型
	@Test(priority=21)
	public void test44() throws InterruptedException {
		webtest.pause(3000);
		webtest.mouseToElement("xpath=//i[@class='icon-laptop']");
		webtest.click("link=积分类型");
		webtest.click("link=新增");
		webtest.type("xpath=//div[@class='tab-wrap tabbable-custom']/div/form/div[2]/input","钱");
		webtest.type("xpath=//div[@class='tab-wrap tabbable-custom']/div/form/div[3]/input","元");
		webtest.click("xpath=//button[text()='确定']");
		webtest.alertAccept();
		Thread.sleep(1000);
		webtest.goBack();
	}
	//启用积分类型
//	@Test(priority=22)
	public void test45() throws InterruptedException {
		webtest.pause(3000);
		webtest.mouseToElement("xpath=//i[@class='icon-laptop']");
		webtest.click("link=积分类型");
		webtest.click("xpath=//input[@value='1']");
		webtest.click("xpath=//button[text()='启用']");
		webtest.alertAccept();
		Thread.sleep(1000);
	}
	//禁用积分类型
	@Test(priority=23)
	public void test46() throws InterruptedException {
		webtest.pause(3000);
		webtest.mouseToElement("xpath=//i[@class='icon-laptop']");
		webtest.click("link=积分类型");
		webtest.click("xpath=//input[@value='1']");
		webtest.click("xpath=//button[text()='禁用']");
		webtest.alertAccept();
		Thread.sleep(1000);
	}
//	删除积分类型
	@Test(priority=24)
	public void test47() throws InterruptedException {
		webtest.pause(3000);
		webtest.mouseToElement("xpath=//i[@class='icon-laptop']");
		webtest.click("link=积分类型");
		webtest.click("xpath=//tbody/tr[5]/td[1]/input");
		webtest.click("xpath=//button[text()='删除']");
		webtest.alertAccept();
		Thread.sleep(1000);
	}
}
