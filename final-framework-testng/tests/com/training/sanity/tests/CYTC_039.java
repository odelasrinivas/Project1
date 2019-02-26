package com.training.sanity.tests;

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
import com.training.generics.ScreenShot;


import com.training.pom.Repay;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CYTC_039 {
	private WebDriver driver;
	private String baseUrl;
	private Repay repay;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod 
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		repay = new Repay(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
		
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.close();
		driver.quit();
	}

	@Test(priority = 1)
	public void repay() throws InterruptedException {
		
		//Member login
		repay.txtsendusername("sample"); //enter the member user name
		repay.txtsendpassword("vasu3"); //enter the password
		repay.Btnsubmit();				//click on submit button
		repay.tabaccount();	//1. Click on Account tab
		repay.linkloans();	//2. Click on Loans link
		repay.viewicon();	//3. Click on View icon
		repay.txtamount("200");	//4. Enter Valid credentials in Amount text box
		repay.buttonrepay(); 	//5. Click on Repay button
		repay.tabaccount(); //8. Click on Account tab
		repay.accountinformation();	//9. Click on Account Information link
		screenShot.captureScreenShot("Testcase_39");
		
		
}
}