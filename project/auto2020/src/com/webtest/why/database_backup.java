package com.webtest.why;

import org.testng.annotations.Test;

import com.webtest.demo.Admin_Login;

public class database_backup extends Admin_Login{
	//31、数据备份
		@Test(priority=31)
		public void why31test() throws InterruptedException {
			webtest.pause(2000);
			webtest.mouseToElement("xpath=//i[@class='icon-windows']");
			webtest.click("link=备份数据库");
			webtest.click("id=export");
			webtest.pause(2000);
		}
		//32、优化表
		@Test(priority=32)
		public void why32test() throws InterruptedException {
			webtest.pause(2000);
			webtest.mouseToElement("xpath=//i[@class='icon-windows']");
			webtest.click("link=备份数据库");
			webtest.click("id=optimize");
			webtest.pause(2000);
		}
		//33、修护表
		@Test(priority=33)
		public void why33test() throws InterruptedException {
			webtest.pause(2000);
			webtest.mouseToElement("xpath=//i[@class='icon-windows']");
			webtest.click("link=备份数据库");
			webtest.click("id=repair");
			webtest.pause(2000);
			
		}
		//34、能否还原已经备份的数据库！！！
		@Test(priority=34)
		public void why34test() throws InterruptedException {
			webtest.pause(2000);
			webtest.mouseToElement("xpath=//i[@class='icon-windows']");
			webtest.click("link=还原数据库");
			webtest.pause(2000);
			
		}
		//35、能否删除已经备份的数据库!!!
		@Test(priority=35)
		public void why35test() throws InterruptedException {
			webtest.pause(2000);
			webtest.mouseToElement("xpath=//i[@class='icon-windows']");
			webtest.click("link=还原数据库");
			webtest.pause(2000);
			
		}

}
