package com.training.pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Advert {
	
	
	private WebDriver driver;
	 public Advert(WebDriver driver) {
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
	 @FindBy(xpath="//tbody//tr[4]//td[1]//fieldset[1]//table[1]//tbody[1]//tr[1]//td[2]//input[1]")
	 private WebElement Buttonsubmit;
	 

	 
	 @FindBy(id="newButton")
	 private WebElement idbutton;
	 @FindBy(name="ad(title)")
	 private WebElement txtTitle;
	@FindBy(name="ad(category)")
	private WebElement category;
	@FindBy(name="ad(price)")
	private WebElement price;
	@FindBy(xpath="//*[@class='CSS1Compat']")
	private WebElement desc;
	@FindBy(id="saveButton")
	private WebElement savebutton;
	
	
	
	 
	 @FindBy(xpath="//*[@id=\"tdContents\"]/table[1]/tbody/tr[2]/td/table/tbody/tr[2]/td[6]/img[2]")
	 private WebElement Remove;
	 @FindBy(xpath="//*[@id=\"menu15\"]/span[2]")
	 private WebElement BtnLogout;
	 @FindBy(xpath="//*[@id=\"menu1\"]/span[2]")
	 private WebElement tabPersonal;
	 @FindBy(xpath="//*[@id=\"submenu1.2\"]/span[2]")
	 private WebElement tabadvertisement;
	 
	 
	 
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
	public void buttnsubmit() {
		this.Buttonsubmit.click();
	}
	
	public void idbutton() {
		this.idbutton.click();
	}
		
	public void txtTitle(String text) {
	this.txtTitle.sendKeys(text);
	}
	 
	public void price(String price) {
		this.price.sendKeys(price);
	}
	public void desc(String desc) {
		this.desc.sendKeys(desc);
	}
	public void savebutton() {
		this.savebutton.click();
	}
	
	
	
	
	 public void buttonsubmit() {
		 this.Buttonsubmit.click();
	 }
	 public void Remove() {
		 this.Remove.click();
	 }
	 public void BtnLogout() {
		 this.BtnLogout.click();
	 }
	 public void tabPersonal() {
		 this.tabPersonal.click();
	 }
	 public void tabadvertisement() {
		 this.tabadvertisement.click();
	 }

}
