package com.webtest.demo;

import org.testng.annotations.Test;

public class sensitiveSetting extends LoginDemo{
//	开启敏感词过滤设置
	@Test(priority=1)
	public void test14() throws InterruptedException {
		
		webtest.mouseToElement("xpath=//i[@class='icon-laptop']");
		webtest.click("link=敏感词设置");
		webtest.click("id=id_OPEN_SENSITIVE_1");
		webtest.click("xpath=//button[text()='确定']");
		webtest.alertAccept();
		Thread.sleep(1000);
	}
//	关闭敏感词过滤设置
	@Test(priority=2)
	public void test15() throws InterruptedException {
		webtest.pause(3000);
		webtest.mouseToElement("xpath=//i[@class='icon-laptop']");
		webtest.click("link=敏感词设置");
		webtest.click("id=id_OPEN_SENSITIVE_0");
		webtest.click("xpath=//button[text()='确定']");
		webtest.alertAccept();
		Thread.sleep(1000);
	}
}
