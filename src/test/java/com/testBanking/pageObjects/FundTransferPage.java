package com.testBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FundTransferPage {

	WebDriver ldriver;
	
	public FundTransferPage(WebDriver rdriver) {
		
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
		
	}
	
	@FindBy(linkText="Fund Transfer")
	@CacheLookup
	WebElement fundTransferLink;
	
	@FindBy(name="payersaccount")
	@CacheLookup
	WebElement payer;
	
	@FindBy(name="payeeaccount")
	@CacheLookup
	WebElement payee;
	
	@FindBy(name="ammount")
	@CacheLookup
	WebElement ammoun;
	
	@FindBy(xpath="/html/body/table/tbody/tr/td/table/tbody/tr[7]/td[2]/input")
	@CacheLookup
	WebElement descr;
	
	@FindBy(name="AccSubmit")
	@CacheLookup
	WebElement subButton;
	
	public void clickFundTransfer() {
		
		fundTransferLink.click();
		
	}
	
	public void setPayersAcc(String payersAcc) {
		
		payer.sendKeys(payersAcc);
		
	}
	
    public void setPayeesAcc(String payeeeAcc) {
		
    	payee.sendKeys(payeeeAcc);
		
	}
    
    public void setAmount(String Amou) {
		
    	ammoun.sendKeys(Amou);
		
	}
    
    public void setDescription(String descrp) {
		
    	descr.sendKeys(descrp);
		
	}
    
    public void clickSubmit() {
		
    	subButton.click();
		
	}
	
	
	
	
	
	
	

}
