package com.webtest.why;

import org.testng.annotations.Test;

import com.webtest.demo.Admin_Login;

public class news_model extends Admin_Login{
	//18���ܷ���ȷ���ģ��
		@Test(priority=18)
		public void why18test() throws InterruptedException {
			webtest.pause(2000);
			webtest.mouseToElement("xpath=//i[@class='icon-windows']");
			webtest.click("link=��Ϣģ��");
			webtest.click("xpath=//a[text()='���ģ��']");
			webtest.type("name=title", "test");
			webtest.type("name=name","test");
			webtest.click("id=id_zhannei_1");
			webtest.click("id=id_sms_1");
			webtest.click("id_email_1");
			webtest.click("xpath=//select[@name='status']");
			webtest.click("xpath=//button[@type='submit']");
			webtest.pause(2000);
			
		}
		
		
		
		
}
