package com.webtest.why;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.webtest.demo.Admin_Login;

public class website_settings extends Admin_Login{
	//36���ܷ������վ����ҳURL
		@Test(priority=36)
		public void why36test() throws InterruptedException {
			webtest.pause(2000);
			webtest.mouseToElement("xpath=//i[@class='icon-windows']");
			webtest.click("link=��վ����");
			webtest.type("xpath=//input[@class='text input-large form-contro']", "http://localhost:8989/");
			webtest.pause(2000);
			webtest.alertAccept();
		}
		
		//37�����������ܷ���Ŀհ�˵��
		@Test(priority=37)
		public void why37test() throws InterruptedException {
			webtest.pause(2000);
			webtest.mouseToElement("xpath=//i[@class='icon-windows']");
			webtest.click("link=��վ����");
			webtest.click("xpath=//a[text()='��������']");
			webtest.type("xpath=//textarea[@class='form-control']","abcd");
			webtest.pause(2000);
			webtest.click("xpath=//button[@type='submit']");
			webtest.alertAccept();
			webtest.pause(2000);
			
		}
		
		//38���ܷ��޸ĺ�̨ÿҳ��¼��
		@Test(priority=38)
		public void why38test() throws InterruptedException {
			webtest.pause(2000);
			webtest.mouseToElement("xpath=//i[@class='icon-windows']");
			webtest.click("link=��վ����");
			webtest.click("xpath=//a[text()='��������']");
			webtest.typeAndClear("xpath=//input[@class=text input-small form-control']", "10");
			webtest.pause(2000);
			webtest.click("xpath=//button[@class='btn submit-btn ajax-post'");
			webtest.alertAccept();
			webtest.pause(2000);
		}
		//39���û������ܷ��޸ı����û������ǳ�
		@Test(priority=39)
		public void why39test() throws InterruptedException {
			webtest.pause(2000);
			webtest.mouseToElement("xpath=//i[@class='icon-windows']");
			webtest.click("link=��վ����");
			webtest.click("xpath=//*[@id=\"main\"]/div/div[3]/ul/li[3]/a");
			webtest.typeAndClear("xpath=//*[@id=\"main\"]/div/div[4]/div/form/div[1]/div/input", "11112223");
			webtest.click("xpath=//*[@id=\"main\"]/div/div[4]/div/form/div[3]/div/button[1]");
			webtest.pause(2000);
			webtest.alertAccept();
		}
		//41���ܷ��ı��Ӵ�
		@Test(priority=41)
		public void why41test() throws InterruptedException {
			webtest.pause(2000);
			webtest.mouseToElement("xpath=//i[@class='icon-windows']");
			webtest.click("link=��վ����");
			webtest.click("xpath=//a[text()='�û�����']");
			driver.switchTo().frame("ueditor_0");
			//webtest.click("xpath=//body[@class='view']");
			webtest.type("xpath=//body[@class='view']",Keys.LEFT_CONTROL + "a" );
			webtest.pause(2000);
	        driver.switchTo().defaultContent();
	        webtest.click("xpath=//*[@id=\"edui5_body\"]/div");
	        webtest.click("xpath=//button[@type='submit']");
	        webtest.alertAccept();
	        webtest.pause(2000);
		}
		//42���ܷ��ı�����Ϊб��
		@Test(priority=42)
		public void why42test() throws InterruptedException {
			webtest.pause(2000);
			webtest.mouseToElement("xpath=//i[@class='icon-windows']");
			webtest.click("link=��վ����");
			webtest.click("xpath=//a[text()='�û�����']");
			driver.switchTo().frame("ueditor_0");
			//webtest.click("xpath=//body[@class='view']");
			webtest.type("xpath=//body[@class='view']",Keys.LEFT_CONTROL + "a" );
	        driver.switchTo().defaultContent();
	        webtest.click("xpath=//*[@id=\"edui6_body\"]/div");
	        webtest.click("xpath=//button[@type='submit']");
	        webtest.alertAccept();
	        webtest.pause(2000);
			
		}
		
		//43���ܷ�����ּ����»���
		@Test(priority=43)
		public void why43test() throws InterruptedException {
			webtest.pause(2000);
			webtest.mouseToElement("xpath=//i[@class='icon-windows']");
			webtest.click("link=��վ����");
			webtest.click("xpath=//*[@id=\"main\"]/div/div[3]/ul/li[3]/a");
			driver.switchTo().frame("ueditor_0");
			//webtest.click("xpath=//body[@class='view']");
			webtest.type("xpath=//body[@class='view']",Keys.LEFT_CONTROL + "a" );
	        driver.switchTo().defaultContent();
	        webtest.click("xpath=//*[@id=\"edui7_body\"]/div");
	        webtest.click("xpath=//button[@type='submit']");
	        webtest.alertAccept();
	        webtest.pause(2000);
			
		}
		//45���ܷ�������ȷ�ֺ�
		@Test(priority=45)
		public void why45test() throws InterruptedException {
			webtest.pause(2000);
			webtest.mouseToElement("xpath=//i[@class='icon-windows']");
			webtest.click("link=��վ����");
			webtest.click("xpath=//a[text()='�û�����']");
			driver.switchTo().frame("ueditor_0");
			//webtest.click("xpath=//body[@class='view']");
			webtest.type("xpath=//body[@class='view']",Keys.LEFT_CONTROL + "a" );
	        driver.switchTo().defaultContent();
	        webtest.click("xpath=//*[@id=\"edui8_button_body\"]");
	        webtest.click("xpath=//*[@id=\"edui16\"]/div/div");
	        webtest.click("xpath=//button[@type='submit']");
	        webtest.alertAccept();
	        webtest.pause(2000);
		}
		//46���ܷ�����������ɫ
		@Test(priority=46)
		public void why46test() throws InterruptedException {
			webtest.pause(2000);
			webtest.mouseToElement("xpath=//i[@class='icon-windows']");
			webtest.click("link=��վ����");
			webtest.click("xpath=//a[text()='�û�����']");
			driver.switchTo().frame("ueditor_0");
			webtest.click("xpath=//body[@class='view']");
			webtest.type("xpath=//body[@class='view']",Keys.LEFT_CONTROL + "a" );
			webtest.pause(2000);
	        driver.switchTo().defaultContent();
	        webtest.click("xpath=//div[@class='edui-box edui-arrow edui-default']");
	        webtest.click("xpath=//a[@title='ffff00']");
	        webtest.click("xpath=//button[@type='submit']");
	        webtest.alertAccept();
	        webtest.pause(2000);
		}
		//47���ܷ���������
		@Test(priority=47)
		public void why47test() throws InterruptedException {
			webtest.pause(2000);
			webtest.mouseToElement("xpath=//i[@class='icon-windows']");
			webtest.click("link=��վ����");
			webtest.click("xpath=//*[@id=\"main\"]/div/div[3]/ul/li[3]/a");
			driver.switchTo().frame("ueditor_0");
			webtest.click("xpath=//body[@class='view']");
			webtest.type("xpath=//body[@class='view']",Keys.LEFT_CONTROL + "a" );
			webtest.pause(2000);
	        driver.switchTo().defaultContent();
	        webtest.click("xpath=//div[@class='edui-box edui-arrow edui-default']");
	        webtest.click("xpath=//div[text()='����']");
	        webtest.click("xpath=//button[@type='submit']");
	        webtest.alertAccept();
	        webtest.pause(2000);
		}
		//44���ܷ����ñ���ɫ
		@Test(priority=44)
		public void why44test() throws InterruptedException {
			webtest.pause(2000);
			webtest.mouseToElement("xpath=//i[@class='icon-windows']");
			webtest.click("link=��վ����");
			webtest.click("xpath=//a[text()='�û�����']");
			driver.switchTo().frame("ueditor_0");
			webtest.click("xpath=//body[@class='view']");
			webtest.type("xpath=//body[@class='view']",Keys.LEFT_CONTROL + "a" );
			webtest.pause(2000);
	        driver.switchTo().defaultContent();
	        webtest.click("xpath=//div[@class='edui-box edui-arrow edui-default']");
	        webtest.click("xpath=//a[@title='92d050']");
	        webtest.click("xpath=//button[@type='submit']");
	        webtest.alertAccept();
	        webtest.pause(2000);
		}
		//48���ܷ�ʹ�ñ���
		@Test(priority=48)
		public void why48test() throws InterruptedException {
			webtest.pause(2000);
			webtest.mouseToElement("xpath=//i[@class='icon-windows']");
			webtest.click("link=��վ����");
			webtest.click("xpath=//a[text()='�û�����']");
			webtest.click("xpath=//div[@class='edui-box edui-icon edui-default']");
			driver.switchTo().frame("edui77_iframe");
			webtest.click("xpath=//img[@title='��Ц']");
			driver.switchTo().defaultContent();
			webtest.click("xpath=//button[@type='submit']");
		    webtest.alertAccept();
		    webtest.pause(2000);
		    
			
		}
		
		//50���ܷ�ѡ���������
		@Test(priority=50)
		public void why50test() throws InterruptedException {
			webtest.pause(2000);
			webtest.mouseToElement("xpath=//i[@class='icon-windows']");
			webtest.click("link=��վ����");
			webtest.click("xpath=//a[text()='�û�����']");
			webtest.click("id=edui46_button_body");
			webtest.click("id=edui50");
			webtest.click("xpath=//button[@type='submit']");
		   // webtest.alertAccept();
		    webtest.pause(3000);
		}
		//54�ܷ�����Զ�������ʾΪ�ر�
				@Test(priority=54)
				public void wwhy36test() throws InterruptedException {
					webtest.pause(2000);
					webtest.mouseToElement("xpath=//i[@class='icon-windows']");
					webtest.click("link=��վ����");
					webtest.click("class=form-control");
					webtest.click("xpath=//option[text()='�ر�']");
					webtest.pause(2000);
				}

}
