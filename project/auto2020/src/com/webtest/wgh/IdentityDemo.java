package com.webtest.wgh;

import org.testng.annotations.Test;

public class IdentityDemo extends LoginDemo{
//	��ݲ�����΢��ģ��ǰ̨����
	@Test(priority = 1)
	public void test1() throws InterruptedException {
		webtest.mouseToElement("xpath=//a[@data-hover='dropdown']");
	    webtest.click("link=������ݷ���");
	    webtest.click("name=role_module[4][]");
	    webtest.click("id=save-role-module-auth");
	}
//	��ݲ���������ģ��ǰ̨����
	@Test(priority=2)
	public void test2() throws InterruptedException {
	    webtest.click("name=role_module[1][]");
	    webtest.click("name=role_module[3][]");
	    webtest.click("name=role_module[4][]");
	    webtest.click("id=save-role-module-auth");
	    
	}

}
