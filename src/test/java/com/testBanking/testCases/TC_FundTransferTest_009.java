package com.testBanking.testCases;

import java.io.IOException;

import com.testBanking.pageObjects.FundTransferPage;
import com.testBanking.pageObjects.LoginPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_FundTransferTest_009 extends Base{

	String accountId;
	String accountId2;

	
	@Test
	public void fundTransferTest() throws IOException, InterruptedException {
		
		LoginPage lp = new LoginPage(driver);
		logger.info("Login Page opened");
		lp.setUsername(username);
		logger.info("Username entred");
		lp.setPassword(password);
		logger.info("Password entred");
		lp.clickSubmit();
		logger.info("Submit button clicked");
		
		accountId = pru.readData("accountId");
		accountId2 = pru.readData("accountId2");
	
		Thread.sleep(2000);
		
		FundTransferPage ft = new FundTransferPage(driver);
		
		ft.clickFundTransfer();
		logger.info("Fund Transfer Page opened");
		ft.setPayersAcc(accountId);
		logger.info("Payers account no entred");
		ft.setPayeesAcc(accountId2);
		logger.info("Payees account no entred");
		ft.setAmount("10");
		logger.info("Amount entred");
		ft.setDescription("Fund Transfer");
		logger.info("Description entred");
		ft.clickSubmit();
		logger.info("Submit button clicked");

		boolean res = driver.getPageSource().contains("Fund Transfer Details");
		
		if (res == true) {
			
			logger.info("Fund Transfer done successfully.");
			Assert.assertTrue(true);

		}else {
			
			logger.info("Fund Transfer failed .");
			captureScreen(driver, "fundTransferTest");
			Assert.assertTrue(false);
			
		}

}
	
}
	
