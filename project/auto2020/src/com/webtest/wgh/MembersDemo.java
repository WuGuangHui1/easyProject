package com.webtest.wgh;

import org.testng.annotations.Test;

public class MembersDemo extends LoginDemo{
//	��Աչʾ֮���˽���չʾ���
	@Test(priority=1)
	public void test27() {
		webtest.click("xpath=//a[@title='��Աչʾ']");
	    webtest.click("link=��������");
        webtest.drag("class=dd-handle","class=dd-empty");
	    webtest.click("id=submit");
	    webtest.alertAccept();
	}
//	����������ӵ����ò���
	@Test(priority=2)
	public void test28() {
		webtest.pause(3000);
		webtest.click("xpath=//a[@data-role='addTo']");
	}
//	�ı���ʾ����
    @Test(priority=3)
    public void test29() {
    	webtest.click("xpath=//a[@title='��Աչʾ']");
	    webtest.click("link=��������");
	    webtest.click("link=����ҳ���²�չʾ");
	    webtest.typeAndClear("name=USER_SHOW_COUNT3","8");
        webtest.click("id=submit");
        webtest.alertAccept();
    }
//    �ı�ͷ������
    @Test(priority=4)
    public void test30() {
    	webtest.pause(3000);
	    webtest.click("link=����ҳ���²�չʾ");
	    webtest.typeAndClear("name=USER_SHOW_TITLE3", "����Ƽ���ע����");
    	webtest.click("id=submit");
        webtest.alertAccept();
    }
}
