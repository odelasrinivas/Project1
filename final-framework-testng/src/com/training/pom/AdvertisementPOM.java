package com.training.pom;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AdvertisementPOM {
	private WebDriver driver;

	public AdvertisementPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "principal")
	private WebElement userName;

	@FindBy(name = "password")
	private WebElement password;

	@FindBy(xpath = "//td[@colspan='2']//input[@value='Submit']")
	private WebElement SubmitBtn;

	// click on advertisement tab on LHS
	@FindBy(xpath = "//*[@id=\"menu6\"]/span[2]")
	private WebElement advertisementtab;

	// Click on manage categories link
	@FindBy(xpath = "//span[contains(text(),'Manage Categories')]")
	private WebElement mangecategories;
	// Click on Submit button of Insert New Category section
	@FindBy(id = "newButton")
	private WebElement submitbutton;
	// Enter valid details in Name textbox
	@FindBy(name = "category(name)")
	private WebElement nametxt;
	// Click on Submit button
	@FindBy(id = "saveButton")
	private WebElement submit;

	// Click on Home tab
	@FindBy(xpath = "//*[@id=\"menu0\"]/span[2]") //// span[contains(text(),'Home')] ////*[@id="menu0"]/span[2]
	private WebElement Homebutton;
	// Enter valid credentials in Member login textbox
	@FindBy(id = "memberUsername")
	private WebElement memberlogintxt;
	// Click on Submit button of Manage advertisements
	@FindBy(xpath = "//tr[4]//td[1]//fieldset[1]//table[1]//tbody[1]//tr[1]//td[2]//input[1]")
	private WebElement manageadvertisement;
	// Click on Submit button of Insert new advertisement
	@FindBy(id = "newButton")
	private WebElement Insertsubmit;
	// Enter valid credentials in Title textbox
	@FindBy(name = "ad(title)")
	private WebElement title;
	// Select Valid credentials from Category list box
	@FindBy(name = "ad(category)")
	private WebElement category;
	// enter valid credentials in Price text box
	@FindBy(name = "ad(price)")
	private WebElement pricetxt;
	// Click on checkbox of Not expirable
	@FindBy(name = "ad(permanent)")
	private WebElement notexpirablechk;
	
	// Enter valid credentials in Description text box
	@FindBy(xpath = "//html")
	private WebElement descriptiontxt;
	
	// Click on Submit button
	@FindBy(id = "saveButton")
	private WebElement newsubmitbtn;
	
	// Click on Back button
	@FindBy(id = "backButton")
	private WebElement backbtn;
	
	// Click on Logout button
	@FindBy(xpath = "//*[@id=\"menu15\"]/span[2]")
	private WebElement logoutbtn;
	
	
	
	// Click on Personal tab
	@FindBy(xpath = "//*[@id=\"menu1\"]/span[2]") // *[@id=\"menu1\"]/span[2]
	private WebElement personaltab;
	
	// Click on Advertisement link
	@FindBy(xpath = "//span[contains(text(),'Advertisements')]")
	private WebElement Advertisementlink;
	//li[@id='submenu1.2']/span[2]
	
	// -------------------------------------------------
	// enter the username
	public String sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
		return this.userName.getAttribute("value");
	}

	// enter the password
	public String sendPassword(String password) {
		this.password.clear();
		this.password.sendKeys(password);
		return this.password.getAttribute("value");
	}

	// click on submit button
	public void clickLoginBtn() {
		this.SubmitBtn.click();
	}

	// Click on Advertisement tab on LHS
	public void advertisement() {
		this.advertisementtab.click();
	}

	// Click on manage categories link
	public void mangecategories() {
		this.mangecategories.click();
	}

	// Click on Submit button of Insert New Category section
	public void subitbtn() {
		this.submitbutton.click();
	}

	// Enter valid details in Name textbox
	public String name(String text) {
		this.nametxt.sendKeys(text);
		return this.nametxt.getAttribute("value");
	}

	// Click on Submit button
	public void submit() {
		this.submit.click();
		// Click on OK button of pop up window
		String Actual_message = driver.switchTo().alert().getText();
		System.out.println("Alert message is:" + Actual_message);
		driver.switchTo().alert().accept();
		Assert.assertEquals(Actual_message, "The category was inserted");
	}

	// Click on Home tab
	public void Home() {
		this.Homebutton.click();
	}

	// Enter valid credentials in Member login textbox
	public String memberlogin(String member) {
		this.memberlogintxt.sendKeys(member);
		return this.memberlogintxt.getAttribute("value");
	}

	// Click on Submit button of Manage advertisements
	public void manageadvertisementbtn() {
		this.manageadvertisement.click();
	}

	// Click on Submit button of Insert new advertisement
	public void Insertsubmitbtn() {
		this.Insertsubmit.click();
	}

	// Enter valid credentials in Title textbox
	public String title(String name) {
		this.title.sendKeys(name);
		return this.title.getAttribute("value");
	}

	// Select Valid credentials from Category list box
	public String category(String dropdown) throws InterruptedException {
		//this.category.sendKeys(dropdown);

		Actions action = new Actions(driver);
		action.moveToElement(category).click().perform();
		Thread.sleep(2000);
		String ss=driver.findElement(By.xpath("//table/tbody/tr[2]/td//select//option[2]")).getText();
		this.category.sendKeys(dropdown);
		
		/*
		 * List<WebElement> cate=driver.findElements(By.name("ad(category)"));
		 * System.out.println(cate.size());
		 */
		return ss;
		//return cate.get(2).getText();
		//return cate.get(1).getText();
	}

	// enter valid credentials in Price text box
	public String price(String money) {
		this.pricetxt.sendKeys(money);
		return this.pricetxt.getAttribute("value");
	}

	// Click on checkbox of Not expirable
	public void notexpirable() {
		this.notexpirablechk.click();
	}

	// Enter valid credentials in Description text box
	public String description(String newmember) {
		this.descriptiontxt.sendKeys("new offer for member");
		return this.descriptiontxt.getText();
		
	}

	// Click on Submit button
	public void newsubmit() {
		this.newsubmitbtn.click();
		// Click on OK button of pop up window
		String Actual_message1 = driver.switchTo().alert().getText();
		System.out.println("Alert message is:" + Actual_message1);
		driver.switchTo().alert().accept();
		Assert.assertEquals(Actual_message1, "Advertisement inserted");

	}

	// Click on Back button
	public void Back() {
		this.backbtn.click();
	}

	// Click on Logout button
	public void logout() {
		this.logoutbtn.click();
		// Click on OK button of pop up window
		String Actual_message2 = driver.switchTo().alert().getText();
		System.out.println("Alert message is:" + Actual_message2);
		driver.switchTo().alert().accept();
		Assert.assertEquals(Actual_message2, "Please confirm to logout");
	}

	// Click on Personal tab
	public void personal() {
		this.personaltab.click();
	}


	  //Click on Advertisement link 
	public void Advertisement() {
	  this.Advertisementlink.click(); }
	 

}
