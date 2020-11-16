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
//		��ӡ���ܵĲ���������Ŀ
		ITestNGMethod[] methods=this.getAllTestMethods();
		System.out.println("һ��ִ���ˣ�"+methods.length);
		
		
//		�ɹ���/ʧ�ܵĲ����������ƺ���Ŀ
		List<ITestResult> failList=this.getFailedTests();
		int len=failList.size();
		System.out.println("ʧ�ܵĲ���������"+failList.size());
		for(int i=0;i<len;i++) {
			//ITestResult failList.get(i);
		}
	}
	
	@Override
	public void onTestFailure(ITestResult tr) {
		super.onTestFailure(tr);
//		ʧ�ܵĲ�����������
	}

}
