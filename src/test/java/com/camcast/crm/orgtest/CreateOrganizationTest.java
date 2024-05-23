



package com.camcast.crm.orgtest;

import java.io.FileInputStream;
import java.time.Duration;
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
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.Fileutility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.listenerutility.ListImpClass1;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfo;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;
@Listeners(com.comcast.crm.listenerutility.ListImpClass1.class)
public class CreateOrganizationTest extends BaseClass {
	
	@Test(groups ="smokeTest")
	public void CreateOrganizationTest()throws Throwable{
	
		ListImpClass1.test.log(Status.INFO,"read data from excel");
		//read data from excel
       String OrgName=eLib.getDataFromExcel("Sheet1", 1, 2)+jLib.getRandomNumber();
		
		
				//step2 navigate to organization
       ListImpClass1.test.log(Status.INFO,"naviate to org page");
						HomePage hp=new HomePage(driver);
						hp.getOrgLink().click();
						//hp.navigateToCampaignPage();
						
				//step3 click on create organization button
						 ListImpClass1.test.log(Status.INFO,"naviate to create org page");
						OrganizationsPage cnp=new OrganizationsPage(driver);
						cnp.getCreateNewOrgBtn().click();
					
						
						//step4 enter all details and create new organization
						 ListImpClass1.test.log(Status.INFO,"create a new org");
						CreatingNewOrganizationPage cnop= new CreatingNewOrganizationPage(driver);
						cnop.createOrg(OrgName);
						 ListImpClass1.test.log(Status.INFO,"naviate to org page");
						cnop.getSaveBtn().click();
						
						
			//verify header message expected result
						OrganizationInfo oip=new OrganizationInfo(driver);
						String actOrgName=oip.getHeaderMsg().getText();
						if(actOrgName.contains(OrgName)) {
							System.out.println(OrgName + "name is verified==PASS");
						}else {
							System.out.println(OrgName + "name is not verified==FAIL");
							
									
						}
	}
						
							@Test(groups="regression Test")
							public void CreateOrganizationTest1()throws Throwable{
							
								
								//read data from excel
								 String OrgName=eLib.getDataFromExcel("Sheet1", 4, 2)+jLib.getRandomNumber();
						       String industry=eLib.getDataFromExcel("Sheet1", 4, 4);
						       String type=eLib.getDataFromExcel("Sheet1", 4, 5);
								
								
						     //step2 navigate to organization
								HomePage hp=new HomePage(driver);
								hp.getOrgLink().click();
								//hp.navigateToCampaignPage();
								//step3 click on create organization button
								OrganizationsPage cnp=new OrganizationsPage(driver);
								cnp.getCreateNewOrgBtn().click();
							
								
								//step4 enter all details and create new organization
								CreatingNewOrganizationPage cnop= new CreatingNewOrganizationPage(driver);
								cnop.createOrg(OrgName,industry,type);
												
												
												
									//verify industry and type info
												
												String actindustries=driver.findElement(By.id("dtlview_Industry")).getText();
												if (actindustries.equals(industry)) {
													System.out.println(industry +" information  is created==PASS");
												}else {
													System.out.println(industry +" information is not created==FAIL");
												}
												String actType=driver.findElement(By.id("dtlview_Type")).getText();
												if (actType.equals(type)) {
													System.out.println(type +" information  is created==PASS");
												}else {
													System.out.println(type +" information is not created==FAIL");
												}
							}
@Test(groups="regression Test")
public void CreateOrganizationTest2()throws Throwable{
	//read data from excel
    String OrgName=eLib.getDataFromExcel("Sheet1", 7, 2)+jLib.getRandomNumber();
    String phoneNumber=eLib.getDataFromExcel("Sheet1", 7, 4);
  //step2 navigate to organization
	HomePage hp=new HomePage(driver);
	hp.getOrgLink().click();
	//hp.navigateToCampaignPage();
	//step3 click on create organization button
	OrganizationsPage cnp=new OrganizationsPage(driver);
	cnp.getCreateNewOrgBtn().click();

	
	//step4 enter all details and create new organization
	CreatingNewOrganizationPage cnop= new CreatingNewOrganizationPage(driver);
	cnop.createOrg(OrgName);
	cnop.createOrg1(OrgName,phoneNumber);
	cnop.getSaveBtn().click();
	
	//verify industry and type info
	
	String actphoneNumber=driver.findElement(By.id("mouseArea_Phone")).getText();
	if (actphoneNumber.equals(phoneNumber)) {
		System.out.println(phoneNumber +" information  is created==PASS");
	}else {
		System.out.println(phoneNumber +" information is not created==FAIL");
	}
}}


