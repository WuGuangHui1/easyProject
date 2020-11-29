package com.smoketest.testcases.view;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.webtest.core.BaseTest;
import com.webtest.dataprovider.MysqlDataProvider;
import com.webtest.dataprovider.OrigionNSDataProvider;

public class FrontTest extends BaseTest {

//	@DataProvider(name="mysql")
	public Object[][] getMysqlDada() throws IOException, ClassNotFoundException{
		return new MysqlDataProvider().getTestDataByMysql("select username, password from loginInfo");
	}
	
//	@Test(dataProvider="mysql",priority=2)
	public void testLogin(String name,String pwd) throws InterruptedException {

		webtest.open("http://localhost:8033//index.php");
		webtest.click("link=登录");
		webtest.type("id=inputEmail", name);
		webtest.type("id=inputPassword", pwd);
		webtest.click("class=login-btn");
		Thread.sleep(2000);
		assertTrue(webtest.isTextPresent("admin"));
	}
	
//	@Test(priority=1)
	public void testRegister() throws InterruptedException {
		webtest.open("http://localhost:8033//index.php");
		webtest.click("link=注册");
		Thread.sleep(2000);
		webtest.type("xpath=//input[@id='email']","956998040@qq.com");
		Thread.sleep(2000);
		webtest.type("xpath=//input[@id='nickname']","mars_08042");
		Thread.sleep(2000);
		webtest.type("xpath=//input[@id='inputPassword']","123456Dxy");
//		Thread.sleep(2000);
		webtest.click("xpath=//div[@class='tab-content']/div[2]/button");
		Thread.sleep(4000);
//		assertTrue(webtest.isTextPresent("感谢您注册 OpenSNS v5开源社群系统 ，希望你玩的愉快！"));
//		Thread.sleep(2000);
		webtest.click("link=前往首页");
		Thread.sleep(4000);
		//已经注册的账户信息：mars_tester@126.com   mars_08041   pwd都是123456Dxy
	}
	@Test(dataProvider="excel" ,dataProviderClass=OrigionNSDataProvider.class)
	public void test2(String usernamemail,String nickname,String password) throws InterruptedException {
		webtest.open("http://localhost:8033//index.php");
		webtest.click("link=注册");
		Thread.sleep(2000);
		webtest.type("name=username", usernamemail);
		webtest.type("name=nickname", nickname);
		webtest.type("name=password", password);
		webtest.click("xpath=//button[@type='submit']");
		System.out.println(usernamemail+nickname+" "+password);
	
		
	}

}
