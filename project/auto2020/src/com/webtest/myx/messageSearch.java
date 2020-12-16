package com.webtest.myx;

import org.testng.annotations.Test;

import com.webtest.demo.Admin_Login;

public class messageSearch extends Admin_Login{
	//搜索短信日志
		@Test
		public void test66() throws InterruptedException {
			webtest.pause(3000);
			webtest.mouseToElement("xpath=//i[@class='icon-laptop']");
			webtest.click("link=短信日志");
			webtest.type("class=search-input form-control", "1234567891");
			webtest.click("class='btn btn-default'");
			Thread.sleep(1000);
		}
}
