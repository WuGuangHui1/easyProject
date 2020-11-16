package com.webtest.core;

import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class WebTestListener extends TestListenerAdapter {
	
	
	@Override
	public void onFinish(ITestContext testContext) {
		// TODO Auto-generated method stub
		super.onFinish(testContext);
//		打印出总的测试用例数目
		ITestNGMethod[] methods=this.getAllTestMethods();
		System.out.println("一共执行了："+methods.length);
		
		
//		成功的/失败的测试用例名称和数目
		List<ITestResult> failList=this.getFailedTests();
		int len=failList.size();
		System.out.println("失败的测试用例："+failList.size());
		for(int i=0;i<len;i++) {
			//ITestResult failList.get(i);
		}
	}
	
	@Override
	public void onTestFailure(ITestResult tr) {
		super.onTestFailure(tr);
//		失败的测试用例截屏
	}

}
