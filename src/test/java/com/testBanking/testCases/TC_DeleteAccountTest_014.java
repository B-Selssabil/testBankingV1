package com.testBanking.testCases;

import java.io.IOException;

import com.testBanking.pageObjects.DeleteAccountPage;
import com.testBanking.pageObjects.LoginPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_DeleteAccountTest_014 extends Base{

	String accountId;
	
	@Test
	public void deleteAccount() throws IOException {
		
		
		LoginPage lp = new LoginPage(driver);
		logger.info("Login Page opened");
		lp.setUsername(username);
		logger.info("Username entred");
		lp.setPassword(password);
		logger.info("Password entred");
		lp.clickSubmit();
		logger.info("Submit button clicked");
		
		
		accountId = pru.readData("accountId2");
		
		DeleteAccountPage dap = new DeleteAccountPage(driver); 
		
		dap.clickDeleteLink();
		logger.info("Deleteaccount Page opened");
		dap.setaccNom(accountId);
		logger.info("Account Nomber entred");
		dap.clickSubmit();
		logger.info("Submit Button clicked");
		driver.switchTo().alert().accept();
		driver.switchTo().alert().accept();
		Assert.assertTrue(true);
		logger.info("Deleted Account Succeussfuly");
		

		

		
		
		
		
	}
	

}
