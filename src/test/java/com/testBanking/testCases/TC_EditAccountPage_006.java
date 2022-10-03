package com.testBanking.testCases;

import java.io.IOException;

import com.testBanking.pageObjects.EditAccountPage;
import com.testBanking.pageObjects.LoginPage;

import org.testng.annotations.Test;

public class TC_EditAccountPage_006 extends Base{

	String idAccount;

	@Test
	public void editAccount() throws IOException, InterruptedException {
		
		LoginPage lp = new LoginPage(driver);
		logger.info("Login Page opened");
		lp.setUsername(username);
		logger.info("Username entred");
		lp.setPassword(password);
		logger.info("Password entred");
		lp.clickSubmit();
		logger.info("Submit button clicked");
		
		idAccount = pru.readData("accountId");
		
		Thread.sleep(2000);
		
		EditAccountPage ea = new EditAccountPage(driver);
		ea.clickEditAcc();
		
		
	}

}
