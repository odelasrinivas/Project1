package com.training.pom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Advert {
	
	
	private WebDriver driver;
	 public Advert(WebDriver driver) {
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
	 }
	 
	 @FindBy(name="principal")
	 private WebElement txtuserName;
	 @FindBy(name="password")
	 private WebElement txtpassword;
	 @FindBy(xpath="//*[@id=\"cyclosLogin\"]/table/tbody/tr[3]/td/input")
	 private WebElement Btnsubmit;
	 
	 @FindBy(id="memberUsername")
	 private WebElement txtmemberlogin;
	 @FindBy(xpath="//tbody//tr[4]//td[1]//fieldset[1]//table[1]//tbody[1]//tr[1]//td[2]//input[1]")
	 private WebElement Buttonsubmit;
	 

	 
	 @FindBy(id="newButton")
	 private WebElement idbutton;
	 @FindBy(name="ad(title)")
	 private WebElement txtTitle;
	@FindBy(name="ad(category)")
	private WebElement category;
	
	@FindBy(name="ad(price)")
	private WebElement price;
	@FindBy(xpath="//*[@class='CSS1Compat']")
	private WebElement desc;
	@FindBy(id="saveButton")
	private WebElement savebutton;
	
	
	
	 
	 @FindBy(xpath="//*[@id=\"tdContents\"]/table[1]/tbody/tr[2]/td/table/tbody/tr[2]/td[6]/img[2]")
	 private WebElement Remove;
	 @FindBy(xpath="//*[@id=\"menu15\"]/span[2]")
	 private WebElement BtnLogout;
	 @FindBy(xpath="//*[@id=\"menu1\"]/span[2]")
	 private WebElement tabPersonal;
	 @FindBy(xpath="//*[@id=\"submenu1.2\"]/span[2]")
	 private WebElement tabadvertisement;
	 
	 
	 //enter the user name
	 public void txtsendusername(String userName) {
		 this.txtuserName.clear();
		 this.txtuserName.sendKeys(userName);
	 }
	 //enter the password
	 public void txtsendpassword(String password) {
		 this.txtpassword.clear();
		 this.txtpassword.sendKeys(password);
	 }
	 //click on submit button
	 public void Btnsubmit() {
		 this.Btnsubmit.click();
	 }
	//click on memberlogin
	public void txtmemberlogin(String memberlogin) {
		this.txtmemberlogin.sendKeys(memberlogin);
		}
	
	public void buttnsubmit() {
		this.Buttonsubmit.click();
	}
	
	public void idbutton() {
		this.idbutton.click();
	}
		
	public void txtTitle(String text) {
	this.txtTitle.sendKeys(text);
	}
	
	public void catagory() {
	//	this.catagory();
		
		WebElement catagory = driver.findElement(By.name("ad(category)")); // select the Category dropdown under New advertisement screen
		Select action = new Select(catagory);
		action.selectByVisibleText("New Category"); // select the New Category under dropdown list on New advertisement screen
	}
	
	
	 //----------------------------------
	public void price(String price) {
		this.price.sendKeys(price);
	}
	public void desc(String desc) {
		this.desc.sendKeys(desc);
	}
	public void savebutton() {
		this.savebutton.click();
		String actual_msgg = driver.switchTo().alert().getText();
		System.out.println("Alert message is:" + actual_msgg);
		driver.switchTo().alert().accept();
		Assert.assertEquals(actual_msgg, "Advertisement inserted");
	}
	
	public void buttonsubmit() {
		 this.Buttonsubmit.click();
	 }
	 public void Remove() {
		 this.Remove.click();
		// Alert pop-up message verification here...

			String actual_msg0 = driver.switchTo().alert().getText();
			System.out.println("Alert message is:" + actual_msg0);
			driver.switchTo().alert().accept();
			Assert.assertEquals(actual_msg0, "Remove advertisement?");
			
	 }
	 public void BtnLogout() {
		 this.BtnLogout.click();
		 
		// Alert pop-up message verification here
			String actual_msg2 = driver.switchTo().alert().getText();
			System.out.println("Alert message is:" + actual_msg2);
			driver.switchTo().alert().accept();
			Assert.assertEquals(actual_msg2, "Please confirm to logout");
	 }
	 public void tabPersonal() {
		 this.tabPersonal.click();
	 }
	 public void tabadvertisement() {
		 this.tabadvertisement.click();
	 }
	

}
