package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Admin_Changepss {

	private WebDriver driver;

	public Admin_Changepss(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "cyclosUsername")
	private WebElement userName;
	@FindBy(name = "password")
	private WebElement password;
	@FindBy(xpath = "//*[@id=\"cyclosLogin\"]/table/tbody/tr[3]/td/input")
	private WebElement loginBtn;
	@FindBy(xpath = "//span[contains(text(),'Personal')]")
	private WebElement personaltab;
	@FindBy(xpath="//*[@id=\"submenu1.1\"]/span[2]")
	private WebElement changepassword;
	@FindBy(name="oldPassword")
	private WebElement currentpassword;
	@FindBy(name="newPassword")
	private WebElement newpassword;
	@FindBy(name="newPasswordConfirmation")
	private WebElement confirmnewpassword;
	@FindBy(xpath="//input[@value='Submit']")
	private WebElement submitbtn;
	
	//enter the username
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	//enter the password
	public void sendPassword(String password) {
		this.password.clear();
		this.password.sendKeys(password);
	}
//click on login button
	public void clickLoginBtn() {
		this.loginBtn.click();
	}
	//1. Click on Personal Link
	public void clickpersonaltab() {
		this.personaltab.click();

	}
	//2. Click on Change password link
	public void changepassword() {
		this.changepassword.click();
	}
	//3. Enter Valid credentials in Current Password textbox
	public void currentpassword(String username) {
		this.currentpassword.sendKeys(username);
	}
	//4. Enter Valid credentials in New Password textbox
	public void newpassword(String password) {
		this.newpassword.sendKeys(password);
		
	}
	//5. Enter Valid credentials in Confirm new Password textbox
	public void confirmnewpassword(String confirm) {
		this.confirmnewpassword.sendKeys(confirm);
	}
	
	//6. Click on Submit button
	public void submit() throws InterruptedException {
		this.submitbtn.click();
		Thread.sleep(2000);
		String actual_msg = driver.switchTo().alert().getText();
		System.out.println("Alert message is:" + actual_msg);
		driver.switchTo().alert().accept();   //7. Click on OK button of pop up window
		Assert.assertEquals(actual_msg, "The password was modified");
	}
	
}
