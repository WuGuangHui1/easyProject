package com.webtest.wgh;

import org.testng.annotations.Test;

public class AttritionRechargeDemo extends LoginDemo{
//	数据统计之流失率统计
	@Test(priority=1)
	public void test15() throws InterruptedException {
		webtest.mouseToElement("xpath=//a[@data-hover='dropdown']");
	    webtest.click("link=流失率统计");
	    webtest.pause(2000);
	}
//	数据统计之充值用户统计
	@Test(priority=2)
	public void test22() throws InterruptedException {
		webtest.mouseToElement("xpath=//a[@data-hover='dropdown']");
	    webtest.click("link=充值用户统计");
	}
}
