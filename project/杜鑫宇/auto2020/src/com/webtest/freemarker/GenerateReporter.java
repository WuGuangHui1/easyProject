package com.webtest.freemarker;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import com.webtest.core.SendEmail;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

public class GenerateReporter implements IReporter {
	@Override
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		// TODO Auto-generated method stub
		try {
			// freemaker鐨勯厤缃�
			Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);
			cfg.setClassForTemplateLoading(this.getClass(), "/templates");
			cfg.setDefaultEncoding("UTF-8");
			cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
			// freemaker鐨勬ā鏉挎枃浠�
			Template temp = cfg.getTemplate("overview.ftl");

			Map context = new HashMap();

			for (ISuite suite : suites) {
				Map<String, ISuiteResult> suiteResults = suite.getResults();
				for (ISuiteResult suiteResult : suiteResults.values()) {
					ReporterData data = new ReporterData();
					ITestContext testContext = suiteResult.getTestContext();
					// 鎶婃暟鎹～鍏ヤ笂涓嬫枃
					context.put("overView", data.testContext(testContext));// 娴嬭瘯缁撴灉姹囨�讳俊鎭�
					// ITestNGMethod[] allTests = testContext.getAllTestMethods();//鎵�鏈夌殑娴嬭瘯鏂规硶
					// Collection<ITestNGMethod> excludeTests =
					// testContext.getExcludedMethods();//鏈墽琛岀殑娴嬭瘯鏂规硶
					IResultMap passedTests = testContext.getPassedTests();// 娴嬭瘯閫氳繃鐨勬祴璇曟柟娉�
					IResultMap failedTests = testContext.getFailedTests();// 娴嬭瘯澶辫触鐨勬祴璇曟柟娉�
					IResultMap skippedTests = testContext.getSkippedTests();// 娴嬭瘯璺宠繃鐨勬祴璇曟柟娉�

					context.put("pass", data.testResults(passedTests, ITestResult.SUCCESS));
					context.put("fail", data.testResults(failedTests, ITestResult.FAILURE));
					context.put("skip", data.testResults(skippedTests, ITestResult.FAILURE));

				}
			}
			System.out.println(context.get("overView").toString());
			// 杈撳嚭娴�
			// Writer writer = new BufferedWriter(new FileWriter("report.html"));
			//（1）下面是生成测试报告页面
			OutputStream out = new FileOutputStream("D:\\demo\\11-28report.html");
			Writer writer = new BufferedWriter(new OutputStreamWriter(out, "utf-8"));// 锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟�
			// 杞崲杈撳嚭
			temp.process(context, writer);
			writer.flush();
			
			//（2）下面是将生成的测试报告网页文件直接以邮件的形式发送给邮箱
			InputStream inputStream = new FileInputStream("D:\\demo\\11-28report.html");
			Scanner scanner = new Scanner(inputStream, "UTF-8");
			String text = scanner.useDelimiter("\\A").next();
			System.out.println(text);
			scanner.close();

			SendEmail send = new SendEmail();
			send.send_mail(text);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}