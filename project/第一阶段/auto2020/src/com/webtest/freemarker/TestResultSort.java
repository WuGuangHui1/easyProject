package com.webtest.freemarker;


import org.testng.ITestResult;

public class TestResultSort implements Comparable<ITestResult> {
    private Long order;
    @Override
    public int compareTo(ITestResult arg0) {
        // TODO Auto-generated method stub
        return this.order.compareTo( arg0.getStartMillis());//按test开始时间排序
    }

}