//To verify whether application allows admin to provide different access to different registered users
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

import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CYTC_066 {
	private WebDriver driver;
	private String baseUrl;
	private Changepermission changepermission;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		changepermission = new Changepermission(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);

		// open the browser
		driver.get(baseUrl);
	}

	@Test(priority = 0)
	public void loginTest() {

		changepermission.sendUserName("admin"); // 1. Enter valid credentials in Login name textbox
		changepermission.sendPassword("123456"); // 2. Enter valid credentials in Password textbox
		changepermission.clickLoginBtn();
	}

	@Test(priority = 1, dataProvider = "excel-inputs", dataProviderClass = LoginDataProviders.class)
	public void changepermission(String memberlogin, String dropdown, String comments) throws InterruptedException, AWTException {
		
		changepermission.memberlogin(memberlogin); //Enter valid credentials in Member login text box
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		changepermission.Changepermissiongroup(); // Click on Submit button of Change Permission group 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		changepermission.newgroup(dropdown); //  Select valid credentials in New group list box
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		changepermission.comment(comments);  // Enter valid credentials in Comments text box
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		changepermission.Submitbutton();  // Click on Submit button
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		changepermission.Homebutton();  // Click on Home tab
		String Expected = "Logged user: admin - admini";
		String Actual_msg = driver.findElement(By.xpath("//span[contains(text(),'Logged user: admin - admini')]")).getText();
		Assert.assertEquals(Actual_msg, Expected);
		System.out.println(Actual_msg);
	}

}