package com.webtest.wgh;

import org.testng.annotations.Test;

public class WeibomanagementDemo extends LoginDemo{
	@Test(priority=1)
	public void test44() {
		webtest.click("xpath=//a[@title='΢��']");
	    webtest.click("xpath=//a[@title='΢������']");
	    webtest.click("xpath=//button[text()='����']");
	    webtest.type("xpath=//input[@class='search-input form-control form-input-width']","С");
	    webtest.click("xpath=//input[@value='ȷ��']");
	}
//   ɾ����̬
	@Test(priority=2)
	public void test45() {
	    webtest.click("xpath=//a[@title='΢������']");
	    webtest.click("xpath=//*[@id=\"table-data\"]/tbody/tr/td[1]/input");
	    webtest.click("xpath=//button[text()='ɾ��']");
        webtest.alertAccept();
	}
//	�ö���̬  
	@Test(priority=3)  
	public void test46() {
	    webtest.click("xpath=//a[@title='΢������']");
	    webtest.click("xpath=//*[@id=\"table-data\"]/tbody/tr/td[15]/a[2]");
	    webtest.click("id=id_type_2");
	    webtest.typeAndClear("xpath=//input[@name='day']", "5");
	    webtest.click("xpath=//button[text()='ȷ��']");
        webtest.alertAccept();
	}
}
