package com.webtest.wgh;

import org.testng.annotations.Test;

public class WebsitestatisticsDemo extends LoginDemo{
//	查看网站用户的信息
	@Test(priority=1)
	public void test12() throws InterruptedException {
		webtest.mouseToElement("xpath=//a[@data-hover='dropdown']");
		webtest.click("link=网站统计");
	}
	@Test(priority=2)
	public void test13() {
		webtest.click("xpath=//button[@data-target='#settingCount']");
		webtest.typeAndClear("name=count_day", "3");
		webtest.click("xpath=//button[@data-role='saveCountSetting']");
	}
	@Test(priority=3) 
	public void test14() {
		webtest.click("xpath=//i[@class='fa fa-minus']");
	}

}
