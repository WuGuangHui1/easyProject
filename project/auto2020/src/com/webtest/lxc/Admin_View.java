package com.webtest.lxc;

import org.testng.annotations.Listeners;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.NSDataProvider;
import com.webtest.listen.JavaMailTestListener;


public class Admin_View extends BaseTest{
	@Test(dataProvider="excel",dataProviderClass=NSDataProvider.class,priority = 1)
	public void testLogin(String a,String b) throws InterruptedException {
		webtest.open("http://localhost:8989/index.php");
		webtest.click("xpath=//a[@data-login='do_login']");
		Thread.sleep(3000);
		webtest.type("id=inputEmail",a);
		Thread.sleep(3000);
		System.out.println("aa");
		webtest.type("id=inputPassword",b);
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(3000);
	}
	@Test(priority = 2)
	public void testViewData() throws InterruptedException {
		webtest.click("xpath=//img[@class='avatar-img nav-img']");
		Thread.sleep(2000);
		webtest.click("xpath=//div[@class='col-xs-6 l-p0']");
		Thread.sleep(2000);
		webtest.click("xpath=//ul[@class='nav navbar-nav new-nav']/li[3]");
		Thread.sleep(1000);
		for(int i=1;i<=3;i++) {
			webtest.click("xpath=//ul[@class='nav nav-pills ucenter-tab']/li["+i+"]");
			Thread.sleep(2000);
		}
	}
	@Test(priority = 3)
	public void testViewTitle() throws InterruptedException {
		webtest.click("xpath=//ul[@class='nav navbar-nav new-nav']/li[4]");
		Thread.sleep(1000);
		for(int i=1;i<=4;i++) {
			webtest.click("xpath=//ul[@class='nav nav-pills ucenter-tab']/li["+i+"]");
			Thread.sleep(2000);
		}
	}
	@Test(priority = 4)
	public void testViewTopic() throws InterruptedException {
		webtest.click("xpath=//ul[@class='nav navbar-nav new-nav']/li[5]");
		Thread.sleep(2000);
	}
	
	//查看积分
	@Test(priority = 4)
	public void testViewIntegral() throws InterruptedException {
		//回到主页
		webtest.click("class=first-a");
		Thread.sleep(2000);
		webtest.click("xpath=//img[@class='avatar-img nav-img']");
		Thread.sleep(2000);
		webtest.click("xpath=//i[@class='os-icon-settings']");
		Thread.sleep(2000);
		webtest.click("id=score");
		Thread.sleep(1000);
		for(int i=1;i<=3;i++) {
			webtest.click("xpath=//ul[@class='nav nav-secondary']/li["+i+"]");
			Thread.sleep(2000);
		}
	}
	
	//查看排行榜用户
	@Test(priority = 5)
	public void testViewLeaderboard() throws InterruptedException {
		//回到主页
		webtest.click("class=first-a");
		Thread.sleep(2000);
		webtest.click("xpath=//img[@class='avatar-img nav-img']");
		Thread.sleep(2000);
		webtest.click("xpath=//i[@class='os-icon-bar-chart']");
		Thread.sleep(2000);
		webtest.click("xpath=//div[@id='content_fans']/p[2]/span/a");
		Thread.sleep(2000);
	}
	
	//查看消息中心
		@Test(priority = 6)
		public void testViewNotice() throws InterruptedException {
			//回到主页
			webtest.click("class=first-a");
			Thread.sleep(2000);
			webtest.mouseToElementandClick("xpath=//i[@class='iconfont icon-caidan']");
			Thread.sleep(2000);
			webtest.click("xpath=//ul[@class='dropdown-menu  drop-self nav-menu']/li[2]");
			Thread.sleep(2000);
			for(int i=1;i<=5;i++) {
				webtest.click("xpath=//ul[@class='nav nav-pills ucenter-tab']/li["+i+"]");
				Thread.sleep(2000);
			}
		}
		//查看消息中心
		@Test(priority = 7)
		public void testViewFavorites() throws InterruptedException {
			//回到主页
			webtest.click("class=first-a");
			Thread.sleep(2000);
			webtest.mouseToElementandClick("xpath=//i[@class='iconfont icon-caidan']");
			Thread.sleep(2000);
			webtest.click("xpath=//ul[@class='dropdown-menu  drop-self nav-menu']/li[3]");
			Thread.sleep(2000);
			for(int i=1;i<=2;i++) {
				webtest.click("xpath=//ul[@class='nav nav-pills ucenter-tab']/li["+i+"]");
				Thread.sleep(2000);
			}
		}
}
