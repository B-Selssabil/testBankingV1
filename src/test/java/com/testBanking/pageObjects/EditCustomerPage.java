package com.testBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditCustomerPage {
	
	WebDriver ldriver;
	
	
	public EditCustomerPage(WebDriver rdriver) {
		
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	@FindBy(linkText="Edit Customer")
	@CacheLookup
	WebElement editCustLink;
	
	@FindBy(name="cusid")
	@CacheLookup
	WebElement  custId;
	
	@FindBy(name="AccSubmit")
	@CacheLookup
	WebElement submButton;
	
	@FindBy(xpath="/html/body/table/tbody/tr/td/table/tbody/tr[7]/td[2]/textarea")
	@CacheLookup
	WebElement addrIn;
	
	@FindBy(xpath="/html/body/table/tbody/tr/td/table/tbody/tr[8]/td[2]/input")
	@CacheLookup
	WebElement cityIn;
	
	@FindBy(xpath="/html/body/table/tbody/tr/td/table/tbody/tr[9]/td[2]/input")
	@CacheLookup
	WebElement stateIn;
	
	@FindBy(name="pinno")
	@CacheLookup
	WebElement pinIn;
	
	@FindBy(name="telephoneno")
	@CacheLookup
	WebElement mobileIn;
	
	@FindBy(name="emailid")
	@CacheLookup
	WebElement emailId;
	
	@FindBy(xpath="/html/body/table/tbody/tr/td/table/tbody/tr[13]/td[2]/input[1]")
	@CacheLookup
	WebElement subButton;
	
	public void clickEditCustLink() {
		
		editCustLink.click();
		
	}
	
   public void setCustomerId(String id) {
		
	   custId.sendKeys(id);
		
	}
   
   public void clickSubmitButton() {
		
	   submButton.click();
		
	}
	
	
   public void resetAddr(String newAddr) {
		
	   addrIn.clear();
	   addrIn.sendKeys(newAddr);
		
	}
   
    public void resetCity(String newCity) {
		
    	cityIn.clear();
    	cityIn.sendKeys(newCity);
		
	}
    
    public void resetState(String newState) {
		
    	stateIn.clear();
    	stateIn.sendKeys(newState);
		
	}
    
    public void resetPin(String newPin) {
		
    	pinIn.clear();
    	pinIn.sendKeys(newPin);
		
	}
    
    public void resetMobileNum(String newNum) {
		
    	mobileIn.clear();
    	mobileIn.sendKeys(newNum);
		
	}
    
    public void resetEmail(String newEmail) {
		
    	emailId.clear();
    	emailId.sendKeys(newEmail);
		
	}
    
   public void clcikSubmit() {
		
	   subButton.click();
		
	}
    
    
	
	
	
	
	
	
	
	
	
	

}
