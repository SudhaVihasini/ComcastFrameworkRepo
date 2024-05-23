package com.comcast.crm.basetest;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.databaseutility.DatabaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.Fileutility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class BaseClass

 {
	/*create object */
	public DatabaseUtility dbLib=new DatabaseUtility();
	
	
	public Fileutility fLib=new Fileutility();
	public ExcelUtility eLib=new ExcelUtility();
	public JavaUtility jLib=new JavaUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public WebDriver driver=null;
	public  static WebDriver sdriver=null;
	//public ExtentSparkReporter spark;//report pgm
	//public ExtentReports report;//report pgm
	
	@BeforeSuite(groups= {"smokeTest","regression Test"})
	public void configBS() throws SQLException{


		dbLib.getDbconnection();
		
//		//spark report config--report pgm
//		ExtentSparkReporter spark=new ExtentSparkReporter("./AdvanceReport/report.html");
//		spark.config().setDocumentTitle("CRM Test Suite Results");
//		spark.config().setReportName("CRM Report");
//		spark.config().setTheme(Theme.DARK);
//		
//		//add Env information and create test---report pgm
//		 report=new ExtentReports();
//		report.attachReporter(spark);
//		report.setSystemInfo("OS","Windows-10");
//		report.setSystemInfo("BROWSER","CHROME-100");
	}
	//@Parameters("BROWSER")//change the line when u run other program
	@BeforeClass(groups= {"smokeTest","regression Test"})
	
	//public void configBC(String browser)throws Throwable//change  the line when u run other program
	public void configBC()throws Throwable
	  {
		System.out.println("==launch the browser===");
		//String BROWSER=fLib.getDataFromPropetiesFile("browser");
		//String BROWSER=browser;//change the line when u run other program
		String BROWSER=fLib.getDataFromPropetiesFile("browser");
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
		sdriver=driver;
	}
	
	@BeforeMethod(groups= {"smokeTest","regression Test"})
	public void configBM() throws Throwable {
		System.out.println("==login==");
		String URL=fLib.getDataFromPropetiesFile("url");
		
		String USERNAME=fLib.getDataFromPropetiesFile("username");
		String PASSWORD=fLib.getDataFromPropetiesFile("password");
		LoginPage lp=new LoginPage(driver);
		lp.LoginToApp(URL, USERNAME, PASSWORD);
	}
	

	@AfterMethod(groups= {"smokeTest","regression Test"})
	public void configAM() {
		System.out.println("==logout==");
		HomePage hp=new HomePage(driver);
		hp.logout();

	}
	
	
	
	@AfterClass(groups= {"smokeTest","regression Test"})
	public void configAC() {
		System.out.println("==close the browser==");
		driver.quit();
	}
	@AfterSuite(groups= {"smokeTest","regression Test"})
	public void configAS() throws SQLException {
		System.out.println("====close Db,Report backup====");
		dbLib.closeDbconnection();
		//report.flush();//rport pgm
	}
}
