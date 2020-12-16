package com.webtest.demo;

import org.testng.annotations.Test;

public class inpimg extends Admin_Login{
	 @Test
	 public void inpimg() throws InterruptedException {

		webtest.open("http://www.roqisoft.com/zhsx/");
		Thread.sleep(1000);
		webtest.mouseToElement("xpath=//strong[text()='']");
		 Thread.sleep(2000);
		 boolean a=webtest.isDisplayed("xpath=//a[text()='']");
	
		 System.out.println(a);
		 if (a==true) {
			 webtest.click("xpath=//a[text()='']");
			 webtest.click("xpath=//strong[text()='']");
			 webtest.enterFrame(0);
			webtest.type("xpath=//div[@id='attachbody']/*/input[@name='attach[]']", "D:\\demo\\1.jpg");
			Thread.sleep(3000);
			webtest.click("xpath=//input[@value='']");
			Thread.sleep(10000);
		 }
		 
	 }
}
