package com.testBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationCustomerPage {
	
	WebDriver ldriver;

	public RegistrationCustomerPage(WebDriver rdriver) {
		
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	@FindBy(xpath="//*[@id=\"customer\"]/tbody/tr[4]/td[2]")
	@CacheLookup
	WebElement custId;
	
	
	public String getCustomerId() {
		
		System.out.println("Id " + custId.getText());
		return custId.getText();
		
		
	}
	
	
	

}
