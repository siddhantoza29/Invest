package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class utility {

 public static String fetchdatafromExcel(int row,int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream file = new FileInputStream("D:\\AutoScreenshots\\paytmdata.xlsx");
		String data = WorkbookFactory.create(file).getSheet("Sheet1").getRow(row).getCell(cell).getStringCellValue();
		System.out.println();
		return data;
	}
	
	public static void takescreenshot() throws IOException
	{
		WebDriver driver=new ChromeDriver();
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("D:\\AutoScreenshots\\New folder\\name.jpg");
		FileHandler.copy(source, dest);
	}

}
