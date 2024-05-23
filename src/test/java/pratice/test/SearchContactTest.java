package pratice.test;

import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.LoginPage;

/**
 * test class for contact module
 * @author Raja
 */
public class SearchContactTest extends BaseClass {
	
	/**
	 * scenario:login()====>navigate contact====>create contact()==verify
	 */
@Test
public void searchcontactTest() {
	/*step1:login to app*/
	
	LoginPage lp=new LoginPage(driver);
	lp.LoginToApp("url", "usrname", "password");
	
}
}
