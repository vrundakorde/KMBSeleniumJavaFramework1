package CommonUtility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG extends SetUp
{
	public static ExtentReports getReportsObject()
	{
		ExtentReports extent = null;
		try {
		//String reportPath = System.getProperty("user.dir")+"\\Reports\\KMB_LeadCreationReport_"+folderDate;
		String reportPath = "C:\\Users\\Vrunda Vibhute\\git\\KMBSeleniumJavaFramework1\\KotakHL_Lead\\Reports\\TestReport_"+folderDate+".html";
		
		ExtentSparkReporter reporter =new ExtentSparkReporter(reportPath);
		reporter.config().setReportName("Web Automation Result");
		reporter.config().setDocumentTitle("Test Results");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester Name","Vrunda Vibhute");
		extent.setSystemInfo(" "," ");
		
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return extent;
	}
}
