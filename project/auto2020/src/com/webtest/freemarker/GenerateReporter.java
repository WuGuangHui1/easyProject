package com.webtest.freemarker;



import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.commons.compress.utils.IOUtils;
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
        // TODO Auto-generated method stub
    	 try {
             
             Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);
//             cfg.setClassForTemplateLoading(this.getClass(),"/templates");
             cfg.setDirectoryForTemplateLoading(new File("templates"));
             cfg.setDefaultEncoding("UTF-8");
             cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
             
             Template temp = cfg.getTemplate("overview.ftl");

             Map context = new HashMap();


             for (ISuite suite : suites) {
                 Map<String, ISuiteResult> suiteResults = suite.getResults();
                 for (ISuiteResult suiteResult : suiteResults.values()) {
                     ReporterData data = new ReporterData();
                     ITestContext testContext = suiteResult.getTestContext();
                     // 把数据填入上下文
                     context.put("overView", data.testContext(testContext));//
                     //ITestNGMethod[] allTests = testContext.getAllTestMethods();
                     //Collection<ITestNGMethod> excludeTests = testContext.getExcludedMethods();//未执行的测试方法
                     IResultMap passedTests = testContext.getPassedTests();//
                     IResultMap failedTests = testContext.getFailedTests();//
                     IResultMap skippedTests = testContext.getSkippedTests();

                    context.put("pass", data.testResults(passedTests, ITestResult.SUCCESS));
                    context.put("fail", data.testResults(failedTests, ITestResult.FAILURE));
                    context.put("skip", data.testResults(skippedTests, ITestResult.FAILURE));

                }
            }
            System.out.println(context.get("overView").toString());

            //Writer writer = new BufferedWriter(new FileWriter("report.html"));
            OutputStream out=new FileOutputStream("D:\\demo\\report1.html");
            Writer writer = new BufferedWriter(new OutputStreamWriter(out,"UTF-8"));
            // 转换输出
            temp.process(context,writer);
            writer.flush();
            InputStream inputStream = new FileInputStream("D:\\demo\\report1.html");
            Scanner scanner = new Scanner(inputStream, "UTF-8");
            String text = scanner.useDelimiter("\\A").next();
            System.out.println(text);
            scanner.close();
            
            
            
            MailUtil send = new MailUtil();
        	send.mail(text);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       
	
    }


}