package com.comcast.crm.objectrepositoryutility;

import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

/**
 * @author Raja
 * contains login page elements and business libraries like login()
 * 
 */


public class LoginPage extends WebDriverUtility {
	
	//rule1 create separate java class
		//rule 2 object creation
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(name="user_name")
	public WebElement usernameEdt;
	@FindBy(name="user_password")
	public WebElement passwordEdt;
	@FindBy(id="submitButton")
	public WebElement loginBtn;
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}
	public WebElement getPasswordEdt() {
		return passwordEdt;
	}
	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	
	//rule3:object initialization
//rule 4:object encapsulation
	//rule5:provide action
	
	/**
	 * login to application based on username,password,url arguments
	 * @param url
	 * @param username
	 * @param password
	 */
	public void LoginToApp(String url,String username,String password) {
		waitForPageToLoad(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url);
		driver.manage().window().maximize();
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginBtn.click();
		
		
		
		
	}
}
