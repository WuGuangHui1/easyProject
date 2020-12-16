package com.webtest.lxc;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.NSDataProvider;

public class Admin_PersonalCover extends BaseTest{
	@Test(dataProvider="excel",dataProviderClass=NSDataProvider.class,priority = 1)
	public void testLogin(String a,String b) throws InterruptedException {
		webtest.open("http://localhost:8989/index.php");
		webtest.click("xpath=//a[@data-login='do_login']");
		Thread.sleep(3000);
		webtest.type("id=inputEmail",a);
		Thread.sleep(3000);
		System.out.println("aa");
		webtest.type("id=inputPassword",b);
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(3000);
	}
	//个人主页，上传个人封面
		@Test(priority = 2)
		public void testPersonalCover() throws InterruptedException, AWTException {
			//回到主页面
			//webtest.click("class=first-a");
			//Thread.sleep(2000);
			webtest.click("xpath=//img[@class='avatar-img nav-img']");
			Thread.sleep(2000);
			webtest.click("xpath=//img[@class='img-responsive']");
			Thread.sleep(2000);
			webtest.click("id=file_upload_1-button");
			Thread.sleep(2000);
			String path =  "D:\\demo\\1.jpg";
			//图片或文件的路径
			StringSelection stringSelection = new StringSelection(path);
			//指定图片的路径，使用相对路径
			Toolkit.getDefaultToolkit().getSystemClipboard()
			        .setContents(stringSelection, null);
			//把图片路径复制粘贴到剪切板
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			    //按下Enter键
			robot.keyRelease(KeyEvent.VK_ENTER);
			   //释放Enter键
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			//按下Ctrl+V
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);
			//释放Ctrl+V
			robot.keyPress(KeyEvent.VK_ENTER);
			//再次点击Enter键
			robot.keyRelease(KeyEvent.VK_ENTER);
			//再次释放Enter键
			Thread.sleep(5000);	
			webtest.click("id=submit_cover");
			Thread.sleep(2000);		
		}	
}
