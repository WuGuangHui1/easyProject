package com.webtest.dataprovider;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NSDataProvider {

//	@DataProvider(name="excel")
//	public  Object[][] getExcelData() throws IOException{
//		return new  ExcelDataProvider().getTestDataByExcel("D:\\demo\\data.xlsx","Sheet1");
//	}

	@DataProvider(name = "txt")
	public Object[][] getTxtData() throws IOException {

		
		return new TxtDataProvider().getTxtUser("C:\\Users\\myx\\Desktop\\a.txt");
//		return new TxtDataProvider().getTxtUser("D:\\demo\\a.txt");
	}

//	@Test(dataProvider = "txt")
	@Test(dataProvider="txt")
	public void getData(String a, String b) {
		System.out.println(a + " " + b);

	}

	@DataProvider(name = "excel")
	public Object[][] getExcelDada() throws IOException {
		return new ExcelDataProvider().getTestDataByExcel("D:\\demo\\data.xlsx", "Sheet1");
	}

	@DataProvider(name = "mysql")
	public Object[][] getMysqlDada() throws IOException {
		return new MysqlDataProvider().getTestDataByMysql("SELECT username, password\r\n" + "FROM `login` ");
	}

	@Test
	public void demosdeot1() {
		System.out.println("a");
	}

//	@Test(dataProvider="mysql")
//	public void testDB(String a,String b) {
//		String list = a+" "+b;
//		
//		System.out.println(list);
//	}
//	
}
