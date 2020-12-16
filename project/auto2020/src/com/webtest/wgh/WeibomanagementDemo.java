package com.webtest.wgh;

import org.testng.annotations.Test;

public class WeibomanagementDemo extends LoginDemo{
	@Test(priority=1)
	public void test44() {
		webtest.click("xpath=//a[@title='微博']");
	    webtest.click("xpath=//a[@title='微博管理']");
	    webtest.click("xpath=//button[text()='搜索']");
	    webtest.type("xpath=//input[@class='search-input form-control form-input-width']","小");
	    webtest.click("xpath=//input[@value='确定']");
	}
//   删除动态
	@Test(priority=2)
	public void test45() {
	    webtest.click("xpath=//a[@title='微博管理']");
	    webtest.click("xpath=//*[@id=\"table-data\"]/tbody/tr/td[1]/input");
	    webtest.click("xpath=//button[text()='删除']");
        webtest.alertAccept();
	}
//	置顶动态  
	@Test(priority=3)  
	public void test46() {
	    webtest.click("xpath=//a[@title='微博管理']");
	    webtest.click("xpath=//*[@id=\"table-data\"]/tbody/tr/td[15]/a[2]");
	    webtest.click("id=id_type_2");
	    webtest.typeAndClear("xpath=//input[@name='day']", "5");
	    webtest.click("xpath=//button[text()='确定']");
        webtest.alertAccept();
	}
}
