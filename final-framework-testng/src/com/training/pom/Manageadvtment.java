package com.training.pom;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Manageadvtment {
	private WebDriver driver;
	 public Manageadvtment(WebDriver driver) {
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
	 }
	 //enter the user name
	 	@FindBy(id="cyclosUsername")
		private WebElement userName; 
		//enter on password
	 	@FindBy(name="password")
		private WebElement password;
		//click on submit button
	 	@FindBy(xpath="//td[@colspan='2']//input[@value='Submit']")
		private WebElement loginBtn; 
		//click on logout button
	 	@FindBy(xpath="//*[@id=\"menu15\"]/span[2]")
		private WebElement logoutbtn;
	 	
	 	//enter the member login text box
	 	@FindBy(xpath="//input[@id='memberUsername']")
		private WebElement memberlogin;
	 	//click on manage advert submit button
	 @FindBy(xpath="//tr[4]//td[1]//fieldset[1]//table[1]//tbody[1]//tr[1]//td[2]//input[1]")
	 private WebElement manageadvert;
	 	//click on Inser new advert submit button
		@FindBy(id="newButton")
		private WebElement Insertnewadvert;
	 	//enter the title name text box
		@FindBy(name="ad(title)")
		private WebElement EnterTitle;
		//select catagory dropdown
		@FindBy(name="ad(category)")
		private WebElement Catagorydrp;
		
		//enter the price
		@FindBy(name="ad(price)")
		private WebElement price;
		//select not expirable check box
		@FindBy(id="notExpirableCheck")
		private WebElement Notexpirable;
		//enter desc text box
		@FindBy(xpath="//*[@class='CSS1Compat']")
		private WebElement desc;
		
		// Click on Submit button
		@FindBy(id="saveButton")
		//@FindBy(xpath="//input[@id='saveButton']")
		private WebElement submitbutton;
		//click on Back button
		@FindBy(id="backButton")
		private WebElement Backbutton;
		//click on Home tab
		@FindBy(xpath="//span[contains(text(),'Home')]")
		private WebElement Homebutton;
	 	
//----------------------------
	 
	 //enter the user name
	 public void sendUserName(String userName) {
			this.userName.clear();
			this.userName.sendKeys(userName);
		}
	 //enter the password
		public void sendPassword(String password) {
			this.password.clear(); 
			this.password.sendKeys(password); 
		}
		//click on submit button
		public void clickLoginBtn() {
			this.loginBtn.click(); 
		}
	//enter the memberlogin text box
		public void memberlogin(String memberlogin) throws AWTException {
			this.memberlogin.sendKeys(memberlogin);
			 
			driver.findElement(By.id("memberUsername")).click();;
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
			  
}
		//click on manage advert submit button
		public void manageadvert() {
			this.manageadvert.click();
		}
		//click on Insert new advert submit button
		public void Insertnewadvert() {
			this.Insertnewadvert.click();
		}
		//enter the title text box
		public void EnterTitle(String Title) {
			this.EnterTitle.sendKeys(Title);
		}
		//select the catagory dropdown list
		public void Catagorydrp(String Example) {
			//this.Catagorydrp.click();
			
			WebElement catagory = driver.findElement(By.name("ad(category)")); // select the Category dropdown under New advertisement screen
			Select action = new Select(catagory);
			action.selectByVisibleText(Example); // select the New Category under dropdown list on New advertisement screen
			
		}
		//enter the pice
		public void price(String price) {
			this.price.sendKeys(price);
		}
		//select the Not expirable check box
		public void Notexpirable() {
			this.Notexpirable.click();
		}

	//enter the description
//	  public void desc(String desc) { 
//	  this.desc.sendKeys(desc); }
	 
		// Click on Submit button
		public void submitbutton() throws InterruptedException {
			this.submitbutton.click();
			
			driver.switchTo().alert().accept();
			
		}
		// Click on Back button
		public void Backbutton() {
			this.Backbutton.click();
		}
		//click on Home tab
		public void Homebutton() {
			this.Homebutton.click();
	}
		
}