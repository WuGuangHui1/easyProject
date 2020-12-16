package com.webtest.jxy;

import org.testng.annotations.Test;

import com.webtest.jxy.Admin_Login;

public class Topic_Test extends Admin_Login{
	/*
	 * 进入话题
	 */

	@Test(priority = 1)
	public void test_see_topic() {
		webtest.click("xpath=//a[@title='微博']");
//		进入排行第一的话题
		webtest.click("xpath=//div[@class='num num-top'][text()='1']");

	}
	/*
	 * 显示热门话题
	 */

	@Test(priority = 2)
	public void test_show_topic() {
		webtest.click("xpath=//a[@title='微博']");
		webtest.click("link=查看更多");
	}

	/*
	 * 话题下发动态
	 */
	@Test(priority = 3)
	public void test_topic_dynamic() {
		webtest.click("xpath=//a[@title='微博']");
		webtest.click("xpath=//div[@class='num num-top'][text()='1']");
		webtest.click("partLink=发动态");
		webtest.type("id=weibo_content", "话题下发动态");
		webtest.Ctrl_Enter();
	}

	/*
	 * 关注话题
	 */
	@Test(priority = 4)
	public void test_follow_topic() {
		webtest.Ctrl_R();
		webtest.click("link=关注");
	}

	/*
	 * 话题主持人
	 */
	@Test(priority = 5)
	public void test_host_topic() {
		webtest.click("link=抢先主持");

	}

	/*
	 * 话题主持人，管理面板
	 */
	@Test(priority = 6)
	public void test_host_manager_topic() {
		webtest.click("xpath=//a[@title='微博']");
		webtest.click("xpath=//div[@class='num num-top'][text()='1']");
		webtest.scrollFind1();
		webtest.type("xpath=//span[@id='web_uploader_wrapper_avatar']//input[@name='file']",
				"C:\\Users\\WHY\\Pictures\\Saved Pictures\\timg.jpg");
		webtest.type("xpath=//span[@id='web_uploader_wrapper_qrcode']//input[@name='file']",
				"C:\\Users\\WHY\\Pictures\\Saved Pictures\\timg.jpg");
		webtest.typeAndClear("id=intro", "测试导语1");
		webtest.scrollFind1();
		webtest.click("xpath=//button[@class='btn btn-primary'][@type='submit']");
	}

	/*
	 * （管理员）推荐话题
	 */
	@Test(priority = 7)
	public void test_recommend_topic() {
		webtest.click("xpath=//a[@title='微博']");
		webtest.click("xpath=//div[@class='num num-top'][text()='1']");
//		webtest.scrollFind1();
		webtest.scrollFind2("id=top");
		webtest.click("id=top");
		webtest.click("xpath=//button[@class='btn btn-primary'][@type='submit']");
		webtest.pause(3000);

	}

	/*
	 * （管理员)设置主持人
	 */
	@Test(priority = 8)
	public void test_manage_host_topic() {
		webtest.click("xpath=//a[@title='微博']");
		webtest.click("xpath=//div[@class='num num-top'][text()='1']");
		webtest.scrollFind2("id=uadmin");
		webtest.typeAndClear("id=uadmin", "112");
		webtest.click("xpath=//button[@class='btn btn-primary'][@type='submit']");
		webtest.pause(6000);
	}

}
