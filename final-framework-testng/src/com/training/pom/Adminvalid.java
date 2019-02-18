package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Adminvalid {
private WebDriver driver; 
	
	public Adminvalid(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="cyclosUsername")
	private WebElement userName; 
	@FindBy(name="password")
	private WebElement password;
	@FindBy(xpath="//*[@id=\"cyclosLogin\"]/table/tbody/tr[3]/td/input")
	private WebElement loginBtn; 
	@FindBy(xpath="//*[@id=\"menu15\"]/span[2]")
	private WebElement logoutbtn;
	
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
	public void clicklogoutbtn() {
		this.logoutbtn.click();
	}	
}
