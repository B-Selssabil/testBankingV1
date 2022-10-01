package com.testBanking.testCases;

import java.io.IOException;


import com.testBanking.Utilities.XLUtils;
import com.testBanking.pageObjects.LoginPage;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC_LoginDDT_002 extends Base{
	
	
	@Test (dataProvider ="LoginData")
	public void loginDDT(String user, String pwd) throws InterruptedException, IOException {
		
		
		LoginPage lp = new LoginPage(driver);
		logger.info("Login Page opened");
		lp.setUsername(user);
		logger.info("Username entred");
		lp.setPassword(pwd);
		logger.info("Password entred");
		lp.clickSubmit();
		logger.info("Submit Button Clicked");
		
		
		if(isAlertPresent()==true) {
			
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			captureScreen(driver, "TC_LoginDDT_002");
			Assert.assertTrue(false);
			logger.error("Loged in failed");

			
		}else {
			
			Assert.assertTrue(true);
			logger.info("Loged in successufuly");
			lp.clickLogout();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
		
		
	}
	
	public boolean isAlertPresent() { //user defined method to check if user is present or not 
		
		
		try {
			
			driver.switchTo().alert();
			return true;
			
		}catch(NoAlertPresentException e) {
			
			return false;
		}

		
		
	}
	
	
	
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException{
		
		
		String path ="C:\\Users\\s_bou\\OneDrive\\Bureau\\testBankingV1\\src\\test\\java\\com\\testBanking\\testData\\Test2.xlsx";
		int rownum = XLUtils.getRowCount(path);
		int colcount =  XLUtils.getCellCount(path, 1);
		
		String logindata[][] = new String[rownum][colcount];
		System.out.println("hh "+ rownum);
		System.out.println(colcount);

		
		for(int i=1 ; i<= rownum; i++) {
			
			for(int j=0 ; j <colcount; j++) {
				
				logindata[i-1][j] = XLUtils.getCellData(path, i, j);
				
			}
			
			
		}
		
		return logindata;
		
	}

}
