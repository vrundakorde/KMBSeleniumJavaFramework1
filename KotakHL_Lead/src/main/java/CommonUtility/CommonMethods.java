package CommonUtility;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import TestScript.leadCreationTest1;

public class CommonMethods extends SetUp
{
	static JavascriptExecutor js = (JavascriptExecutor) driver;
	static WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(70));
	
	
	
	public static void input(WebElement element, String SheetName, String ColName, int rowNum) throws EncryptedDocumentException, IOException
	{
		try {
			ExWait(element);
			element.sendKeys(ExcelOperation.getCellData(SheetName,ColName,rowNum));
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public static void ExWait(WebElement element)
	{
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void ExWaitWithJS(String urlText)
	{
		//wait until the page return complete as its status
		//wait.until(webDriver -> ((JavascriptExecutor)webDriver).executeScript("return document.readyState").equals("complete"));
		//wait.until(ExpectedConditions.stalenessOf(element));
		//wait.until(ExpectedConditions.urlContains(urlText));
		wait.until(ExpectedConditions.urlMatches(urlText));
	}
	
	//To highlight selected webelement
	public static void highLight(WebElement element)
	{
		 js.executeScript("arguments[0].style.border='4px solid red'", element);
	}
	
	//to scroll down the page by pixel values as Y co-ordiante
	public static void scrollDown(int y) 
	{
		js.executeScript("window.scrollBy(0,"+y+")");
	}
	
	//To scroll down the page by visibility of the element
	public static void scrollByVisibilityofElement(WebElement element)
	{
		js.executeScript("arguments[0].scrollIntoView()",element);
	}
	
	//To scroll down the page at the bottom of page.
	public static void scrollAtBottom()
	{
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		//Return the complete height of body (page)
	}
	
	//To select values from dropdown by visible text
	public static void selectByText(WebElement element, String sheetName, String colName, int rowNum) 
	{
		
		Select sel = new Select(element);
		try {
			ExWait(element);
			sel.selectByVisibleText(ExcelOperation.getCellData(sheetName,colName, rowNum));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} 
		
	}
	
	//To select values from dropdown by its value
	public static void selectByValue(WebElement element, String str) 
	{
		Select sel=  new Select(element);
		ExWait(element);
		sel.selectByValue("str");
	}
	//To select values from dropdown by its index value
	public static void selectByIndex(WebElement element, int index) 
	{
		Select sel= new Select(element);
		ExWait(element);
		sel.selectByIndex(index);
	}
	
	//To handle mouse hover actions
	public static void mouseHover(WebElement Element) 
	{
		Actions a = new Actions(driver);
		ExWait(Element);
		a.moveToElement(Element).perform();	
	}
	
	
	
}

