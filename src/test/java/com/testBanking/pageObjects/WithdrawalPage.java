package com.testBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WithdrawalPage {

	
	WebDriver ldriver;
	
	public WithdrawalPage(WebDriver rdriver) {
		
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	@FindBy(linkText="Withdrawal")
	@CacheLookup
	WebElement withdrawalLink;
	
	@FindBy(name="accountno")
	@CacheLookup
	WebElement accNo;
	
	@FindBy(name="ammount")
	@CacheLookup
	WebElement amount;
	
	@FindBy(xpath="/html/body/table/tbody/tr/td/table/tbody/tr[8]/td[2]/input")
	@CacheLookup
	WebElement descr;
	
	@FindBy(name="AccSubmit")
	@CacheLookup
	WebElement subButton;
	
	public void clickWithdrawalLink() {
		
		withdrawalLink.click();
		
	}
	
    public void setAccountNo(String accountNo) {
		
    	accNo.sendKeys(accountNo);
		
	}
    
    public void setAmount(String amoun) {
    	
    	amount.sendKeys(amoun);
    	
    }
    
    public void setDesc(String des) {
    	
	   descr.sendKeys(des);
    	
    }
    
    public void clickSubmit() {
		
    	subButton.click();
		
	}

}
