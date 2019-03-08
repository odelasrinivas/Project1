package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

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
	public void clicklogoutbtn() throws InterruptedException {
		this.logoutbtn.click();
		Thread.sleep(3000);
		String actual_msg = driver.switchTo().alert().getText();
		System.out.println("Alert message is:" + actual_msg);
		driver.switchTo().alert().accept();  //5. Click on OK button
		Assert.assertEquals(actual_msg, "Please confirm to logout");
	}	
}
