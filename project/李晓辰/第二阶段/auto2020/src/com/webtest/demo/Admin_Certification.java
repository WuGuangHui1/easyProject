package com.webtest.demo;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.NSDataProvider;

public class Admin_Certification extends BaseTest{
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
	public void testApplication() throws InterruptedException {
		webtest.click("xpath=//img[@class='avatar-img nav-img']");
		Thread.sleep(2000);
		webtest.click("xpath=//i[@class='os-icon-settings']");
		Thread.sleep(2000);
		webtest.click("id=process");
		Thread.sleep(2000);
		webtest.click("xpath=//div[@class='v-type row']/div[2]/div[2]/a");
		Thread.sleep(2000);
		webtest.click("xpath=//a[@class='do-attest']");
		Thread.sleep(2000);
		webtest.click("id=child_type");
		Thread.sleep(2000);
		webtest.click("xpath=//option[@value='优秀站长']");
		Thread.sleep(2000);
		webtest.type("xpath=//input[@name='name']", "李晓辰");
		Thread.sleep(2000);
		webtest.type("xpath=//input[@name='id_num']", "130104200002191821");
		Thread.sleep(2000);
		webtest.type("xpath=//input[@name='phone']", "18732627309");
		Thread.sleep(2000);
		webtest.click("id=image_type");
		Thread.sleep(2000);
		webtest.click("xpath=//option[@value='身份证']");
		Thread.sleep(2000);
		webtest.type("xpath=//input[@name='file']", "D:\\demo\\1.jpg");
		Thread.sleep(2000);
		webtest.type("xpath=//input[@name='file']", "D:\\demo\\2.png");
		Thread.sleep(2000);
		webtest.click("xpath=//a[@data-role='submit']");
		Thread.sleep(2000);
	}
	@Test(priority = 3)
	public void testChange() throws InterruptedException {
		webtest.click("xpath=//img[@class='avatar-img nav-img']");
		Thread.sleep(2000);
		webtest.click("xpath=//i[@class='os-icon-settings']");
		Thread.sleep(2000);
		webtest.click("id=process");
		Thread.sleep(2000);
		webtest.click("xpath=//a[text()='修改认证资料']");
		Thread.sleep(2000);
		webtest.typeAndClear("xpath=//input[@name='name']", "李辰");
		Thread.sleep(2000);
		webtest.click("xpath=//a[@data-role='submit']");
		Thread.sleep(2000);
	}
	@Test(priority = 3)
	public void testDelete() throws InterruptedException {
		webtest.click("xpath=//img[@class='avatar-img nav-img']");
		Thread.sleep(2000);
		webtest.click("xpath=//i[@class='os-icon-settings']");
		Thread.sleep(2000);
		webtest.click("id=process");
		Thread.sleep(2000);
		webtest.click("xpath=//a[text()='取消认证']");
		Thread.sleep(2000);
	}
	//申请组织认证
	@Test(priority = 4)
	public void testApplicantO() throws InterruptedException {
		webtest.click("xpath=//img[@class='avatar-img nav-img']");
		Thread.sleep(2000);
		webtest.click("xpath=//i[@class='os-icon-settings']");
		Thread.sleep(2000);
		webtest.click("id=process");
		Thread.sleep(2000);
		webtest.click("xpath=//div[@class='v-type row']/div[3]/div[2]/a");
		Thread.sleep(2000);
		webtest.click("xpath=//a[@class='do-attest']");
		Thread.sleep(2000);
	}
	@Test(priority = 4)
	public void testBindPhNumO() throws InterruptedException {
		webtest.click("xpath=//img[@class='avatar-img nav-img']");
		Thread.sleep(2000);
		webtest.click("xpath=//i[@class='os-icon-settings']");
		Thread.sleep(2000);
		webtest.click("id=process");
		Thread.sleep(2000);
		webtest.click("xpath=//div[@class='v-type row']/div[3]/div[2]/a");
		Thread.sleep(2000);
		webtest.click("xpath=//a[@class='do-attest']");
		Thread.sleep(2000);
		webtest.click("xpath=//div[@class='id-liberty id-term row']/div[2]/a");
		Thread.sleep(2000);
	}
	@Test(priority = 5)
	public void testConcernO() throws InterruptedException {
		webtest.click("xpath=//img[@class='avatar-img nav-img']");
		Thread.sleep(2000);
		webtest.click("xpath=//i[@class='os-icon-settings']");
		Thread.sleep(2000);
		webtest.click("id=process");
		Thread.sleep(2000);
		webtest.click("xpath=//div[@class='v-type row']/div[3]/div[2]/a");
		Thread.sleep(2000);
		webtest.click("xpath=//a[@class='do-attest']");
		Thread.sleep(2000);
		webtest.click("xpath=//div[@class='id-liberty id-term row']/div[3]/a");
		Thread.sleep(2000);
	}
	@Test(priority = 6)
	public void testInviteO() throws InterruptedException {
		webtest.click("xpath=//img[@class='avatar-img nav-img']");
		Thread.sleep(2000);
		webtest.click("xpath=//i[@class='os-icon-settings']");
		Thread.sleep(2000);
		webtest.click("id=process");
		Thread.sleep(2000);
		webtest.click("xpath=//div[@class='v-type row']/div[3]/div[2]/a");
		Thread.sleep(2000);
		webtest.click("xpath=//a[@class='do-attest']");
		Thread.sleep(2000);
		webtest.click("xpath=//div[@class='id-liberty id-term row']/div[4]/a");
		Thread.sleep(2000);
	}
	@Test(priority = 7)
	public void testFansO() throws InterruptedException {
		webtest.click("xpath=//img[@class='avatar-img nav-img']");
		Thread.sleep(2000);
		webtest.click("xpath=//i[@class='os-icon-settings']");
		Thread.sleep(2000);
		webtest.click("id=process");
		Thread.sleep(2000);
		webtest.click("xpath=//div[@class='v-type row']/div[3]/div[2]/a");
		Thread.sleep(2000);
		webtest.click("xpath=//a[@class='do-attest']");
		Thread.sleep(2000);
		webtest.click("xpath=//div[@class='id-liberty id-term row']/div[5]/a");
		Thread.sleep(2000);
	}
	//申请企业认证
	@Test(priority = 8)
	public void testApplicantE() throws InterruptedException {
		webtest.click("xpath=//img[@class='avatar-img nav-img']");
		Thread.sleep(2000);
		webtest.click("xpath=//i[@class='os-icon-settings']");
		Thread.sleep(2000);
		webtest.click("id=process");
		Thread.sleep(2000);
		webtest.click("xpath=//div[@class='v-type row']/div[4]/div[2]/a");
		Thread.sleep(2000);
		webtest.click("xpath=//a[@class='do-attest']");
		Thread.sleep(2000);
	}
}
