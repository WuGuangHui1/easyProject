package com.webtest.wgh;

import org.testng.annotations.Test;

public class UserDemo extends LoginDemo{
//	删除用户
	@Test(priority=1)
	public void test31() {
		webtest.click("xpath=//a[@title='用户中心']");
        webtest.click("xpath=//*[@id=\"main\"]/div/div[4]/table/tbody/tr[1]/td[1]/input");
        webtest.click("xpath=//button[contains(text(),'删除')]");
        webtest.alertAccept();
        webtest.alertAccept();
	}
//	修改邮箱后缀
	@Test(priority=2)
	public void test32() {
		webtest.click("xpath=//a[@title='用户中心']");
		webtest.click("xpath=//*[@id=\"main\"]/div/div[4]/table/tbody/tr[1]/td[1]/input");
		webtest.click("xpath=//button[contains(text(),'修改第三方登录邮箱后缀')]");
		webtest.alertAccept();
	}
//	搜索用户
	@Test(priority=3)
	public void test33() {
		webtest.click("id=seek");
		webtest.click("xpath=//option[@value='2']");
		webtest.typeAndClear("xpath=//input[@name='nickname']","admin");
		webtest.click("id=search");
	}
	

}
