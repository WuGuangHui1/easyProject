package com.webtest.wgh;

import org.testng.annotations.Test;

public class ReplyCommentDemo extends LoginDemo{
//	删除回复
	@Test(priority=1)
	public void test49() {
		webtest.click("xpath=//a[@title='微博']");
	    webtest.click("xpath=//a[@title='回复管理']");
	    webtest.click("xpath=//*[@id=\"table-data\"]/tbody/tr[1]/td[1]/input");  
	    webtest.click("xpath=//button[text()='删除']");
	    webtest.alertAccept();
	}
//禁用回复
	@Test(priority=2)
	public void test50() {
		webtest.pause(3000);
	    webtest.click("xpath=//*[@id=\\\"table-data\\\"]/tbody/tr[1]/td[1]/input");
	    webtest.click("xpath=//button[text()='禁用']");
	    webtest.alertAccept();
	    webtest.pause(2000);
	}
}
