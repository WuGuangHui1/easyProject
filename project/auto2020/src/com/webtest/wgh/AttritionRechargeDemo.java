package com.webtest.wgh;

import org.testng.annotations.Test;

public class AttritionRechargeDemo extends LoginDemo{
//	����ͳ��֮��ʧ��ͳ��
	@Test(priority=1)
	public void test15() throws InterruptedException {
		webtest.mouseToElement("xpath=//a[@data-hover='dropdown']");
	    webtest.click("link=��ʧ��ͳ��");
	    webtest.pause(2000);
	}
//	����ͳ��֮��ֵ�û�ͳ��
	@Test(priority=2)
	public void test22() throws InterruptedException {
		webtest.mouseToElement("xpath=//a[@data-hover='dropdown']");
	    webtest.click("link=��ֵ�û�ͳ��");
	}
}
