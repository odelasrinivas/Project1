//To verify whether application displays appropriate error message upon entering invalid details while creating advertisement
package com.training.sanity.tests;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;


import com.training.pom.Manageadvtment;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CYTC_070 {
	private WebDriver driver;
	private String baseUrl;
	private Manageadvtment manageadvtment;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public  void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		manageadvtment = new Manageadvtment(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);

		// open the browser
		driver.get(baseUrl);
	}

	@Test (priority=0)
	public void loginTest() {
		
		manageadvtment.sendUserName("admin");  //1. Enter valid credentials in Login name textbox
		manageadvtment.sendPassword("123456");  //2. Enter valid credentials in Password textbox
		manageadvtment.clickLoginBtn();  //click on submit button
	}
	
	
	@Test (priority=1,dataProvider = "excel-inputs3", dataProviderClass = LoginDataProviders.class)
	public void manageadvtment(String memberlogin, String Title, String Example, String price) throws InterruptedException, AWTException {
	
	
		manageadvtment.memberlogin(memberlogin); // Enter  credentials in Member login textbox
		manageadvtment.manageadvert(); // Click on Submit button of Manage advertisements 
		
		manageadvtment.Insertnewadvert(); // Click on Submit button of Insert new advertisement
		
		manageadvtment.EnterTitle(Title); // Enter  credentials in Title textbox
		
		manageadvtment.Catagorydrp(Example); // Select  credentials from Category list box
		
		manageadvtment.price(price); // enter  credentials in Price text box
		
		//driver.switchTo().frame(0);  //frame in
		//manageadvtment.desc(desc);  // Enter  credentials in Description text box
		//driver.switchTo().defaultContent();  //frame out
		
		manageadvtment.submitbutton();  // Click on Submit button
		
		manageadvtment.Backbutton();  // Click on Back button
		String ExpectedResult = "Description"; 
		String ActualResult =driver.findElement(By.xpath("//td[contains(text(),'Description')]")).getText();
		Assert.assertEquals(ActualResult, ExpectedResult);
		System.out.println(ActualResult); 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		manageadvtment.Homebutton();  //click on Home button
		 
		}
}