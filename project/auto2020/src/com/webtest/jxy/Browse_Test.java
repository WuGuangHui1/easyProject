package com.webtest.jxy;

import org.testng.annotations.Test;

/**
 * 
 * @author 吉晓瑜
 *
 */

public class Browse_Test extends Admin_Login {
	/*
	 * 全站动态下的全部
	 */
	@Test(priority = 1)
	public void test_show_all() {
		webtest.click("xpath=//a[@title='微博']");
//		点击全站动态
		webtest.click("id=all");
		webtest.click("xpath=//a[@id='all_']//p[@class='mg-bt0']");

	}

	/*
	 * 全站动态下的图片
	 */
	@Test(priority = 2)
	public void test_show_photo() {
		webtest.click("xpath=//a[@title='微博']");
//		点击全站动态
		webtest.click("id=all");
//		全部
		webtest.click("xpath=//a[@id='image']//p[@class='mg-bt0']");
	}

	/*
	 * 查看详情
	 */
	@Test(priority = 3)
	public void test_show_time() throws InterruptedException {
		webtest.mouseToElement("xpath=//a[@data-hover='查看详情']");
		webtest.pause(3000);
	}

	/*
	 * 大图浏览
	 */
	@Test(priority = 4)
	public void test_show_bigphoto() {
		webtest.pause(3000);
//		div[@id='weibo_list']//div[@data-position='one-weibo']//
		webtest.click("xpath=//a[@title='点击查看大图']");
	}

	/*
	 * 上一个图+下一个图
	 */
	@Test(priority = 5)
	public void test_next_bigphoto() throws InterruptedException {
		webtest.mouseToElement("xpath=//img[@class='pswp__img']");
//		下一个
		webtest.click("xpath=//button[@title='Next (arrow right)']");
//		上一个
		webtest.click("xpath=//button[@title='Previous (arrow left)']");

	}

	/*
	 * 右旋转
	 */
	@Test(priority = 6)
	public void test_turn_right() {
		webtest.click("xpath=//button[@title='右旋转']");
	}

	/*
	 * 左旋转
	 */
	@Test(priority = 7)
	public void test_turn_left() {
		webtest.click("xpath=//button[@title='左旋转']");

	}

	/*
	 * 切换全屏
	 */
	@Test(priority = 8)
	public void test_all_bigphoto() throws InterruptedException {
		webtest.click("xpath=//button[@title='切换全屏']");
		webtest.mouseToElement("xpath=//img[@class='pswp__img']");
		webtest.click("xpath=//button[@title='切换全屏']");
	}

	/*
	 * 关闭图片
	 */
	@Test(priority = 9)
	public void test_esc_bigphoto() throws InterruptedException {
		webtest.click("xpath=//button[@title='关闭 (Esc)']");
	}

}
