package com.webtest.demo;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.NSDataProvider;

public class Admin_ChangeData extends BaseTest{
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
	@Test(priority = 2)
	public void testChangeData1() throws InterruptedException {
		webtest.click("xpath=//img[@class='avatar-img nav-img']");
		Thread.sleep(2000);
		webtest.click("xpath=//i[@class='os-icon-settings']");
		Thread.sleep(2000);
		webtest.typeAndClear("id=nickname", "test");
		Thread.sleep(2000);
		webtest.click("xpath=//input[@value='2']");
		Thread.sleep(2000);
		webtest.click("id=J_province");
		Thread.sleep(2000);
		webtest.click("xpath=//option[@value='130000']");
		Thread.sleep(2000);
		webtest.click("id=J_city");
		Thread.sleep(2000);
		webtest.click("xpath=//option[@value='131000']");
		Thread.sleep(2000);
		webtest.click("id=J_district");
		Thread.sleep(2000);
		webtest.click("xpath=//option[@value='131082']");
		Thread.sleep(2000);
		webtest.typeAndClear("id=signature", "这是我的个性签名");
		Thread.sleep(2000);
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(2000);
	}
	@Test(priority = 3)
	public void testChangeData2() throws InterruptedException {
		webtest.click("xpath=//img[@class='avatar-img nav-img']");
		Thread.sleep(2000);
		webtest.click("xpath=//i[@class='os-icon-settings']");
		Thread.sleep(2000);
		webtest.click("xpath=//a[text()='个人资料']");
		Thread.sleep(2000);
		//一清除就为空，有问题，待解决
		webtest.type("id=expand_1", "151336597");
		//webtest.typeAndClear("id=expand_1", "1151336597");
		Thread.sleep(2000);
		webtest.typeAndClear("id=expand_2", "2000-02-19");
		Thread.sleep(2000);
		webtest.click("id=expand_2");
		Thread.sleep(2000);
		webtest.click("xpath=//input[@class='btn btn-primary expandinfo-sumbit']");
		Thread.sleep(2000);
	}
	@Test(priority = 4)
	public void testChangeData3() throws InterruptedException {
		webtest.click("xpath=//img[@class='avatar-img nav-img']");
		Thread.sleep(2000);
		webtest.click("xpath=//i[@class='os-icon-settings']");
		Thread.sleep(2000);
		webtest.click("xpath=//a[text()='开发者资料']");
		Thread.sleep(2000);
		webtest.click("id=expand_3");
		Thread.sleep(2000);
		webtest.click("xpath=//option[@value='Java']");
		Thread.sleep(2000);
		webtest.click("xpath=//input[@value='是']");
		Thread.sleep(2000);
		webtest.typeAndClear("id=expand_5", "这是我的简介");
		Thread.sleep(2000);
		webtest.click("xpath=//input[@value='PhotoShop']");
		Thread.sleep(2000);
		if(webtest.isChecked("xpath=//input[@value='Flash']")) {
			webtest.click("xpath=//input[@value='Flash']");
			Thread.sleep(2000);
		}
		webtest.click("xpath=//input[@class='btn btn-primary expandinfo-sumbit']");
		Thread.sleep(2000);
	}
}
