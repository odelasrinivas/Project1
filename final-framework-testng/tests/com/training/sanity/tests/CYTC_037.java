//To verify whether application allows member to view removed advertisement by admin
package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.training.generics.ScreenShot;
import com.training.pom.Account;
import com.training.pom.Advert;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CYTC_037 {
	private WebDriver driver;
	private String baseUrl;
	private Advert advert;
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
		advert = new Advert(driver);
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

	@Test(priority=0)
	public void adverts() throws InterruptedException {

		// Admin Login
		advert.txtsendusername("admin"); // enter login name
		advert.txtsendpassword("123456"); // enter password
		advert.Btnsubmit(); // click on submit button
		advert.txtmemberlogin("Anjaiah"); // Enter member Login text box
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;     //scroll down
		js.executeScript("scrollBy(0,500)");								//scroll down
		Thread.sleep(5000);
		advert.buttonsubmit(); // Click on submit button under Advertisements

		// Assert message verification here..
		String Expected = "Advertisements of Anjaiah";  
		String Actual_msg0 = driver.findElement(By.xpath("//td[@class='tdHeaderTable']")).getText();
		Assert.assertEquals(Actual_msg0, Expected);
		System.out.println(Actual_msg0);
		
		advert.idbutton(); // click on submit button under Advertisements of sample screen
		advert.txtTitle("TestTen"); // Enter the Title textbox under New advertisement screen
		advert.catagory();
		advert.price("5000"); // Enter the price text box
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().frame(0); // Frame is selected under Description box
		advert.desc("This is srinivas"); // Enter text field under frame description box
		driver.switchTo().defaultContent(); // comeout from the frame
		advert.savebutton(); // Click on submit button under New advertisement screen
		screenShot.captureScreenShot("Test case-37a Test data");
		advert.BtnLogout(); // Click on Logout button
}

	@Test(priority=1)
	public void advert() throws InterruptedException {

		// Admin login
		advert.txtsendusername("admin"); // enter the admin creditials
		advert.txtsendpassword("123456"); // enter the password
		advert.Btnsubmit(); // click on submit button
		advert.txtmemberlogin("Anjaiah"); // Enter member Login text box
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		advert.buttonsubmit(); // Click on submit button under Advertisements
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		screenShot.captureScreenShot("Test case-37b");
		
		advert.Remove(); // click on remove button
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Alert pop-up message verification here.....
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String actual_msg1 = driver.switchTo().alert().getText();
		System.out.println("Alert message is:" + actual_msg1);
		driver.switchTo().alert().accept();
		Assert.assertEquals(actual_msg1, "Advertisement removed");

		advert.BtnLogout(); // click on logout button
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Member login
		advert.txtsendusername("Anjaiah"); // enter the member login credentials
		advert.txtsendpassword("anjaiah"); // enter the password
		advert.Btnsubmit(); // click on submit button
		advert.tabPersonal(); // click on Personal tab on LHS
		advert.tabadvertisement(); // click on Advertisement link on LHS under personal tab
		// Assert message printing here.. //validate here Advertisement should be removed from the module
		String Expected = "Advertisements";
		String Actual_msg3 = driver.findElement(By.xpath("//*[@id=\"submenu1.2\"]/span[2]")).getText();
		Assert.assertEquals(Actual_msg3, Expected);
		System.out.println(Actual_msg3);

		screenShot.captureScreenShot("Test case-37c");

	}

}
