package com.webtest.demo.view;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.webtest.core.BaseTest;
import com.webtest.dataprovider.MysqlDataProvider;

public class Admin_Login extends BaseTest {

	@DataProvider(name="mysql")
	public Object[][] getMysqlDada() throws IOException, ClassNotFoundException{
		return new MysqlDataProvider().getTestDataByMysql("select username, password from loginInfo");
	}
	
	@Test(dataProvider="mysql")
	public void testLogin(String name,String pwd) throws InterruptedException {

		webtest.open("http://localhost:8033//index.php");
		webtest.click("link=登录");
		webtest.type("id=inputEmail", name);
		webtest.type("id=inputPassword", pwd);
		webtest.click("class=login-btn");
		Thread.sleep(2000);
		assertTrue(webtest.isTextPresent("admin"));
	}

}
