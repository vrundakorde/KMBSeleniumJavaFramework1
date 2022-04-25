package CommonUtility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


public class ListenersTest extends ExtentReporterNG implements ITestListener
{
	ExtentTest test;
	ExtentReports extent = getReportsObject();
	
	//To avoid overwrite of test when executing test cases in parallel mode we are using ThreadLocal
	ThreadLocal<ExtentTest> extentTest= new ThreadLocal<ExtentTest>();
	
	//onTestStart Listener handles on Start of any Test		
    public void onTestStart(ITestResult Result)					
    {		
		System.out.println(Result.getName()+" test case started");	
		test = extent.createTest(Result.getMethod().getMethodName()+" test case started");
		extentTest.set(test);
    }	
	
	 // When Test case get passed, this method is called.			
    public void onTestSuccess(ITestResult Result)					
    {		
    	System.out.println("The name of the testcase passed is :"+Result.getName());	
    	extentTest.get().log(Status.PASS, Result.getMethod().getMethodName()+" Passed");
    	//test.log(Status.PASS, Result.getMethod().getMethodName()+" Passed");
    }		

	//OnTestFailure Listener handles to capture screen shots of Failed test case
    @Override		
    public void onTestFailure(ITestResult result) 		
	{	
		extentTest.get().fail(result.getThrowable());
		//test.fail(result.getThrowable());
		try 
		{
				//ScreenShot.takeSnapShot(result.getMethod().getMethodName());
				extentTest.get().addScreenCaptureFromPath(ScreenShot.takeSnapShot(result.getMethod().getMethodName()), result.getMethod().getMethodName());
				//test.addScreenCaptureFromPath(ScreenShot.takeSnapShot(result.getMethod().getMethodName()), result.getMethod().getMethodName());
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
    
    @Override	
	public void onFinish(ITestContext context)
	{
		extent.flush();
	}
	
	
}
