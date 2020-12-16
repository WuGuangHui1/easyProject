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
	//������ҳ���ϴ����˷���
		@Test(priority = 2)
		public void testPersonalCover() throws InterruptedException, AWTException {
			//�ص���ҳ��
			//webtest.click("class=first-a");
			//Thread.sleep(2000);
			webtest.click("xpath=//img[@class='avatar-img nav-img']");
			Thread.sleep(2000);
			webtest.click("xpath=//img[@class='img-responsive']");
			Thread.sleep(2000);
			webtest.click("id=file_upload_1-button");
			Thread.sleep(2000);
			String path =  "D:\\demo\\1.jpg";
			//ͼƬ���ļ���·��
			StringSelection stringSelection = new StringSelection(path);
			//ָ��ͼƬ��·����ʹ�����·��
			Toolkit.getDefaultToolkit().getSystemClipboard()
			        .setContents(stringSelection, null);
			//��ͼƬ·������ճ�������а�
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			    //����Enter��
			robot.keyRelease(KeyEvent.VK_ENTER);
			   //�ͷ�Enter��
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			//����Ctrl+V
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);
			//�ͷ�Ctrl+V
			robot.keyPress(KeyEvent.VK_ENTER);
			//�ٴε��Enter��
			robot.keyRelease(KeyEvent.VK_ENTER);
			//�ٴ��ͷ�Enter��
			Thread.sleep(5000);	
			webtest.click("id=submit_cover");
			Thread.sleep(2000);		
		}	
}
