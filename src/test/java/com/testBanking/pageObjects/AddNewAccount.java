package com.testBanking.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewAccount {

	
	WebDriver ldriver;
	
	
	public AddNewAccount(WebDriver rdriver) {
		
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		
		
	}
	
	@FindBy(linkText="New Account")
	@CacheLookup
	WebElement lnkNewAcc;
	
	@FindBy(name="cusid")
	@CacheLookup
	WebElement custId;
	
	@FindBy(tagName="option")
	@CacheLookup
	List<WebElement> op ;
	
	@FindBy(name="inideposit")
	@CacheLookup
	WebElement initDepo;
	
	@FindBy(name="button2")
	@CacheLookup
	WebElement subButton;
	
	
	public void clickNewAccount() {
		
		lnkNewAcc.click();
		
	}
	
	
    public void setCustomerId(String cusId) {
		
    	custId.sendKeys(cusId);
		
	}
    
    public void selectType(String type) {
		
    	for(WebElement e:op) {
    		
    		if (type.equals(e.getText())) {
    			
    			e.click();
    		}
    		
    	}
    	
	}
    
    public void setInitDeposit(String initDep) {
		
    	initDepo.sendKeys(initDep);
		
	}
    
    public void clickSubmit() {
		
    	subButton.click();
		
	}
    
		
	
	

}
