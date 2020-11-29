package com.webtest.dataprovider;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NSDataProvider {

	
//	@DataProvider(name="excel")
//	public  Object[][] getTxtData() throws IOException{
//		return new  TxtDataProvider().getTxtUser("D:\\demo\\dataexcel.xls");
//	}
//	@Test(dataProvider="txt")
//	public void getData(String a,String b) {
//		System.out.println(a+" "+b);
//		
//	}
	@DataProvider(name="excel")
	public Object[][] getExcelDada() throws IOException{
		return new ExcelDataProvider().getTestDataByExcel("D:\\demo\\testexcel2.xls","sheet1");
	}
	@Test(dataProvider="excel")
	public void getExcelData(String user, String pwd) {
		System.out.println(user+" "+pwd);
	}
//	@DataProvider(name="mysql")
//	public Object[][] getMysqlDada() throws IOException{
//		return new MysqlDataProvider().getTestDataByMysql("SELECT name,password FROM login ");
//	}
//	
//	@Test(dataProvider="mysql")
//	public void testDB(String a,String b) {
//		System.out.println(a+" "+b);
//	}
	
}
