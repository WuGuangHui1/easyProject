package com.webtest.why;

import org.testng.annotations.Test;

import com.webtest.demo.Admin_Login;

public class conversation_settings extends Admin_Login{
	//16、能否选择模板
		@Test(priority=16)
		public void why16test() throws InterruptedException {
			webtest.pause(2000);
			webtest.mouseToElement("xpath=//i[@class='icon-windows']");
			webtest.click("link=会话设置");
			webtest.click("class=form-control");
			webtest.click("xpath=//option[value='session1'");
			webtest.click("xpath=//button[@type='submit']");
			//webtest.alertAccept();
			webtest.pause(1000);
		}
		//17、点击返回能否返回之前的页面
		@Test(priority=17)
		public void why17test() throws InterruptedException {
//			webtest.pause(2000);
//			webtest.mouseToElement("xpath=//i[@class='icon-windows']");
//			webtest.click("link=会话设置");
			webtest.click("xpath=//button[@class='btn btn-return']");
			webtest.pause(2000);
		}

}
