package com.webtest.demo;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class FrontendTest extends BaseTest {
	@Test
	public void testlogin() {
		webtest.open(" ");
		webtest.click("link=µÇÂ¼");
		
		webtest.type("name=username", "admin");
		webtest.type("name=password", "123456");
		webtest.click("xpath=//button[@type='submit']");
//		assertTrue(webtest.isTextPresent("ÍË³ö"));
		Assert.assertTrue(webtest.isTextPresent("ÍË³ö"));
	}
}
