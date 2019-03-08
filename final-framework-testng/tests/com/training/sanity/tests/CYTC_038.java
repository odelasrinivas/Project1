//To verify whether application allows member to view loan details in granted by admin
package com.training.sanity.tests;
import org.openqa.selenium.JavascriptExecutor;

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

import com.training.pom.Grantloan;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CYTC_038 {
	private WebDriver driver;
	private String baseUrl;
	private Grantloan grantloan;
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
		grantloan =new Grantloan(driver);
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
	public void advert() throws InterruptedException {
		//Admin login
		grantloan.txtsendusername("admin"); //enter the admin credentials
		grantloan.txtsendpassword("123456"); //enter the password
		grantloan.Btnsubmit(); //click on submit button
		grantloan.txtmemberlogin("Anjaiah"); //enter the Member login text box under Jump to member profile window
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor) driver;     //scroll down
		js.executeScript("scrollBy(0,1000)");								//scroll down
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		grantloan.Bsubmit();	//2.click on the Grant loan submit button under Loans window section
		grantloan.txtAmount("100000"); //3.Enter valid credentials in amount text box
		grantloan.txtdescription("Home loan");  //4.Enter valid credentials in Description textbox
		grantloan.BGsubmit();	//5. Click on Submit button
		grantloan.BLsubmit();  //6. Click on Submit button
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		grantloan.Viewsubmit();  //8. Click on Submit button of View Loans
		grantloan.btnlogout();  	//9. Click on Logout button
		grantloan.txtsendusername("Anjaiah");	//11. Enter valid member name in Login Name
		grantloan.txtsendpassword("anjaiah");		//12. Enter valid credentials in password text box
		grantloan.Btnsubmit();					//13. click on Submit button
		grantloan.tabaccount();				//14. Click on Account tab
		grantloan.linkloans();			//15. Click on Loans link
		//Assert message verificaiton here..//Loans granted by admin should get displayed
		String Expected = "My loans";
		String Actual_msg=driver.findElement(By.xpath("//*[@id=\"tdContents\"]/form/table/tbody/tr[1]/td[1]")).getText();
		Assert.assertEquals(Actual_msg, Expected);
		System.out.println(Actual_msg);
		screenShot.captureScreenShot("Testcase_38");
		
	
		
}
}
