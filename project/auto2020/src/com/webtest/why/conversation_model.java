package com.webtest.why;

import org.testng.annotations.Test;

import com.webtest.demo.Admin_Login;

public class conversation_model extends Admin_Login{
	//9���ܷ���ӵ����ò���
		@Test(priority=9)
		public void why9test() throws InterruptedException {
			webtest.pause(2000);
			webtest.mouseToElement("xpath=//i[@class='icon-windows']");
			webtest.click("link=�Ựģ��");
			webtest.click("class=icon-plus");
			
		}
		//10���ܷ�����ˢ��
		@Test(priority=10)
		public void why10test() throws InterruptedException {
			webtest.pause(2000);
			webtest.mouseToElement("xpath=//i[@class='icon-windows']");
			webtest.click("link=�Ựģ��");
			webtest.click("xpath=//button[@class='btn btn-default ajax-post btn btn-default']");
			webtest.alertAccept();
			
		}
		//11���ܷ�ѡ��ȫ��
		@Test(priority=11)
		public void why11test() throws InterruptedException {
			webtest.pause(2000);
			webtest.mouseToElement("xpath=//i[@class='icon-windows']");
			webtest.click("link=�Ựģ��");
			webtest.click("class=check-all");
			webtest.pause(2000);
		}
		//12���ܷ�ȡ��ȫѡ
		@Test(priority=12)
		public void why12test() throws InterruptedException {
			webtest.pause(2000);
			webtest.mouseToElement("xpath=//i[@class='icon-windows']");
			webtest.click("link=�Ựģ��");
			webtest.click("class=check-all");
			webtest.pause(2000);
		}
		//13���ܷ�ѡ�е���һ��
		@Test(priority=13)
		public void why13test() throws InterruptedException {
			webtest.pause(2000);
			webtest.mouseToElement("xpath=//i[@class='icon-windows']");
			webtest.click("link=�Ựģ��");
			webtest.click("xpath=//*[@id=\"table-data\"]/tbody/tr[1]/td[1]/input");
			webtest.pause(2000);
		}
		//14���ܷ�ȡ��ѡ��ĳһ��
		@Test(priority=14)
		public void why14test() throws InterruptedException {
			webtest.pause(2000);
			webtest.mouseToElement("xpath=//i[@class='icon-windows']");
			webtest.click("link=�Ựģ��");
			webtest.click("xpath=//*[@id=\"table-data\"]/tbody/tr[1]/td[1]/input");
			webtest.pause(2000);
		}
		//15���ܷ�鿴��ϸ��Ϣ
		@Test(priority=15)
		public void why15test() throws InterruptedException {
			webtest.pause(2000);
			webtest.mouseToElement("xpath=//i[@class='icon-windows']");
			webtest.click("link=�Ựģ��");
			webtest.doubleClick("xpath=//*[@id=\"table-data\"]/tbody/tr[1]/td[9]");
			webtest.pause(2000);
		}

}
