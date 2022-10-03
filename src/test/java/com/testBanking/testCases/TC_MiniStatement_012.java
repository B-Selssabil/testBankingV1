package com.testBanking.testCases;

import java.io.IOException;

import com.testBanking.pageObjects.LoginPage;
import com.testBanking.pageObjects.MiniStatementPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_MiniStatement_012 extends Base {

	String accountId;
	@Test
	public void miniStatementTest() throws IOException, InterruptedException {
		

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
		
		MiniStatementPage ms = new MiniStatementPage(driver);
		ms.clickMiniState();
		logger.info("Mini statement page opened .");
		ms.setAccountNum(accountId);
		logger.info("Account number entred .");
		ms.clickSubmit();
		logger.info("Submit button clicked");

		
		boolean res = driver.getPageSource().contains("Mini Statement details");
		if (res == true) {
			
			Assert.assertTrue(true);
			logger.info("Mini statement checked successfully .");
			
		}else {
			
			captureScreen(driver, "miniStatementTest");
			Assert.assertTrue(false);
			logger.info("Mission failed .");

			
		}
		
		
	}

}
