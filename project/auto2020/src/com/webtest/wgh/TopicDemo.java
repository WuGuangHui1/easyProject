package com.webtest.wgh;

import org.testng.annotations.Test;

public class TopicDemo extends LoginDemo{
//	��������
	@Test(priority=1)  
	public void test41() {
		webtest.click("xpath=//a[@title='΢��']");
	    webtest.click("xpath=//a[@title='�������']");
	    webtest.click("xpath=//button[text()='����']");
        webtest.type("xpath=//input[@class='search-input form-control form-input-width']","�������ÿ�");
        webtest.click("xpath=//input[@value='ȷ��']");
	}
//	�Ƽ�����   
    @Test(priority=2)
    public void test42() {
	    webtest.click("xpath=//a[@title='�������']");
	    webtest.click("xpath=//*[@id=\"table-data\"]/tbody/tr/td[1]/input");
	    webtest.click("xpath=//button[text()='�Ƽ�']");
        webtest.alertAccept();
    }
//    ɾ������  
    @Test(priority=3)
    public void test43() {
	    webtest.click("xpath=//a[@title='�������']");
	    webtest.click("xpath=//*[@id=\"table-data\"]/tbody/tr/td[1]/input");
	    webtest.click("xpath=//button[text()='��ɾ������']");
        webtest.alertAccept();
    }
    
}
