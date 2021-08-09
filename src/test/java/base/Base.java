package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	public static WebDriver openChromeBrowser()
	{
		System.setProperty("webdriver.chrome.driver","D:\\Automation\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		return driver;
	}
	
	/*public static WebDriver openFirefoxBrowser()
	{
		System.setProperty("webdriver.gecko.driver","D:\\AutoScreenshots\\Gecko\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		return driver;
	} */

}
