package com.training.pom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	public void clickpersonalBtn() {
		this.personal.click();
	}
	public void clickchangepassword() {
		this.changepassword.click();
	}
	public void currentpassword(String password) {
		this.currentpassword.sendKeys(password);
	}
	public void newpassword(String password) {
		this.newpassword.sendKeys(password);
	}
	public void confirmnewpassword(String cnpass) {
		this.confirmnewpassword.sendKeys(cnpass);
	}
	public void clicksubmitbtn() {
		this.clicksubmitbtn.click();
	}
	

}
