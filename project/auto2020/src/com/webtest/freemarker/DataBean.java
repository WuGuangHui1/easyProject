package com.webtest.freemarker;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.testng.ITestNGMethod;

public class DataBean {
    private int excludeTestsSize; 
    private int passedTestsSize; 
    private int failedTestsSize; 
    private int skippedTestsSize; 
    private int allTestsSize; 
    private ITestNGMethod[] allTestsMethod; 
    private Collection<ITestNGMethod> excludeTestsMethod; 
    private String testsTime; 
    private String passPercent; 
    private String testName; 
    private String className; 
    private String duration; 
    private String params; 
    private String description; 
    private List<String> output; 
    private String dependMethod; 
    private Throwable throwable; 
    private StackTraceElement[] stackTrace; 
    public int getExcludeTestsSize() {
        return excludeTestsSize;
    }

    public void setExcludeTestsSize(int excludeTestsSize) {
        this.excludeTestsSize = excludeTestsSize;
    }

    public int getPassedTestsSize() {
        return passedTestsSize;
    }

    public void setPassedTestsSize(int passedTestsSize) {
        this.passedTestsSize = passedTestsSize;
    }

    public int getFailedTestsSize() {
        return failedTestsSize;
    }

    public void setFailedTestsSize(int failedTestsSize) {
        this.failedTestsSize = failedTestsSize;
    }

    public int getSkippedTestsSize() {
        return skippedTestsSize;
    }

    public void setSkippedTestsSize(int skippedTestsSize) {
        this.skippedTestsSize = skippedTestsSize;
    }

    public int getAllTestsSize() {
        return allTestsSize;
    }

    public void setAllTestsSize(int allTestsSize) {
        this.allTestsSize = allTestsSize;
    }

    public String getPassPercent() {
        return passPercent;
    }

    public void setPassPercent(String passPercent) {
        this.passPercent = passPercent;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getOutput() {
        return output;
    }

    public void setOutput(List<String> output) {
        this.output = output;
    }

    public String getDependMethod() {
        return dependMethod;
    }

    public void setDependMethod(String dependMethod) {
        this.dependMethod = dependMethod;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable2) {
        this.throwable = throwable2;
    }

    public StackTraceElement[] getStackTrace() {
        return stackTrace;
    }

    public void setStackTrace(StackTraceElement[] stackTrace) {
        this.stackTrace = stackTrace;
    }

    public void setTestsTime(String testsTime) {
        this.testsTime = testsTime;
    }

    public String getTestsTime() {
        return testsTime;
    }

    public void setAllTestsMethod(ITestNGMethod[] allTestsMethod) {
        this.allTestsMethod = allTestsMethod;
    }

    public ITestNGMethod[] getAllTestsMethod() {
        return allTestsMethod;
    }

    public void setExcludeTestsMethod(Collection<ITestNGMethod> excludeTestsMethod) {
        this.excludeTestsMethod = excludeTestsMethod;
    }

    public Collection<ITestNGMethod> getExcludeTestsMethod() {
        return excludeTestsMethod;
    }

    @Override
    public String toString() {
        return "DataBean{" +
                "excludeTestsSize=" + excludeTestsSize +
                ", passedTestsSize=" + passedTestsSize +
                ", failedTestsSize=" + failedTestsSize +
                ", skippedTestsSize=" + skippedTestsSize +
                ", allTestsSize=" + allTestsSize +
                ", allTestsMethod=" + Arrays.toString(allTestsMethod) +
                ", excludeTestsMethod=" + excludeTestsMethod +
                ", testsTime='" + testsTime + '\'' +
                ", passPercent='" + passPercent + '\'' +
                ", testName='" + testName + '\'' +
                ", className='" + className + '\'' +
                ", duration='" + duration + '\'' +
                ", params='" + params + '\'' +
                ", description='" + description + '\'' +
                ", output=" + output +
                ", dependMethod='" + dependMethod + '\'' +
                ", throwable=" + throwable +
                ", stackTrace=" + Arrays.toString(stackTrace) +
                '}';
    }
}
