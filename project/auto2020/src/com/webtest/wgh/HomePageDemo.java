package com.webtest.wgh;

import org.testng.annotations.Test;

public class HomePageDemo extends LoginDemo{
//	�ı���վ��ҳ���͸�Ϊ��¼ҳ
	@Test(priority=1)
	public void test26() {
		webtest.click("xpath=//a[@title='��վ����ҳ']");
		webtest.click("link=��������");
		webtest.click("id=id_HOME_INDEX_TYPE_login");
		webtest.click("id=submit");
		webtest.alertAccept();
	}
	
}
