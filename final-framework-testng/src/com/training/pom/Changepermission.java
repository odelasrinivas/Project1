package com.training.pom;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.training.readexcel.ApachePOIExcelRead;

public class Changepermission {
	private WebDriver driver;

	public Changepermission(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// enter the user name
	@FindBy(id = "cyclosUsername")
	private WebElement userName;

	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}

	// enter the password
	@FindBy(name = "password")
	private WebElement password;

	public void sendPassword(String password) {
		this.password.clear();
		this.password.sendKeys(password);
	}

	// click on submit button
	@FindBy(xpath = "//*[@id=\"cyclosLogin\"]/table/tbody/tr[3]/td/input")
	private WebElement loginBtn;

	public void clickLoginBtn() {
		this.loginBtn.click();
	}

	// enter the member login
	@FindBy(xpath = "//input[@id='memberUsername']")
	private WebElement memberlogin;

	public void memberlogin(String memberlogin) throws AWTException {
		this.memberlogin.sendKeys(memberlogin);

		driver.findElement(By.id("memberUsername")).click();
		;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Create object on Actions class
		Actions builder = new Actions(driver);

		// find the element which we want to Select from auto suggestion
		WebElement ele = driver.findElement(By.xpath("//div[@id='membersByUsername']/ul/li[2]"));

		// use Mouse hover action for that element
		builder.moveToElement(ele).build().perform();

		// Give wait for 2 seconds
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// finally click on that element
		builder.click(ele).build().perform();
	}

	// click on change permission submit button
	@FindBy(xpath = "//fieldset/table/tbody/tr[2]/td[2]/input")
	private WebElement Changepermissiongroup;

	public void Changepermissiongroup() {
		this.Changepermissiongroup.click();
	}

	// select the new group from drop down
	@FindBy(xpath = "//select[@name='newGroupId']")
	private WebElement newgroupid;

	public void newgroup(String dropdown) throws AWTException, InterruptedException {
		// this.newgroupid.click();

		driver.findElement(By.xpath("//select[@name='newGroupId']")).click();
		Thread.sleep(2000);
		Actions builder = new Actions(driver);
		WebElement ele = driver.findElement(By.xpath("//select"));
		builder.moveToElement(ele).build().perform();
		builder.sendKeys(dropdown);
		Thread.sleep(2000);
		builder.click(ele).build().perform();
	}

	// enter the comments on text box
	@FindBy(xpath = "//textarea[@id='comments']")
	private WebElement comments;

	public void comment(String comments) throws InterruptedException {
		this.comments.sendKeys(comments);
	}

	// click on submit button
	@FindBy(xpath = "//input[@value='Submit']")
	private WebElement Submitbutton;

	public void Submitbutton() throws InterruptedException {
		this.Submitbutton.click();
		Thread.sleep(2000);
		String actual_msgg = driver.switchTo().alert().getText();

		System.out.println("Alert message is:" + actual_msgg);
		driver.switchTo().alert().accept();
		Assert.assertEquals(actual_msgg, "The member's group was changed");
	}

	// click on Home tab on LHS
	@FindBy(xpath = "//span[contains(text(),'Home')]")
	private WebElement Homebutton;

	public void Homebutton() {
		this.Homebutton.click();
	}

}
