package com.camcast.crm.orgtest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.Fileutility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfo;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class DeleteOrgTest {
	
	public static void main(String[] args) throws Throwable {
		/*create object*/
		Fileutility fLib=new Fileutility();
		ExcelUtility eLib=new ExcelUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		

	
		/*read data from property fil*/
		String BROWSER=fLib.getDataFromPropetiesFile("browser");
		String URL=fLib.getDataFromPropetiesFile("url");
		String USERNAME=fLib.getDataFromPropetiesFile("username");
		String PASSWORD=fLib.getDataFromPropetiesFile("password");
		//read data from excel
       String OrgName=eLib.getDataFromExcel("Sheet1", 10, 2)+jLib.getRandomNumber();
		
		//launch browser using common data from properties file.
		
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
				
				
				//step1 login to app
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
						driver.get("http://localhost:8888/");
				//	LoginPage lp=PageFactory.initElements(driver, LoginPage.class);//object initialization rule3
//						LoginPage lp=new LoginPage(driver);
//						lp.LoginToApp(USERNAME, PASSWORD);
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
						
			//verify header message expected result
						OrganizationInfo oip=new OrganizationInfo(driver);
						String actOrgName=oip.getHeaderMsg().getText();
						if(actOrgName.contains(OrgName)) {
							System.out.println(OrgName + "name is verified==PASS");
						}else {
							System.out.println(OrgName + "name is not verified==FAIL");
							
									
						}
						//go back to organization page
						HomePage hp1=new HomePage(driver);
						hp1.getOrgLink().click();
						//search for organization
						cnp.getSearchEdt().sendKeys(OrgName);
						wLib.select(cnp.getSearchDD(),"Organization Name");
						cnp.getSearchBtn().click();
						//in dynamic webtable select and delete org
						driver.findElement(By.xpath("//a[text()='"+OrgName+"']/../../td[8]/a[text()='del']")).click();
						
						//step5:LOGOUT
						hp.logout();
						
						
						driver.quit();
						}
}
