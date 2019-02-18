package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cleartext {

	private WebDriver driver;

	public Cleartext(WebDriver driver) {
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
	@FindBy(xpath = "//span[contains(text(),'Profile')]")
	private WebElement profiletab;
	@FindBy(xpath = "//input[@id='modifyButton']")
	private WebElement changebtn;
	@FindBy(name = "admin(name)")
	private WebElement clearfullname;
	@FindBy(id = "saveButton")
	private WebElement savebtn;

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

	public void clickprofiletab() {
		this.profiletab.click();

	}

	public void clickchangebtn() {
		this.changebtn.click();
	}

	public void clearfullnametxt() {
		this.clearfullname.clear();
	}

	public void clearfullnametxt(String name) {
		this.clearfullname.sendKeys(name);
	}

	public void savebutton() {
		this.savebtn.click();
	}

}
