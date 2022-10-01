package com.testBanking.Utilities;


//Listener class used to generate extent reports 
import java.io.File;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;


public class Reporting extends TestListenerAdapter {
	
	public ExtentHtmlReporter htmlReporter;
	public 	ExtentReports extent;
	public ExtentTest logger;
	public WebDriver driver; 
	
	public void onStart(ITestContext testcontext) {
		
		
		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repName = "Test-Report" + timeStamp + ".html";
		
		
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/"+ repName );
		htmlReporter.loadXMLConfig(System.getProperty("user.dir") + "/extent-config.xml");
		
		
		extent = new ExtentReports();
		
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "LocalHost");
		extent.setSystemInfo("Browser", "Chrome");
		extent.setSystemInfo("Tester Name", "Selssabil");
		extent.setSystemInfo("Enviroment", "QA");
		
		
		htmlReporter.config().setDocumentTitle("InetBanking Test Project"); //Title of The Report 
		htmlReporter.config().setReportName("Functional Test Report");//Name of the report 
		htmlReporter.config().setTheme(Theme.DARK); 
	
		
	}
	
	
	public void onTestSuccess(ITestResult tr) {
		
		logger = extent.createTest(tr.getName());
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
		
	}
	
	public void onTestFailure(ITestResult tr) {

		
		logger = extent.createTest(tr.getName());
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		
		String screenshotPath = System.getProperty("user.dir")+"\\Screenshots\\"+ tr.getName()+".png";
		File f = new File(screenshotPath);
		if(f.exists()) {
			
			try {
				logger.fail("Screenshot is below :" + logger.addScreenCaptureFromPath(screenshotPath));
				
			}catch(IOException e) {
				
				e.printStackTrace();
			}
			
			
		}
	}
	
	
	
	public void  onTestSkipped(ITestResult tr) {
		
		logger = extent.createTest(tr.getName());
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
		
	}
	
	public void onFinish(ITestContext testContext) {
		
		
		extent.flush();
	}
	
	
	/*
	
	@AfterTest
	public void endReport() {
		
		extent.flush();
		
	}
	
	@BeforeMethod
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.nopcommerce.com/fr");
		
	}
	
	@Test
	public void noCommerceTitleTest() {
		
		test = extent.createTest("noCommerceTitleTest");
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Free and open-source eCommerce platform. ASP.NET Core based shopping cart. - nopCommerce");
		
		
	}
	
	@Test
	public void nopCommerceLogoTest() {
		
		test = extent.createTest("nopCommerceLogoTest");
		Boolean status  = driver.findElement(By.xpath("/html/body/div[7]/header/nav/div[2]/a/img")).isDisplayed();
		Assert.assertTrue(status);
		 
	}
	
	@Test
	public void nopCommerceLoginTest() {
		
		test = extent.createTest("nopCommerceLoginTest");
		Assert.assertTrue(true);
	
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		
		if (result.getStatus()== ITestResult.FAILURE) {
			
			test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getName());
			test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getThrowable());
			
			String screenshotPath = NopCommerce.getscreenShot(driver, result.getName());
			
			test.addScreenCaptureFromPath(screenshotPath);
			
		}else if (result.getStatus() == ITestResult.SKIP) {
			
			test.log(Status.SKIP, "Test Case SKIPPED IS " + result.getName());
			
		}else if (result.getStatus() == ITestResult.SUCCESS)  {
			
			test.log(Status.PASS, "Test Case PASSED IS " + result.getName());

			
		}
		
		driver.quit();
	}
	
	public static String getscreenShot(WebDriver driver , String screenshotName) throws IOException {
		
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		String destination = System.getProperty("user.dir") + "/Screenshots" + screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		
		
		
		return destination ;
		
	}

*/
}
