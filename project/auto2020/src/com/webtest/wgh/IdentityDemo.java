package com.webtest.wgh;

import org.testng.annotations.Test;

public class IdentityDemo extends LoginDemo{
//	身份不允许微博模块前台访问
	@Test(priority = 1)
	public void test1() throws InterruptedException {
		webtest.mouseToElement("xpath=//a[@data-hover='dropdown']");
	    webtest.click("link=允许身份访问");
	    webtest.click("name=role_module[4][]");
	    webtest.click("id=save-role-module-auth");
	}
//	身份不允许所有模块前台访问
	@Test(priority=2)
	public void test2() throws InterruptedException {
	    webtest.click("name=role_module[1][]");
	    webtest.click("name=role_module[3][]");
	    webtest.click("name=role_module[4][]");
	    webtest.click("id=save-role-module-auth");
	    
	}

}
