package com.testBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomizedStatementPage {

WebDriver ldriver;

	
	public CustomizedStatementPage(WebDriver rdriver) {
		
		 ldriver = rdriver;
		 PageFactory.initElements(rdriver, this);
		
	}
	
	
	@FindBy(linkText="Customised Statement")
	@CacheLookup
	WebElement customizedStatementLink ;
	
	@FindBy(name="accountno")
	@CacheLookup
	WebElement accounNum ;
	
	@FindBy(name="fdate")
	@CacheLookup
	WebElement fDate ;
	
	@FindBy(name="tdate")
	@CacheLookup
	WebElement tDate ;
	
	@FindBy(name="amountlowerlimit")
	@CacheLookup
	WebElement amountLower ;
	
	@FindBy(name="numtransaction")
	@CacheLookup
	WebElement numbTrans ;
	
	@FindBy(name="AccSubmit")
	@CacheLookup
	WebElement subButton ;
	
	
    public void clickCustomizedStatement() {
		
    	customizedStatementLink.click();
		
	}
    
    
    public void setAccountNum(String accNumb) {
		
    	accounNum.sendKeys(accNumb);
		
	}
    
    public void setFromDate(String dd, String mm, String yy) {
		
    	fDate.sendKeys(dd);
    	fDate.sendKeys(mm);
    	fDate.sendKeys(yy);
		
	}
    
    public void setToDate(String dd1, String mm1, String yy1) {
		
    	tDate.sendKeys(dd1);
    	tDate.sendKeys(mm1);
    	tDate.sendKeys(yy1);
		
	}
    
    public void setMinTrans(String minTran) {
		
    	amountLower.sendKeys(minTran);
		
	}
    
   public void setNumbTran(String numbTra) {
		
	   numbTrans.sendKeys(numbTra);
		
	}
   
   public void clickSubButton() {
		
	   subButton.click();
		
	}
	
}
