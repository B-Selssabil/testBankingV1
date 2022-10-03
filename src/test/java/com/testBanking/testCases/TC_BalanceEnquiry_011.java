package com.testBanking.testCases;

import java.io.IOException;

import com.testBanking.pageObjects.BalanceEnquiryPage;
import com.testBanking.pageObjects.LoginPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_BalanceEnquiry_011  extends Base {

	String accountId;
	@Test
	public void balanceEnquiryTest() throws IOException, InterruptedException {
		

		LoginPage lp = new LoginPage(driver);
		logger.info("Login Page opened");
		lp.setUsername(username);
		logger.info("Username entred");
		lp.setPassword(password);
		logger.info("Password entred");
		lp.clickSubmit();
		logger.info("Submit button clicked");
		
		accountId = pru.readData("accountId2");
	
		Thread.sleep(2000);
		
		BalanceEnquiryPage be = new BalanceEnquiryPage(driver);
		be.clickBalanceEnquiry();
		
		logger.info("Balance enquiry page opened .");
		be.setAccountNum(accountId);
		logger.info("Account number entred .");
		be.clickSubmit();
		logger.info("Submit button clicked");

		boolean res = driver.getPageSource().contains("Balance Enquiry");
		if (res == true) {
			
			Assert.assertTrue(true);
			logger.info("Balance checked successfully .");
			
		}else {
			
			captureScreen(driver, "balanceEnquiryTest");
			Assert.assertTrue(false);
			logger.info("Mission failed .");

			
		}
		
		
	}

}
