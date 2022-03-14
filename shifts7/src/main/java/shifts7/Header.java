package shifts7;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header {

	@FindBy (xpath=  "//span[@class='primary-nav__button-icon']")
	private WebElement icon;
	
	@FindBy (xpath="//a[text()='Employees']")
	private WebElement Employes;
	
	@FindBy ( xpath  = "(//a[@class='primary-nav__link'])[1]")
     private WebElement dashboard;
     
	@FindBy ( xpath  = "(//a[@href='/schedule'])[1]")
    private WebElement schedule;
    
	@FindBy ( xpath  = "(//a[@href='/log_book'])[1]")
    private WebElement LogBook;
	
    @FindBy(xpath = "(//div[@class='primary-nav__dropdown'])[2]")
    private WebElement Myprofile;
    
    @FindBy(xpath = "//a[@href='/users/logout']")
    private WebElement LogOut;
    
	private Actions act;
	
	private WebDriver driver;
	
	public Header(WebDriver driver)
	{
	PageFactory.initElements(driver, this);
	this.driver= driver;
	}
	
	public void employe() throws InterruptedException {
	
	act = new Actions (driver);
	Thread.sleep(3000);
    act.moveToElement(icon).moveToElement(Employes).click().perform();
    
     }
	
	public void Dashboard() throws InterruptedException {
    Thread.sleep(3000);
	dashboard.click();		
	}
	
	public void Schedule() throws InterruptedException {
		
	schedule.click();
	JavascriptExecutor hi = (JavascriptExecutor)driver;
    Thread.sleep(2000);
    hi.executeScript("scroll(0,-400)");
	    }
	
	public void logbook() throws InterruptedException {
	Thread.sleep(2000);
	LogBook.click();
	}
	
	public void logOut() throws InterruptedException {
		
	act = new Actions(driver);
	Thread.sleep(3000);
	act.moveToElement(Myprofile).moveToElement(LogOut).click().perform();
		
	}
}
