package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Account {
	
	
	private WebDriver driver;
	 public Account(WebDriver driver) {
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
	 }
	 
	 @FindBy(name="principal")
	 private WebElement txtuserName;
	 @FindBy(name="password")
	 private WebElement txtpassword;
	 @FindBy(xpath="//*[@id=\"cyclosLogin\"]/table/tbody/tr[3]/td/input")
	 private WebElement Btnsubmit;

	 @FindBy(xpath="//*[@id=\"menu2\"]/span[2]")
	 private WebElement tabAccount;
	 @FindBy(xpath="//*[@id=\"submenu2.4\"]/span[2]")
	 private WebElement tabmemberpayment;
	 @FindBy(id="memberUsername")
	 private WebElement txtlogin;

	 
	 @FindBy(name="amount")
	 private WebElement txtamount;
	 @FindBy(name="description")
	 private WebElement txtdescription;
	 @FindBy(id="submitButton")
	 private WebElement Buttonsubmit;
	 @FindBy(xpath="//*[@id=\"submenu2.0\"]/span[2]")
	 private WebElement tabAccountInformation;
	 
	 @FindBy(xpath="//input[@value='Submit']")
	 private WebElement Transactionsubmit;
	 
	 
	 
	 
	 public void txtsendusername(String userName) {
		 this.txtuserName.clear();
		 this.txtuserName.sendKeys(userName);
	 }
	 public void txtsendpassword(String password) {
		 this.txtpassword.clear();
		 this.txtpassword.sendKeys(password);
	 }
	 public void Btnsubmit() {
		 this.Btnsubmit.click();
	 }
	 
	 public void tabaccout() {
		 this.tabAccount.click();
	}
	 
		
	 
	 //--------------------------------------
	 public void tabmemberpayment() {
		 this.tabmemberpayment.click();
	 }
	 
	 public void txtlogin(String text) {
	this.txtlogin.sendKeys(text);

	
	 }
	 
	 public void txtamount(String text1) {
		 this.txtamount.sendKeys(text1);
	 }
	 public void txtdescription(String text2) {
		 this.txtdescription.sendKeys(text2);
	 }
	 public void Buttonsubmit() {
		 this.Buttonsubmit.click();
	 }
	 
	 public void tabAccountInformation() {
		 this.tabAccountInformation.click();
	 }
	 
	 public void Transactionsubmit() {
		 this.Transactionsubmit.click();
	 }
	 
}
