package com.webtest.demo;

import org.testng.annotations.Test;

public class inpimg extends Admin_Login{
	 @Test
	 public void inpimg() throws InterruptedException {

		webtest.open("http://www.roqisoft.com/zhsx/");
		Thread.sleep(1000);
		webtest.mouseToElement("xpath=//strong[text()='我的空间']");
		 Thread.sleep(2000);
		 boolean a=webtest.isDisplayed("xpath=//a[text()='个人相册']");
	
		 System.out.println(a);
		 if (a==true) {
			 webtest.click("xpath=//a[text()='个人相册']");
			 webtest.click("xpath=//strong[text()='点击上传图片']");
			 webtest.enterFrame(0);
			webtest.type("xpath=//div[@id='attachbody']/*/input[@name='attach[]']", "D:\\demo\\1.jpg");
			Thread.sleep(3000);
			webtest.click("xpath=//input[@value='上传']");
			Thread.sleep(10000);
		 }
		 
	 }
}
