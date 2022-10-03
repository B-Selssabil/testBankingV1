package com.testBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditAccountPage {

   WebDriver ldriver;
	
	
	public EditAccountPage(WebDriver rdriver) {
		
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	@FindBy(linkText="Edit Account")
	@CacheLookup
	WebElement editAccountLink;
	
	@FindBy(name="cusid")
	@CacheLookup
	WebElement  custId;
	
	
	public void clickEditAcc() {
		
		editAccountLink.click();
		
	}

}
