package com.camcast.crm.contacttest;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
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
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateContactWithOrgTest {
	public static void main(String[] args) throws EncryptedDocumentException, Throwable {
		/*create object*/
		Fileutility fLib=new Fileutility();
		ExcelUtility eLib=new ExcelUtility();
		JavaUtility jLib=new JavaUtility();
WebDriverUtility wLib=new WebDriverUtility();
		//read common data from properties file
		
		
		
String BROWSER=fLib.getDataFromPropetiesFile("browser");
String URL=fLib.getDataFromPropetiesFile("url");
String USERNAME=fLib.getDataFromPropetiesFile("username");
String PASSWORD=fLib.getDataFromPropetiesFile("password");
		//read data from excel
		
		String orgName=eLib.getDataFromExcel("contact", 7, 3)+jLib.getRandomNumber();
		String contactLastName=eLib.getDataFromExcel("contact", 7, 4)+jLib.getRandomNumber();
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
				wLib.waitForPageToLoad(driver);
						driver.get("http://localhost:8888/");
					driver.findElement(By.name("user_name")).sendKeys(USERNAME);
						driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
						driver.findElement(By.id("submitButton")).click();
				//step2 navigate to organization
						driver.findElement(By.linkText("Organizations")).click();
				//step3 click on create organization button
						driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
			    //step4 enter all details and create new organization
						driver.findElement(By.name("accountname")).sendKeys(orgName);
						driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			//verify header message expected result
						String headerInfo=driver.findElement(By.xpath("//span[@class=\'dvHeaderText\']")).getText();
						if(headerInfo.contains(orgName))
						{
							System.out.println(orgName+ "is created==PASS");
						}else {
							System.out.println(orgName+ "is not created==FAIL");
						}
						
						
						//step5 navigate to organization
						driver.findElement(By.linkText("Contacts")).click();
				//step6 click on create organization button
						driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
			    //step7 enter all details and create new organization
						driver.findElement(By.name("lastname")).sendKeys(contactLastName);
						driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
					//switch to child window
						wLib.switchToTabOnURL(driver,"module=Accounts");
						
 					driver.findElement(By.name("search_text")).sendKeys(orgName);
						driver.findElement(By.name("search")).click();
						driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
						
						//switch to parent window
						
						wLib.switchToTabOnURL(driver,"Contacts&action");
						driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				//stp8 verify header OrgName info  expected result
			 headerInfo=driver.findElement(By.xpath("//span[@class=\'dvHeaderText\']")).getText();
			if(headerInfo.contains(contactLastName))
			{
				System.out.println(contactLastName+ "header verified==PASS");
			}else {
				System.out.println(contactLastName+ "header verified==FAIL");
			}
			
			//verify header OrgName info  expected result
			String actOrgName=driver.findElement(By.id("mouseArea_Organization Name")).getText();
			if (actOrgName.trim().equals(orgName)) {
				System.out.println(orgName+ "is created==PASS");
			}else {
				System.out.println(orgName+ "is not created==FAIL");
			}
						//STEP5:LOGOUT
						
						
						
						driver.quit();
						}
}


