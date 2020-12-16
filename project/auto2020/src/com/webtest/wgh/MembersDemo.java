package com.webtest.wgh;

import org.testng.annotations.Test;

public class MembersDemo extends LoginDemo{
//	会员展示之找人界面展示身份
	@Test(priority=1)
	public void test27() {
		webtest.click("xpath=//a[@title='会员展示']");
	    webtest.click("link=基本设置");
        webtest.drag("class=dd-handle","class=dd-empty");
	    webtest.click("id=submit");
	    webtest.alertAccept();
	}
//	基本设置添加到常用操作
	@Test(priority=2)
	public void test28() {
		webtest.pause(3000);
		webtest.click("xpath=//a[@data-role='addTo']");
	}
//	改变显示人数
    @Test(priority=3)
    public void test29() {
    	webtest.click("xpath=//a[@title='会员展示']");
	    webtest.click("link=基本设置");
	    webtest.click("link=找人页右下侧展示");
	    webtest.typeAndClear("name=USER_SHOW_COUNT3","8");
        webtest.click("id=submit");
        webtest.alertAccept();
    }
//    改变头衔名称
    @Test(priority=4)
    public void test30() {
    	webtest.pause(3000);
	    webtest.click("link=找人页右下侧展示");
	    webtest.typeAndClear("name=USER_SHOW_TITLE3", "随机推荐关注的人");
    	webtest.click("id=submit");
        webtest.alertAccept();
    }
}
