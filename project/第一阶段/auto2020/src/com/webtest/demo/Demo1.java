package com.webtest.demo;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import com.webtest.listen.JavaMailTestListener1;


@Listeners(JavaMailTestListener1.class)
public class Demo1{
	@Test
    public void test1() {
        Assert.assertEquals(1, 1);
    }
	@Test
    public void test2() {
        Assert.assertEquals(2, 1);
    }
	@Test
    public void test3() {
        Assert.assertEquals(3, 1);
    }
	@Test
    public void test4() {
        Assert.assertEquals(2, 2);
    }
	@Test
    public void test5() throws IOException {
        Assert.assertEquals(4, 1);
        //ExcelDataProvider e=new ExcelDataProvider();
       // Object[][] results=e.getTestDataByExcel("conf/1.xlsx","Sheet1");
    }
	
	
}