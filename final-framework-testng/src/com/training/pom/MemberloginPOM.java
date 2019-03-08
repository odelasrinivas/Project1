package com.training.pom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MemberloginPOM {
	private WebDriver driver;

	public MemberloginPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// enter the username
	@FindBy(name = "principal")
	private WebElement userName;

	public String sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
		return this.userName.getAttribute("value");
	}

	// enter the password
	@FindBy(name = "password")
	private WebElement password;

	public String sendPassword(String password) {
		this.password.clear();
		this.password.sendKeys(password);
		return this.password.getAttribute("value");
	}

	// click on submit button
	@FindBy(xpath = "//td[@colspan='2']//input[@value='Submit']")
	private WebElement SubmitBtn;

	public void clickLoginBtn() {
		this.SubmitBtn.click();
	}

	// enter the valid credentials on member login text box
	@FindBy(xpath = "//input[2]")
	private WebElement Memberlogin;

	public String Memberlogintxt(String member) {
		this.Memberlogin.sendKeys("manzoor");
		
		driver.findElement(By.xpath("//div[@id='membersByUsername']/ul/li[2]")).click(); 
		return this.Memberlogin.getText();
	}

	// Click on Submit button of Change Permission group
	@FindBy(xpath = "//fieldset/table/tbody/tr[2]/td[2]/input")
	private WebElement Changepermissiongroup;

	public void Changepermissiongroupbtn() {
		this.Changepermissiongroup.click();
	}

	// Click on New group list box
	@FindBy(xpath = "//select[@name='newGroupId']")
	private WebElement NewGroup;

	public String Newgroupdrp(String dropdown) throws InterruptedException {
		this.NewGroup.sendKeys("Full members");
		return this.NewGroup.getAttribute("value");
		//return this.NewGroup.getText();
	}

	// Enter valid credentials in Comments text box
	@FindBy(name = "comments")
	private WebElement commentstxt;

	public String commenttextbox(String text) {
		this.commentstxt.sendKeys(text);
		return this.commentstxt.getAttribute("value");
	}

	// Click on Submit button
	@FindBy(xpath = "//input[@value='Submit']")
	private WebElement Submitbutton;

	public void Submitbutton() throws InterruptedException {
		this.Submitbutton.click();

		// Click on OK button of pop up window
		/*
		 * String actual_msgg = driver.switchTo().alert().getText();
		 * System.out.println("Alert message is:" + actual_msgg);
		 * driver.switchTo().alert().accept(); Assert.assertEquals(actual_msgg,
		 * "The member's group was changed");
		 */

		driver.switchTo().alert().accept();
	}

}
