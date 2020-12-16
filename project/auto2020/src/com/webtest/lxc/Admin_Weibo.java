package com.webtest.lxc;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.NSDataProvider;

public class Admin_Weibo extends BaseTest{
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
	@Test(priority = 2)
	public void testLike() throws InterruptedException {
		webtest.click("xpath=//img[@class='avatar-img nav-img']");
		Thread.sleep(2000);
		webtest.click("xpath=//div[@class='col-xs-6 l-p0']");
		Thread.sleep(2000);
		webtest.click("xpath=//div[@data-weibo-id='18']/div/a/i");	
		Thread.sleep(2000);
	}
	@Test(priority = 3)
	public void testUnLike() throws InterruptedException {
		//�ص���ҳ��
		webtest.click("class=first-a");
		Thread.sleep(2000);
		webtest.click("xpath=//img[@class='avatar-img nav-img']");
		Thread.sleep(2000);
		webtest.click("xpath=//div[@class='col-xs-6 l-p0']");
		Thread.sleep(2000);
		webtest.click("xpath=//div[@data-weibo-id='18']/div/a/i");	
		Thread.sleep(2000);
	}
	@Test(priority = 4)
	public void testComment() throws InterruptedException {
		//�ص���ҳ��
		webtest.click("class=first-a");
		Thread.sleep(2000);
		webtest.click("xpath=//img[@class='avatar-img nav-img']");
		Thread.sleep(2000);
		webtest.click("xpath=//div[@class='col-xs-6 l-p0']");
		Thread.sleep(2000);
		webtest.doubleClick("xpath=//div[@data-weibo-id='18']/div[@data-role='weibo_comment_btn']");
		Thread.sleep(2000);
		webtest.type("id=text_18", "΢������");
		Thread.sleep(2000);
		webtest.click("xpath=//i[@class='os-icon-paper-plane']");
		Thread.sleep(2000);
	}
	@Test(priority = 5)
	public void testCommentLike() throws InterruptedException {
		//�ص���ҳ��
		webtest.click("class=first-a");
		Thread.sleep(2000);
		webtest.click("xpath=//img[@class='avatar-img nav-img']");
		Thread.sleep(2000);
		webtest.click("xpath=//div[@class='col-xs-6 l-p0']");
		Thread.sleep(2000);
		webtest.mouseToElement("xpath=//div[@id='comment_17']/div");
		Thread.sleep(2000);
		webtest.click("id=support_Weibo_weibo_comment_17_icon");
		Thread.sleep(2000);
	}
	@Test(priority = 6)
	public void testCommentUnLike() throws InterruptedException {
		//�ص���ҳ��
		webtest.click("class=first-a");
		Thread.sleep(2000);
		webtest.click("xpath=//img[@class='avatar-img nav-img']");
		Thread.sleep(2000);
		webtest.click("xpath=//div[@class='col-xs-6 l-p0']");
		Thread.sleep(2000);
		webtest.mouseToElement("xpath=//div[@id='comment_17']/div");
		Thread.sleep(2000);
		webtest.click("id=support_Weibo_weibo_comment_17_icon");
		Thread.sleep(2000);
	}
	//΢�����ۻظ�
	@Test(priority = 7)
	public void testCommentReply() throws InterruptedException {
		//�ص���ҳ��
		webtest.click("class=first-a");
		Thread.sleep(2000);
		webtest.click("xpath=//img[@class='avatar-img nav-img']");
		Thread.sleep(2000);
		webtest.click("xpath=//div[@class='col-xs-6 l-p0']");
		Thread.sleep(2000);
		webtest.mouseToElement("xpath=//div[@id='comment_17']");
		Thread.sleep(2000);
		webtest.click("xpath=//div[@id='comment_action_show_17']/a[@data-role='weibo_reply']");
		Thread.sleep(2000);
		webtest.type("xpath=//input[@id='text_18']", "�ظ�΢������");
		Thread.sleep(2000);
		webtest.click("xpath=//i[@class='os-icon-paper-plane']");
		Thread.sleep(2000);
	}
//	//ת��΢��
//	@Test(priority = 8)
//	public void testForward() throws InterruptedException {
//		//�ص���ҳ��
//		webtest.click("class=first-a");
//		Thread.sleep(2000);
//		webtest.click("xpath=//img[@class='avatar-img nav-img']");
//		Thread.sleep(2000);
//		webtest.click("xpath=//div[@class='col-xs-6 l-p0']");
//		Thread.sleep(2000);
//		webtest.click("xpath=//div[@data-weibo-id='17']/div[3]");
//		Thread.sleep(2000);
//		webtest.type("id=repost_content", "ת��΢��");
//		Thread.sleep(2000);
//		webtest.click("xpath=//input[@class='btn btn-primary']");
//		Thread.sleep(2000);
//	}
//	//ת��΢��ͬʱ����
//	@Test(priority = 9)
//	public void testForwardAddReply() throws InterruptedException {
//		//�ص���ҳ��
//		webtest.click("class=first-a");
//		Thread.sleep(2000);
//		webtest.click("xpath=//img[@class='avatar-img nav-img']");
//		Thread.sleep(2000);
//		webtest.click("xpath=//div[@class='col-xs-6 l-p0']");
//		Thread.sleep(2000);
//		webtest.click("xpath=//div[@data-weibo-id='17']/div[3]");
//		Thread.sleep(2000);
//		webtest.type("id=repost_content", "ת��ͬʱ�ظ�");
//		Thread.sleep(2000);
//		webtest.click("id=becomment");
//		Thread.sleep(2000);
//		webtest.click("xpath=//input[@class='btn btn-primary']");
//		Thread.sleep(2000);
//	}
//	//ȡ��ת��΢��
//	@Test(priority = 10)
//	public void testCloseForward() throws InterruptedException {
//		//�ص���ҳ��
//		webtest.click("class=first-a");
//		Thread.sleep(2000);
//		webtest.click("xpath=//img[@class='avatar-img nav-img']");
//		Thread.sleep(2000);
//		webtest.click("xpath=//div[@class='col-xs-6 l-p0']");
//		Thread.sleep(2000);
//		webtest.click("xpath=//div[@data-weibo-id='17']/div[3]");
//		Thread.sleep(2000);
//		webtest.type("id=repost_content", "�ر�ת������");
//		Thread.sleep(2000);
//		webtest.click("xpath=//button[@class='mfp-close']");
//		Thread.sleep(2000);
//	}
//	//΢������
//	@Test(priority = 11)
//	public void testShare() throws InterruptedException {
//		//�ص���ҳ��
//		webtest.click("class=first-a");
//		Thread.sleep(2000);
//		webtest.click("xpath=//img[@class='avatar-img nav-img']");
//		Thread.sleep(2000);
//		webtest.click("xpath=//div[@class='col-xs-6 l-p0']");
//		Thread.sleep(2000);
//		webtest.click("xpath=//div[@data-weibo-id='17']/div[4]");
//		Thread.sleep(2000);
//		webtest.click("xpath=//div[@data-weibo-id='17']/div[4]/div/div/a[1]");
//		Thread.sleep(2000);
//		webtest.getWindow(1);
//		Thread.sleep(2000);
//		webtest.click("id=changeAccounts");
//		Thread.sleep(2000);
//		webtest.enterFrame("loginFrame");
//		Thread.sleep(2000);
//		webtest.click("id=img_out_1151336597");
//		Thread.sleep(2000);
//		webtest.leaveFrame();
//		Thread.sleep(2000);
//		webtest.type("id=descriptiontx", "����QQ�ռ����");
//		Thread.sleep(2000);
//		webtest.click("id=postButton");
//		Thread.sleep(2000);
//		webtest.getWindow(0);
//		Thread.sleep(2000);
//	}
//	//�鿴ת����ԭ΢��
//	@Test(priority = 12)
//	public void testOpenForward() throws InterruptedException {
//		//�ص���ҳ��
//		webtest.click("class=first-a");
//		Thread.sleep(2000);
//		webtest.click("xpath=//img[@class='avatar-img nav-img']");
//		Thread.sleep(2000);
//		webtest.click("xpath=//div[@class='col-xs-6 l-p0']");
//		Thread.sleep(2000);
//		webtest.click("xpath=//div[@id='weibo_20']/div/div/div[2]/div[3]/span[2]");
//		Thread.sleep(2000);
//	}
}
