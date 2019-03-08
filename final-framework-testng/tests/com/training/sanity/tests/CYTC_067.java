//To verify whether details stored by the admin get displayed in database
package com.training.sanity.tests;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.dataproviders.LoginDataProviders_CYTC067;

import com.training.generics.GenericMethods;
import com.training.generics.ScreenShot;
import com.training.pom.Changepermission;
import com.training.pom.MemberloginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CYTC_067 {

	private WebDriver driver;
	private String baseUrl;
	private MemberloginPOM memberloginPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private GenericMethods genericMethods;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);

	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		memberloginPOM = new MemberloginPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// genericMethods = new GenericMethods(driver);
		// open the browser
		driver.get(baseUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

	@Test(dataProvider = "db-inputs", dataProviderClass = LoginDataProviders_CYTC067.class)
	public void loginDBTest(String username, String newgrouplist, String commenttextbox) throws InterruptedException {

		memberloginPOM.sendUserName("admin"); // Enter valid credentials user
		memberloginPOM.sendPassword("123456"); // enter the password
		memberloginPOM.clickLoginBtn(); // click on submit button
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String username1= memberloginPOM.Memberlogintxt("manzoor"); // Enter valid credentials in Member login text box
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor) driver; // scroll down
		js.executeScript("scrollBy(0,500)"); // scroll down
		memberloginPOM.Changepermissiongroupbtn(); // Click on Submit button of Change Permission group
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String newgrouplist1 = memberloginPOM.Newgroupdrp("Full members"); // Click on New group list box
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String commenttextbox1 = memberloginPOM.commenttextbox("full access to the member"); // Enter valid credentials in Comments text box
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		memberloginPOM.Submitbutton(); // Click on Submit button
		
		Assert.assertEquals(username1, username);
		Assert.assertEquals(newgrouplist1, newgrouplist);
		Assert.assertEquals(commenttextbox1, commenttextbox);

		screenShot.captureScreenShot("Test case-67");
	
	}
}
