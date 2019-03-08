//To verify whether application allows member to view message sent by the admin
package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mysql.jdbc.Messages;
import com.training.generics.ScreenShot;
import com.training.pom.Message;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CYTC_040 {
	private WebDriver driver;
	private String baseUrl;
	private Message message;
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
		message = new Message(driver);
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
	public void messages() throws InterruptedException {
		//Login Admin
		message.LoginName("admin");  //enter admin name
		message.Password("123456");  //enter password
		message.Submit();		//click on Submit button

		message.Messages();		//select the Messages tab on LHE
		message.Messageslink(); //Select the Messageslink under Message tab
		message.Messagelistsubmit();  //3. Click on Submit button of Send a new message
		String ExpectedResult1 = "Send message";
		String ActualResult1 = driver.findElement(By.xpath("//td[@class='tdHeaderTable']")).getText();
		Assert.assertEquals(ActualResult1, ExpectedResult1);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		message.Memebrlogin("manzoor");    //4. Enter valid credentials in Member login text box
		//Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		message.Subjecttext("hello");  //6. Enter valid credentials in Subject textbox
		driver.switchTo().frame(0); // Frame is selected under Description box
		message.Description("Welcome"); //7. enter description in Body Textbox
		driver.switchTo().defaultContent(); // come out from the frame
		message.sendmessagesubmit();  //8. Click on Submit button
		message.Logout();  		//10. Click on Logout button
		message.LoginName("Anjaiah");  //12. Enter valid member name in Login Name
		message.Password("anjaiah");  //13. Enter valid credentials in password textbox
		message.Submit();   //14. click on Submit button
		//Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String ExpectedResult3 = "Logged user: sample - sample";
		String ActualResult3 = driver.findElement(By.xpath("//span[contains(text(),'Logged user: sample - sample')]")).getText();
		Assert.assertEquals(ActualResult3, ExpectedResult3);
		message.personal();   //15. Click on Personal link
		message.memberMessageslink();  //16. Click on Messages link
		message.Clickonmessagetoview();   //17. Click on message to view

	
	}
}