package com.webtest.wgh;

import org.testng.annotations.Test;

public class IntoFrontDemo extends LoginDemo{
//	����ǰ̨
	@Test(priority=1)
	public void test23() throws InterruptedException {
		webtest.click("class=icon-copy");
	}

}
