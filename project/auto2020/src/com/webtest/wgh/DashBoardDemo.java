package com.webtest.wgh;

import org.testng.annotations.Test;

public class DashBoardDemo extends LoginDemo{
//	仪表盘图标设置
//	@Test(priority=3)
//	public void test3() throws InterruptedException {
//	    webtest.mouseToElement("xpath=//div[@class='tile-box']");
//	    webtest.click("class=icon-settings");
//	    webtest.click("xpath=//a[@class='icon-selector']");
//	    webtest.click("xpath=//span[@class='icon-diamond']");
//	    webtest.click("xpath=//button[@data-role='saveTileSetting']");
//	}
//	仪表盘背景颜色设置     
//	@Test(priority=4)
//	public void test4() throws InterruptedException {
//		webtest.mouseToElement("xpath=//a[@data-hover='dropdown']");
//	    webtest.click("link=仪表盘");
//	    webtest.mouseToElement("xpath=//div[@class='tile-box']");
//	    webtest.click("class=icon-settings");
//	    webtest.click("xpath=//div[@title='选择图标背景色']");
//	    webtest.click("id=00ff33");
//	    webtest.click("xpath=//button[@data-role='saveTileSetting']");
//	}
//仪表盘的允许身份访问
	@Test(priority=5)
	public void test5() throws InterruptedException {
	    webtest.click("xpath=//*[@id=\"tile_9\"]/a/span");
	}
//	仪表盘的用户管理删除
	@Test(priority=6) 
	public void test6() throws InterruptedException {
		webtest.mouseToElement("xpath=//a[@data-hover='dropdown']");
	    webtest.click("link=仪表盘");
	    webtest.mouseToElement("xpath=//*[@id=\"tile_11\"]/div");
	    webtest.click("xpath=//*[@id=\"tile_11\"]/div/div[3]/a/i");
	    webtest.alertAccept();
	}

}
