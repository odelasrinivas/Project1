package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Message {
	
	private WebDriver driver;
	 public Message(WebDriver driver) {
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
	 }
	 
	 
	 @FindBy(name="principal")
	 private WebElement LoginName;
	 @FindBy(name="password")
	 private WebElement Password;
	 @FindBy(xpath="//*[@id=\"cyclosLogin\"]/table/tbody/tr[3]/td/input")
	 private WebElement Submit;
	//----------------------------------
	 @FindBy(xpath="//*[@id=\"menu8\"]/span[2]")
	 private WebElement Messages;
	 @FindBy(xpath="//*[@id=\"submenu8.0\"]/span[2]")
	 private WebElement Messageslink;
	 @FindBy(id="newButton")
	 private WebElement Messagelistsubmit;
	 
	 @FindBy(id="memberUsername")
	 private WebElement Memberlogin;
	 @FindBy(name="message(category)")
	 private WebElement Category;
	 @FindBy(name="message(subject)")
	 private WebElement Subjecttext;
	 
	 @FindBy(xpath="//html[@class='CSS1Compat']")
	 private WebElement Description;
	 @FindBy(xpath="//input[@value='Submit']")
	 private WebElement sendmessagesubmit;
	 @FindBy(xpath="//span[contains(text(),'Logout')]")
	 private WebElement Logout;
	 //--------------------------------------
	 
	 @FindBy(xpath="//*[@id=\"menu1\"]/span[2]")
	 private WebElement personal;
	 @FindBy(xpath="//*[@id=\"submenu1.1\"]/span[2]")
	 private WebElement memberMessageslink;
	 @FindBy(xpath="//*[@id=\"tdContents\"]/form[2]/table[1]/tbody/tr[2]/td/table/tbody/tr[2]/td[3]/table/tbody/tr/td[2]/a")
	 private WebElement Clickonmessagetoview;
	 
	 //---------------------------------------------------
	 public void LoginName(String userName) {
		 this.LoginName.clear();
		 this.LoginName.sendKeys(userName);
	 }
	 public void Password(String password) {
		 this.Password.clear();
		 this.Password.sendKeys(password);
	 }
	 public void Submit() {
		 this.Submit.click();
	 }
	 //-------------------------------------
	 
	 public void Messages() {
		 this.Messages.click();
	 }
	 public void Messageslink() {
		 this.Messageslink.click();
	 }
	 public void Messagelistsubmit() {
		 this.Messagelistsubmit.click();
	 }
	 
	 //-----------------------------------------
	 public void Memebrlogin(String text) throws InterruptedException {
		 this.Memberlogin.sendKeys(text);
		 
		// Create object on Actions class
			Actions builder = new Actions(driver);

			// find the element which we want to Select from auto suggestion
			WebElement ele = driver.findElement(By.xpath("//div[@id='membersByUsername']/ul/li[2]"));

			// use Mouse hover action for that element
			builder.moveToElement(ele).build().perform();
			// System.out.println("********************");
			// Give wait for 2 seconds
			Thread.sleep(2000);

			// finally click on that element
			builder.click(ele).build().perform();

			// System.out.println("******done**************");
			// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Thread.sleep(2000);
}
	 
	 public void Category() {
		 this.Category.isSelected();
		 WebElement catagory = driver.findElement(By.name("message(category)")); // select the Category dropdown under New advertisement screen
			Select action = new Select(catagory);
			action.selectByVisibleText("Loan request"); // select the New Category under dropdown list on New advertisement screen
 }
	 public void Subjecttext(String subjecttext) {
		 this.Subjecttext.sendKeys(subjecttext);
	 }
	 
	 public void Description(String description) {
		 this.Description.sendKeys(description);
	 }
	 public void sendmessagesubmit() {
		 this.sendmessagesubmit.click();
		 
		 	String actual_msgg = driver.switchTo().alert().getText();
			System.out.println("Alert message is:" + actual_msgg);
			driver.switchTo().alert().accept();			//9. Click OK button of pop up window
			Assert.assertEquals(actual_msgg, "The message was successfully sent");
	 }
	 	public void Logout() {
		 this.Logout.click();
		 String actual_msgg1 = driver.switchTo().alert().getText();
			System.out.println("Alert message is:" + actual_msgg1);
			driver.switchTo().alert().accept();				//	11. Click OK Button
			Assert.assertEquals(actual_msgg1, "Please confirm to logout");
			
			String ExpectedResult2 = "Login";
			String ActualResult2 = driver.findElement(By.xpath("//div[contains(text(),'Login')]")).getText();
			Assert.assertEquals(ActualResult2, ExpectedResult2);
			
	 }
	 //----------------------------------------------
	 public void personal() {
		 this.personal.click();
	 }
	 public void memberMessageslink() {
		 this.memberMessageslink.click();
	 }
	 public void Clickonmessagetoview() {
		 this.Clickonmessagetoview.click();
		 
			String ExpectedResult = "Message details";
			String ActualResult = driver.findElement(By.xpath("//*[@id=\"tdContents\"]/table[1]/tbody/tr[1]/td[1]")).getText();
			// System.out.println("ExpectedResult is:"+ActualResult);
			Assert.assertEquals(ActualResult, ExpectedResult);
	 }
	 
}
