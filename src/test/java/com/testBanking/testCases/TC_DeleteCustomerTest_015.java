package com.testBanking.testCases;

import java.io.IOException;


import com.testBanking.pageObjects.DeleteCustomerPage;
import com.testBanking.pageObjects.LoginPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_DeleteCustomerTest_015 extends Base {
	
	String idCustomer;
	
	@Test
	public void deleteCustomer() throws InterruptedException, IOException  {
		
		
		LoginPage lp = new LoginPage(driver);
		logger.info("Login Page opened");
		lp.setUsername(username);
		logger.info("Username entred");
		lp.setPassword(password);
		logger.info("Password entred");
		lp.clickSubmit();
		logger.info("Submit button clicked");
		
       
		idCustomer = pru.readData("idofCust2");

		Thread.sleep(2000);
		
		DeleteCustomerPage dc = new DeleteCustomerPage(driver);
		dc.clickLinkDelete();
		logger.info("DeleteCustomer Page opened");
		dc.setCustomerId(idCustomer);
		logger.info("Customer id entred");
		dc.clickSubmit();
		logger.info("Submit button clicked");

		
		driver.switchTo().alert().accept();
		driver.switchTo().alert().accept();
		Assert.assertTrue(true);
		logger.info("Deleted Customer succeussfully");

		
		
		
		
		
		
		
	}

}
