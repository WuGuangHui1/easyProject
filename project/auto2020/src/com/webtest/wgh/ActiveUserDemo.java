package com.webtest.wgh;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
/**
 * 
 * @author 武光辉
 *
 */
public class ActiveUserDemo extends LoginDemo{
//	查看活跃用户
	@Test(priority=1)
	public void test16() throws InterruptedException {
		webtest.mouseToElement("xpath=//a[@data-hover='dropdown']");
	    webtest.click("link=活跃用户统计");
	    
	}
//  活跃用户之时段选择
	@Test(priority=2)
	public void test17() {
		webtest.click("id=reservation");
		webtest.click("xpath=//div[@class='calendar second left']/div/table/tbody/tr[3]/td[6]");
		webtest.click("xpath=//div[@class='calendar first right']/div/table/tbody/tr[2]/td[3]"); 
		webtest.click("xpath=//button[contains(text(),'确定')]");
	}
//	活跃用户统计之不同时间
	@Test(priority=3)
	public void test18() {
		webtest.click("xpath=//input[@value='week']");
	
	}

}
