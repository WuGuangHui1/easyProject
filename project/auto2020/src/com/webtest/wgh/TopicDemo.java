package com.webtest.wgh;

import org.testng.annotations.Test;

public class TopicDemo extends LoginDemo{
//	搜索话题
	@Test(priority=1)  
	public void test41() {
		webtest.click("xpath=//a[@title='微博']");
	    webtest.click("xpath=//a[@title='话题管理']");
	    webtest.click("xpath=//button[text()='搜索']");
        webtest.type("xpath=//input[@class='search-input form-control form-input-width']","你今天真好看");
        webtest.click("xpath=//input[@value='确定']");
	}
//	推荐话题   
    @Test(priority=2)
    public void test42() {
	    webtest.click("xpath=//a[@title='话题管理']");
	    webtest.click("xpath=//*[@id=\"table-data\"]/tbody/tr/td[1]/input");
	    webtest.click("xpath=//button[text()='推荐']");
        webtest.alertAccept();
    }
//    删除话题  
    @Test(priority=3)
    public void test43() {
	    webtest.click("xpath=//a[@title='话题管理']");
	    webtest.click("xpath=//*[@id=\"table-data\"]/tbody/tr/td[1]/input");
	    webtest.click("xpath=//button[text()='仅删除话题']");
        webtest.alertAccept();
    }
    
}
