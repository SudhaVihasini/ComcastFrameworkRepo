package com.comcast.crm.listenerutility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.basetest.BaseClass;

public class ListImpClass implements ITestListener,ISuiteListener
{
	public ExtentSparkReporter spark;//report pgm
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
		//write this pgm fr report screenshot
		//spark report config--report pgm
				ExtentSparkReporter spark=new ExtentSparkReporter("./AdvanceReport/report.html");
				spark.config().setDocumentTitle("CRM Test Suite Results");
				spark.config().setReportName("CRM Report");
				spark.config().setTheme(Theme.DARK);
				
				//add Env information and create test---report pgm
				 report=new ExtentReports();
				report.attachReporter(spark);
				report.setSystemInfo("OS","Windows-10");
				report.setSystemInfo("BROWSER","CHROME-100");
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
	//step1:create an object to EventFiring Webdriver
			EventFiringWebDriver edriver=new EventFiringWebDriver(BaseClass.sdriver);
			
			//step2:use getScreenshotAs method to get file type of screenshot
			File srcFile=edriver.getScreenshotAs(OutputType.FILE);
			String time=new Date().toString().replace(" "," ").replace(":"," ");//-add fr time based screenshot
			//step3:store screen on local driver
			try {
			//FileUtils.copyFile(srcFile,new File("./Screenshot/"+testName+".png"));
				//FileUtils.copyFile(srcFile,new File("./Screenshot/"+testName+".png"));//suite level
				FileUtils.copyFile(srcFile,new File("./Screenshot/"+testName+ "+"+time+".png"));//time based
			
	}catch (IOException e) {
		e.printStackTrace();
	}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("====>"+result.getMethod().getMethodName()+">===START====");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("====>"+result.getMethod().getMethodName()+">===End====");
	}
	

}
