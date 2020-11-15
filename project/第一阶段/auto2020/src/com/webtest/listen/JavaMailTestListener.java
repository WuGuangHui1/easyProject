package com.webtest.listen;

import java.io.IOException;
import java.util.List;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class JavaMailTestListener extends TestListenerAdapter {
	
	
	@Override
	public void onFinish(ITestContext testContext) {
		// TODO Auto-generated method stub
		super.onFinish(testContext);
         
		ITestNGMethod[] methods = this.getAllTestMethods();
		System.out.println("一共执行了："+methods.length);
		List <ITestResult> faillist=this.getFailedTests();
		int len = faillist.size();
		System.out.println("失败的测试用例"+len+"次");
		String text="";
		for(int i=0;i<len;i++) {
			ITestResult tr=faillist.get(i);
			System.out.println(tr.getInstanceName()+":"+tr.getName()+"失败了"+"\n");
			text+=tr.getInstanceName()+":"+tr.getName()+"失败了"+"\n";
			
		}
		System.out.println(text);
		MailUtil send = new MailUtil();
		try {
			send.mail(text);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void onTestFailure(ITestResult tr) {
		super.onTestFailure(tr);
//		失败的测试用例截屏
	}

}