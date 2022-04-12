package CommonUtility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersTest implements ITestListener
{
	//onTestStart Listener handles on Start of any Test	
	@Override		
    public void onTestStart(ITestResult Result)					
    {		
		System.out.println(Result.getName()+" test case started");					
    }	
	
	 // When Test case get passed, this method is called.		
    @Override		
    public void onTestSuccess(ITestResult Result)					
    {		
    System.out.println("The name of the testcase passed is :"+Result.getName());					
    }		

	//OnTestFailure Listener handles to capture screen shots of Failed test case
    @Override		
    public void onTestFailure(ITestResult result) 		
	{	
		TakesScreenshot t = (TakesScreenshot) SetUp.driver;
		
		File srcFile = t.getScreenshotAs(OutputType.FILE);
		try 
		{
			FileUtils.copyFile(srcFile, new File("C:\\Users\\Vrunda Vibhute\\eclipse-workspace\\KotakHL_Lead\\Screenshots"+result.getName()+".png"));
		    System.out.println("The name of the testcase failed is :"+result.getName());					

		} 
		catch (Exception e) 
		{	
			System.out.println(e.getMessage());
		}
		
	}

	 // When Test case get Skipped, this method is called.		
    @Override		
    public void onTestSkipped(ITestResult Result)					
    {		
    	System.out.println("The name of the testcase Skipped is :"+Result.getName());					
    }		
	
	
	
	
}
