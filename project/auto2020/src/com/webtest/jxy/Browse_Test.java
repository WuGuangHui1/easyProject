package com.webtest.jxy;

import org.testng.annotations.Test;

/**
 * 
 * @author �����
 *
 */

public class Browse_Test extends Admin_Login {
	/*
	 * ȫվ��̬�µ�ȫ��
	 */
	@Test(priority = 1)
	public void test_show_all() {
		webtest.click("xpath=//a[@title='΢��']");
//		���ȫվ��̬
		webtest.click("id=all");
		webtest.click("xpath=//a[@id='all_']//p[@class='mg-bt0']");

	}

	/*
	 * ȫվ��̬�µ�ͼƬ
	 */
	@Test(priority = 2)
	public void test_show_photo() {
		webtest.click("xpath=//a[@title='΢��']");
//		���ȫվ��̬
		webtest.click("id=all");
//		ȫ��
		webtest.click("xpath=//a[@id='image']//p[@class='mg-bt0']");
	}

	/*
	 * �鿴����
	 */
	@Test(priority = 3)
	public void test_show_time() throws InterruptedException {
		webtest.mouseToElement("xpath=//a[@data-hover='�鿴����']");
		webtest.pause(3000);
	}

	/*
	 * ��ͼ���
	 */
	@Test(priority = 4)
	public void test_show_bigphoto() {
		webtest.pause(3000);
//		div[@id='weibo_list']//div[@data-position='one-weibo']//
		webtest.click("xpath=//a[@title='����鿴��ͼ']");
	}

	/*
	 * ��һ��ͼ+��һ��ͼ
	 */
	@Test(priority = 5)
	public void test_next_bigphoto() throws InterruptedException {
		webtest.mouseToElement("xpath=//img[@class='pswp__img']");
//		��һ��
		webtest.click("xpath=//button[@title='Next (arrow right)']");
//		��һ��
		webtest.click("xpath=//button[@title='Previous (arrow left)']");

	}

	/*
	 * ����ת
	 */
	@Test(priority = 6)
	public void test_turn_right() {
		webtest.click("xpath=//button[@title='����ת']");
	}

	/*
	 * ����ת
	 */
	@Test(priority = 7)
	public void test_turn_left() {
		webtest.click("xpath=//button[@title='����ת']");

	}

	/*
	 * �л�ȫ��
	 */
	@Test(priority = 8)
	public void test_all_bigphoto() throws InterruptedException {
		webtest.click("xpath=//button[@title='�л�ȫ��']");
		webtest.mouseToElement("xpath=//img[@class='pswp__img']");
		webtest.click("xpath=//button[@title='�л�ȫ��']");
	}

	/*
	 * �ر�ͼƬ
	 */
	@Test(priority = 9)
	public void test_esc_bigphoto() throws InterruptedException {
		webtest.click("xpath=//button[@title='�ر� (Esc)']");
	}

}
