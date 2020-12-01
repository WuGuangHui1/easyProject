package com.webtest.demo;

import org.testng.annotations.Test;

public class Management_Dynamic_Test extends Admin_Login {
	/*
	 * 8,����ȫվ�ö�
	 */
	@Test(priority =1 )
	public void test_top_dynamic() {
		webtest.click("xpath=//a[@title='΢��']");
		webtest.click("xpath=//a[@data-hover='�鿴����']");
		webtest.click("xpath=//a[@data-target='#setTopModal']");
//		�ö�����
		webtest.click("id=content_top");
//		�ö�����
//		webtest.type("name=top_title", "8�������ö�");
//		webtest.pause(6000);
//		�ö�����1
		webtest.type("name=top_dead","1");
		webtest.pause(6000);
//		ȷ��
		webtest.click("xpath=//button[@data-role='weibo_set_top']");
		
//		Assert.assertEquals(, );
	}
	/*
	 * 12������ȫ���ö�+13ȡ��ȫ���ö�
	 */
	@Test(priority =2 )
	public void test_top_conceal_dynamic() {
		webtest.click("xpath=//a[@title='΢��']");
//		div[@id='weibo_42']
		webtest.click("xpath=//a[@data-hover='�鿴����']");
		webtest.click("link=����");
		System.out.println("1111223333");
		webtest.pause(4000);
		webtest.click("xpath=//a[@title='΢��']");
		webtest.pause(4000);
		webtest.click("xpath=//li[@data-role='show_all_top_weibo']");
		webtest.pause(4000);
	}
	/*
	 * 10,ȡ��ȫ���ö�
	 */
	@Test(priority =3 )
	public void test_top_concel1_dynamic() {
		webtest.click("xpath=//a[@title='΢��']");
//		div[@id='weibo_40']
		webtest.click("xpath=//a[@data-hover='�鿴����']");
		webtest.click("xpath=//a[@data-target='#setTopModal']");
//		ȡ���ö�
		webtest.click("link=ȡ���ö�");
		webtest.pause(6000);
	}
	/*
	 * 9,�����ö�
	 */
	@Test(priority =4)
	public void test_top2_dynamic() {
		webtest.click("xpath=//a[@title='΢��']");
//		//div[@id='weibo_40']
		webtest.click("xpath=//a[@data-hover='�鿴����']");
		webtest.click("xpath=//a[@data-target='#setTopModal']");
//		�ö�����
		webtest.click("id=title_top");
//		�ö�����
		webtest.type("name=top_title", "8�������ö�");
//		webtest.pause(6000);
//		�ö�����1
		webtest.type("name=top_dead","1");
		webtest.pause(6000);
//		ȷ��
		webtest.click("xpath=//button[@data-role='weibo_set_top']");
		
//		Assert.assertEquals(, );
	}
	
	/*
	 * 11,ȡ�������ö� 
	 */
	@Test(priority =5)
	public void test_top_concel2_dynamic() {
		webtest.click("xpath=//a[@title='΢��']");
//		��������ö���С����
		webtest.click("partLink=123");
//		ȡ���ö�
		webtest.click("link=ȡ���ö�");
		webtest.pause(6000);
	}
	
	

	/*
	 * 14���޶�̬
	 */
	@Test(priority = 6)
	public void test_like_dynamic() {
		webtest.click("xpath=//a[@title='΢��']");
		webtest.click("xpath=//a[@title='ϲ��']");
	}
	/*
	 * 15ȡ�����޶�̬
	 */
	@Test(dependsOnMethods = {"test_like_dynamic"},priority = 7)
	public void test_unlike_dynamic() {
		webtest.click("xpath=//a[@title='΢��']");
		webtest.click("xpath=//a[@title='ϲ��']");
	}
	
	/*
	 * ���۹���
	 */
	@Test(priority = 8)
	public void test_discuss() {
		webtest.click("xpath=//a[@title='΢��']");
		webtest.click("partLink=˵һ��");
		webtest.type("xpath=//input[@placeholder='���ۣ�Ctrl+Enter��']","��������");
		webtest.Ctrl_Enter();
		webtest.pause(5000);
	}

	/*
	 * ���۵���
	 */
	@Test(priority = 9)
	public void test_like_com() throws InterruptedException {
		webtest.click("xpath=//a[@title='΢��']");
		webtest.mouseToElement("xpath=//div[@class='clearfix']//div[@class='col-xs-11  comment-content']");
		webtest.click("class=text-muted show-always");
		
	}
	/*
	 * ����ȡ������
	 */
	@Test(dependsOnMethods = {"test_like_com"},priority = 10)
	public void test_unlike_com() throws InterruptedException {
		webtest.click("xpath=//a[@title='΢��']");
		webtest.mouseToElement("xpath=//div[@class='clearfix']//div[@class='col-xs-11  comment-content']");
		webtest.click("class=text-muted show-always");
		
	}
	/*
	 * ���ۻظ�
	 */
	@Test(priority = 11)
	public void test_discuss_reply() throws InterruptedException {
		webtest.Ctrl_R();
		webtest.pause(5000);
		webtest.mouseToElement("xpath=//div[@class='clearfix']//div[@class='col-xs-11  comment-content']");
		webtest.click("link=�ظ�");
		webtest.type("xpath=//input[@placeholder='���ۣ�Ctrl+Enter��']","�������ۻظ�");
		webtest.Ctrl_Enter();
	}
	/*
	 * ��������
	 */
	@Test(priority = 12)
	public void test_discuss_hide() {
		webtest.click("xpath=//div[@class=' col-xs-3 operate-color'][@data-role='weibo_comment_btn']");
		webtest.pause(3000);
	}
	
	
	/*
	 * �ٱ���̬
	 */
	@Test(priority = 13)
	public void test_inform_dynamic() {
		webtest.click("xpath=//a[@title='΢��']");
		webtest.click("xpath=//a[@data-hover='�鿴����']");
		webtest.click("xpath=//div[@class='pull-right']//a[@data-title='�ٱ�']");
		webtest.typeAndClear("name=content", "�ٱ�ԭ��1");
		webtest.click("xpath=//input[@type='submit']");
	}
	/*
	 * �ٱ���̬����
	 */
	@Test(priority = 14)
	public void test_inform_com_dynamic() {
		webtest.click("xpath=//a[@title='΢��']");
		webtest.click("xpath=//a[@data-hover='�鿴����']");
		webtest.click("xpath=//div[@class='clearfix text-muted']//a[@data-title='�ٱ�']");
		webtest.typeAndClear("name=content", "�ٱ�����2");
		webtest.click("xpath=//input[@type='submit']");
	}
	
	
	
	/*
	 * ɾ����̬����
	 */
	@Test(priority = 15)
	public void test_del_com_dynamic() {
		webtest.click("xpath=//a[@title='΢��']");
		webtest.click("xpath=//a[@data-hover='�鿴����']");
//		webtest.click("link=ɾ��");
		webtest.click("xpath=//div[@id='comment_14']//a[@data-role='comment_del']");
		
	}
	
	
	/*
	 * ɾ����̬
	 */
	@Test(priority = 16)
	public void test_del_dynamic() {
		webtest.click("xpath=//a[@title='΢��']");
		webtest.click("xpath=//a[@data-hover='�鿴����']");
		webtest.click("partLink=ɾ��");
		webtest.alertAccept();
		webtest.pause(6000);
		
	}
	

}
