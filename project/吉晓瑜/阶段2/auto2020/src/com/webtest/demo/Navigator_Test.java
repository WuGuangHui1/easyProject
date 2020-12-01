package com.webtest.demo;

import org.testng.annotations.Test;

public class Navigator_Test extends Admin_Login {
	/*
	 * ǩ������
	 */
	@Test(priority = 1)
	public void test_signIn_date() {
		webtest.click("xpath=//a[@title='΢��']");
		webtest.click("class=checking");
	}

	/*
	 * ǩ��
	 */
	@Test(priority = 2)
	public void test_signIn() {
		webtest.click("xpath=//a[@title='΢��']");
		webtest.click("class=checking");
		boolean f = webtest.isChecked("link=ǩ��");
		System.out.println(f);
//		webtest.click("link=ǩ��");
		webtest.click("class=btn-sign show-check");

	}

	/*
	 * ���а�
	 */
	@Test(priority = 3)
	public void test_rank() {
		webtest.click("xpath=//a[@title='΢��']");
		webtest.click("class=pc6");

	}

	/*
	 * �ҵĹ�ע
	 */
	@Test(priority = 4)
	public void test_attention() {
		webtest.click("xpath=//a[@title='΢��']");
		webtest.click("id=concerned");
	}

	/*
	 * ���Ŷ�̬
	 */
	@Test(priority = 5)
	public void test_hot_news() {
		webtest.click("id=hot");

	}

	/*
	 * �ҵ�ϲ��
	 */
	@Test(priority = 6)
	public void test_like_news() {
		webtest.click("id=fav");

	}

	/*
	 * �鿴��ҳ
	 */
	@Test(priority = 7)
	public void test_home_page() {
		webtest.click("xpath=//a[@title='΢��']");
		webtest.click("xpath=//div[@class='op-tb op-top']//a[@class='user_name']");
		webtest.pause(3000);

	}

	/*
	 * �鿴��ҳ(���Ͽ�Ƭ��
	 */
	@Test(priority = 8)
	public void test_small_page() throws InterruptedException {
		webtest.click("xpath=//a[@title='΢��']");
		webtest.mouseToElement("xpath=//div[@class='content-head']//img[@class='avatar-img']");
		webtest.pause(3000);

	}

	/*
	 * ��ݱ�ǩ����
	 */
	@Test(priority = 9)
	public void test_find_identity() throws InterruptedException {
		webtest.click("xpath=//a[@title='��Աչʾ']");
		webtest.mouseToElement("class=zhanzhang");
		webtest.click("link=������");
		webtest.pause(3000);
	}

	/*
	 * ������ǩ����
	 */
	@Test(priority = 10)
	public void test_find_area() {
		webtest.click("xpath=//a[@title='��Աչʾ']");
		webtest.click("id=tab_area");
		webtest.click("partLink=������");
		webtest.click("partLink=������");
		webtest.click("partLink=������");
		webtest.pause(3000);
	}

	/*
	 * ��ע�ˣ���������
	 */
	@Test(priority = 11)
	public void test_attention_find1() throws InterruptedException {
		webtest.click("xpath=//a[@title='��Աչʾ']");
		webtest.mouseToElement("class=zhanzhang");
		webtest.click("link=������");
		webtest.pause(3000);
		webtest.click("xpath=//button[@class='box']");
		webtest.pause(3000);
	}

	/*
	 * ��ע�ˣ�ȫվ��̬��
	 */
	@Test(priority = 12)
	public void test_attention_find2() {
		webtest.click("xpath=//a[@title='΢��']");
		webtest.click("xpath=//div[@class='op-tb op-top']//a[@class='user_name']");
		webtest.pause(3000);
		webtest.click("xpath=//div[@class='col-xs-4 bt-group']//button[@class='btn btn-primary']");
		webtest.pause(3000);
	}

	/*
	 * ȡ����ע
	 */
	@Test(priority = 13)
	public void test_cancel_attention() {
		webtest.click("xpath=//a[@title='��Աչʾ']");
		webtest.scrollFind2("xpath=//button[text()='�ѹ�ע']");
		webtest.pause(3000);
		boolean b = webtest.isElementPresent("xpath=//button[contains(text(),'�ѹ�ע')]");
		System.out.println(b);
		webtest.findClick("xpath=//button[contains(text(),'�ѹ�ע')]");
		webtest.pause(6000);
	}
	/*
	 * ����
	 */
	@Test(priority = 14)
	public void test_chat() {
		webtest.click("xpath=//a[@title='��Աչʾ']");
		webtest.click("xpath=//div[@class='sns-star-user']//a");
		webtest.click("xpath=//div[@class='col-xs-4 bt-group']//button[@class='btn btn-default']");
		webtest.typeAndClear("id=chat_content", "���Է������죺hi");
		webtest.click("xpath=//button[@onclick='talker.post_message()']");
		webtest.pause(5000);
		webtest.click("class=icon-off");
		webtest.click("class=icon-minus");
		webtest.pause(5000);
		
	}
	/*
	 * ����������
	 */
	@Test(priority = 15)
	public void test_invite() {
		webtest.click("xpath=//a[@title='΢��']");
		webtest.click("link=��������");
		webtest.click("link=����������");
		webtest.click("link=�һ�����");
		webtest.click("link=�һ�");
		webtest.pause(3000);
		webtest.click("link=����������");
		webtest.enter();
		webtest.pause(2000);
		webtest.enter();
		webtest.enter();
//		webtest.alertAccept();
		webtest.pause(6000);

	}
}
