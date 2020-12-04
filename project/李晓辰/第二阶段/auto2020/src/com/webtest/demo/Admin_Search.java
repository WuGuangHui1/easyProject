package com.webtest.demo;

import java.io.IOException;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.NSDataProvider;

public class Admin_Search extends BaseTest{
	@Test(dataProvider="excel",dataProviderClass=NSDataProvider.class,priority = 1)
	public void testLogin(String a,String b) throws InterruptedException {
		webtest.open("http://localhost:8888/index.php");
		webtest.click("xpath=//a[@data-login='do_login']");
		Thread.sleep(3000);
		webtest.type("id=inputEmail",a);
		Thread.sleep(3000);
		System.out.println("aa");
		webtest.type("id=inputPassword",b);
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(3000);
	}
	//搜索
	@Test(priority = 2)
	public void testSearch() throws InterruptedException {
		webtest.click("id=show_box");
		System.out.println("0000");
		Thread.sleep(3000);
		webtest.type("name=keywords", "测试");
		Thread.sleep(3000);
		webtest.click("xpath=//i[@class='icon icon-search pull-right']");
		Thread.sleep(3000);
	}
	@Test(priority = 3)
	public void testSearchback() throws InterruptedException {
		webtest.click("id=show_box");
		System.out.println("0000");
		Thread.sleep(3000);
		webtest.type("name=keywords", "测试");
		Thread.sleep(3000);
		webtest.click("xpath=//i[@class='icon icon-search pull-right']");
		//webtest.enter();
		Thread.sleep(3000);
		webtest.click("xpath=//a[@class='navbar-brand logo']");
		Thread.sleep(3000);
	}
	//系统消息
	@Test(priority = 4)
	public void testNotice() throws InterruptedException {
		webtest.click("xpath=//i[@class='iconfont icon-duihua']");
		Thread.sleep(2000);
		webtest.click("xpath=//a[@class='do-button']");
		Thread.sleep(2000);
		webtest.click("class=close");
		Thread.sleep(2000);
	}
	@Test(priority = 5)
	public void testNoticeEnter() throws InterruptedException {
		webtest.click("xpath=//i[@class='iconfont icon-duihua']");
		Thread.sleep(2000);
		webtest.click("xpath=//ul[@class='load-more-block']//li[1]");
		Thread.sleep(2000);
	}
}
