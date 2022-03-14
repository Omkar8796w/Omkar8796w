package Browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser {

	public static WebDriver launchtheBrowser1() {
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\omkar wagh\\Downloads\\chromedriver_win32\\chromedriver.exe"); 
    WebDriver driver = new ChromeDriver();
	return driver; 	
	
	//for Chrome Apllication
	
	}
	
	public static WebDriver launchtheBrowser2() {
    System.setProperty("webdriver.gecodriver.driver", ""); 
    WebDriver driver = new FirefoxDriver();
	return driver;
	
	//For FireFox Application
	
	}
}

