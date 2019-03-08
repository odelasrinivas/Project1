package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginCyclos;
import com.training.pom.Membervalid;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CYT_006 {
	private WebDriver driver;
	private String baseUrl;
	private Membervalid membervalid;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod // pre-requisities written in this method here
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		membervalid = new Membervalid(driver);
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
	public void validLoginTest() throws InterruptedException {
		//Log in as a member
		membervalid.sendUserName("sample");  //enter the member credentials
		membervalid.sendPassword("vasu4");    // enter the password
		membervalid.clickLoginBtn();   // click on submit button
		membervalid.clickpersonalBtn();	//1. Click on Personal link
		String actualmsg = "Profile";
		Assert.assertEquals(actualmsg, "Profile");
		String message = "Messages";
		Assert.assertEquals(message, "Messages");
		String contacts = "Contacts";
		Assert.assertEquals(contacts, "Contacts");
		String changpass = "Change password";
		Assert.assertEquals(changpass, "Change password");
		membervalid.clickchangepassword();  //2. Click on Change password link
		membervalid.currentpassword("vasu4");  //3. Enter Valid credentials in Current Password text box
		membervalid.newpassword("vasu5");  //4. Enter Valid credentials in New Password text box
		membervalid.confirmnewpassword("vasu5");  //5. Enter Valid credentials in Confirm new Password text box
		Thread.sleep(2000);
		membervalid.clicksubmitbtn();		//6. Click on Submit button
		/*
		 * Thread.sleep(3000); String actual_msg = driver.switchTo().alert().getText();
		 * System.out.println("Alert message is:" + actual_msg);
		 * driver.switchTo().alert().accept(); //7. Click on OK button of pop up window
		 * Assert.assertEquals(actual_msg, "The password was modified");
		 */
		screenShot.captureScreenShot("screen2");  //take the screen shot

	}
}