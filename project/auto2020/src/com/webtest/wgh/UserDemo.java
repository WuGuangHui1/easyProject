package com.webtest.wgh;

import org.testng.annotations.Test;

public class UserDemo extends LoginDemo{
//	ɾ���û�
	@Test(priority=1)
	public void test31() {
		webtest.click("xpath=//a[@title='�û�����']");
        webtest.click("xpath=//*[@id=\"main\"]/div/div[4]/table/tbody/tr[1]/td[1]/input");
        webtest.click("xpath=//button[contains(text(),'ɾ��')]");
        webtest.alertAccept();
        webtest.alertAccept();
	}
//	�޸������׺
	@Test(priority=2)
	public void test32() {
		webtest.click("xpath=//a[@title='�û�����']");
		webtest.click("xpath=//*[@id=\"main\"]/div/div[4]/table/tbody/tr[1]/td[1]/input");
		webtest.click("xpath=//button[contains(text(),'�޸ĵ�������¼�����׺')]");
		webtest.alertAccept();
	}
//	�����û�
	@Test(priority=3)
	public void test33() {
		webtest.click("id=seek");
		webtest.click("xpath=//option[@value='2']");
		webtest.typeAndClear("xpath=//input[@name='nickname']","admin");
		webtest.click("id=search");
	}
	

}
