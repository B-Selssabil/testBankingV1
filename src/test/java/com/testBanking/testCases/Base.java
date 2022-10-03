package com.testBanking.testCases;



import java.io.File;






import org.apache.logging.log4j.*;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import com.testBanking.Utilities.ReadConfig;
import com.testBanking.Utilities.PropertiesUtils;

import org.apache.commons.lang3.RandomStringUtils;
import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


public class Base {
	
	ReadConfig readconfig = new ReadConfig();
	PropertiesUtils pru ;
	public String baseUrl = readconfig.getApplicationURL();
	public String username  = readconfig.getUserName();
	public String password = readconfig.getPassword();
	public static WebDriver driver ;
	
	
	public static Logger logger = LogManager.getLogger(Base.class);

	@Parameters({"browser"})
	@BeforeClass
	public void setUp(String br) throws IOException {
		
		pru =  new PropertiesUtils();
		if(br.equals("chrome")) {
		
			System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
			driver = new ChromeDriver();
		
		}else if(br.equals("firefox")) {
			
			System.setProperty("webdriver.gecko.driver", readconfig.getFireFoxPath());
			driver = new FirefoxDriver();
			
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
		driver.manage().window().maximize();
		
		
	}
	
	@AfterClass
	public void tearDown() {
		
		driver.quit();
		
	}
	
	
	
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		
		TakesScreenshot ts =  (TakesScreenshot) driver ;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+ "Screenshots" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
		
	}
	
public String randomString() {
		
		String generatedstring = RandomStringUtils.randomAlphabetic(8);
		return generatedstring;
		
	}
	
	
    public String randomString2() {
		
		String generatedstring2 = RandomStringUtils.randomNumeric(4);
		return generatedstring2;
		
	}

}
