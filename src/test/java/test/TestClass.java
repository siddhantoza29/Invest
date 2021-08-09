package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.Base;
import pom.rechargepom;
import utils.utility;

public class TestClass extends Base {
	private	WebDriver driver;
	private String data;
	private double data2;
	private FileInputStream file;
    
	private  rechargepom page;
	private String value;
	@BeforeSuite
	public void beforesuite()
	{

	}
	@BeforeTest
	public void launchbrower()
	{
		driver = openChromeBrowser();
		driver.manage().window().maximize();
	}

	@BeforeClass
	public void objects()
	{
		page = new rechargepom(driver);
	}
	@BeforeMethod
	public void geturl()
	{
		driver.get("https://paytm.com/");
	} 

	@Test
	public void creditcard() throws EncryptedDocumentException, IOException
	{
		int row=1;
		int cell=1;
		
		page.clickonrech();
		page.more();
		page.credit();
		page.prepaidclick();
		try
		{
		    data = utility.fetchdatafromExcel(row, cell);
			page.mobclick(value);
		}
		catch(IllegalStateException e)
		{
		    file = new FileInputStream("D:\\AutoScreenshots\\paytmdata.xlsx");
			double data2 = WorkbookFactory.create(file).getSheet("Sheet1").getRow(row).getCell(cell).getNumericCellValue();
			System.out.println(data2);
			value = String.valueOf(data2);
			
			page.mobclick(value);
		}
		
	}
	@AfterMethod()
	public void  aftermethod()
	{
		System.out.println("aftermethod");
	}
	@AfterClass()
	public void close()
	{
		//driver.close();
		System.out.println("afterclass");
	}
	@AfterTest()
	public void aftertest()
	{
		page = null;
	}
	@AfterSuite()
	public void aftersuite()
	{

		System.out.println("aftersuite");
	}

}


