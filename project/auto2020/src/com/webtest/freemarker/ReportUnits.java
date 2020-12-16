package com.webtest.freemarker;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ReportUnits {
    private static final NumberFormat DURATION_FORMAT = new DecimalFormat("#0.000");
    private static final NumberFormat PERCENTAGE_FORMAT = new DecimalFormat("#0.00%");
    public String getTestDuration(ITestContext context){
        long duration;
        duration=context.getEndDate().getTime()-context.getStartDate().getTime();
        return formatDuration(duration);
    }

    public String formatDuration(long elapsed)
    {
        double seconds = (double) elapsed / 1000;
        return DURATION_FORMAT.format(seconds);
    }
    public String formatPercentage(int numerator, int denominator)
    {
        return PERCENTAGE_FORMAT.format(numerator / (double) denominator);
    }
    public String getParams(ITestResult result){
        Object[] params = result.getParameters();
        List<String> list = new ArrayList<String>(params.length);
        for (Object o:params){
            list.add(renderArgument(o));
        }
        return  commaSeparate(list);
    }
    public String getDependMethods(ITestResult result){
        String[] methods=result.getMethod().getMethodsDependedUpon();
        return commaSeparate(Arrays.asList(methods));
    }
    public String getCause(Throwable throwable){
        StackTraceElement[] stackTrace=throwable.getStackTrace(); //��ջ�켣
        List<String> list = new ArrayList<String>(stackTrace.length);
        for (Object o:stackTrace){
            list.add(renderArgument(o));
        }
        return  commaSeparate(list);
    }
    public List<String> getAllOutput(){
        return Reporter.getOutput();
    }
    public List<String> getTestOutput(ITestResult result){
        return Reporter.getOutput(result);
    }
    private String renderArgument(Object argument)
    {
        if (argument == null)
        {
            return "null";
        }
        else if (argument instanceof String)
        {
            return "\"" + argument + "\"";
        }
        else if (argument instanceof Character)
        {
            return "\'" + argument + "\'";
        }
        else
        {
            return argument.toString();
        }
    }
    private String commaSeparate(Collection<String> strings)
    {
        StringBuilder buffer = new StringBuilder();
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext())
        {
            String string = iterator.next();
            buffer.append(string);
            if (iterator.hasNext())
            {
                buffer.append(", ");
            }
        }
        return buffer.toString();
    }
}