package com.testBanking.testCases;

import java.io.IOException;

import com.testBanking.pageObjects.DepositPage;
import com.testBanking.pageObjects.LoginPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_Deposit_007 extends Base {

	
	String accountId;
	@Test
	public void depositTest() throws IOException, InterruptedException {
		
		
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
		
		DepositPage dp = new DepositPage(driver);
		dp.clickDepositLink();
		logger.info("Deposit Page opened");
		dp.setAccountNo(accountId);
		logger.info("Acount Number entred");
		dp.setAmount("54");
		logger.info("Amount entred");
		dp.setDescr("Deposit");
		logger.info("Description entred");
		dp.clickSubmit();
		logger.info("Submit button clicked");

		
		
		logger.info("Deposit transaction done successfully .");
		Assert.assertTrue(true);
		
	}
	
	

}
