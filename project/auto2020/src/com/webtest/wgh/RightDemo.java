package com.webtest.wgh;

import java.io.IOException;

import org.testng.annotations.Test;

public class RightDemo extends LoginDemo{
//	��ջ���
	@Test(priority=2)
	public void test24() {
		webtest.click("xpath=//a[@onclick='clear_cache()']");
	}
//	�˳���¼
    @Test(priority=3)
    public void test25() {
    	webtest.click("xpath=//a[@class='dropdown-toggle' and @data-toggle='dropdown']");
    	webtest.click("link=�˳�");
    }
    
}
