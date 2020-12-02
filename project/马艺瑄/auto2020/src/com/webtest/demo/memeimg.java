package com.webtest.demo;

import org.testng.annotations.Test;

public class memeimg extends LoginDemo{
	//更改表情包状态
		@Test(priority=1)
		public void test71() throws InterruptedException {
			webtest.pause(3000);
			webtest.mouseToElement("xpath=//i[@class='icon-laptop']");
			webtest.click("link=表情设置");
			webtest.clickandholdto("xpath=//div[text()=' 默认值 ']",-250, 0);
			System.out.println("aa");
			Thread.sleep(1000);
			webtest.click("xpath=//button[text()='保存']");
			webtest.alertAccept();
			Thread.sleep(1000);
		}
		//更改表情包排序
		@Test(priority=2)
		public void test72() throws InterruptedException {
			webtest.pause(3000);
			webtest.mouseToElement("xpath=//i[@class='icon-laptop']");
			webtest.click("link=表情设置");
			webtest.clickandholdto("xpath=//div[text()=' 默认值 ']",0, 50);
			System.out.println("aa");
			Thread.sleep(1000);
			webtest.click("xpath=//button[text()='保存']");
			webtest.alertAccept();
			Thread.sleep(1000);
		}
		//新增邀请码类型
		@Test(priority=3)
		public void test73() throws InterruptedException {
			webtest.pause(3000);
			webtest.mouseToElement("xpath=//i[@class='icon-laptop']");
			webtest.click("link=邀请码类型");
			webtest.click("link=新增");
			webtest.type("xpath=//form[@class='form-horizontal']/div[2]/input","aa");
			webtest.type("xpath=//form[@class='form-horizontal']/div[4]/div/input","60");
			webtest.type("xpath=//form[@class='form-horizontal']/div[5]/input","2");
			webtest.type("xpath=//form[@class='form-horizontal']/div[6]/div/input","60");
			webtest.click("xpath=//form[@class='form-horizontal']/div[7]/span/span[1]/span/ul/li/input");
			Thread.sleep(1000);
			webtest.click("xpath=//li[text()='普通用户']");
			Thread.sleep(1000);
			webtest.click("xpath=//form[@class='form-horizontal']/div[8]/span/span[1]/span/ul/li/input");
			Thread.sleep(1000);
			webtest.click("xpath=//li[text()='普通用户']");
			webtest.click("xpath=//button[text()='确定']");
			webtest.alertAccept();
			Thread.sleep(1000);
			webtest.goBack();
			}
		//删除邀请码类型
		@Test(priority=4)
		public void test74() throws InterruptedException {
			webtest.pause(3000);
			webtest.mouseToElement("xpath=//i[@class='icon-laptop']");
			webtest.click("link=邀请码类型");
			webtest.click("xpath=//tbody/tr[5]/td[1]/input");
			webtest.click("xpath=//button[text()='删除']");
			webtest.alertAccept();
			webtest.alertAccept();
			Thread.sleep(1000);
		}
		
}
