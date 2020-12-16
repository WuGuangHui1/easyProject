package com.webtest.wgh;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class WeibodynamicDemo extends LoginDemo{
//	
	@Test(priority=1)
	public void test34() {
		webtest.click("xpath=//a[@title='微博']");
	    webtest.click("xpath=//a[@title='微博设置']");
	    webtest.typeAndClear("name=WEIBO_INFO","说说吧");
	    webtest.click("xpath=//button[contains(text(),'确定')]");
	    webtest.alertAccept();
	}
//	改变动态字数限制
    @Test(priority=2)
    public void test35() {
    	webtest.pause(3000);
    	webtest.typeAndClear("xpath=//input[@name='WEIBO_NUM']","150");
    	webtest.click("xpath=//button[contains(text(),'确定')]");
    	webtest.alertAccept();
    	
    }
//    改变动态标记阈值
    @Test(priority=3)
    public void test36() {
    	webtest.pause(3000);
    	JavascriptExecutor js=(JavascriptExecutor)driver;
    	js.executeScript("scrollTo(0,10000)");
    	webtest.typeAndClear("xpath=//input[@name='WEIBO_HOT_COMMENT_NUM']", "10");
    	webtest.click("xpath=//button[contains(text(),'确定')]");
    	webtest.alertAccept();
    	
    }
//    关闭插入图片
    @Test(priority=4)
    public void test37() {
    	webtest.pause(3000);
    	webtest.click("link=动态类型设置");
    	webtest.click("id=id_CAN_IMAGE_0");
    	webtest.click("id=submit");
    	webtest.alertAccept();
    }
//    关闭插入话题
    @Test(priority=5)
    public void test38() {
    	webtest.pause(3000);
    	webtest.click("link=动态类型设置");
    	webtest.click("id=id_CAN_TOPIC_0");
    	webtest.click("id=submit");
    	webtest.alertAccept();
    }
//    评论按时间倒序排序
    @Test(priority=6)
    public void test39() {
    	webtest.pause(3000);
    	webtest.click("link=动态评论设置");
    	webtest.click("id=id_COMMENT_ORDER_0");
    	webtest.click("id=submit");
    	webtest.alertAccept();

    }
//    设置常用话题
    @Test(priority=7)
    public void test40() {
    	webtest.pause(3000);
    	webtest.click("link=话题设置");
    	webtest.typeAndClear("xpath=//input[@name='USE_TOPIC']","hhhhh");
    	webtest.click("id=submit");
    	webtest.alertAccept();
    }
}
