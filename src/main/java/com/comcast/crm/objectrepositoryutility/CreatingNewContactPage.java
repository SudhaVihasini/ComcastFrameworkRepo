package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewContactPage {
	
	public CreatingNewContactPage(WebDriver driver) {
		
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="lastname")
	private WebElement LastName1;
	
	@FindBy(xpath="(//input[@type='submit'])[2]")
	private WebElement saveBtn;
	
	
	@FindBy(xpath="//input[@name='support_start_date']")
	private WebElement startDate ;
	@FindBy(xpath="//input[@name='support_end_date']")
	private WebElement endDate;
	
	

	

public WebElement getLastName1() {
		return LastName1;
	}


public WebElement getSaveBtn() {
		return saveBtn;
	}


public WebElement getStartDate() {
		return startDate;
	}


public WebElement getEndDate() {
		return endDate;
	}
}


	/*
	 * 
	 * public void CreatingNewContactPageApp(String LastName ) {
	 * LastName1.sendKeys(LastName); String start=jLib.getSystemDateYYYYDDMM();
	 * 
	 * String end=jLib.getRequiredDateYYYYDDMM(30); //startDate saveBtn.click();
	 * 
	 */

/*
String startDate=jLib.getSystemDateYYYYDDMM();
			
			String endDate=jLib.getRequiredDateYYYYDDMM(30);
			
			cncp.getStartDate().clear();
			
			cncp.getStartDate().sendKeys(startDate);
			Thread.sleep(3000);
			cncp.getEndDate().clear();
			cncp.getEndDate().sendKeys(endDate);
			cncp.getSaveBtn().click();  */
 










