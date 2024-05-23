package com.comcast.crm.generic.webdriverutility;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public class UtilityClassObject {
	public static ThreadLocal<ExtentTest>test=new ThreadLocal<ExtentTest>();
    public static ThreadLocal<WebDriver>driver=new  ThreadLocal<WebDriver>();
}
