package com.webtest.why;
import org.testng.annotations.Test;

import com.webtest.demo.Admin_Login;
/**
 * 
 * @author ����ӱ
 *
 */
public class conversation_list extends Admin_Login{

	//1����ӵ����ò���
	@Test(priority=1)
	public void why1test() throws InterruptedException {
		webtest.pause(2000);
		webtest.mouseToElement("xpath=//i[@class='icon-windows']");
		webtest.click("link=�Ự�б�");
		webtest.click("class=icon-plus");
	}
	////2���ܷ�����ˢ��ҳ��
	@Test(priority=2)
	public void why2test() throws InterruptedException {
		webtest.pause(2000);
		webtest.mouseToElement("xpath=//i[@class='icon-windows']");
		webtest.click("link=�Ự�б�");
		webtest.click("xpath=//button[@class='btn btn-default ajax-post btn btn-default']");
		webtest.alertAccept();
		webtest.pause(2000);
	}
	////3���ܷ�ѡ��ȫ��
	@Test(priority=3)
	public void why3test() throws InterruptedException {
		webtest.pause(2000);
		webtest.mouseToElement("xpath=//i[@class='icon-windows']");
		webtest.click("link=�Ự�б�");
		webtest.click("class=check-all");
		webtest.pause(2000);
	}
	////4���ܷ�ȡ��ȫѡ
	@Test(priority=4)
	public void why4test() throws InterruptedException {
		webtest.pause(2000);
		webtest.mouseToElement("xpath=//i[@class='icon-windows']");
		webtest.click("link=�Ự�б�");
		webtest.click("class=check-all");
		webtest.click("class=check-all");
		webtest.pause(2000);
	}
	//5���ܷ�ѡ�е���һ��
	@Test(priority=5)
	public void why5test() throws InterruptedException {
		webtest.pause(2000);
		webtest.mouseToElement("xpath=//i[@class='icon-windows']");
		webtest.click("link=�Ự�б�");
		webtest.click("xpath=//*[@id=\"table-data\"]/tbody/tr[1]/td[1]/input");
		webtest.pause(2000);
	}
	//6���ܷ�ȡ��ѡ��ĳһ��
	@Test(priority=6)
	public void why6test() throws InterruptedException {
		webtest.pause(2000);
		webtest.mouseToElement("xpath=//i[@class='icon-windows']");
		webtest.click("link=�Ự�б�");
		webtest.click("xpath=//*[@id=\"table-data\"]/tbody/tr[1]/td[1]/input");
		webtest.pause(2000);
	}
	//7���ܷ�鿴ͼ���ͼ
	@Test(priority=7)
	public void why7test() throws InterruptedException {
		webtest.pause(2000);
		webtest.mouseToElement("xpath=//i[@class='icon-windows']");
		webtest.click("link=�Ự�б�");
		webtest.click("xpath=//*[@id=\"table-data\"]/tbody/tr[1]/td[9]/div/a/img");
		webtest.pause(2000);
	}
	//8���ܷ�鿴��ϸ��Ϣ
	@Test(priority=8)
	public void why8test() throws InterruptedException {
		webtest.pause(2000);
		webtest.mouseToElement("xpath=//i[@class='icon-windows']");
		webtest.click("link=�Ự�б�");
		webtest.doubleClick("xpath=//td[text()='Common_system��Ĭ�ϡ�']");
		//webtest.click("xpath=/html/body/div[5]/span/a");
		webtest.pause(2000);
	}
}
	

