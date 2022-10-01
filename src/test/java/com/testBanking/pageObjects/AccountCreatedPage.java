package com.testBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreatedPage {

	
	WebDriver ldriver;
	public AccountCreatedPage(WebDriver rdriver) {
		
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
			
	}
	
	@FindBy(xpath="//*[@id=\"account\"]/tbody/tr[4]/td[2]")
	@CacheLookup
	WebElement accId;
	
	public String getAccounId() {
		
		System.out.println("Account Id " + accId.getText());
		return accId.getText();
		
		
	}

}
