package com.webtest.wgh;

import org.testng.annotations.Test;

public class RetentionDemo extends LoginDemo{
//	�鿴���������ͳ��
	@Test(priority=1)
	public void test19() throws InterruptedException {
		webtest.mouseToElement("xpath=//a[@data-hover='dropdown']");
	    webtest.click("link=������ͳ��");
	}
	@Test(priority=2)
	public void test20() {
		webtest.click("xpath=//input[@value='day1']");
	}
//	������ͳ��
	@Test(priority=3)
	public void test21() {
		webtest.click("id=reservation");
		webtest.click("xpath=/html/body/div[4]/div[2]/div/table/tbody/tr[3]/td[6]");
		webtest.click("xpath=/html/body/div[4]/div[1]/div/table/tbody/tr[2]/td[3]");
		webtest.click("xpath=//button[contains(text(),'ȷ��')]");
	}

}
