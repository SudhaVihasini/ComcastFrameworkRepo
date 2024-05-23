package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewOrganizationPage {
	WebDriver driver;
	public CreatingNewOrganizationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	
	@FindBy(name="accountname")
	private WebElement OrgNameEdt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	@FindBy(name="industry")
	private WebElement industryDB;
	@FindBy(name="accounttype")
	private WebElement typeDB;
	@FindBy(name="phone")
	private WebElement phoneEdt;
	
	public WebElement getPhoneEdt() {
		return phoneEdt;
	}

	public WebElement getOrgNameEdt() {
		return OrgNameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void createOrg( String OrgName) {
		OrgNameEdt.sendKeys(OrgName);
	}
		public void createOrg1( String OrgName,String phoneNumber) {
			phoneEdt.sendKeys(phoneNumber);
		
	}
		
	
	public void createOrg( String OrgName,String industry) {
		OrgNameEdt.sendKeys(OrgName);
		Select sel=new Select(industryDB);
		sel.selectByVisibleText(industry);
	}
		  public void createOrg( String OrgName,String industry,String type) {
				OrgNameEdt.sendKeys(OrgName);
				Select sel=new Select(industryDB);
				sel.selectByVisibleText(industry);
				
				Select sel1=new Select(typeDB);
					sel1.selectByVisibleText(type);
					  saveBtn.click();
				
	
	
}
		  
		  
		  
		  
	}
