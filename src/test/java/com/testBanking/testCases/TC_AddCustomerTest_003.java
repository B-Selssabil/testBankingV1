package com.testBanking.testCases;

import java.io.IOException;


import com.testBanking.pageObjects.AddCustomerPage;
import com.testBanking.pageObjects.LoginPage;
import com.testBanking.pageObjects.RegistrationCustomerPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_AddCustomerTest_003 extends Base {
	
	
	String idofCust;

	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		
		LoginPage lp = new LoginPage(driver);
		logger.info("Login Page opened");
		lp.setUsername(username);
		logger.info("Username entred");
		lp.setPassword(password);
		logger.info("Password entred");
		lp.clickSubmit();
		logger.info("Submit Button Clicked");

		
		Thread.sleep(3000);
		
		AddCustomerPage addcust = new AddCustomerPage(driver);
		
		
		addcust.clickAddNewCustomer();
		logger.info("Add newCustomer Page Opened");

		addcust.custName("Emilie");
		logger.info("Customer name entred ");
		addcust.custGender("f");
		logger.info("Customer gender entred ");
		addcust.custDob("12", "4", "1992");
		logger.info("Customer date of birth entred ");
		addcust.custAddress("Britich");
		logger.info("Customer address entred ");
		addcust.custcity("Britich");
		logger.info("Customer city entred ");
		addcust.custState("Single");
		logger.info("Customer state entred ");
		addcust.custpinno("621919");
		logger.info("Customer pinno entred ");
		addcust.cusTtelphonenum("023246738829");
		logger.info("Customer telephone entred ");

		
		String email = randomString() + "@gmail.com";
		addcust.custemail(email);
		logger.info("Customer email entred ");

		
		addcust.custpassword("aabbef");
		logger.info("Customer password entred ");
		pru.writeNewData("custPassword", "aawberf");

		addcust.clickSubmit();
		logger.info("Submit button clicked");

		RegistrationCustomerPage rp = new RegistrationCustomerPage(driver);
		idofCust = rp.getCustomerId();
		
		pru.writeNewData("idofCust", idofCust);

		
		
		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res == true) {
			
			Assert.assertTrue(true);
			logger.info("Added new customer successfuly ");

		}else {
			captureScreen(driver, "addNewCustomr");
			Assert.assertTrue(false);
			logger.error("Adding new customer failed ");

		}
		
	}
	
	

}
