package com.webtest.freemarker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;


import org.testng.IResultMap;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.Reporter;




public class ReporterData {

    public List<ITestResult> sortByTime(Set<ITestResult> str) {
        List<ITestResult> list = new ArrayList<ITestResult>();
        for (ITestResult r : str) {
            list.add(r);
        }
        Collections.sort(list);
        return list;


    }

    public DataBean testContext(ITestContext context) {
        DataBean data = new DataBean();
        ReportUnits units = new ReportUnits();
        IResultMap passedTests = context.getPassedTests();
        IResultMap failedTests= context.getFailedTests();
        IResultMap skipedTests = context.getSkippedTests();
        Collection<ITestNGMethod> excludeTests = context.getExcludedMethods();

        int passedTestsSize = passedTests.size();
        int failedTestsSize = failedTests.size();
        int skipedTestsSize = skipedTests.size();
        int excludeTestsSize = excludeTests.size();
        int allTestsSize= passedTestsSize+failedTestsSize+skipedTestsSize;
        data.setAllTestsSize(allTestsSize);
        data.setPassedTestsSize(passedTestsSize);
        data.setFailedTestsSize(failedTestsSize);
        data.setSkippedTestsSize(skipedTestsSize);
        data.setExcludeTestsSize(excludeTestsSize);
        data.setTestsTime(units.getTestDuration(context));
        data.setPassPercent(units.formatPercentage(passedTestsSize, allTestsSize));
        data.setAllTestsMethod(context.getAllTestMethods());
        data.setExcludeTestsMethod(context.getExcludedMethods());

        return data;


    }


    public List<DataBean> testResults(IResultMap map, int status) {
        List<DataBean> list = new ArrayList<DataBean>();
        ReportUnits units = new ReportUnits();
        map.getAllResults().size();
        for (ITestResult result : sortByTime(map.getAllResults())) {
            DataBean data = new DataBean();
            data.setTestName(result.getName());
            data.setClassName(result.getTestClass().getName());
            data.setDuration(units.formatDuration(result.getEndMillis()
                    - result.getStartMillis()));
            data.setParams(units.getParams(result));
            data.setDescription(result.getMethod().getDescription());
            data.setOutput(Reporter.getOutput(result));
            data.setDependMethod(units.getDependMethods(result));
            data.setThrowable(result.getThrowable());
            if (result.getThrowable() != null) {
                data.setStackTrace(result.getThrowable().getStackTrace());
            }
            list.add(data);
        }
        return list;
    }

}