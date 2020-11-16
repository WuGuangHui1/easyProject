package com.webtest.demo;

import org.testng.annotations.Test;

public class comment extends Admin_Login{
	 @Test
	 public void addco() throws InterruptedException {
			
		webtest.open("http://www.roqisoft.com/zhsx/blog/");
		 Thread.sleep(3000);
		webtest.click("xpath=//div[@class='main']/ul[1]/div[@class='article']/h2/a[@title='ÏêÏ¸ÔÄ¶Á test']");
		
		Thread.sleep(5000);
		webtest.type("class=textarea", "comment");
		Thread.sleep(5000);

		webtest.click("name=submit");
		Thread.sleep(5000);
	 }
}
