package com.webtest.myx;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
/**
 * 
 * @author ���լu
 *
 */
public class adPosition extends LoginDemo{
//	ϵͳ����ģ����ӹ��λ     ����������·����
	@Test(priority=1)
	public void test16() throws InterruptedException {
		webtest.pause(3000);
		webtest.mouseToElement("xpath=//i[@class='icon-laptop']");
		webtest.click("link=���λ");
		webtest.click("xpath=//table[@id='table-data']/tbody/tr[1]/td[5]/a");
		webtest.click("link=��ӹ��λ");
		webtest.type("xpath=//input[@name='title']", "21��");
		webtest.type("name=name", "Twenty one year");
		webtest.type("name=path","Weibo/Index/detail");
		webtest.click("id=id_type_1");
		webtest.click("name=status");
		webtest.click("xpath=//option[@value='1']");
		webtest.type("name=width", "10px");
		webtest.type("name=height", "10px");
	    webtest.type("name=margin", "5px 2px 0 3px");
	    JavascriptExecutor js=(JavascriptExecutor)driver;
    	js.executeScript("scrollTo(0,10000)");
	    webtest.type("name=padding", "5px 2px 0 3px");
		webtest.click("id=id_theme_all");
		webtest.click("xpath=//button[text()='ȷ��']");
		webtest.alertAccept();
		Thread.sleep(1000);
		webtest.goBack();
		webtest.goBack();
	}
//	 ΢��ģ����ӹ��λ
	@Test(priority=2)
	public void test32() throws InterruptedException {
		webtest.pause(3000);
		webtest.mouseToElement("xpath=//i[@class='icon-laptop']");
		webtest.click("link=���λ");
		webtest.click("xpath=//table[@id='table-data']/tbody/tr[5]/td[5]/a");
		webtest.click("link=��ӹ��λ");
		webtest.type("xpath=//input[@name='title']", "������");
		webtest.type("name=name", "Karry");
		webtest.type("name=path","Weibo/Index/detail");
		webtest.click("id=id_type_1");
		webtest.click("name=status");
		webtest.click("xpath=//option[@value='1']");
		webtest.type("name=width", "10px");
		webtest.type("name=height", "10px");
	    webtest.type("name=margin", "5px 2px 0 3px");
	    JavascriptExecutor js=(JavascriptExecutor)driver;
    	js.executeScript("scrollTo(0,10000)");
	    webtest.type("name=padding", "5px 2px 0 3px");
		webtest.click("id=id_theme_all");
		webtest.click("xpath=//button[text()='ȷ��']");
		webtest.alertAccept();
		Thread.sleep(1000);
		webtest.goBack();
		
	}
//	΢��ģ��ɾ�����λ  ��valueֵ��id��
	@Test(priority=3)
	public void test33() throws InterruptedException {
		webtest.pause(3000);
		webtest.mouseToElement("xpath=//i[@class='icon-laptop']");
		webtest.click("link=���λ");
		webtest.click("xpath=//table[@id='table-data']/tbody/tr[5]/td[5]/a");
		webtest.click("xpath=//input[@value='10003']");
		webtest.click("xpath=//button[text()='ɾ��']");
		webtest.alertAccept();
		Thread.sleep(1000);
	}
//	΢��ģ����ù��λ
	@Test(priority=4)
	public void test34() throws InterruptedException {
		webtest.pause(3000);
		webtest.mouseToElement("xpath=//i[@class='icon-laptop']");
		webtest.click("link=���λ");
		webtest.click("xpath=//table[@id='table-data']/tbody/tr[5]/td[5]/a");
		webtest.click("xpath=//input[@value='10002']");
		webtest.click("xpath=//button[text()='����']");
		webtest.alertAccept();
		Thread.sleep(1000);
	}
//	΢��ģ�����ù��λ
	@Test(priority=5)
	public void test35() throws InterruptedException {
		webtest.pause(3000);
		webtest.mouseToElement("xpath=//i[@class='icon-laptop']");
		webtest.click("link=���λ");
		webtest.click("xpath=//table[@id='table-data']/tbody/tr[5]/td[5]/a");
		webtest.click("xpath=//input[@value='10001']");
		webtest.click("xpath=//button[text()='����']");
		webtest.alertAccept();
		Thread.sleep(1000);
	}
}
