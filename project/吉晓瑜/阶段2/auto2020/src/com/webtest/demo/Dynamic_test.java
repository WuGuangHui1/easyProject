package com.webtest.demo;

import org.testng.annotations.Test;

public class Dynamic_test extends Admin_Login {
	/*
	 * 1�������ı���̬
	 */
	@Test(priority = 1)
	public void test_writing_dynamic() {
		webtest.click("xpath=//a[@title='΢��']");
		webtest.pause(2000);
		webtest.click("xpath=//div[@data-role='switch_sendBox']");
		webtest.click("xpath=//div[@data-role='show-sendBox']");
		webtest.typeAndClear("id=weibo_content", "����1");
		webtest.click("xpath=//a[@data-role='send_weibo']");
		webtest.pause(8000);
	}

	/*
	 * ,2�����ı�+ͼƬ��̬
	 */
	@Test(priority = 2)
	public void test_photo_dynamic() {
		webtest.Ctrl_R();
		webtest.pause(3000);
		webtest.click("xpath=//a[@title='΢��']");
		webtest.click("xpath=//div[@data-role='switch_sendBox']");
		webtest.typeAndClear("id=weibo_content", "����2");
		webtest.click("id=insert_image");
		webtest.type("name=file", "C:\\Users\\JJIXI\\Desktop\\u.jpg");
		webtest.pause(3000);
		webtest.click("xpath=//a[@data-role='send_weibo']");

	}

	/*
	 * 3��������̬���ϴ���Ƭ��ɾ��
	 */
	@Test(priority = 3)
	public void test_photo2_dynamic() {
		webtest.pause(3000);
		webtest.click("xpath=//a[@title='΢��']");
		webtest.click("xpath=//div[@data-role='switch_sendBox']");
//		webtest.click("xpath=//div[@data-role='show-sendBox']");
		webtest.typeAndClear("id=weibo_content", "����3");
		webtest.click("id=insert_image");
		webtest.type("name=file", "C:\\Users\\JJIXI\\Desktop\\u.jpg");
		webtest.pause(3000);
		webtest.click("link=ɾ��");
		webtest.click("xpath=//a[@data-role='send_weibo']");

	}

	/*
	 * 4,������̬���ϴ���Ƭ��ɾ��,�ر��ϴ�ͼƬ����
	 */
	@Test(priority = 4)
	public void test_photo3_dynamic() {
		webtest.pause(3000);
		webtest.click("xpath=//a[@title='΢��']");
		webtest.click("xpath=//div[@data-role='switch_sendBox']");
//		webtest.click("xpath=//div[@data-role='show-sendBox']");
		webtest.typeAndClear("id=weibo_content", "����4");
		webtest.click("id=insert_image");
		webtest.type("name=file", "C:\\Users\\JJIXI\\Desktop\\u.jpg");
		webtest.pause(3000);
		webtest.click("link=ɾ��");
		webtest.click("link=X");
		webtest.click("xpath=//a[@data-role='send_weibo']");
//		System.out.println(webtest.getAlertTest());

	}

	/*
	 * 5�����뻰��
	 */
	@Test(priority = 5)
	public void test_topic_dynamic() {
		webtest.pause(3000);
		webtest.click("xpath=//a[@title='΢��']");
		webtest.click("xpath=//div[@data-role='switch_sendBox']");
//		webtest.click("xpath=//div[@data-role='show-sendBox']");
		webtest.typeAndClear("id=weibo_content", "����4");
		webtest.click("xpath=//a[@title='���뻰��']");
		webtest.type("id=weibo_content", "bbbb");
		webtest.click("xpath=//a[@data-role='send_weibo']");
//		System.out.println(webtest.getAlertTest());

	}

	/*
	 * 6,��̬-ֻ�������
	 */
	@Test(priority = 6)
	public void test_expression_dynamic() {
		webtest.pause(3000);
		webtest.click("xpath=//a[@title='΢��']");
		webtest.click("xpath=//div[@data-role='switch_sendBox']");
//		webtest.click("xpath=//div[@data-role='show-sendBox']");
		webtest.click("xpath=//a[@title='�������']");
		webtest.click("xpath=//a[@title='diaoxie']");
		webtest.click("xpath=//a[@data-role='send_weibo']");
		webtest.Ctrl_Enter();

	}

	/*
	 * 7,��̬-enter����
	 */
	@Test(priority = 7)
	public void test_enter_dynamic() {
		webtest.pause(3000);
		webtest.click("xpath=//a[@title='΢��']");
		webtest.click("xpath=//div[@data-role='switch_sendBox']");
//		webtest.click("xpath=//div[@data-role='show-sendBox']");
		webtest.typeAndClear("id=weibo_content", "����7");
		webtest.click("xpath=//a[@title='diaoxie']");
		webtest.Ctrl_Enter();
		webtest.pause(6000);
	}

}
