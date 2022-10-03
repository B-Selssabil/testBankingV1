package com.testBanking.testCases;

import java.io.IOException;

import com.testBanking.pageObjects.ChangePasswordPage;
import com.testBanking.pageObjects.LoginPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_ChangePassword_010 extends Base{

	@Test
	public void changePasswordTest() throws IOException, InterruptedException {
		

		LoginPage lp = new LoginPage(driver);
		logger.info("Login Page opened");
		lp.setUsername(username);
		logger.info("Username entred");
		lp.setPassword(password);
		logger.info("Password entred");
		lp.clickSubmit();
		logger.info("Submit button clicked");
		
	

	
		Thread.sleep(2000);
		
		ChangePasswordPage cp = new ChangePasswordPage(driver);
		cp.clickChangePassword();
		logger.info("Change Password page opened .");
		cp.setOldPassword(password);
		logger.info("Old Password entred");
		cp.setNewPassword("happy99_");
		logger.info("New Password entred");
		cp.confirmNewPassword("happy99_");
		logger.info("New Password Confirmed");
		cp.clickSubmit();
		logger.info("Submit button clicked");

		pru.writeNewData("Password", "happy99_");
		driver.switchTo().alert().accept();

		String res = driver.getTitle();
		if (res.equals("Guru99 Bank Home Page")) {
			
             Assert.assertTrue(true);
            logger.info("Password changed successfully .");
            
		}else {
			
			Assert.assertTrue(false);
            logger.info("Failed changing password.");
		}
		
}
	
}