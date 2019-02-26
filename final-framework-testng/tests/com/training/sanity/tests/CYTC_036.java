package com.training.sanity.tests;

import java.awt.Desktop.Action;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.training.generics.ScreenShot;
import com.training.pom.Account;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CYTC_036 {
	private WebDriver driver;
	private String baseUrl;
	private Account account;
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
		account =new Account(driver);
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

	@Test(priority=1)
	public void account() throws InterruptedException {
		account.txtsendusername("sample");
		account.txtsendpassword("vasu3");
		account.Btnsubmit();
		account.tabaccout();
		String actual_msg="Account Information"; 
		 Assert.assertEquals(actual_msg, "Account Information");
		 String actual_msg1="Scheduled payments"; 
		 Assert.assertEquals(actual_msg1, "Scheduled payments");
		 String actual_msg2="Invoices"; 
		 Assert.assertEquals(actual_msg2, "Invoices");
		 String actual_msg3="Loans"; 
		 Assert.assertEquals(actual_msg3, "Loans");
		  
		 account.tabmemberpayment(); 
		 String expectedmsg="Payment to member"; String
		 actualmes=driver.findElement(By.xpath("//*[@id=\"tdContents\"]/form/table/tbody/tr[1]/td[1]")).getText();
		 Assert.assertEquals(actualmes, expectedmsg);
		 driver.findElement(By.id("memberUsername")).sendKeys("selenium");
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
		  // Create object on Actions class
		  Actions builder=new Actions(driver);

		  // find the element which we want to Select from auto suggestion
		  WebElement ele=driver.findElement(By.xpath("//div[@id='membersByUsername']/ul/li[2]"));

		  // use Mouse hover action for that element
		  builder.moveToElement(ele).build().perform();

		  // Give wait for 2 seconds 
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
		  // finally click on that element
		  builder.click(ele).build().perform();
		
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		  account.txtamount("5000");
		
		  //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		  account.txtdescription("Birthday Gift");
		  account.Buttonsubmit();
		
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		  String Expected_meg ="Transaction confirmation";
		  String Actual_meg = driver.findElement(By.xpath("//*[@id=\"tdContents\"]/form/table[1]/tbody/tr[1]/td[1]")).getText();
		  Assert.assertEquals(Actual_meg, Expected_meg);
		
		  account.Transactionsubmit();
		  account.tabAccountInformation();
		  String Expected_meg1 ="Search transactions on Member account";
		  String Actual_meg1 = driver.findElement(By.xpath("//td[@class='tdHeaderTable']")).getText();
		  Assert.assertEquals(Actual_meg1, Expected_meg1);
		
		  screenShot.captureScreenShot("Test case_36");
		
		
	}
}