package com.webtest.demo;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.webtest.dataprovider.TxtDataProvider;

public class testGetTxtUser {
	@Test
    public void test() throws IOException {
		String filepath="D:\\demo\\2.txt";
		TxtDataProvider tdp=new TxtDataProvider();
		tdp.getTxtUser(filepath);
		//tdp.printResult();
		//tdp.getValue("username");
    }
}
