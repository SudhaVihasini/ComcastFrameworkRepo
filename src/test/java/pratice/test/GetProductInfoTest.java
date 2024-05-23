package pratice.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GetProductInfoTest {
	@Test(dataProvider="getData")
	public void getProductInfoTest(String brandName,String productName) {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.amazon.in/");
		
		//search product
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandName,Keys.ENTER);
		//capture product info
		String x="//span[text()='"+productName+"']/ancestor::div[@class='a-section a-spacing-small a-spacing-top-small']/descendant::span[@class='a-price-whole']";
	String price=driver.findElement(By.xpath(x)).getText();
	System.out.println(price);
	driver.quit();
	}
	@DataProvider
	public Object[][] getData() {
		Object[][] ObjArr = new Object[3][2];
		ObjArr[0][0]="iphone";
		ObjArr[0][1]="Apple iPhone 13 (128GB) - Starlight";

		ObjArr[1][0]="iphone";
		ObjArr[1][1]="Apple iPhone 15 (128 GB) - Black";

		ObjArr[2][0]="iphone";
		ObjArr[2][1]="Apple iPhone 13 (128GB) - Pink";

		return ObjArr;
	}
}
