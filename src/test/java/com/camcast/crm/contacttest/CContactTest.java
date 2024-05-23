package com.camcast.crm.contacttest;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.ContactInfo;
import com.comcast.crm.objectrepositoryutility.ContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewContactPage;
import com.comcast.crm.objectrepositoryutility.HomePage;

/**
 * 
 * @author Raja
 * 
 */
public class CContactTest extends BaseClass {
	
	@Test(groups ="smokeTest")
	
	
	public void cContactTest()throws Throwable{
		
	//read data from excel
	String LastName=eLib.getDataFromExcel("contact", 1,3)+jLib.getRandomNumber();
		
				//step2 navigate to contact
						HomePage hp=new HomePage(driver);
						hp.getContactlnk().click();
				//step3 click on create contact
						ContactPage cp= new ContactPage(driver);
						cp.getCreateNewContactBtn().click();
						
		    //step4 enter all details and create new organization
						CreatingNewContactPage cncp=new CreatingNewContactPage(driver);
						cncp.getLastName1().sendKeys(LastName);
						cncp.getSaveBtn().click();
					
						
						//verify header OrgName info  expected result
						//String actLastName=driver.findElement(By.id("dtlview_Last Name")).getText();
//						if (actLastName.equals(LastName)) {
//							System.out.println(LastName+ "is created==PASS");
//						}else {
//							System.out.println(LastName+ "is not created==FAIL");
//						}
//						System.out.println("First script don");
						
						String actLastName=cp.getHeaderlastname().getText();
						//Assert.assertEquals(LastName, actLastName);
					SoftAssert s=new SoftAssert();
						s.assertEquals(LastName, actLastName);
						s.assertAll();
					
					
	}
	
	
	
	

	

	@Test(groups="regression Test")
	public void createContactWithSupportDateTest() throws Throwable {
		
			//read data from excel
			String LastName=eLib.getDataFromExcel("contact", 4, 3)+jLib.getRandomNumber();
			//step2 navigate to contact
			HomePage hp=new HomePage(driver);
			hp.getContactlnk().click();
			//step3 click on create contact
			ContactPage cp= new ContactPage(driver);
			cp.getCreateNewContactBtn().click();
			CreatingNewContactPage cncp=new CreatingNewContactPage(driver);
		
		
			//step4:enter all the details and create new contact
			cncp.getLastName1().sendKeys(LastName);
			String startDate=jLib.getSystemDateYYYYDDMM();
			
			String endDate=jLib.getRequiredDateYYYYDDMM(30);
			
			cncp.getStartDate().clear();
			
			cncp.getStartDate().sendKeys(startDate);
			Thread.sleep(3000);
			cncp.getEndDate().clear();
			cncp.getEndDate().sendKeys(endDate);
			cncp.getSaveBtn().click();

			//verify header OrgName info  expected result
//			String actstartDate=driver.findElement(By.id("dtlview_Support Start Date")).getText();
//			System.out.println(actstartDate);
//			if (actstartDate.equals(startDate)) {
//				System.out.println(startDate+ "is created==PASS");
//			}else {
//				System.out.println(startDate+ "is not created==FAIL");
//			}	
//		String actEndDate=driver.findElement(By.id("dtlview_Support End Date")).getText();
//		if (actEndDate.equals(endDate)) {
//			System.out.println(endDate+ "is created==PASS");
//		}else {
//			System.out.println(endDate+ "is not created==FAIL");
//		}
//		System.out.println("Second script don");
//		}
	ContactInfo  cio=new ContactInfo(driver);
			

			String actstartDate=cio.getStartdate().getText();
			Assert.assertEquals(startDate, actstartDate);
			String actendDate=cio.getEnddate().getText();
			Assert.assertEquals(endDate, actendDate);
			
	}
}



		
	