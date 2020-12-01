package com.webtest.demo;

import org.testng.annotations.Test;

public class Dynamic_test extends Admin_Login {
	/*
	 * 1，发布文本动态
	 */
	@Test(priority = 1)
	public void test_writing_dynamic() {
		webtest.click("xpath=//a[@title='微博']");
		webtest.pause(2000);
		webtest.click("xpath=//div[@data-role='switch_sendBox']");
		webtest.click("xpath=//div[@data-role='show-sendBox']");
		webtest.typeAndClear("id=weibo_content", "测试1");
		webtest.click("xpath=//a[@data-role='send_weibo']");
		webtest.pause(8000);
	}

	/*
	 * ,2，发文本+图片动态
	 */
	@Test(priority = 2)
	public void test_photo_dynamic() {
		webtest.Ctrl_R();
		webtest.pause(3000);
		webtest.click("xpath=//a[@title='微博']");
		webtest.click("xpath=//div[@data-role='switch_sendBox']");
		webtest.typeAndClear("id=weibo_content", "测试2");
		webtest.click("id=insert_image");
		webtest.type("name=file", "C:\\Users\\JJIXI\\Desktop\\u.jpg");
		webtest.pause(3000);
		webtest.click("xpath=//a[@data-role='send_weibo']");

	}

	/*
	 * 3，发布动态，上传照片再删除
	 */
	@Test(priority = 3)
	public void test_photo2_dynamic() {
		webtest.pause(3000);
		webtest.click("xpath=//a[@title='微博']");
		webtest.click("xpath=//div[@data-role='switch_sendBox']");
//		webtest.click("xpath=//div[@data-role='show-sendBox']");
		webtest.typeAndClear("id=weibo_content", "测试3");
		webtest.click("id=insert_image");
		webtest.type("name=file", "C:\\Users\\JJIXI\\Desktop\\u.jpg");
		webtest.pause(3000);
		webtest.click("link=删除");
		webtest.click("xpath=//a[@data-role='send_weibo']");

	}

	/*
	 * 4,发布动态，上传照片再删除,关闭上传图片窗口
	 */
	@Test(priority = 4)
	public void test_photo3_dynamic() {
		webtest.pause(3000);
		webtest.click("xpath=//a[@title='微博']");
		webtest.click("xpath=//div[@data-role='switch_sendBox']");
//		webtest.click("xpath=//div[@data-role='show-sendBox']");
		webtest.typeAndClear("id=weibo_content", "测试4");
		webtest.click("id=insert_image");
		webtest.type("name=file", "C:\\Users\\JJIXI\\Desktop\\u.jpg");
		webtest.pause(3000);
		webtest.click("link=删除");
		webtest.click("link=X");
		webtest.click("xpath=//a[@data-role='send_weibo']");
//		System.out.println(webtest.getAlertTest());

	}

	/*
	 * 5，插入话题
	 */
	@Test(priority = 5)
	public void test_topic_dynamic() {
		webtest.pause(3000);
		webtest.click("xpath=//a[@title='微博']");
		webtest.click("xpath=//div[@data-role='switch_sendBox']");
//		webtest.click("xpath=//div[@data-role='show-sendBox']");
		webtest.typeAndClear("id=weibo_content", "测试4");
		webtest.click("xpath=//a[@title='插入话题']");
		webtest.type("id=weibo_content", "bbbb");
		webtest.click("xpath=//a[@data-role='send_weibo']");
//		System.out.println(webtest.getAlertTest());

	}

	/*
	 * 6,动态-只插入表情
	 */
	@Test(priority = 6)
	public void test_expression_dynamic() {
		webtest.pause(3000);
		webtest.click("xpath=//a[@title='微博']");
		webtest.click("xpath=//div[@data-role='switch_sendBox']");
//		webtest.click("xpath=//div[@data-role='show-sendBox']");
		webtest.click("xpath=//a[@title='插入表情']");
		webtest.click("xpath=//a[@title='diaoxie']");
		webtest.click("xpath=//a[@data-role='send_weibo']");
		webtest.Ctrl_Enter();

	}

	/*
	 * 7,动态-enter发布
	 */
	@Test(priority = 7)
	public void test_enter_dynamic() {
		webtest.pause(3000);
		webtest.click("xpath=//a[@title='微博']");
		webtest.click("xpath=//div[@data-role='switch_sendBox']");
//		webtest.click("xpath=//div[@data-role='show-sendBox']");
		webtest.typeAndClear("id=weibo_content", "测试7");
		webtest.click("xpath=//a[@title='diaoxie']");
		webtest.Ctrl_Enter();
		webtest.pause(6000);
	}

}
