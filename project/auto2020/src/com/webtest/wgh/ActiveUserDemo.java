package com.webtest.wgh;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
/**
 * 
 * @author ����
 *
 */
public class ActiveUserDemo extends LoginDemo{
//	�鿴��Ծ�û�
	@Test(priority=1)
	public void test16() throws InterruptedException {
		webtest.mouseToElement("xpath=//a[@data-hover='dropdown']");
	    webtest.click("link=��Ծ�û�ͳ��");
	    
	}
//  ��Ծ�û�֮ʱ��ѡ��
	@Test(priority=2)
	public void test17() {
		webtest.click("id=reservation");
		webtest.click("xpath=//div[@class='calendar second left']/div/table/tbody/tr[3]/td[6]");
		webtest.click("xpath=//div[@class='calendar first right']/div/table/tbody/tr[2]/td[3]"); 
		webtest.click("xpath=//button[contains(text(),'ȷ��')]");
	}
//	��Ծ�û�ͳ��֮��ͬʱ��
	@Test(priority=3)
	public void test18() {
		webtest.click("xpath=//input[@value='week']");
	
	}

}
