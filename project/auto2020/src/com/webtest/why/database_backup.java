package com.webtest.why;

import org.testng.annotations.Test;

import com.webtest.demo.Admin_Login;

public class database_backup extends Admin_Login{
	//31�����ݱ���
		@Test(priority=31)
		public void why31test() throws InterruptedException {
			webtest.pause(2000);
			webtest.mouseToElement("xpath=//i[@class='icon-windows']");
			webtest.click("link=�������ݿ�");
			webtest.click("id=export");
			webtest.pause(2000);
		}
		//32���Ż���
		@Test(priority=32)
		public void why32test() throws InterruptedException {
			webtest.pause(2000);
			webtest.mouseToElement("xpath=//i[@class='icon-windows']");
			webtest.click("link=�������ݿ�");
			webtest.click("id=optimize");
			webtest.pause(2000);
		}
		//33���޻���
		@Test(priority=33)
		public void why33test() throws InterruptedException {
			webtest.pause(2000);
			webtest.mouseToElement("xpath=//i[@class='icon-windows']");
			webtest.click("link=�������ݿ�");
			webtest.click("id=repair");
			webtest.pause(2000);
			
		}
		//34���ܷ�ԭ�Ѿ����ݵ����ݿ⣡����
		@Test(priority=34)
		public void why34test() throws InterruptedException {
			webtest.pause(2000);
			webtest.mouseToElement("xpath=//i[@class='icon-windows']");
			webtest.click("link=��ԭ���ݿ�");
			webtest.pause(2000);
			
		}
		//35���ܷ�ɾ���Ѿ����ݵ����ݿ�!!!
		@Test(priority=35)
		public void why35test() throws InterruptedException {
			webtest.pause(2000);
			webtest.mouseToElement("xpath=//i[@class='icon-windows']");
			webtest.click("link=��ԭ���ݿ�");
			webtest.pause(2000);
			
		}

}
