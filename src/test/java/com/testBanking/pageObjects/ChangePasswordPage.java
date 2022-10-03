package com.testBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChangePasswordPage {

   WebDriver ldriver;

	public ChangePasswordPage(WebDriver rdriver) {
		
		 ldriver = rdriver;
		 PageFactory.initElements(rdriver, this);
		
	}
	
	@FindBy(linkText="Change Password")
	@CacheLookup
	WebElement changePasswordLink ;
	
	@FindBy(name="oldpassword")
	@CacheLookup
	WebElement oldPass ;
	
	@FindBy(name="newpassword")
	@CacheLookup
	WebElement newPass ;
	
	@FindBy(name="confirmpassword")
	@CacheLookup
	WebElement confirmNewPass ;
	
	@FindBy(name="sub")
	@CacheLookup
	WebElement subButton ;
	
    public void clickChangePassword() {
		
    	changePasswordLink.click();
		
	}
    
    public void setOldPassword(String oPass) {
		
    	oldPass.sendKeys(oPass);
		
	}
    
    public void setNewPassword(String nPass) {
		
    	newPass.sendKeys(nPass);
		
	}
    
    public void confirmNewPassword(String cnPass) {
		
    	confirmNewPass.sendKeys(cnPass);
		
	}
    
    public void clickSubmit() {
		
    	subButton.click();
		
	}
	
}
