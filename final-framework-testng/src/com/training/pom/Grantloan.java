package com.training.pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Grantloan {
	
	
	private WebDriver driver;
	 public Grantloan(WebDriver driver) {
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
	 }
	 
	 @FindBy(name="principal")
	 private WebElement txtuserName;
	 @FindBy(name="password")
	 private WebElement txtpassword;
	 @FindBy(xpath="//*[@id=\"cyclosLogin\"]/table/tbody/tr[3]/td/input")
	 private WebElement Btnsubmit;
	 
	 @FindBy(id="memberUsername")
	 private WebElement txtmemberlogin;
	 @FindBy(xpath="//tbody//tr[8]//td[1]//fieldset[1]//table[1]//tbody[1]//tr[1]//td[4]//input[1]")
	 private WebElement BSubmit;
	 @FindBy(id="amount")
	 private WebElement txtAmount;
	 @FindBy(id="description")
	 private WebElement txtdescription;
	 @FindBy(xpath="//input[@value='Submit']")
	 private WebElement BGsubmit;
	 @FindBy(xpath="//input[@value='Submit']")
	 private WebElement BLsubmit;
	 @FindBy(xpath="//tbody//tr[8]//td[1]//fieldset[1]//table[1]//tbody[1]//tr[1]//td[2]//input[1]")
	 private WebElement Viewsubmit;
	 @FindBy(xpath="//*[@id=\"menu15\"]/span[2]")
	 private WebElement btnlogout;
	 
	 @FindBy(xpath="//*[@id=\"menu2\"]/span[2]")
	 private WebElement tabaccount;
	 @FindBy(xpath="//*[@id=\"submenu2.3\"]/span[2]")
	 private WebElement linkloans;
	 
	 
	 
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
	
	public void txtmemberlogin(String memberlogin) {
		this.txtmemberlogin.sendKeys(memberlogin);
		
	}
	public void Bsubmit() {
		this.BSubmit.click();
	}
	public void txtAmount(String text) {
		this.txtAmount.sendKeys(text);
	}
	public void txtdescription(String text1) {
		this.txtdescription.sendKeys(text1);
	}
	public void BGsubmit() {
		this.BGsubmit.click();
	}
	public void BLsubmit() {
		this.BLsubmit.click();
	}
	public void Viewsubmit() {
		this.Viewsubmit.click();
	}

	public void btnlogout() {
		this.btnlogout.click();
	}
	
	public void tabaccount() {
		this.tabaccount.click();
	}
	
	public void linkloans() {
		this.linkloans.click();
	}
	
}
