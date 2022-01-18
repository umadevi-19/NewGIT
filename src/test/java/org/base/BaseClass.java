package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.ContextClickAction;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	private static int rownumber;
	private static int cellnumber;
	private static Object String;
	private static java.lang.String value;
	private static java.lang.String valueOf;
	private static java.lang.String l;
	
	public static void browserLaunch() {
		WebDriverManager.chromedriver().setup();
		
	driver=new ChromeDriver();
	Actions a=new Actions(driver);
		
	}
	public static void urlLaunch(String url) {
		driver.get(url);
	

}
	public static void maxwindow() {
		driver.manage().window().maximize();

	}
	public static void textfill(WebElement element,String text) {
		
	
		element.sendKeys(text);

	}
	
	
	public static void takeScreenshot(String snap) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File target=new File("C:\\Users\\Baby\\eclipse-workspace\\Maven19\\Screenshot\\"+snap+".png");
		FileUtils.copyFile(source, target);
	}
	public static void moveToElement(WebElement element) {
		Actions a=new Actions(driver);
		
		a.moveToElement(element).perform();
		
	}
	public static void draganddrop(WebElement element,WebElement element1) {
		Actions a=new Actions(driver);
		a.dragAndDrop(element, element1).perform();

	}
	public static void btnclick(WebElement element) {
		element.click();
		
   }
	
	public static void dismissalert() {
		
		Alert a=driver.switchTo().alert();
	        a.dismiss();
	}
	
public static void acceptAlert() {
		
		Alert dl = driver.switchTo().alert();

		dl.accept();
}   

public static void sendTextAlertBox(String text) {
	 Alert al = driver.switchTo().alert();
	 al.sendKeys(text);
	
}
public static void ContextClickAction(WebElement element) {
	Actions a=new Actions(driver);
	a.contextClick(element).perform();
}

public static void dropdownIndex(WebElement element,int index) {
	Select drop=new Select(element);
	
	drop.selectByIndex(index);
	
}
public static void dropdowntext(WebElement element,String text) {
	Select drop=new Select(element);
	drop.selectByVisibleText(text);

}
public static void dropdownValue(WebElement element, String value) {
	Select drop=new Select(element);
	drop.selectByValue(value);
	
	

}
public static void textfromBox(WebElement element) {
	String text = element.getText();
System.out.println(text);
	
}
	
public static String getData(int rowNumber, int cellNumber) throws IOException {
	File f = new File("C:\\Users\\Baby\\eclipse-workspace\\Maven10\\Excel files\\Details.xlsx");
	
	FileInputStream fin = new FileInputStream(f);
	
	Workbook w = new XSSFWorkbook(fin);
	
	Sheet s = w.getSheet("GreensTech");
	
	Row row = s.getRow(rowNumber);
	Cell cell = row.getCell(cellNumber);
	
	int cellType = cell.getCellType();
	
	String value =" ";
	if (cellType == 1) {
		value = cell.getStringCellValue();			
	}else if (cellType == 0) {
		if(DateUtil.isCellInternalDateFormatted(cell)) {
			Date d = cell.getDateCellValue();
			
			SimpleDateFormat sim = new SimpleDateFormat("dd,MMMM,yyyy");
			value = sim.format(d);
			
			
		}else {
			double d = cell.getNumericCellValue();
			
			value=(String)l;

}
	

	}
	return value;}}