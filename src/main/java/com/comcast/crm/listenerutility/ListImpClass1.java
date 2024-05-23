package com.comcast.crm.listenerutility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.basetest.BaseClass;

public class ListImpClass1 implements ITestListener,ISuiteListener {
	//public ExtentReports report;
	public static	ExtentTest test;
	
	
	//public ExtentSparkReporter spark;//report pgm
	public static  ExtentReports report;//report pgm
	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("Report backup");
		report.flush();//report screnshot pgm
	}

	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("Report configuration");
		ExtentSparkReporter spark=new ExtentSparkReporter("./AdvanceReport/report.html");
		spark.config().setDocumentTitle("CRM Test Suite Results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		
		//add Env information and create test
		 report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS","Windows-10");
		report.setSystemInfo("BROWSER","CHROME-100");
		//write this pgm fr report screenshot
		//spark report config--report pgm
//				 spark=new ExtentSparkReporter("./AdvanceReport/report.html");
//				spark.config().setDocumentTitle("CRM Test Suite Results");
//				spark.config().setReportName("CRM Report");
//				spark.config().setTheme(Theme.DARK);
				
				//add Env information and create test---report pgm
//				 report=new ExtentReports();
//				report.attachReporter(spark);
//				report.setSystemInfo("OS","Windows-10");
//				report.setSystemInfo("BROWSER","CHROME-100");
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
	String testName=result.getMethod().getMethodName();
    TakesScreenshot eDriver=(TakesScreenshot)BaseClass.sdriver;//screenshot pgm
	String filePath=eDriver.getScreenshotAs(OutputType.BASE64);//screenshot pgm
	
	String time=new Date().toString().replace(" "," _").replace(":"," _");//-add fr time based screenshot
	test.addScreenCaptureFromBase64String(filePath,testName+"_"+time); //screenshot pgm
	 test.log(Status.FAIL, result.getMethod().getMethodName()+"===>failed<=====");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("====>"+result.getMethod().getMethodName()+">===START====");
		 test=report.createTest(result.getMethod().getMethodName());
		 
		 test.log(Status.INFO, result.getMethod().getMethodName()+"===>STARTED<=====");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("====>"+result.getMethod().getMethodName()+">===End====");
		 test.log(Status.PASS, result.getMethod().getMethodName()+"===>completed<=====");
	}
	

}


