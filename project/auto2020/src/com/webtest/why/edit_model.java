package com.webtest.why;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.webtest.demo.Admin_Login;

public class edit_model extends Admin_Login{
	//20�� �ܷ��ı��Ӵ�!!!!

	@Test(priority=20)
	public void why20test() throws InterruptedException {
		webtest.pause(2000);
		webtest.mouseToElement("xpath=//i[@class='icon-windows']");
		webtest.click("link=��Ϣģ��");
		webtest.click("xpath=//table[@class='table table-bordered table-striped table-hover']/tbody/tr[1]/td[1]/a");
		driver.switchTo().frame("ueditor_0");
		webtest.click("xpath=//body[@class='view']");
		webtest.type("xpath=//body[@class='view']",Keys.LEFT_CONTROL + "a" );
        driver.switchTo().defaultContent();
        webtest.click("id=edui157_body");
        webtest.click("id=submit");
        webtest.alertAccept();
        webtest.pause(2000);
	}
	//21���ܷ���Ϊб��
	@Test(priority=21)
	public void why21test() throws InterruptedException {
		webtest.pause(2000);
		webtest.mouseToElement("xpath=//i[@class='icon-windows']");
		webtest.click("link=��Ϣģ��");
		webtest.click("xpath=//table[@class='table table-bordered table-striped table-hover']/tbody/tr[1]/td[1]/a");
		webtest.pause(2000);
		driver.switchTo().frame("ueditor_0");
		webtest.click("xpath=//body[@class='view']");
		webtest.type("xpath=//body[@class='view']",Keys.LEFT_CONTROL + "a" );
        driver.switchTo().defaultContent();
		webtest.click("xpath=//*[@id=\"edui158_body\"]/div");//���б�尴ť
        webtest.click("id=submit");
        webtest.alertAccept();
        webtest.pause(2000);
	}
	
	//22���ܷ������»���
	@Test(priority=22)
	public void why22test() throws InterruptedException {
		webtest.pause(2000);
		webtest.mouseToElement("xpath=//i[@class='icon-windows']");
		webtest.click("link=��Ϣģ��");
		webtest.click("xpath=//table[@class='table table-bordered table-striped table-hover']/tbody/tr[1]/td[1]/a");
		webtest.pause(2000);
		driver.switchTo().frame("ueditor_0");
		webtest.click("xpath=//body[@class='view']");
		webtest.type("xpath=//body[@class='view']",Keys.LEFT_CONTROL + "a" );
        driver.switchTo().defaultContent();
        webtest.click("xpath=//*[@id=\"edui159_body\"]/div");
        webtest.click("id=submit");
        webtest.alertAccept();
        webtest.pause(2000);
	}
	//23���ܷ������ֺ�
	@Test(priority=23)
	public void why23test() throws InterruptedException {
		webtest.pause(2000);
		webtest.mouseToElement("xpath=//i[@class='icon-windows']");
		webtest.click("link=��Ϣģ��");
		webtest.click("xpath=//table[@class='table table-bordered table-striped table-hover']/tbody/tr[1]/td[1]/a");
		webtest.pause(2000);
		webtest.click("id=edui160_button_body");
		webtest.click("xpath=//div[text()='16px'");
		driver.switchTo().frame("ueditor_0");
		webtest.click("xpath=//body[@class='view']");
		webtest.type("xpath=//body[@class='view']",Keys.LEFT_CONTROL + "a" );
        driver.switchTo().defaultContent();
        webtest.click("id=submit");
        webtest.alertAccept();
        webtest.pause(2000);
	}
	//24���ܷ�������ɫ
	@Test(priority=24)
	public void why24test() throws InterruptedException {
		webtest.pause(2000);
		webtest.mouseToElement("xpath=//i[@class='icon-windows']");
		webtest.click("link=��Ϣģ��");
		webtest.click("xpath=//table[@class='table table-bordered table-striped table-hover']/tbody/tr[1]/td[1]/a");
		webtest.pause(2000);
		webtest.click("xpath=//*[@id=\"edui171_state\"]/div/div[3]");
		webtest.pause(2000);
		webtest.click("xpath=//*[@id=\"edui172\"]/table/tbody/tr[6]/td[10]/a");
		webtest.pause(2000);
		driver.switchTo().frame("ueditor_0");
		webtest.click("xpath=//body[@class='view']");
		webtest.type("xpath=//body[@class='view']",Keys.LEFT_CONTROL + "a" );
		webtest.pause(2000);
        driver.switchTo().defaultContent();
        webtest.type("xpath=xpath=//body[@class='view']",Keys.LEFT_CONTROL + "a" );
		webtest.click("xpath=//*[@id=\"edui171_button_body\"]/div[1]");
		webtest.click("id=submit");
		webtest.alertAccept();
		webtest.pause(2000);
	}
	//25���ܷ�������
	@Test(priority=25)
	public void why25test() throws InterruptedException {
		webtest.pause(2000);
		webtest.mouseToElement("xpath=//i[@class='icon-windows']");
		webtest.click("link=��Ϣģ��");
		webtest.click("xpath=//table[@class='table table-bordered table-striped table-hover']/tbody/tr[1]/td[1]/a");
		webtest.pause(2000);
		driver.switchTo().frame("ueditor_0");
		webtest.click("xpath=//body[@class='view']");
	    webtest.type("xpath=xpath=//body[@class='view']",Keys.LEFT_CONTROL + "a" );
		webtest.click("xpath=//*[@id=\"edui174_body\"]/div[1]");
		driver.switchTo().defaultContent();
		webtest.pause(2000);
	}
	//26����������
	@Test(priority=26)
	public void why26test() throws InterruptedException {
		webtest.pause(2000);
		webtest.mouseToElement("xpath=//i[@class='icon-windows']");
		webtest.click("link=��Ϣģ��");
		webtest.click("xpath=//table[@class='table table-bordered table-striped table-hover']/tbody/tr[1]/td[1]/a");
		webtest.pause(2000);
		driver.switchTo().frame("ueditor_0");
		webtest.click("xpath=//body[@class='view']");
		webtest.type("xpath=//body[@class='view']",Keys.LEFT_CONTROL + "a" );
        driver.switchTo().defaultContent();
		webtest.click("xpath=//*[@id=\"edui175_button_body\"]");
		webtest.click("xpath=//*[@id=\"edui179\"]/div/div");
		webtest.pause(2000);
	}
	//27�����BaiDu��ͼ  �޷����
	@Test(priority=27)
	public void why27test() throws InterruptedException {
		webtest.pause(2000);
		webtest.mouseToElement("xpath=//i[@class='icon-windows']");
		webtest.click("link=��Ϣģ��");
		webtest.click("xpath=//table[@class='table table-bordered table-striped table-hover']/tbody/tr[1]/td[1]/a");
		webtest.click("xpath=//*[@id=\"edui193_body\"]/div[1]");
		webtest.pause(2000);
		
	}
	//28����ӱ���
	@Test(priority=28)
	public void why28test() throws InterruptedException {
		webtest.pause(2000);
		webtest.mouseToElement("xpath=//i[@class='icon-windows']");
		webtest.click("link=��Ϣģ��");
		webtest.click("xpath=//table[@class='table table-bordered table-striped table-hover']/tbody/tr[1]/td[1]/a");
		webtest.pause(2000);
		webtest.click("xpath=//body[@class='view']");
		webtest.click("xpath=//div[@class='edui-box edui-icon edui-default'");
		//driver.switchTo().frame("edui194_iframe");
		webtest.click("xpath=//*[@id=\"tab0\"]/table/tbody/tr[2]/td[4]/span/img");
		webtest.pause(2000);
		driver.switchTo().defaultContent();
	}
	//30�����ô�������
	@Test(priority=30) 
	public void why30test() throws InterruptedException {
		webtest.pause(2000);
		webtest.mouseToElement("xpath=//i[@class='icon-windows']");
		webtest.click("link=��Ϣģ��");
		webtest.click("xpath=//table[@class='table table-bordered table-striped table-hover']/tbody/tr[1]/td[1]/a");
		webtest.click("xpath=//*[@id=\"edui201_button_body\"]");
		webtest.click("xpath=//*[@id=\"edui205\"]/div/div");
		webtest.pause(2000);
	}
}
