package com.webtest.demo;

import org.testng.annotations.Test;

public class Management_Dynamic_Test extends Admin_Login {
	/*
	 * 8,测试全站置顶
	 */
	@Test(priority =1 )
	public void test_top_dynamic() {
		webtest.click("xpath=//a[@title='微博']");
		webtest.click("xpath=//a[@data-hover='查看详情']");
		webtest.click("xpath=//a[@data-target='#setTopModal']");
//		置顶类型
		webtest.click("id=content_top");
//		置顶标题
//		webtest.type("name=top_title", "8：测试置顶");
//		webtest.pause(6000);
//		置顶天数1
		webtest.type("name=top_dead","1");
		webtest.pause(6000);
//		确认
		webtest.click("xpath=//button[@data-role='weibo_set_top']");
		
//		Assert.assertEquals(, );
	}
	/*
	 * 12，隐藏全文置顶+13取消全文置顶
	 */
	@Test(priority =2 )
	public void test_top_conceal_dynamic() {
		webtest.click("xpath=//a[@title='微博']");
//		div[@id='weibo_42']
		webtest.click("xpath=//a[@data-hover='查看详情']");
		webtest.click("link=隐藏");
		System.out.println("1111223333");
		webtest.pause(4000);
		webtest.click("xpath=//a[@title='微博']");
		webtest.pause(4000);
		webtest.click("xpath=//li[@data-role='show_all_top_weibo']");
		webtest.pause(4000);
	}
	/*
	 * 10,取消全文置顶
	 */
	@Test(priority =3 )
	public void test_top_concel1_dynamic() {
		webtest.click("xpath=//a[@title='微博']");
//		div[@id='weibo_40']
		webtest.click("xpath=//a[@data-hover='查看详情']");
		webtest.click("xpath=//a[@data-target='#setTopModal']");
//		取消置顶
		webtest.click("link=取消置顶");
		webtest.pause(6000);
	}
	/*
	 * 9,标题置顶
	 */
	@Test(priority =4)
	public void test_top2_dynamic() {
		webtest.click("xpath=//a[@title='微博']");
//		//div[@id='weibo_40']
		webtest.click("xpath=//a[@data-hover='查看详情']");
		webtest.click("xpath=//a[@data-target='#setTopModal']");
//		置顶类型
		webtest.click("id=title_top");
//		置顶标题
		webtest.type("name=top_title", "8：测试置顶");
//		webtest.pause(6000);
//		置顶天数1
		webtest.type("name=top_dead","1");
		webtest.pause(6000);
//		确认
		webtest.click("xpath=//button[@data-role='weibo_set_top']");
		
//		Assert.assertEquals(, );
	}
	
	/*
	 * 11,取消标题置顶 
	 */
	@Test(priority =5)
	public void test_top_concel2_dynamic() {
		webtest.click("xpath=//a[@title='微博']");
//		点击标题置顶的小标题
		webtest.click("partLink=123");
//		取消置顶
		webtest.click("link=取消置顶");
		webtest.pause(6000);
	}
	
	

	/*
	 * 14点赞动态
	 */
	@Test(priority = 6)
	public void test_like_dynamic() {
		webtest.click("xpath=//a[@title='微博']");
		webtest.click("xpath=//a[@title='喜欢']");
	}
	/*
	 * 15取消点赞动态
	 */
	@Test(dependsOnMethods = {"test_like_dynamic"},priority = 7)
	public void test_unlike_dynamic() {
		webtest.click("xpath=//a[@title='微博']");
		webtest.click("xpath=//a[@title='喜欢']");
	}
	
	/*
	 * 评论功能
	 */
	@Test(priority = 8)
	public void test_discuss() {
		webtest.click("xpath=//a[@title='微博']");
		webtest.click("partLink=说一句");
		webtest.type("xpath=//input[@placeholder='评论（Ctrl+Enter）']","测试评论");
		webtest.Ctrl_Enter();
		webtest.pause(5000);
	}

	/*
	 * 评论点赞
	 */
	@Test(priority = 9)
	public void test_like_com() throws InterruptedException {
		webtest.click("xpath=//a[@title='微博']");
		webtest.mouseToElement("xpath=//div[@class='clearfix']//div[@class='col-xs-11  comment-content']");
		webtest.click("class=text-muted show-always");
		
	}
	/*
	 * 评论取消点赞
	 */
	@Test(dependsOnMethods = {"test_like_com"},priority = 10)
	public void test_unlike_com() throws InterruptedException {
		webtest.click("xpath=//a[@title='微博']");
		webtest.mouseToElement("xpath=//div[@class='clearfix']//div[@class='col-xs-11  comment-content']");
		webtest.click("class=text-muted show-always");
		
	}
	/*
	 * 评论回复
	 */
	@Test(priority = 11)
	public void test_discuss_reply() throws InterruptedException {
		webtest.Ctrl_R();
		webtest.pause(5000);
		webtest.mouseToElement("xpath=//div[@class='clearfix']//div[@class='col-xs-11  comment-content']");
		webtest.click("link=回复");
		webtest.type("xpath=//input[@placeholder='评论（Ctrl+Enter）']","测试评论回复");
		webtest.Ctrl_Enter();
	}
	/*
	 * 评论隐藏
	 */
	@Test(priority = 12)
	public void test_discuss_hide() {
		webtest.click("xpath=//div[@class=' col-xs-3 operate-color'][@data-role='weibo_comment_btn']");
		webtest.pause(3000);
	}
	
	
	/*
	 * 举报动态
	 */
	@Test(priority = 13)
	public void test_inform_dynamic() {
		webtest.click("xpath=//a[@title='微博']");
		webtest.click("xpath=//a[@data-hover='查看详情']");
		webtest.click("xpath=//div[@class='pull-right']//a[@data-title='举报']");
		webtest.typeAndClear("name=content", "举报原因1");
		webtest.click("xpath=//input[@type='submit']");
	}
	/*
	 * 举报动态评论
	 */
	@Test(priority = 14)
	public void test_inform_com_dynamic() {
		webtest.click("xpath=//a[@title='微博']");
		webtest.click("xpath=//a[@data-hover='查看详情']");
		webtest.click("xpath=//div[@class='clearfix text-muted']//a[@data-title='举报']");
		webtest.typeAndClear("name=content", "举报评论2");
		webtest.click("xpath=//input[@type='submit']");
	}
	
	
	
	/*
	 * 删除动态评论
	 */
	@Test(priority = 15)
	public void test_del_com_dynamic() {
		webtest.click("xpath=//a[@title='微博']");
		webtest.click("xpath=//a[@data-hover='查看详情']");
//		webtest.click("link=删除");
		webtest.click("xpath=//div[@id='comment_14']//a[@data-role='comment_del']");
		
	}
	
	
	/*
	 * 删除动态
	 */
	@Test(priority = 16)
	public void test_del_dynamic() {
		webtest.click("xpath=//a[@title='微博']");
		webtest.click("xpath=//a[@data-hover='查看详情']");
		webtest.click("partLink=删除");
		webtest.alertAccept();
		webtest.pause(6000);
		
	}
	

}
