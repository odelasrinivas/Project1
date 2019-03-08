package com.training.pom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Membervalid {
	
private WebDriver driver; 
	
	public Membervalid(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="cyclosUsername")
	private WebElement userName; 
	@FindBy(name="password")
	private WebElement password;
	@FindBy(xpath="//*[@id=\"cyclosLogin\"]/table/tbody/tr[3]/td/input")
	private WebElement loginBtn; 
	@FindBy(xpath="//*[@id=\"menu1\"]/span[2]")
	private WebElement personal;
	@FindBy(xpath="//*[@id=\"submenu1.7\"]/span[2]")
	private WebElement changepassword;
	@FindBy(name="oldPassword")
	private WebElement currentpassword;
	@FindBy(name="newPassword")
	private WebElement newpassword;
	@FindBy(name="newPasswordConfirmation")
	private WebElement confirmnewpassword;
	@FindBy(xpath="//input[@value='Submit']")
	private WebElement clicksubmitbtn;
	
	//---------------------------
	// enter the user name 
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
	//--------------------------------------------
	//click on personla link on LHS
	public void clickpersonalBtn() {
		this.personal.click();
	}
	
	//2. Click on Change password link
	public void clickchangepassword() {
		this.changepassword.click();
	}
	//3. Enter Valid credentials in Current Password textbox
	public void currentpassword(String password) {
		this.currentpassword.sendKeys(password);
	}
	
	//4. Enter Valid credentials in New Password textbox
	public void newpassword(String password) {
		this.newpassword.sendKeys(password);
	}
	//5. Enter Valid credentials in Confirm new Password textbox
	public void confirmnewpassword(String cnpass) {
		this.confirmnewpassword.sendKeys(cnpass);
	}
	//6. Click on Submit button
	public void clicksubmitbtn() throws InterruptedException {
		this.clicksubmitbtn.click();
		//7. Click on OK button of pop up window
		Thread.sleep(3000);
		
		
		
		String actual_msg = driver.switchTo().alert().getText();
		System.out.println("Alert message is:" + actual_msg);
		driver.switchTo().alert().accept();  
		Assert.assertEquals(actual_msg, "The password was modified");
		
		Thread.sleep(3000);
		
		String actual_msg1 = driver.switchTo().alert().getText();
		System.out.println("Alert message is:" + actual_msg1);
		driver.switchTo().alert().accept();
		Assert.assertEquals(actual_msg1,"Passwords are not Equal");
	}
	

}
