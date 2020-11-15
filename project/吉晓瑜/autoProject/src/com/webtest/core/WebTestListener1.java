package com.webtest.core;

import java.io.IOException;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class WebTestListener1 extends TestListenerAdapter {

	@Override
	public void onFinish(ITestContext testContext) {
		// TODO Auto-generated method stub
//		super.onFinish(testContext);
//		��ӡ���ܵĲ���������Ŀ
		ITestNGMethod[] methods = this.getAllTestMethods();
		System.out.println("-��ִ����: " + methods.length);
//		�ɹ���ʧ�ܵĲ����������ƺ���Ŀ
		List<ITestResult> failList = this.getFailedTests();
		int len = failList.size();
		System.out.println("ʧ�ܵĲ�������: " + len);
		for (int i = 0; i < len; i++) {
			ITestResult tr = failList.get(i);
			System.out.println(tr.getInstanceName() + ":" + tr.getName() + "ʧ����");

		}
		List<ITestResult> failList2 = this.getPassedTests();
		int len2 = failList.size();
		System.out.println("�ɹ��Ĳ�������: " + len2);
		for (int i = 0; i < len2; i++) {
			ITestResult tr = failList2.get(i);
			System.out.println(tr.getInstanceName() + ":" + tr.getName() + "�ɹ���");

		}

//		�����ʼ�
	}

//	@Override
//	public void onTestFailure(ITestResult tr) {
//		// TODO Auto-generated method stub
////		super.onTestFailure(tr);
////		ʧ�ܵĲ�����������
//
//		BaseTest tb = (BaseTest) tr.getInstance();
//		SeleniumScreenShot screenShot = new SeleniumScreenShot(tb.getDriver());
//		try {
//			screenShot.screenShot();
//			System.out.println("onTestFailure"+tr.getInstanceName() + ":" + tr.getName() + "ʧ����");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}

}
