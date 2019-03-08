package com.training.pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

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
	 
	 
	 //enter the admin login name
	 public void txtsendusername(String userName) {
		 this.txtuserName.clear();
		 this.txtuserName.sendKeys(userName);
	 }
	 //enter the password
	 public void txtsendpassword(String password) {
		 this.txtpassword.clear();
		 this.txtpassword.sendKeys(password);
	 }
	 //click on submit button
	 public void Btnsubmit() {
		 this.Btnsubmit.click();
	 }
	//enter the member log in name in text box
	public void txtmemberlogin(String memberlogin) {
		this.txtmemberlogin.sendKeys(memberlogin);
		
	}
	//2.click on the Grant loan submit button under Loans window section
	public void Bsubmit() {
		this.BSubmit.click();
	}
	//3.Enter valid credentials in amount text box
	public void txtAmount(String text) {
		this.txtAmount.sendKeys(text);
	}
	//4.Enter valid credentials in Description textbox
	public void txtdescription(String text1) {
		this.txtdescription.sendKeys(text1);
	}
	//5. Click on Submit button
	public void BGsubmit() {
		this.BGsubmit.click();
	}
	//6. Click on Submit button
	public void BLsubmit() {
		this.BLsubmit.click();

		//Alert pop-up message verification
		String actual_msg1 = driver.switchTo().alert().getText();
		System.out.println("Alert message is:" + actual_msg1);
		driver.switchTo().alert().accept();			//7. Click on OK button
		Assert.assertEquals(actual_msg1, "The loan was successfully granted");
		
	}
	//8. Click on Submit button of View Loans
	public void Viewsubmit() {
		this.Viewsubmit.click();
	}
	//9. Click on Logout button
	public void btnlogout() {
		this.btnlogout.click();
		//Alert pop-up message verification..
				String actual_msg = driver.switchTo().alert().getText();
				System.out.println("Alert message is:" + actual_msg);
				driver.switchTo().alert().accept();			//10. Click OK Button
				Assert.assertEquals(actual_msg, "Please confirm to logout");
		
	}
	//14. Click on Account tab
	public void tabaccount() {
		this.tabaccount.click();
	}
	//15. Click on Loans link
	public void linkloans() {
		this.linkloans.click();
	}
	
}
