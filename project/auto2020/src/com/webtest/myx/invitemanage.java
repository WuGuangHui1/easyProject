package com.webtest.myx;

import org.testng.annotations.Test;

public class invitemanage extends LoginDemo{
	//����������
			@Test(priority=5)
			public void test75() throws InterruptedException {
				webtest.pause(3000);
				webtest.mouseToElement("xpath=//i[@class='icon-laptop']");
				webtest.click("link=���������");
				webtest.click("xpath=//div[@class='fl']/button[2]");
				webtest.click("xpath=//a[text()='����']");
				Thread.sleep(1000);
			}
			//ɾ��������
			@Test(priority=6)
			public void test76() throws InterruptedException {
				webtest.pause(3000);
				webtest.mouseToElement("xpath=//i[@class='icon-laptop']");
				webtest.click("link=���������");
				webtest.click("xpath=//tbody/tr[1]/td[1]/input");
				Thread.sleep(1000);
				webtest.click("xpath=//div[@class='fl']/button[1]");
				webtest.alertAccept();
				Thread.sleep(1000);
			}
			//����������
			@Test(priority=7)
			public void test80() throws InterruptedException {
				webtest.pause(3000);
				webtest.mouseToElement("xpath=//i[@class='icon-laptop']");
				webtest.click("link=���������");
				webtest.click("xpath=//div[@class='fl']/button[6]");
				Thread.sleep(1000);
			
			}
}
