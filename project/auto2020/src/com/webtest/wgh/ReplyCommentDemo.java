package com.webtest.wgh;

import org.testng.annotations.Test;

public class ReplyCommentDemo extends LoginDemo{
//	ɾ���ظ�
	@Test(priority=1)
	public void test49() {
		webtest.click("xpath=//a[@title='΢��']");
	    webtest.click("xpath=//a[@title='�ظ�����']");
	    webtest.click("xpath=//*[@id=\"table-data\"]/tbody/tr[1]/td[1]/input");  
	    webtest.click("xpath=//button[text()='ɾ��']");
	    webtest.alertAccept();
	}
//���ûظ�
	@Test(priority=2)
	public void test50() {
		webtest.pause(3000);
	    webtest.click("xpath=//*[@id=\\\"table-data\\\"]/tbody/tr[1]/td[1]/input");
	    webtest.click("xpath=//button[text()='����']");
	    webtest.alertAccept();
	    webtest.pause(2000);
	}
}
