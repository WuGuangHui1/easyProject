 package com.webtest.dataprovider;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class OrigionNSDataProvider {

	@DataProvider(name="txt")
	public  Object[][] getTxtData() throws IOException{
		System.out.println(new TxtDataProvider().getTxtUser("D:\\demo\\test1116.txt"));
		return new  TxtDataProvider().getTxtUser("D:\\demo\\test1116.txt");
	}
	@DataProvider(name="movie")
	public  Object[][] getMovieData() throws IOException{
		return new  OrigionExcelDataProvider().getTestDataByExcel("data/movie.xlxs","Sheet1");
	}
//	@Test(dataProvider="txt")
//	能测试通过的唯一解决办法就是：保存txt文件的时候，格式选择UTF-8的编码格式，
	//每一个和运行相关的代码文件的属性配置里也要统一为utf-8的格式；问题是只读取文件中的第2行???待解决
	public void getData(String a,String b) {
		System.out.println(a+" "+b);
	}

	@DataProvider(name="excel")
	public Object[][] getExcelDada() throws IOException{
//		return new ExcelDataProvider().getTestDataByExcel("data/user.xlsx","Sheet1");
		return new OrigionExcelDataProvider().getTestDataByExcel("D:\\demo\\dataexcel.xlsx","Sheet1");
	}
	
	@Test(dataProvider="excel")
	public void getExcelData(String user, String pwd) {
		System.out.println(user+" "+pwd);
	}
	
	@DataProvider(name="mysql")
	public Object[][] getMysqlDada() throws IOException, ClassNotFoundException{
//		return new OriginMysqlDataProvider().getTestDataByMysql("SELECT sid, sname, spwd\r\n" + 
//				"FROM `student` ");
//		return new MysqlDataProvider().getTestDataByMysql("SELECT sid, sname, spwd, ssex from student");
		return new MysqlDataProvider().getTestDataByMysql("SELECT username,password from loginInfo");
	}
	
//	@Test(dataProvider="mysql")
	public void testDB(String name,String pwd) {
		System.out.println(name+" "+pwd);
	}
	
}
