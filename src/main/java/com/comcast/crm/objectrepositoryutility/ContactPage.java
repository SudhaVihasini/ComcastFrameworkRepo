

package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
//	WebDriver driver;
	public ContactPage(WebDriver driver) {
//		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(id="dtlview_Last Name")
	private WebElement headerlastname;
	
	public WebElement getHeaderlastname() {
		return headerlastname;
	}
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement CreateNewContactBtn;
	
	public WebElement getCreateNewContactBtn() {
		return CreateNewContactBtn;
	}

	
	}

	
	
	
	
