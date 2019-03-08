//To verify whether application allows admin to add advertisement to multiple member
package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.Changepermission;
import com.training.pom.LoginCyclos;
import com.training.pom.Manageadv;
import com.training.pom.Membervalid;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CYTC_068 {
	private WebDriver driver;
	private String baseUrl;
	private Manageadv manageadv;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public  void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		manageadv = new Manageadv(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);

		// open the browser
		driver.get(baseUrl);
	}

	/*
	 * @AfterMethod public void tearDown() throws Exception { 
	 * Thread.sleep(1000);
	 * driver.close(); 
	 * driver.quit(); }
	 */

@Test (priority=0)
public void loginTest() {
	
	manageadv.sendUserName("admin");  //1. Enter valid credentials in Login name textbox
	manageadv.sendPassword("123456");  //2. Enter valid credentials in Password textbox
	manageadv.clickLoginBtn();  
}
	
	
	@Test (priority=1,dataProvider = "excel-inputs2", dataProviderClass = LoginDataProviders.class)
	public void manageadv(String memberlogin, String Title, String Example, String price, String desc) throws InterruptedException, AWTException {
	
  
		Thread.sleep(2000);
		manageadv.memberlogin(memberlogin);  //Enter valid credentials in Member login textbox
		manageadv.manageadvert();  // Click on Submit button of Manage advertisements 
		manageadv.Insertnewadvert();  // Click on Submit button of Insert new advertisement
		manageadv.EnterTitle(Title);  // Enter valid credentials in Title textbox
		manageadv.Catagorydrp(Example);  // Select Valid credentials from Category list box
		manageadv.price(price);  // enter valid credentials in Price text box
		manageadv.Notexpirable();  // Click on checkbox of Not expirable
		driver.switchTo().frame(0); //frame in
		manageadv.desc(desc);  // Enter valid credentials in Description text box
		driver.switchTo().defaultContent();  //frame out
		manageadv.submitbutton(); // Click on Submit button
		manageadv.Backbutton();  // Click on Back button
		String ExpectedResult = "Description";
		String ActualResult=driver.findElement(By.xpath("//td[contains(text(),'Description')]")).getText();
		Assert.assertEquals(ActualResult, ExpectedResult);
		System.out.println(ActualResult);
		 Thread.sleep(2000);
		 manageadv.Homebutton();//click on Home tab
	
	}
}