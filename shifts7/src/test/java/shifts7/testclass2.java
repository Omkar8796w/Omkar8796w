  
package shifts7;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Browser.Browser;
import Utils.Utility;


public class testclass2 extends Browser{

	  private WebDriver driver;
	  private loginPage1 login;
	  private Header header;
	  int Testid;
	  static ExtentTest test;
	  static ExtentHtmlReporter reporter;
	
	  @BeforeTest
	  @Parameters ("browser")
	  public void launchthebrowser(String browser) throws Exception  {
			reporter = new ExtentHtmlReporter("test-output"+File.separator+"ExtendReport"+File.separator+"extendReport.html");
			ExtentReports extend = new ExtentReports();
			extend.attachReporter(reporter);
	  
	  if(browser.equalsIgnoreCase("Chrome"))
	  {
	  driver = launchtheBrowser1();
	  }
	  if(browser.equalsIgnoreCase("FireFox"))
	  {
      driver = launchtheBrowser2();
	  }
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	    
	  }
	
	  @BeforeClass
      public void launchBrowser() {	  
	  login = new loginPage1 (driver);
	  header = new Header(driver);
	  }
	
	  @BeforeMethod()
	  public void loginIntoApplication() throws EncryptedDocumentException, IOException, InterruptedException{
	  driver.get("https://app.7shifts.com/");
	  String username1 = Utility.getDatafromeExcel("Sheet1", 1, 0);
      login.Username(username1);
      String password1 = Utility.getDatafromeExcel("Sheet1", 1, 1);
	  login.Password(password1);
	  login.loginbutton();	
	  }
	  
	  @Test  (priority = 1)
	  public void verifytheDashBoard() throws InterruptedException {
	  Testid = 101;
	  header.Dashboard();
	  String title = driver.getCurrentUrl(); 
	  Assert.assertEquals(title,"https://app.7shifts.com/employers");
	  System.out.println("pass 1");
	  }
	  
	  @Test  (priority = 2)
	  public void verifytheSchedule() throws InterruptedException {
	  Testid = 101;
	  header.Schedule();
	  String title2 = driver.getCurrentUrl();
	  Assert.assertEquals(title2,"https://app.7shifts.com/location/236889/schedule/2022-02-21?view=week&department_id=337665");
	  System.out.println("pass 2");
	 
	  }
	  
	  @Test  (priority = 3)
	  public void verifytheLogBook() throws InterruptedException {
	  Testid = 102;
	  header.logbook();
      String title3 = driver.getCurrentUrl();
      Assert.assertEquals(title3,"https://app.7shifts.com/log_book");
      System.out.println("pass 3");
	  }
	  
	  @Test  (priority = 4)
	  public void verifytheemployeetab() throws InterruptedException {
	  Testid = 103;
	  header.employe();
	  String title4 = driver.getCurrentUrl();
	  Assert.assertEquals(title4,"https://app.7shifts.com/company/186135/employees");
	  System.out.println("pass 4");
	  }
	  
      @AfterMethod
      public void LogOutFromApplication(ITestResult result) throws InterruptedException, IOException {
      if(ITestResult.FAILURE==result.getStatus())
      {
      Utility.getScreenShot(driver, Testid);
      }
      header.logOut();
      System.out.println("logout pass");
      }
	  
      @AfterClass
      public void QuittheBrowser(){
      login = null;
      header = null;
      }	
      
      @AfterTest
      public void quitTheBrowser() {
      driver.quit();
      driver = null;
      System.gc();   //garbage collectors   	  
      }
}
