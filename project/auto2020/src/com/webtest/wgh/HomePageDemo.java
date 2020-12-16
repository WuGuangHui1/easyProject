package com.webtest.wgh;

import org.testng.annotations.Test;

public class HomePageDemo extends LoginDemo{
//	改变网站首页类型改为登录页
	@Test(priority=1)
	public void test26() {
		webtest.click("xpath=//a[@title='网站的主页']");
		webtest.click("link=基本设置");
		webtest.click("id=id_HOME_INDEX_TYPE_login");
		webtest.click("id=submit");
		webtest.alertAccept();
	}
	
}
