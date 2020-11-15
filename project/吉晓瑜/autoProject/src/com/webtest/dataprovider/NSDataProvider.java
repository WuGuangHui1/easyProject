package com.webtest.dataprovider;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NSDataProvider {

	static String file1="E:\\demo\\tools\\dataProvider\\1.xls";
	static String file2="E:\\demo\\tools\\dataProvider\\1.txt";
	static String sheet="Sheet2";

	@DataProvider(name="laksdjf")
	public  Object[][] getTxtData() throws IOException{
		return new  TxtDataProvider().getTxtUser(file2);
	}
	@Test(dataProvider="txt")
	public void getData(String a,String b) {
		System.out.println(a+" "+b);
		
	}

	@DataProvider(name="excel")
	public Object[][] getExcelDada() throws IOException{
		return new ExcelDataProvider().getTestDataByExcel(file1,sheet);
	}
	
	@DataProvider(name="mysql")
	public Object[][] getMysqlDada() throws IOException{
		return new MysqlDataProvider().getTestDataByMysql("SELECT filmname, petname\r\n" + 
				"FROM `mm_movie` ");
	}
	
//	@Test(dataProvider="mysql")
//	public void testDB(String a,String b) {
//		System.out.println(a+" "+b);
//	}
	
	
}
