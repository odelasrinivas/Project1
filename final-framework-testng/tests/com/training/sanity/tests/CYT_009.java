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
//import com.training.pom.Adminvalid;
import com.training.pom.Cleartext;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CYT_009 {
	private WebDriver driver;
	private String baseUrl;
	private Cleartext cleartext;
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
		cleartext = new Cleartext(driver);
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
	public void cleartext() throws InterruptedException {
		cleartext.sendUserName("admin");
		cleartext.sendPassword("123456");
		cleartext.clickLoginBtn();
		cleartext.clickpersonaltab();

		// String profiletext =
		// driver.findElement(By.xpath("//span[contains(text(),'Profile')]")).getText();

		// System.out.println("Profile Text is..." + profiletext);

		String actualmsg = "Profile";
		Assert.assertEquals(actualmsg, "Profile");

		// String changetext =
		// driver.findElement(By.xpath("//span[contains(text(),'Change
		// Password')]")).getText();
		// System.out.println("change Text is..." + changetext);

		String changetext = "Change Password";
		Assert.assertEquals(changetext, "Change Password");

		// String email = driver.findElement(By.xpath("//span[contains(text(),'E-Mail
		// Notifications')]")).getText();
		// System.out.println("Email Text is..." + email);

		String email = "E-Mail Notifications";
		Assert.assertEquals(email, "E-Mail Notifications");

		cleartext.clickprofiletab();
		cleartext.clickchangebtn();
		Thread.sleep(2000);
		cleartext.clearfullnametxt();
		Thread.sleep(2000);
		cleartext.clearfullnametxt("admini");
		cleartext.savebutton();
		Thread.sleep(2000);
		String actual_msg = driver.switchTo().alert().getText();
		System.out.println("Alert message is:" + actual_msg);
		driver.switchTo().alert().accept();
		Assert.assertEquals(actual_msg, "Profile modified");
		screenShot.captureScreenShot("Fourth");

	}
}