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

public class Manageadv {
	private WebDriver driver;

	public Manageadv(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// enter the user name
	@FindBy(id = "cyclosUsername")
	private WebElement userName;

	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}

	// click on password
	@FindBy(name = "password")
	private WebElement password;

	public void sendPassword(String password) {
		this.password.clear();
		this.password.sendKeys(password);
	}

	// click on submit button
	@FindBy(xpath = "//td[@colspan='2']//input[@value='Submit']")
	private WebElement loginBtn;

	public void clickLoginBtn() {
		this.loginBtn.click();
	}

	@FindBy(xpath = "//*[@id=\"menu15\"]/span[2]")
	private WebElement logoutbtn;

	// Enter valid credentials in Member login textbox
	@FindBy(xpath = "//input[@id='memberUsername']")
	private WebElement memberlogin;

	public void memberlogin(String memberlogin) throws AWTException {
		this.memberlogin.sendKeys(memberlogin);

		driver.findElement(By.id("memberUsername")).click();
		;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Create object on Actions class
		Actions builder = new Actions(driver);

		// find the element which we want to Select from auto suggestion
		WebElement ele = driver.findElement(By.xpath("//div[@id='membersByUsername']/ul/li[2]"));

		// use Mouse hover action for that element
		builder.moveToElement(ele).build().perform();

		// Give wait for 2 seconds
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// finally click on that element
		builder.click(ele).build().perform();

	}

// Click on Submit button of Manage advertisements 	 	
	@FindBy(xpath = "//tr[4]//td[1]//fieldset[1]//table[1]//tbody[1]//tr[1]//td[2]//input[1]")
	private WebElement manageadvert;

	public void manageadvert() {
		this.manageadvert.click();
	}

	// Click on Submit button of Insert new advertisement
	@FindBy(id = "newButton")
	private WebElement Insertnewadvert;

	public void Insertnewadvert() {
		this.Insertnewadvert.click();
	}

	// Enter valid credentials in Title text box
	@FindBy(name = "ad(title)")
	private WebElement EnterTitle;

	public void EnterTitle(String Title) {
		this.EnterTitle.sendKeys(Title);
	}

	// Select Valid credentials from Category list box
	@FindBy(name = "ad(category)")
	private WebElement Catagorydrp;

	public void Catagorydrp(String Example) {
		// this.Catagorydrp.click();

		WebElement catagory = driver.findElement(By.name("ad(category)")); // select the Category dropdown under New advertisement screen
		Select action = new Select(catagory);
		action.selectByVisibleText(Example); // select the New Category under dropdown list on New advertisement screen

	}

	// enter valid credentials in Price text box
	@FindBy(name = "ad(price)")
	private WebElement price;

	public void price(String price) {
		this.price.sendKeys(price);
	}

	// Click on checkbox of Not expirable
	@FindBy(id = "notExpirableCheck")
	private WebElement Notexpirable;

	public void Notexpirable() {
		this.Notexpirable.click();
	}

	// Enter valid credentials in Description text box
	@FindBy(xpath = "//*[@class='CSS1Compat']")
	private WebElement desc;

	public void desc(String desc) {
		this.desc.sendKeys(desc);
	}

	// Click on Submit button
	@FindBy(id = "saveButton")
	private WebElement submitbutton;

	public void submitbutton() throws InterruptedException {
		this.submitbutton.click();

		String msgg = driver.switchTo().alert().getText();
		System.out.println("Alert message is:" + msgg);
		driver.switchTo().alert().accept();
		Assert.assertEquals(msgg, "Advertisement inserted");
	}

	// Click on Back button
	@FindBy(id = "backButton")
	private WebElement Backbutton;

	public void Backbutton() {
		this.Backbutton.click();
	}

	//
	@FindBy(xpath = "//span[contains(text(),'Home')]")
	private WebElement Homebutton;

	public void Homebutton() {
		this.Homebutton.click();
	}

}