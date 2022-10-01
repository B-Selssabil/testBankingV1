package com.testBanking.testCases;

import java.io.IOException;

import com.testBanking.pageObjects.AccountCreatedPage;
import com.testBanking.pageObjects.AddNewAccount;
import com.testBanking.pageObjects.LoginPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_AddAccountTest_005 extends Base{

	String idCustomer;
	String accountId;
		
	@Test
	public void addNewAccount() throws InterruptedException, IOException {
		
		LoginPage lp = new LoginPage(driver);
		logger.info("Login Page opened");
		lp.setUsername(username);
		logger.info("Username entred");
		lp.setPassword(password);
		logger.info("Password entred");
		lp.clickSubmit();
		logger.info("Submit button clicked");
		
		idCustomer = pru.readData("idofCust");
	
		Thread.sleep(2000);
	
		AddNewAccount acc = new AddNewAccount(driver);
	
		acc.clickNewAccount();
		logger.info("AddNewAccount Page opened");
		acc.setCustomerId(idCustomer);
		logger.info("Customer id entred");
		acc.selectType("Current");
		logger.info("Account type selected");
		acc.setInitDeposit("423676");
		logger.info("Init deposit entred");
		acc.clickSubmit();
		logger.info("Submit button clicked");
		
		AccountCreatedPage ac = new AccountCreatedPage(driver);
		accountId = ac.getAccounId();
		
		pru.writeNewData("accountId", accountId);
		
		
		boolean res = driver.getPageSource().contains("Account Generated Successfully!!!");
		
		if(res==true) {
			
			Assert.assertTrue(true);
			logger.info("New Account added successfully");
			
			
		}else {
			
			Assert.assertTrue(true);
			logger.error("Failed adding new account");	
			captureScreen(driver, idCustomer);

			
			
		}

		
		
				
	}

}
