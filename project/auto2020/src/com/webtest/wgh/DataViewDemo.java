package com.webtest.wgh;

import org.testng.annotations.Test;

public class DataViewDemo extends LoginDemo{

	@Test(priority=1)
	public void test7() throws InterruptedException {
		webtest.mouseToElement("xpath=//i[@class='icon-home']");
		webtest.click("link=数据概览");
	}
	@Test(priority = 2)
	public void test8() throws InterruptedException {
		webtest.click("xpath=//i[@class='icon-plus']");
		webtest.click("xpath=//a[@data-role='add-portlet']");
	}
	@Test(priority=3)
	public void test9() throws InterruptedException {
	    webtest.click("xpath=//a[@data-role='delete-portlet']");
	}
	@Test(priority=4)   
	public void test10() throws InterruptedException {
		webtest.mouseToElement("xpath=//a[@data-hover='dropdown']");
		webtest.click("link=数据概览");
	}
	@Test(priority=5)
	public void test11() throws InterruptedException {
		webtest.mouseToElement("xpath=//i[@class='icon-home']");
		webtest.click("link=数据概览");
		webtest.click("xpath=//div[@class='dashboard-stat purple']/a");
	}

}
