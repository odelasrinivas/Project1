//To verify whether application allows admin to create an category under advertisement section, create advertisement based on the category & member to view advertisement
package com.training.sanity.tests;

import java.awt.List;
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
import com.training.dataproviders.LoginDataProviders_CYTC069;
import com.training.generics.GenericMethods;
import com.training.generics.ScreenShot;
import com.training.pom.AdvertisementPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CYTC_069 {

	private WebDriver driver;
	private String baseUrl;
	private AdvertisementPOM advertisementPOM;
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
		advertisementPOM = new AdvertisementPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		genericMethods = new GenericMethods(driver);
		// open the browser
		driver.get(baseUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		 driver.quit();
	}

	@Test(dataProvider = "db-inputs", dataProviderClass = LoginDataProviders_CYTC069.class)
	public void loginDBTest(String name, String memberlogin, String title, String category, String price, String description, String loginname, String password) throws InterruptedException {

		advertisementPOM.sendUserName("admin"); // Enter valid credentials on admin
		advertisementPOM.sendPassword("123456"); // enter the password
		advertisementPOM.clickLoginBtn(); // click on submit
		advertisementPOM.advertisement(); // Click on Advertisement tab on LHS
		advertisementPOM.mangecategories(); // Click on manage categories link
		advertisementPOM.subitbtn(); // Click on Submit button of Insert New Category section
		
		String name1 = advertisementPOM.name("special offer"); // Enter valid details in Name textbox
		
		advertisementPOM.submit(); // Click on Submit button
		advertisementPOM.Home(); // Click on Home tab
		
		String memberlogin1 = advertisementPOM.memberlogin("srinu"); // Enter valid credentials in Member login textbox
		
		advertisementPOM.manageadvertisementbtn(); // Click on Submit button of Manage advertisements
		advertisementPOM.Insertsubmitbtn(); // Click on Submit button of Insert new advertisement
		
		String title1 = advertisementPOM.title("new offer"); // Enter valid credentials in Title textbox
	
		String category1 = advertisementPOM.category("Example ad category"); // Select Valid credentials from Category list box
		System.out.println(category1);
		String price1 = advertisementPOM.price("0,07"); // enter valid credentials in Price text box
		
		advertisementPOM.notexpirable(); // Click on checkbox of Not expirable
		
		driver.switchTo().frame(0); // Frame is selected under Description box
		
		String description1 = advertisementPOM.description("new offer for member"); // Enter valid credentials in Description text box
		
		driver.switchTo().defaultContent(); // comeout from the frame
		advertisementPOM.newsubmit();// Click on Submit button
		advertisementPOM.Back(); // Click on Back button
		advertisementPOM.logout(); // Click on logout button
		
		String loginname1 = advertisementPOM.sendUserName("srinu"); // Enter valid credentials on member
		String password1 = advertisementPOM.sendPassword("5678"); // enter the password
		
		advertisementPOM.clickLoginBtn(); // click on submit
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		advertisementPOM.personal(); // Click on Personal tab
	
		advertisementPOM.advertisement(); // Click on Advertisement link
		

		Assert.assertEquals(name1, name);
		Assert.assertEquals(memberlogin1, memberlogin);
		Assert.assertEquals(title1, title);
		Assert.assertEquals(category1, category);
		Assert.assertEquals(price1, price);
		Assert.assertEquals(description1, description);
		Assert.assertEquals(loginname1, loginname);
		Assert.assertEquals(password1, password);

		screenShot.captureScreenShot("Test case-69");
	}
}
