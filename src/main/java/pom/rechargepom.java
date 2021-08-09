package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class rechargepom {
	private WebDriver driver;
	@FindBy (xpath ="(//div[text()='Recharge'])[1]")
	private WebElement recharge;
	
	@FindBy (xpath= "//span[text()='More']")
	private WebElement more;
	
	@FindBy (xpath = "//div[text()='Credit Card Payment']")
	private WebElement creditcard;
	
	@FindBy (xpath="//span[text()='Prepaid/Postpaid']")
	private WebElement prepaid;
	
	@FindBy(xpath="//input[@type='tel']")
	private WebElement number;
	
	
	public rechargepom(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickonrech()
	{
		recharge.click();
	}
	public void more()
	{
		Actions act = new Actions(driver);
		act.moveToElement(more).perform();
	}
	public void  credit()
	{
		Actions act = new Actions(driver);
	act.moveToElement(creditcard).click().perform();
	}
	public void prepaidclick()
	{
		prepaid.click();
	}
	public void mobclick(String value)
	{
		number.sendKeys(value);
	}
}
