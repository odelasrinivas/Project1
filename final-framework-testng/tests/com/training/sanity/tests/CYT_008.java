package com.training.sanity.tests;

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
import com.training.pom.Adminvalid;
//import com.training.pom.Membervalid;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CYT_008 {

	private WebDriver driver;
	private String baseUrl;
	private Adminvalid adminvalid;
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
		adminvalid = new Adminvalid(driver);
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
	public void adminvalidLoginTest() throws InterruptedException {
		adminvalid.sendUserName("admin");
		adminvalid.sendPassword("123456");
		adminvalid.clickLoginBtn();
		adminvalid.clicklogoutbtn();
		Thread.sleep(3000);
		String actual_msg = driver.switchTo().alert().getText();
		System.out.println("Alert message is:" + actual_msg);
		driver.switchTo().alert().accept();

		Assert.assertEquals(actual_msg, "Please confirm to logout");

		screenShot.captureScreenShot("Screen3");
	}
}