
package com.camcast.crm.contacttest;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.Fileutility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;

public class CreateContactWithSupportDate {
	public static void main(String[] args) throws Throwable 
	{
		/*create object*/
		Fileutility fLib=new Fileutility();
		ExcelUtility eLib=new ExcelUtility();
		JavaUtility jLib=new JavaUtility();

	
		/*read data from property file*/
		String BROWSER=fLib.getDataFromPropetiesFile("browser");
		String URL=fLib.getDataFromPropetiesFile("url");
		String USERNAME=fLib.getDataFromPropetiesFile("username");
		String PASSWORD=fLib.getDataFromPropetiesFile("password");
		//read data from excel
      // String OrgName=eLib.getDataFromExcel("Sheet1", 1, 2)+jLib.getRandomNumber();
       String LastName=eLib.getDataFromExcel("contact", 4, 3)+jLib.getRandomNumber();
       
		//launch browser using common data from properties file
		
				WebDriver driver=null;
				if(BROWSER.equals("chrome"))
				{
					driver=new ChromeDriver();
				}
				else if(BROWSER.equals("edge"))
				{
					driver=new EdgeDriver();
				}
				if(BROWSER.equals("firefox"))
				{
					driver=new FirefoxDriver();
				}
				driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
				
				//step1 login to app
						driver.get("http://localhost:8888/");
					driver.findElement(By.name("user_name")).sendKeys(USERNAME);
						driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
						driver.findElement(By.id("submitButton")).click();
				//step2 navigate to organization
						driver.findElement(By.linkText("Contacts")).click();
				//step3 click on create organization button
						driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
			    //step4 enter all details and create new organization
						
						String startDate=jLib.getSystemDateYYYYDDMM();
						String endDate=jLib.getRequiredDateYYYYDDMM(30);
								
								
						driver.findElement(By.name("lastname")).sendKeys(LastName);
						
						
						driver.findElement(By.name("support_start_date")).clear();
						driver.findElement(By.name("support_start_date")).sendKeys(startDate);
						
						driver.findElement(By.name("support_end_date")).clear();
						driver.findElement(By.name("support_end_date")).sendKeys(endDate);
						
						driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
						
						
						//verify header OrgName info  expected result
						String actstartDate=driver.findElement(By.id("dtlview_Support Start Date")).getText();
						
						if (actstartDate.equals(startDate)) {
							System.out.println(startDate+ "is created==PASS");
						}else {
							System.out.println(startDate+ "is not created==FAIL");
						}
						
						String actEndDate=driver.findElement(By.id("dtlview_Support End Date")).getText();
						if (actEndDate.equals(endDate)) {
							System.out.println(endDate+ "is created==PASS");
						}else {
							System.out.println(LastName+ "is not created==FAIL");
						}
						//STEP5:LOGOUT
						driver.quit();
						}
}


