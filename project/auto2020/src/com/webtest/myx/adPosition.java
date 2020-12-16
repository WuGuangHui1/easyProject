package com.webtest.myx;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
/**
 * 
 * @author 马艺瑄
 *
 */
public class adPosition extends LoginDemo{
//	系统公共模块添加广告位     （不会设置路径）
	@Test(priority=1)
	public void test16() throws InterruptedException {
		webtest.pause(3000);
		webtest.mouseToElement("xpath=//i[@class='icon-laptop']");
		webtest.click("link=广告位");
		webtest.click("xpath=//table[@id='table-data']/tbody/tr[1]/td[5]/a");
		webtest.click("link=添加广告位");
		webtest.type("xpath=//input[@name='title']", "21岁");
		webtest.type("name=name", "Twenty one year");
		webtest.type("name=path","Weibo/Index/detail");
		webtest.click("id=id_type_1");
		webtest.click("name=status");
		webtest.click("xpath=//option[@value='1']");
		webtest.type("name=width", "10px");
		webtest.type("name=height", "10px");
	    webtest.type("name=margin", "5px 2px 0 3px");
	    JavascriptExecutor js=(JavascriptExecutor)driver;
    	js.executeScript("scrollTo(0,10000)");
	    webtest.type("name=padding", "5px 2px 0 3px");
		webtest.click("id=id_theme_all");
		webtest.click("xpath=//button[text()='确定']");
		webtest.alertAccept();
		Thread.sleep(1000);
		webtest.goBack();
		webtest.goBack();
	}
//	 微博模块添加广告位
	@Test(priority=2)
	public void test32() throws InterruptedException {
		webtest.pause(3000);
		webtest.mouseToElement("xpath=//i[@class='icon-laptop']");
		webtest.click("link=广告位");
		webtest.click("xpath=//table[@id='table-data']/tbody/tr[5]/td[5]/a");
		webtest.click("link=添加广告位");
		webtest.type("xpath=//input[@name='title']", "王俊凯");
		webtest.type("name=name", "Karry");
		webtest.type("name=path","Weibo/Index/detail");
		webtest.click("id=id_type_1");
		webtest.click("name=status");
		webtest.click("xpath=//option[@value='1']");
		webtest.type("name=width", "10px");
		webtest.type("name=height", "10px");
	    webtest.type("name=margin", "5px 2px 0 3px");
	    JavascriptExecutor js=(JavascriptExecutor)driver;
    	js.executeScript("scrollTo(0,10000)");
	    webtest.type("name=padding", "5px 2px 0 3px");
		webtest.click("id=id_theme_all");
		webtest.click("xpath=//button[text()='确定']");
		webtest.alertAccept();
		Thread.sleep(1000);
		webtest.goBack();
		
	}
//	微博模块删除广告位  （value值是id）
	@Test(priority=3)
	public void test33() throws InterruptedException {
		webtest.pause(3000);
		webtest.mouseToElement("xpath=//i[@class='icon-laptop']");
		webtest.click("link=广告位");
		webtest.click("xpath=//table[@id='table-data']/tbody/tr[5]/td[5]/a");
		webtest.click("xpath=//input[@value='10003']");
		webtest.click("xpath=//button[text()='删除']");
		webtest.alertAccept();
		Thread.sleep(1000);
	}
//	微博模块禁用广告位
	@Test(priority=4)
	public void test34() throws InterruptedException {
		webtest.pause(3000);
		webtest.mouseToElement("xpath=//i[@class='icon-laptop']");
		webtest.click("link=广告位");
		webtest.click("xpath=//table[@id='table-data']/tbody/tr[5]/td[5]/a");
		webtest.click("xpath=//input[@value='10002']");
		webtest.click("xpath=//button[text()='禁用']");
		webtest.alertAccept();
		Thread.sleep(1000);
	}
//	微博模块启用广告位
	@Test(priority=5)
	public void test35() throws InterruptedException {
		webtest.pause(3000);
		webtest.mouseToElement("xpath=//i[@class='icon-laptop']");
		webtest.click("link=广告位");
		webtest.click("xpath=//table[@id='table-data']/tbody/tr[5]/td[5]/a");
		webtest.click("xpath=//input[@value='10001']");
		webtest.click("xpath=//button[text()='启用']");
		webtest.alertAccept();
		Thread.sleep(1000);
	}
}
