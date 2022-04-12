package CommonUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;



public class SetUp implements AutoConst
{
	public static WebDriver driver;
	
	@BeforeClass
	public void setUpTest() throws IOException 
	{
		Properties prop=new Properties();

		FileInputStream fis =new FileInputStream("C:\\Users\\Vrunda Vibhute\\eclipse-workspace\\KotakHL_Lead\\src\\main\\java\\CommonUtility\\Config.properties");

		prop.load(fis);
		
		String browserName=prop.getProperty("Browser");
		String URL = prop.getProperty("URL");
		
		//using webdriver manager
		if(browserName.equalsIgnoreCase("Chrome"))
		{
			ChromeOptions chromeOptions = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(chromeOptions);
		}
		else if(browserName.equalsIgnoreCase("Firefox"))
		{
			
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(firefoxOptions);
		}
		
		driver.get(URL);
		driver.manage().window().maximize();
		System.out.println("Browser Open..");	
		
	}

	@AfterClass
	public void tearDownTest() 
	{
		//Close Browser
		//driver.close();
		//driver.quit();
		//System.out.println("Browser Closed..");
	}


}
