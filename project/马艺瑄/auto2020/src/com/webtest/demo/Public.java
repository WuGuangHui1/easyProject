package com.webtest.demo;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.freemarker.GenerateReporter;


@Listeners(GenerateReporter.class)
public class Public extends LoginDemo{
//	��������
	@Test(priority=1)
	public void test1() throws InterruptedException {
		webtest.mouseToElement("xpath=//i[@class='icon-laptop']");
		webtest.click("link=�����б�");
        webtest.click("link=����");
        webtest.type("xpath=//input[@name='title']","Baidu");
        webtest.type("xpath=//input[@name='link']", "https://www.baidu.com/");
        driver.switchTo().frame("ueditor_0");
		webtest.click("xpath=//body[@class='view']");
		webtest.type("xpath=//body[@class='view']", "�������ÿ�");
        driver.switchTo().defaultContent();
        JavascriptExecutor js=(JavascriptExecutor)driver;
    	js.executeScript("scrollTo(0,10000)");
    	webtest.click("xpath=//button[text()='ȷ��']");
    	webtest.alertAccept();
    	Thread.sleep(1000);
	}
//	��������  value��ֵӦ�þ����Ǹ�id
	@Test(priority=2)
	public void test2() throws InterruptedException {
		webtest.pause(3000);
		webtest.mouseToElement("xpath=//i[@class='icon-laptop']");
		webtest.click("link=�����б�");
		webtest.click("xpath=//tbody/tr[1]/td[1]/input");
		webtest.click("xpath=//button[text()='����']");
		webtest.alertAccept();
		Thread.sleep(1000);
	}
//	���ù���
	@Test(priority=3)
	public void test3() throws InterruptedException {
		webtest.pause(3000);
		webtest.mouseToElement("xpath=//i[@class='icon-laptop']");
		webtest.click("link=�����б�");
		webtest.click("xpath=//tbody/tr[1]/td[1]/input");
		webtest.click("xpath=//button[text()='����']");
		webtest.alertAccept();
		Thread.sleep(1000);
	}
//  ɾ������
	@Test(priority=4)
	public void test4() throws InterruptedException {
		webtest.pause(3000);
		webtest.mouseToElement("xpath=//i[@class='icon-laptop']");
		webtest.click("link=�����б�");
		webtest.click("xpath=//tbody/tr[1]/td[1]/input");
		webtest.click("xpath=//button[text()='ɾ��']");
		webtest.alertAccept();
		Thread.sleep(1000);
	}




//	@Test(priority=21)(δ�ɹ���
//	public void test36() throws InterruptedException {
//		webtest.mouseToElement("xpath=//i[@class='icon-laptop']");
//		webtest.click("link=ͼƬˮӡ����");
//		Thread.sleep(1000);
//		webtest.enter();
//		Thread.sleep(1000);
//		webtest.click("xpath=//input[text()='����']");
//		webtest.click("xpath=//input[@value='10001']");
//		webtest.click("xpath=//button[text()='ȷ��']");
//		webtest.alertAccept();
//	}

	
	
	
	
	
	
	

}
