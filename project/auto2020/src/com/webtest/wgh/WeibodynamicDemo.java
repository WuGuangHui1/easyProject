package com.webtest.wgh;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class WeibodynamicDemo extends LoginDemo{
//	
	@Test(priority=1)
	public void test34() {
		webtest.click("xpath=//a[@title='΢��']");
	    webtest.click("xpath=//a[@title='΢������']");
	    webtest.typeAndClear("name=WEIBO_INFO","˵˵��");
	    webtest.click("xpath=//button[contains(text(),'ȷ��')]");
	    webtest.alertAccept();
	}
//	�ı䶯̬��������
    @Test(priority=2)
    public void test35() {
    	webtest.pause(3000);
    	webtest.typeAndClear("xpath=//input[@name='WEIBO_NUM']","150");
    	webtest.click("xpath=//button[contains(text(),'ȷ��')]");
    	webtest.alertAccept();
    	
    }
//    �ı䶯̬�����ֵ
    @Test(priority=3)
    public void test36() {
    	webtest.pause(3000);
    	JavascriptExecutor js=(JavascriptExecutor)driver;
    	js.executeScript("scrollTo(0,10000)");
    	webtest.typeAndClear("xpath=//input[@name='WEIBO_HOT_COMMENT_NUM']", "10");
    	webtest.click("xpath=//button[contains(text(),'ȷ��')]");
    	webtest.alertAccept();
    	
    }
//    �رղ���ͼƬ
    @Test(priority=4)
    public void test37() {
    	webtest.pause(3000);
    	webtest.click("link=��̬��������");
    	webtest.click("id=id_CAN_IMAGE_0");
    	webtest.click("id=submit");
    	webtest.alertAccept();
    }
//    �رղ��뻰��
    @Test(priority=5)
    public void test38() {
    	webtest.pause(3000);
    	webtest.click("link=��̬��������");
    	webtest.click("id=id_CAN_TOPIC_0");
    	webtest.click("id=submit");
    	webtest.alertAccept();
    }
//    ���۰�ʱ�䵹������
    @Test(priority=6)
    public void test39() {
    	webtest.pause(3000);
    	webtest.click("link=��̬��������");
    	webtest.click("id=id_COMMENT_ORDER_0");
    	webtest.click("id=submit");
    	webtest.alertAccept();

    }
//    ���ó��û���
    @Test(priority=7)
    public void test40() {
    	webtest.pause(3000);
    	webtest.click("link=��������");
    	webtest.typeAndClear("xpath=//input[@name='USE_TOPIC']","hhhhh");
    	webtest.click("id=submit");
    	webtest.alertAccept();
    }
}
