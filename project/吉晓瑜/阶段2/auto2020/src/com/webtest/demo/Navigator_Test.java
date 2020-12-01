package com.webtest.demo;

import org.testng.annotations.Test;

public class Navigator_Test extends Admin_Login {
	/*
	 * 签到日历
	 */
	@Test(priority = 1)
	public void test_signIn_date() {
		webtest.click("xpath=//a[@title='微博']");
		webtest.click("class=checking");
	}

	/*
	 * 签到
	 */
	@Test(priority = 2)
	public void test_signIn() {
		webtest.click("xpath=//a[@title='微博']");
		webtest.click("class=checking");
		boolean f = webtest.isChecked("link=签到");
		System.out.println(f);
//		webtest.click("link=签到");
		webtest.click("class=btn-sign show-check");

	}

	/*
	 * 排行榜
	 */
	@Test(priority = 3)
	public void test_rank() {
		webtest.click("xpath=//a[@title='微博']");
		webtest.click("class=pc6");

	}

	/*
	 * 我的关注
	 */
	@Test(priority = 4)
	public void test_attention() {
		webtest.click("xpath=//a[@title='微博']");
		webtest.click("id=concerned");
	}

	/*
	 * 热门动态
	 */
	@Test(priority = 5)
	public void test_hot_news() {
		webtest.click("id=hot");

	}

	/*
	 * 我的喜欢
	 */
	@Test(priority = 6)
	public void test_like_news() {
		webtest.click("id=fav");

	}

	/*
	 * 查看主页
	 */
	@Test(priority = 7)
	public void test_home_page() {
		webtest.click("xpath=//a[@title='微博']");
		webtest.click("xpath=//div[@class='op-tb op-top']//a[@class='user_name']");
		webtest.pause(3000);

	}

	/*
	 * 查看主页(资料卡片）
	 */
	@Test(priority = 8)
	public void test_small_page() throws InterruptedException {
		webtest.click("xpath=//a[@title='微博']");
		webtest.mouseToElement("xpath=//div[@class='content-head']//img[@class='avatar-img']");
		webtest.pause(3000);

	}

	/*
	 * 身份标签找人
	 */
	@Test(priority = 9)
	public void test_find_identity() throws InterruptedException {
		webtest.click("xpath=//a[@title='会员展示']");
		webtest.mouseToElement("class=zhanzhang");
		webtest.click("link=开发者");
		webtest.pause(3000);
	}

	/*
	 * 地区标签找人
	 */
	@Test(priority = 10)
	public void test_find_area() {
		webtest.click("xpath=//a[@title='会员展示']");
		webtest.click("id=tab_area");
		webtest.click("partLink=北京市");
		webtest.click("partLink=北京市");
		webtest.click("partLink=东城区");
		webtest.pause(3000);
	}

	/*
	 * 关注人（找人区）
	 */
	@Test(priority = 11)
	public void test_attention_find1() throws InterruptedException {
		webtest.click("xpath=//a[@title='会员展示']");
		webtest.mouseToElement("class=zhanzhang");
		webtest.click("link=开发者");
		webtest.pause(3000);
		webtest.click("xpath=//button[@class='box']");
		webtest.pause(3000);
	}

	/*
	 * 关注人（全站动态）
	 */
	@Test(priority = 12)
	public void test_attention_find2() {
		webtest.click("xpath=//a[@title='微博']");
		webtest.click("xpath=//div[@class='op-tb op-top']//a[@class='user_name']");
		webtest.pause(3000);
		webtest.click("xpath=//div[@class='col-xs-4 bt-group']//button[@class='btn btn-primary']");
		webtest.pause(3000);
	}

	/*
	 * 取消关注
	 */
	@Test(priority = 13)
	public void test_cancel_attention() {
		webtest.click("xpath=//a[@title='会员展示']");
		webtest.scrollFind2("xpath=//button[text()='已关注']");
		webtest.pause(3000);
		boolean b = webtest.isElementPresent("xpath=//button[contains(text(),'已关注')]");
		System.out.println(b);
		webtest.findClick("xpath=//button[contains(text(),'已关注')]");
		webtest.pause(6000);
	}
	/*
	 * 聊天
	 */
	@Test(priority = 14)
	public void test_chat() {
		webtest.click("xpath=//a[@title='会员展示']");
		webtest.click("xpath=//div[@class='sns-star-user']//a");
		webtest.click("xpath=//div[@class='col-xs-4 bt-group']//button[@class='btn btn-default']");
		webtest.typeAndClear("id=chat_content", "测试发起聊天：hi");
		webtest.click("xpath=//button[@onclick='talker.post_message()']");
		webtest.pause(5000);
		webtest.click("class=icon-off");
		webtest.click("class=icon-minus");
		webtest.pause(5000);
		
	}
	/*
	 * 邀请生成码
	 */
	@Test(priority = 15)
	public void test_invite() {
		webtest.click("xpath=//a[@title='微博']");
		webtest.click("link=立即邀请");
		webtest.click("link=生成邀请码");
		webtest.click("link=兑换名额");
		webtest.click("link=兑换");
		webtest.pause(3000);
		webtest.click("link=生成邀请码");
		webtest.enter();
		webtest.pause(2000);
		webtest.enter();
		webtest.enter();
//		webtest.alertAccept();
		webtest.pause(6000);

	}
}
