package com.webtest.jxy;

import org.testng.annotations.Test;

import com.webtest.jxy.Admin_Login;

public class Topic_Test extends Admin_Login{
	/*
	 * ���뻰��
	 */

	@Test(priority = 1)
	public void test_see_topic() {
		webtest.click("xpath=//a[@title='΢��']");
//		�������е�һ�Ļ���
		webtest.click("xpath=//div[@class='num num-top'][text()='1']");

	}
	/*
	 * ��ʾ���Ż���
	 */

	@Test(priority = 2)
	public void test_show_topic() {
		webtest.click("xpath=//a[@title='΢��']");
		webtest.click("link=�鿴����");
	}

	/*
	 * �����·���̬
	 */
	@Test(priority = 3)
	public void test_topic_dynamic() {
		webtest.click("xpath=//a[@title='΢��']");
		webtest.click("xpath=//div[@class='num num-top'][text()='1']");
		webtest.click("partLink=����̬");
		webtest.type("id=weibo_content", "�����·���̬");
		webtest.Ctrl_Enter();
	}

	/*
	 * ��ע����
	 */
	@Test(priority = 4)
	public void test_follow_topic() {
		webtest.Ctrl_R();
		webtest.click("link=��ע");
	}

	/*
	 * ����������
	 */
	@Test(priority = 5)
	public void test_host_topic() {
		webtest.click("link=��������");

	}

	/*
	 * ���������ˣ��������
	 */
	@Test(priority = 6)
	public void test_host_manager_topic() {
		webtest.click("xpath=//a[@title='΢��']");
		webtest.click("xpath=//div[@class='num num-top'][text()='1']");
		webtest.scrollFind1();
		webtest.type("xpath=//span[@id='web_uploader_wrapper_avatar']//input[@name='file']",
				"C:\\Users\\WHY\\Pictures\\Saved Pictures\\timg.jpg");
		webtest.type("xpath=//span[@id='web_uploader_wrapper_qrcode']//input[@name='file']",
				"C:\\Users\\WHY\\Pictures\\Saved Pictures\\timg.jpg");
		webtest.typeAndClear("id=intro", "���Ե���1");
		webtest.scrollFind1();
		webtest.click("xpath=//button[@class='btn btn-primary'][@type='submit']");
	}

	/*
	 * ������Ա���Ƽ�����
	 */
	@Test(priority = 7)
	public void test_recommend_topic() {
		webtest.click("xpath=//a[@title='΢��']");
		webtest.click("xpath=//div[@class='num num-top'][text()='1']");
//		webtest.scrollFind1();
		webtest.scrollFind2("id=top");
		webtest.click("id=top");
		webtest.click("xpath=//button[@class='btn btn-primary'][@type='submit']");
		webtest.pause(3000);

	}

	/*
	 * ������Ա)����������
	 */
	@Test(priority = 8)
	public void test_manage_host_topic() {
		webtest.click("xpath=//a[@title='΢��']");
		webtest.click("xpath=//div[@class='num num-top'][text()='1']");
		webtest.scrollFind2("id=uadmin");
		webtest.typeAndClear("id=uadmin", "112");
		webtest.click("xpath=//button[@class='btn btn-primary'][@type='submit']");
		webtest.pause(6000);
	}

}
