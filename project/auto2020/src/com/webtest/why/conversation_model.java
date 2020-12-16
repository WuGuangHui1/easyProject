package com.webtest.why;

import org.testng.annotations.Test;

import com.webtest.demo.Admin_Login;

public class conversation_model extends Admin_Login{
	//9、能否添加到常用操作
		@Test(priority=9)
		public void why9test() throws InterruptedException {
			webtest.pause(2000);
			webtest.mouseToElement("xpath=//i[@class='icon-windows']");
			webtest.click("link=会话模板");
			webtest.click("class=icon-plus");
			
		}
		//10、能否正常刷新
		@Test(priority=10)
		public void why10test() throws InterruptedException {
			webtest.pause(2000);
			webtest.mouseToElement("xpath=//i[@class='icon-windows']");
			webtest.click("link=会话模板");
			webtest.click("xpath=//button[@class='btn btn-default ajax-post btn btn-default']");
			webtest.alertAccept();
			
		}
		//11、能否选中全列
		@Test(priority=11)
		public void why11test() throws InterruptedException {
			webtest.pause(2000);
			webtest.mouseToElement("xpath=//i[@class='icon-windows']");
			webtest.click("link=会话模板");
			webtest.click("class=check-all");
			webtest.pause(2000);
		}
		//12、能否取消全选
		@Test(priority=12)
		public void why12test() throws InterruptedException {
			webtest.pause(2000);
			webtest.mouseToElement("xpath=//i[@class='icon-windows']");
			webtest.click("link=会话模板");
			webtest.click("class=check-all");
			webtest.pause(2000);
		}
		//13、能否选中单个一行
		@Test(priority=13)
		public void why13test() throws InterruptedException {
			webtest.pause(2000);
			webtest.mouseToElement("xpath=//i[@class='icon-windows']");
			webtest.click("link=会话模板");
			webtest.click("xpath=//*[@id=\"table-data\"]/tbody/tr[1]/td[1]/input");
			webtest.pause(2000);
		}
		//14、能否取消选中某一行
		@Test(priority=14)
		public void why14test() throws InterruptedException {
			webtest.pause(2000);
			webtest.mouseToElement("xpath=//i[@class='icon-windows']");
			webtest.click("link=会话模板");
			webtest.click("xpath=//*[@id=\"table-data\"]/tbody/tr[1]/td[1]/input");
			webtest.pause(2000);
		}
		//15、能否查看详细信息
		@Test(priority=15)
		public void why15test() throws InterruptedException {
			webtest.pause(2000);
			webtest.mouseToElement("xpath=//i[@class='icon-windows']");
			webtest.click("link=会话模板");
			webtest.doubleClick("xpath=//*[@id=\"table-data\"]/tbody/tr[1]/td[9]");
			webtest.pause(2000);
		}

}
