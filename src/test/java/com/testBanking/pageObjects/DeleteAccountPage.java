package com.testBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteAccountPage {
	
	
	WebDriver ldriver;

	public DeleteAccountPage(WebDriver rdriver) {
		
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		
		
	}
	
	@FindBy(linkText="Delete Account")
	@CacheLookup
	WebElement lnkDeleteAcc;
	
	@FindBy(name="accountno")
	@CacheLookup
	WebElement accNo;

	@FindBy(name="AccSubmit")
	@CacheLookup
	WebElement subButton;
	
    public void clickDeleteLink() {
		
    	lnkDeleteAcc.click();
		
	}
	
	public void setaccNom(String acctNom) {
		
		accNo.sendKeys(acctNom);
		
	}
	
    public void clickSubmit() {
		
    	subButton.click();
		
	}
	
	

}
