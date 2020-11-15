package com.webtest.demo;

import java.io.IOException;

import org.testng.annotations.Test;

import com.webtest.dataprovider.ExcelDataProvider;

public class TestDemo {
	@Test
	public void test1() throws IOException {
		Object[][] result=new ExcelDataProvider().getTestDataByExcel("C:\\Users\\dell\\Desktop\\1.xlsx", "sheet1");
//		System.out.println(result.length);
//	    for(int i=0;i<result.length;i++) {
//	    	for(int j=0;j<result[i].length;j++) {
//	    		System.out.println(i+j+result[i][j].toString());
//	    	}
//	    }
	}

}
