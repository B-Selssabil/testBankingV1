package com.testBanking.testCases;

import java.io.IOException;

import com.testBanking.pageObjects.EditCustomerPage;
import com.testBanking.pageObjects.LoginPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_EditCustomerTest_004 extends Base{
	
	String idCustomer;

	@Test
	public void editCustomer() throws IOException, InterruptedException {
		
		LoginPage lp = new LoginPage(driver);
		logger.info("Login Page opened");
		lp.setUsername(username);
		logger.info("Username entred");
		lp.setPassword(password);
		logger.info("Password entred");
		lp.clickSubmit();
		logger.info("Submit button clicked");
		
		idCustomer = pru.readData("idofCust");
		System.out.println("id of cust" + idCustomer);
		
		Thread.sleep(2000);
		
		
		EditCustomerPage ed = new EditCustomerPage(driver);
		
		ed.clickEditCustLink();
		logger.info("Edit Customer Page opened");
		ed.setCustomerId(idCustomer);
		logger.info("Id of Customer entred");
		ed.clickSubmitButton();
		Thread.sleep(2000);

		logger.info("Fisrt Submit Button clicked");		
		ed.resetAddr("USA");
		logger.info("Customer Address edited");
		ed.resetCity("NYC");
		logger.info("Customer City edited");
		ed.resetState("NYC");
		logger.info("Customer Satate edited");
		ed.resetPin("342567");
		logger.info("Customer Pin edited");
		ed.resetMobileNum("063682535");
		logger.info("Customer Mobile Number edited");
		String email = randomString() + "@gmail.com";
		ed.resetEmail(email);
		logger.info("Customer Email edited");
		ed.clcikSubmit();
		logger.info("Submit Button clicked");

		
		driver.switchTo().alert().accept();
		boolean res = driver.getPageSource().contains("Edit Customer Form");
		
		if (res == true) {
			
			Assert.assertTrue(true);
			logger.info("Customer information edited successufly");
			
		}else {
			
			captureScreen(driver, "editCustomer" );
			Assert.assertTrue(false);
			logger.info("Customer information failed editing");
			
		}
	

		
		
		
	}

}
