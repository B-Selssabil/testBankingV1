package com.testBanking.testCases;

import java.io.IOException;

import com.testBanking.pageObjects.CustomizedStatementPage;
import com.testBanking.pageObjects.LoginPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_CustomizedStatement_013 extends Base{

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
		
		CustomizedStatementPage cs = new CustomizedStatementPage(driver);
		cs.clickCustomizedStatement();
		logger.info("Customized statement page opened .");
		cs.setAccountNum(accountId);
		logger.info("Account number entred .");
		cs.setFromDate("12", "5", "2022");
		logger.info("From date entred .");
		cs.setToDate("22", "7", "2022");
		logger.info("To date entred .");
		cs.setMinTrans("10");
		logger.info("Minimum Transaction Value entred .");
		cs.setNumbTran("4");
		logger.info("Number of Transaction	 entred .");
		cs.clickSubButton();
		logger.info("Submit button clicked");

		
		boolean res = driver.getPageSource().contains("Customized Statement details");
		if (res == true) {
			
			Assert.assertTrue(true);
			logger.info("Customized statement checked successfully .");
			
		}else {
			
			captureScreen(driver, "miniStatementTest");
			Assert.assertTrue(false);
			logger.info("Mission failed .");

			
		}
		
		
	}

}
