package shifts7;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage1 {

		@FindBy (xpath = "//input[@id='email']")
		private WebElement username ;
		
		@FindBy (xpath = "//input[@id='password']")
		private WebElement password ;
		
		@FindBy (xpath = "//input[@name='submit']")
		private WebElement loginbutton;

		private WebDriver driver;
		
	    public loginPage1(WebDriver driver) {
		   PageFactory.initElements(driver, this);
		   this.driver = driver;
	    }
	   
	    public String Username(String userid) {
		   username.sendKeys(userid);;
		   return userid;
	    }
	   
	    public String Password(String pass) {
		   password.sendKeys(pass);
		   return pass;
	    }
	   
	    public void loginbutton() throws InterruptedException {
		   loginbutton.click();
		  
	  
	    }}


