package com.testBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BalanceEnquiryPage {

	
	WebDriver ldriver ;
	
	public BalanceEnquiryPage(WebDriver rdriver) {
		
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		
		
	}
	
	@FindBy(linkText="Balance Enquiry")
	@CacheLookup
	WebElement linkBalance ;
	
	@FindBy(name="accountno")
	@CacheLookup
	WebElement accNum;
	
	@FindBy(name="AccSubmit")
	@CacheLookup
	WebElement subButton;
	
	public void clickBalanceEnquiry() {
		
		linkBalance.click();
		
	}
	
	public void setAccountNum(String accoNum) {
		
		accNum.sendKeys(accoNum);
		
	}
	
    public void clickSubmit() {
		
    	subButton.click();
		
	}

}
