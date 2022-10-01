package com.testBanking.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	
	WebDriver ldriver;
	
	
	public AddCustomerPage(WebDriver rdriver) {
		
	  ldriver = rdriver;
	  PageFactory.initElements(rdriver, this);
	  
	}
	
	
	@FindBy(how =How.XPATH, using="/html/body/div[3]/div/ul/li[2]/a")
	@CacheLookup
	WebElement lnkAddNewCustomer;
	
	@FindBy(how = How.NAME, using="name")
	@CacheLookup
	WebElement txtCustomeNname;
	
	@FindBy(how = How.NAME, using="rad1")
	@CacheLookup
	List<WebElement> rdGender;
 
	@FindBy(how = How.ID_OR_NAME, using="dob")
	@CacheLookup
	WebElement txtdob;

	@FindBy(how = How.NAME, using="addr")
	@CacheLookup
	WebElement txtaddress;
	
	@FindBy(how = How.NAME, using="city")
	@CacheLookup
	WebElement txtcity;
	
	@FindBy(how = How.NAME, using="state")
	@CacheLookup
	WebElement txtstate;
	
	@FindBy(how = How.NAME, using="pinno")
	@CacheLookup
	WebElement txtpinno;
	
	@FindBy(how = How.NAME, using="telephoneno")
	@CacheLookup
	WebElement txttelephoneno;
	
	@FindBy(how = How.NAME, using="emailid")
	@CacheLookup
	WebElement txteamilid;
	
	@FindBy(how = How.NAME, using="password")
	@CacheLookup
	WebElement txtpassword;
	
	@FindBy(how = How.NAME, using="sub")
	@CacheLookup
	WebElement btnSubmit;
	
	public void clickAddNewCustomer() {
		
		lnkAddNewCustomer.click();
		
	}
	
	public void custName(String cname) {
		
		txtCustomeNname.sendKeys(cname);
			
	}
	
	
	public void custGender(String cgender) {
		
		for(WebElement e:rdGender) {
			
			if((e.getAttribute("value")).equals(cgender)){
				
				e.click();
				
			}
			
		}
		
		
	}
	
	public void custDob(String dd, String mm, String yy) {
		
		txtdob.sendKeys(dd);
		txtdob.sendKeys(mm);
		txtdob.sendKeys(yy);
		
		
	}
	
	public void custAddress(String caddress) {
		
		txtaddress.sendKeys(caddress);
		
	}
	
	public void custcity(String ccity) {
		
		txtcity.sendKeys(ccity);
		
	}
	
	public void custState(String cstate) {
		
		txtstate.sendKeys(cstate);
		
		
	}
	
	public void custpinno(String cpino) {
		
		txtpinno.sendKeys(String.valueOf(cpino));
		
		
	}
	
	public void cusTtelphonenum(String cnum) {
		
		txttelephoneno.sendKeys(cnum);
		
	}
	
	public void custemail(String ceamil) {
		
		txteamilid.sendKeys(ceamil);
		
		
	}
	
	public void custpassword(String cpassword) {
		
		txtpassword.sendKeys(cpassword);
		
	}
	
	public void clickSubmit() {
		
		btnSubmit.click();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
