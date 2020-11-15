package com.webtest.freemarker;

import java.io.*;
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

import com.webtest.listen.MailUtil;

import freemarker.template.*;

public class GenerateReporter implements IReporter {
    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites,
                               String outputDirectory) {
        try {
            //freemaker������
            Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);
            cfg.setClassForTemplateLoading(this.getClass(),"/templates");
            cfg.setDefaultEncoding("UTF-8");
            cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
            //freemaker��ģ���ļ�
            Template temp = cfg.getTemplate("overview.ftl");
            Map context = new HashMap();
            for (ISuite suite : suites) {
                Map<String, ISuiteResult> suiteResults = suite.getResults();
                for (ISuiteResult suiteResult : suiteResults.values()) {
                    ReporterData data = new ReporterData();
                    ITestContext testContext = suiteResult.getTestContext();
                    // ����������������
                    context.put("overView", data.testContext(testContext));//���Խ��������Ϣ
                    //ITestNGMethod[] allTests = testContext.getAllTestMethods();//���еĲ��Է���
                    //Collection<ITestNGMethod> excludeTests = testContext.getExcludedMethods();//δִ�еĲ��Է���
                    IResultMap passedTests = testContext.getPassedTests();//����ͨ���Ĳ��Է���
                    IResultMap failedTests = testContext.getFailedTests();//����ʧ�ܵĲ��Է���
                    IResultMap skippedTests = testContext.getSkippedTests();//���������Ĳ��Է���

                    context.put("pass", data.testResults(passedTests, ITestResult.SUCCESS));
                    context.put("fail", data.testResults(failedTests, ITestResult.FAILURE));
                    context.put("skip", data.testResults(skippedTests, ITestResult.FAILURE));

                }
            }
            System.out.println(context.get("overView").toString());
            // �����
            OutputStream out=new FileOutputStream("D:\\demo\\report1.html");
            Writer writer = new BufferedWriter(new OutputStreamWriter(out,"utf-8"));//�����������
            // ת�����
            temp.process(context,writer);
            writer.flush();
           InputStream inputStream=new FileInputStream("D:\\demo\\report1.html");
           Scanner scanner=new Scanner(inputStream,"UTF-8");
           String text=scanner.useDelimiter("\\A").next();
           System.out.println(text);
           MailUtil send = new MailUtil();
           send.mail(text);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       
        
	
    }


}