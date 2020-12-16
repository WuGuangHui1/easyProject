package com.webtest.demo;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class text extends BaseTest{
	
	
		
		
	 @Test
	 @Parameters({"title","text"})
	 public void addtext(String title,String text) throws InterruptedException {
		 webtest.open("http://www.roqisoft.com/zhsx/");
			
			webtest.click("xpath=//a[text()='登录']");
			webtest.type("name=user", "mmyy");
			webtest.type("name=pw", "123456");
			webtest.click("xpath=//input[@type='submit']");
			assertTrue(webtest.isTextPresent("退出"));
		
		 webtest.mouseToElement("xpath=//strong[text()='我的空间']");
		 Thread.sleep(2000);
		 boolean a=webtest.isDisplayed("xpath=//a[text()='个人游记']");
		 
		 System.out.println(a);
		 if (a==true) {
			 webtest.click("xpath=//a[text()='个人游记']");
			 webtest.click("xpath=//u[text()='点我写游记']");
			
			 webtest.type("id=title",title);
			 webtest.enterFrame(1);
			 webtest.click("class=ke-content");
			 webtest.type("class=ke-content",text);
			 webtest.leaveFrame();
		
			 webtest.click("xpath=//input[@value='发布文章']");
		
			 Thread.sleep(10000);
			
		 }
		 
		
	 }
	 @Test
	 @Parameters({"title","change"})
	 public void changetext(String title,String change) throws InterruptedException {
		 webtest.click("xpath=//a[text()='"+title+"']");
		 webtest.enterFrame(1);
		 webtest.click("class=ke-content");
		 webtest.typeAndClear("class=ke-content", change);
		 webtest.leaveFrame();
		 webtest.click("xpath=//input[@value='保存并返回']");
		 Thread.sleep(10000);
	 }
}
