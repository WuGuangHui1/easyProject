package com.webtest.why;

import org.testng.annotations.Test;

import com.webtest.demo.Admin_Login;

public class user_navigation extends Admin_Login{
	//52���û������ܷ�ѡ��ͬģ��
	@Test(priority=52)
	public void why52test() throws InterruptedException {
		webtest.pause(2000);
		webtest.mouseToElement("xpath=//i[@class='icon-windows']");
		webtest.click("link=�û�����");
		webtest.click("name=nav[1][modu1][]");
		webtest.click("value=Home/index/index");
		webtest.click("id=submit");
		//webtest.alertAccept();
		webtest.pause(2000);
	}
	//53���û������ܷ��������´��ڴ�
	@Test(priority=53)
	public void why53test() throws InterruptedException {
//		webtest.pause(2000);
//		webtest.mouseToElement("xpath=//i[@class='icon-windows']");
//		webtest.click("link=�û�����");
		webtest.click("class=target");
		webtest.click("id=submit]");
		//webtest.alertAccept();
		webtest.pause(2000);
		
	}
	

}
