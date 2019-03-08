package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Repay {
	
	private WebDriver driver;
	 public Repay(WebDriver driver) {
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
	 }
	 
	 
	 @FindBy(name="principal")
	 private WebElement txtuserName;
	 @FindBy(name="password")
	 private WebElement txtpassword;
	 @FindBy(xpath="//*[@id=\"cyclosLogin\"]/table/tbody/tr[3]/td/input")
	 private WebElement Btnsubmit;
	 
	// @FindBy(xpath="//*[@id=\"menu2\"]/span[2]")
	 //private WebElement tabaccount;
	 @FindBy(xpath="//span[@class='menuText'][contains(text(),'Account')]")
	 private WebElement tabaccount;
	 @FindBy(xpath="//*[@id=\"submenu2.3\"]/span[2]")
	 private WebElement linkloans;
	 @FindBy(xpath="//tbody//tr[3]//td[4]//img[1]")
	 private WebElement viewicon;
	 @FindBy(id="amountText")
	 private WebElement txtamount;
	 @FindBy(xpath="//input[@value='Repay']")
	 private WebElement buttonrepay;
	 @FindBy(xpath="//*[@id=\"submenu2.0\"]/span[2]")
	 private WebElement accountinformation;
	 
	 
	 
	 
	 
	//enter the member user name
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
	//1. Click on Account tab
	 public void tabaccount() {
			this.tabaccount.click();
		}
	//2. Click on Loans link
		public void linkloans() {
			this.linkloans.click();
			
			String Expected = "My loans";
			String Actual_msg=driver.findElement(By.xpath("//*[@id=\"tdContents\"]/form/table/tbody/tr[1]/td[1]")).getText();
			Assert.assertEquals(Actual_msg, Expected);
			System.out.println(Actual_msg);
			
		}
		//3. Click on View icon
	 public void viewicon() {
		 this.viewicon.click();
	 }
	//4. Enter Valid credentials in Amount text box
	 public void txtamount(String text) {
		 this.txtamount.clear();
		 this.txtamount.sendKeys(text);
	}
	//5. Click on Repay button
	 public void buttonrepay() throws InterruptedException {
		 this.buttonrepay.click();
		 
		//Alert pop up....
			//Alert alert = driver.switchTo().alert();
			//alert.accept();  //6. Click on OK button
			Thread.sleep(2000);
			String actual_message = driver.switchTo().alert().getText();
			String lines[] = actual_message.split("\\r?\\n");
			  
			 // String alert[]=actual_message.split(" ");
			 
			  
			  System.out.println( lines[1]);
			  System.out.println( lines[2]);
			  
			  System.out.println("Alert message is:" + actual_message);
			  driver.switchTo().alert().accept(); 
			  if(lines[1].equalsIgnoreCase("Are you sure to repay 2,00 units?"))
			  {
			  Assert.assertEquals(lines[1], "Are you sure to repay 2,00 units?");
			  System.out.println("Alert message is:" + actual_message);
			  }else if(lines[2].equalsIgnoreCase("Please, click OK to proceed"))
					  {
			Assert.assertEquals(lines[2], "Please, click OK to proceed");
			System.out.println("Alert message is:" + actual_message);
				  
				  }
			 
			 Thread.sleep(2000);
			
			//Alert pop up message again here....
			String actual_msg1 = driver.switchTo().alert().getText();
			System.out.println("Alert message is:" + actual_msg1);
			driver.switchTo().alert().accept();  //7. Click ok button
			Assert.assertEquals(actual_msg1, "The repayment was succesfully processed");
			
	 }
	//9. Click on Account Information link
	 public void accountinformation() {
		 this.accountinformation.click();
		 
			String Expected_meg1 ="Loan details";
			String Actual_meg1 = driver.findElement(By.xpath("//td[@class='tdHeaderTable']")).getText();
			Assert.assertEquals(Actual_meg1, Expected_meg1);
	 }

}
