package com.testBanking.testCases;

import java.io.IOException;



import com.testBanking.pageObjects.LoginPage;


import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_LoginTest_001 extends Base {
	


	
	@Test
	public void loginTest() throws IOException {
		

		LoginPage lp = new LoginPage(driver);
		logger.info("Login Page opened");
		lp.setUsername(username);
		logger.info("Username entred");
		lp.setPassword(password);
		logger.info("Password entred");
		lp.clickSubmit();
		logger.info("Submit Button Clicked");

		
		if (driver.getTitle().equals("Guru99 Bank Manger HomePage")) {
			
			Assert.assertTrue(true);
			logger.info("Loged in successufuly");

			
			
		}else {
			
			
			captureScreen(driver, "loginTest");
			Assert.assertFalse(false);
			logger.error("Loged in failed");



			
			
		}
		
		
		
		
	}
		
				
		
	}
	
	
	


