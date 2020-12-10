package com.webtest.freemarker.dxy;

import java.io.BufferedWriter;
import java.io.File;
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

import com.webtest.core.dxy.SendEmail;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

public class GenerateReporter implements IReporter {
	@Override
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		try {
			// freemaker的配置
			Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);
//			cfg.setClassForTemplateLoading(this.getClass(), "./templat/es");
			cfg.setDirectoryForTemplateLoading(new File("templates"));
			cfg.setDefaultEncoding("UTF-8");
			cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
			// freemaker的模板文件
			Template temp = cfg.getTemplate("overview.ftl");

			Map context = new HashMap();

			for (ISuite suite : suites) {
				Map<String, ISuiteResult> suiteResults = suite.getResults();
				for (ISuiteResult suiteResult : suiteResults.values()) {
					ReporterData data = new ReporterData();
					ITestContext testContext = suiteResult.getTestContext();
					// 把数据填入上下文
					context.put("overView", data.testContext(testContext));// 测试结果汇总信息
					// ITestNGMethod[] allTests = testContext.getAllTestMethods();//所有的测试方法
					// Collection<ITestNGMethod> excludeTests =
					// testContext.getExcludedMethods();//未执行的测试方法
					IResultMap passedTests = testContext.getPassedTests();// 测试通过的测试方法
					IResultMap failedTests = testContext.getFailedTests();// 测试失败的测试方法
					IResultMap skippedTests = testContext.getSkippedTests();// 测试跳过的测试方法

					context.put("pass", data.testResults(passedTests, ITestResult.SUCCESS));
					context.put("fail", data.testResults(failedTests, ITestResult.FAILURE));
					context.put("skip", data.testResults(skippedTests, ITestResult.FAILURE));

				}
			}
			System.out.println(context.get("overView").toString());
			// 输出流
			// Writer writer = new BufferedWriter(new FileWriter("report.html"));
			// （1）下面是生成测试报告页面
			OutputStream out = new FileOutputStream("D:\\demo\\11-28report.html");
			Writer writer = new BufferedWriter(new OutputStreamWriter(out, "utf-8"));
			// 转换输出
			temp.process(context, writer);
			writer.flush();

			// （2）下面是将生成的测试报告网页文件直接以邮件的形式发送给邮箱
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