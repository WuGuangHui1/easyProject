package com.webtest.otherdemo;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


//@Listeners(GenerateReporter.class)
public class FreemarkerDemo{
	@Test
    public void test1() {
        Assert.assertEquals(3, 1);
    }
	@Test
    public void test2() {
        Assert.assertEquals(2, 2);
    }
	@Test
    public void test3() {
        Assert.assertEquals(3, 3);
    }
	@Test
    public void test4() {
        Assert.assertEquals(2, 2);
    }
	@Test
    public void test5() {
        Assert.assertEquals(1, 1);
    }
	
}
