package com.testBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DepositPage {
	
	
	WebDriver ldriver;
	
	public DepositPage(WebDriver rdriver) {
		
		ldriver = rdriver;
        PageFactory.initElements(rdriver, this);		
		
		
	}
	
	@FindBy(linkText="Deposit")
	@CacheLookup
	WebElement clickDeposit;
	
	@FindBy(name="accountno")
	@CacheLookup
	WebElement accNo;
	
	@FindBy(name="ammount")
	@CacheLookup
	WebElement ammoun;
	
	@FindBy(name="desc")
	@CacheLookup
	WebElement descr;
	
	@FindBy(name="AccSubmit")
	@CacheLookup
	WebElement subbutton;
	
	public void clickDepositLink() {
		
		clickDeposit.click();
		
	}
	
    public void setAccountNo(String accNum) {
		
    	accNo.sendKeys(accNum);
		
	}
    
    public void setAmount(String amount) {
		
    	ammoun.sendKeys(amount);
		
	}
    
    public void setDescr(String descrp) {
		
    	descr.sendKeys(descrp);
		
	}
    
    public void clickSubmit() {
		
    	subbutton.click();
		
	}

}
