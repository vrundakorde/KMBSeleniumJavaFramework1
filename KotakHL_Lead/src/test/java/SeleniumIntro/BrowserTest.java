package SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserTest {
	public static WebDriver driver, driver2;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Welcome");
		
		
		ChromeOptions chromeOptions = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(chromeOptions);
		
		driver.get("https://kmb.crmnext.com/sng7/app/login/login");
		//driver.switchTo().newWindow(WindowType.TAB);
		//driver.navigate();
		
		//driver2 = new ChromeDriver(chromeOptions);
		//driver2.get("http://demo.guru99.com/V4/");
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='TxtName']")).click();
		driver.findElement(By.xpath("//input[@id='TxtName']")).sendKeys("HLSARM");
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='TxtPassword']")).click();
		driver.findElement(By.xpath("//input[@id='TxtPassword']")).sendKeys("acid_qa");
		
		Thread.sleep(2000);
		WebElement loginBtn= driver.findElement(By.xpath("//input[@name='command']"));
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;  
		jsExecutor.executeScript("arguments[0].style.border='2px solid red'", loginBtn);  
		Thread.sleep(2000);

		loginBtn.click();
		Thread.sleep(2000);

		//CommonUtility.ScreenShot.takeSnapShot(driver, "homepage.png");
		
		
		
	}

}
