package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	
	public void clickpersonaltab() {
		this.personaltab.click();

	}
	
	public void changepassword() {
		this.changepassword.click();
	}
	public void currentpassword(String username) {
		this.currentpassword.sendKeys(username);
	}
	
	public void newpassword(String password) {
		this.newpassword.sendKeys(password);
		
	}
	public void confirmnewpassword(String confirm) {
		this.confirmnewpassword.sendKeys(confirm);
	}
	
	public void submit() {
		this.submitbtn.click();
	}
	
}
