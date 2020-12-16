package com.webtest.why;

import org.testng.annotations.Test;

import com.webtest.demo.Admin_Login;

public class user_navigation extends Admin_Login{
	//52、用户导航能否选择不同模块
	@Test(priority=52)
	public void why52test() throws InterruptedException {
		webtest.pause(2000);
		webtest.mouseToElement("xpath=//i[@class='icon-windows']");
		webtest.click("link=用户导航");
		webtest.click("name=nav[1][modu1][]");
		webtest.click("value=Home/index/index");
		webtest.click("id=submit");
		//webtest.alertAccept();
		webtest.pause(2000);
	}
	//53、用户导航能否设置在新窗口打开
	@Test(priority=53)
	public void why53test() throws InterruptedException {
//		webtest.pause(2000);
//		webtest.mouseToElement("xpath=//i[@class='icon-windows']");
//		webtest.click("link=用户导航");
		webtest.click("class=target");
		webtest.click("id=submit]");
		//webtest.alertAccept();
		webtest.pause(2000);
		
	}
	

}
