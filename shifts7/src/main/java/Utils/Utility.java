package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
       
    public static String getDatafromeExcel(String sheet,int row,int col) throws EncryptedDocumentException, IOException {
    	
    String path = "C:\\Users\\omkar wagh\\OneDrive\\Desktop\\omkarwagh1.xlsx" ;
	FileInputStream file = new FileInputStream(path);
	String data = WorkbookFactory.create(file).getSheet(sheet).getRow(row).getCell(col).getStringCellValue();	
    return data;

	}
	
	public static void getScreenShot(WebDriver driver,int Testid) throws IOException {
		
    TakesScreenshot ok = ((TakesScreenshot)driver);
	File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	File Dest = new File("C:\\Users\\omkar wagh\\OneDrive\\Pictures\\Screenshots\\New folder\\"+Testid+".jpg");
	FileHandler.copy(src, Dest);
	
	}
}
