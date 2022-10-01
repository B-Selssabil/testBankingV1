package com.testBanking.testCases;

import java.io.IOException;

import com.testBanking.pageObjects.LoginPage;
import com.testBanking.pageObjects.WithdrawalPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_Withdrawal_008 extends Base{

    String accountId;
	
	@Test
	public void withdrawalTest() throws InterruptedException, IOException {
		
		LoginPage lp = new LoginPage(driver);
		logger.info("Login Page opened");
		lp.setUsername(username);
		logger.info("Username entred");
		lp.setPassword(password);
		logger.info("Password entred");
		lp.clickSubmit();
		logger.info("Submit button clicked");
		
		accountId = pru.readData("accountId");
		
		Thread.sleep(2000);
		
		WithdrawalPage wp = new WithdrawalPage(driver);
		wp.clickWithdrawalLink();
		logger.info("Withdrawal Page opened");
		
		wp.setAccountNo(accountId);
		logger.info("Account Id entred");
		wp.setAmount("20");
		logger.info("Amount entred");
		wp.setDesc("withdrawal");
		logger.info("Description entred");
		wp.clickSubmit();
		logger.info("Submit Button Clicked");
		
		boolean res = driver.getPageSource().contains("Transaction details of Withdrawal for Account");
		
		if(res == true) {
			
			Assert.assertTrue(true);
			logger.info("Transaction done successfuly .");
						
		}else {
			
			captureScreen(driver, "withdrawalTest");
			Assert.assertTrue(false);
			logger.info("Transaction failed .");
			
		}

		
	}

}
