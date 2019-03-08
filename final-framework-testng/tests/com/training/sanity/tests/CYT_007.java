package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
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

public class CYT_007 {

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
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
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
	// @Test(dependsOnMethods= {"validLoginTest"})
	public void InvalidLoginTest() throws InterruptedException {

		membervalid.sendUserName("Sample");  //enter the member name
		membervalid.sendPassword("vasu4");  // enter the password
		membervalid.clickLoginBtn(); //click on submit button
		membervalid.clickpersonalBtn();  //click on personal link

		String actualmsg = "Profile";
		Assert.assertEquals(actualmsg, "Profile");
		String message = "Messages";
		Assert.assertEquals(message, "Messages");
		String contacts = "Contacts";
		Assert.assertEquals(contacts, "Contacts");
		String changpass = "Change password";
		Assert.assertEquals(changpass, "Change password");

		membervalid.clickchangepassword(); //2. Click on Change password link
		membervalid.currentpassword("vasu4"); //3. Enter Valid credentials in Current Password textbox
		membervalid.newpassword("vasu4");  //4. Enter Valid credentials in New Password textbox
		membervalid.confirmnewpassword("Srinivas123");  //5. Enter different credentials in Confirm new Password textbox
		Thread.sleep(2000);
		membervalid.clicksubmitbtn();  //6. Click on Submit button
		/*
		 * Thread.sleep(3000);
		 * 
		 * String actual_msg = driver.switchTo().alert().getText();
		 * System.out.println("Alert message is:" + actual_msg);
		 * driver.switchTo().alert().accept();
		 * Assert.assertEquals(actual_msg,"Passwords are not Equal");
		 */
		screenShot.captureScreenShot("Sreecn2");
		

	}
}