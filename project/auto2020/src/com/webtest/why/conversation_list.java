package com.webtest.why;
import org.testng.annotations.Test;

import com.webtest.demo.Admin_Login;
/**
 * 
 * @author 王慧颖
 *
 */
public class conversation_list extends Admin_Login{

	//1、添加到常用操作
	@Test(priority=1)
	public void why1test() throws InterruptedException {
		webtest.pause(2000);
		webtest.mouseToElement("xpath=//i[@class='icon-windows']");
		webtest.click("link=会话列表");
		webtest.click("class=icon-plus");
	}
	////2、能否正常刷新页面
	@Test(priority=2)
	public void why2test() throws InterruptedException {
		webtest.pause(2000);
		webtest.mouseToElement("xpath=//i[@class='icon-windows']");
		webtest.click("link=会话列表");
		webtest.click("xpath=//button[@class='btn btn-default ajax-post btn btn-default']");
		webtest.alertAccept();
		webtest.pause(2000);
	}
	////3、能否选中全列
	@Test(priority=3)
	public void why3test() throws InterruptedException {
		webtest.pause(2000);
		webtest.mouseToElement("xpath=//i[@class='icon-windows']");
		webtest.click("link=会话列表");
		webtest.click("class=check-all");
		webtest.pause(2000);
	}
	////4、能否取消全选
	@Test(priority=4)
	public void why4test() throws InterruptedException {
		webtest.pause(2000);
		webtest.mouseToElement("xpath=//i[@class='icon-windows']");
		webtest.click("link=会话列表");
		webtest.click("class=check-all");
		webtest.click("class=check-all");
		webtest.pause(2000);
	}
	//5、能否选中单个一行
	@Test(priority=5)
	public void why5test() throws InterruptedException {
		webtest.pause(2000);
		webtest.mouseToElement("xpath=//i[@class='icon-windows']");
		webtest.click("link=会话列表");
		webtest.click("xpath=//*[@id=\"table-data\"]/tbody/tr[1]/td[1]/input");
		webtest.pause(2000);
	}
	//6、能否取消选中某一行
	@Test(priority=6)
	public void why6test() throws InterruptedException {
		webtest.pause(2000);
		webtest.mouseToElement("xpath=//i[@class='icon-windows']");
		webtest.click("link=会话列表");
		webtest.click("xpath=//*[@id=\"table-data\"]/tbody/tr[1]/td[1]/input");
		webtest.pause(2000);
	}
	//7、能否查看图标大图
	@Test(priority=7)
	public void why7test() throws InterruptedException {
		webtest.pause(2000);
		webtest.mouseToElement("xpath=//i[@class='icon-windows']");
		webtest.click("link=会话列表");
		webtest.click("xpath=//*[@id=\"table-data\"]/tbody/tr[1]/td[9]/div/a/img");
		webtest.pause(2000);
	}
	//8、能否查看详细信息
	@Test(priority=8)
	public void why8test() throws InterruptedException {
		webtest.pause(2000);
		webtest.mouseToElement("xpath=//i[@class='icon-windows']");
		webtest.click("link=会话列表");
		webtest.doubleClick("xpath=//td[text()='Common_system【默认】']");
		//webtest.click("xpath=/html/body/div[5]/span/a");
		webtest.pause(2000);
	}
}
	

