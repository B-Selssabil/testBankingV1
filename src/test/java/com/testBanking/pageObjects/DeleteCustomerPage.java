package com.testBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteCustomerPage {
	
	WebDriver ldriver ;
	
	public DeleteCustomerPage(WebDriver rdriver) {
		
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);

	}
	
	
	@FindBy(linkText="Delete Customer")
	@CacheLookup
	WebElement lnkDeleteCust;
	
	
	@FindBy(name="cusid")
    @CacheLookup 
    WebElement idInput; 
	
	@FindBy(name="AccSubmit")
	@CacheLookup
	WebElement subButton;
	
   public void clickLinkDelete() {
		
	   lnkDeleteCust.click();
		
	}
	
	public void setCustomerId(String id) {
		
		idInput.sendKeys(id);
		
	}
	
    public void clickSubmit() {
		
    	subButton.click();
		
	}
	
 }
