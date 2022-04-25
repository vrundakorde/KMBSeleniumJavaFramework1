package TestScript;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import CommonUtility.AutoConst;
import CommonUtility.ExcelOperation;
import CommonUtility.KMBLog;
import CommonUtility.ListenersTest;
import CommonUtility.SetUp;
import POM.CustomerAcceptance;
import POM.FileClosedInCRM;
import POM.LeadCreation;
import POM.LoginPage;


public class leadCreationTest1 extends SetUp implements AutoConst
{

	//Variables for reading excel sheet
	public static int TotalTestScenarios;
	public static ArrayList<String> sheetNames,methodnames;
	public static String RunMode;
	public static String TestCaseIDName;
	public static String TestCaseDesc;
	public static String LeadStatus;	
	
	//Objects of POM classes
	public LoginPage login;
	public LeadCreation leadCreate; 
	public CustomerAcceptance custAccept;
	public FileClosedInCRM fileClosed;
	
	//public static Logger log =LogManager.getLogger(leadCreationTest1.class.getName());
	
	@Test
	void ExecuteScript() throws IOException
	{
		try 
		{
			
	//Start iterating Scenarios excel sheet and run scripts accordingly	with RunMode = Yes	
			TotalTestScenarios=ExcelOperation.getRowCount(SheetName);
			System.out.println("Total Test Scenarios :"+TotalTestScenarios);
			
			for(int i=0;i<=TotalTestScenarios;i++)
			{
				RunMode=ExcelOperation.getCellData(SheetName,"RunMode", i);
				TestCaseIDName=ExcelOperation.getCellData(SheetName, "TCID", i);
				TestCaseDesc=ExcelOperation.getCellData(SheetName, "Description", i);
				System.out.println("Run  Mode is :"+RunMode + "| TestCase ID Name :"+TestCaseIDName+"| Test Case Description : "+TestCaseDesc);
				KMBLog.log.info("Run  Mode is :"+RunMode + "| TestCase ID Name :"+TestCaseIDName+"| Test Case Description : "+TestCaseDesc);
				
			//To check whether Run Mode is Yes if true then execute that scenarios only
				if(RunMode.equalsIgnoreCase("Yes"))
				{
					if(TestCaseIDName.equalsIgnoreCase("TC01"))
					{
							KMBLog.logInfo("Executaion Started");	
							LeadCreation();
							//log.info("TC01 Execution Completed");	
							KMBLog.logInfo("Execution Completed");
					}
											
				
				}//end of if loop to check RunMode
			} // end of for loop to iterate excel sheet
		} catch (Exception e) 
		{
			System.out.println("ExecuteScript exception :"+e.getMessage());
			//log.error("ExecuteScript exception :"+e.getMessage());
			KMBLog.logError("ExecuteScript exception :"+e.getMessage());
		}
	}
	
	
		public void LeadCreation() throws Exception
		{
			//Login	
				login = new LoginPage(driver);
				//log.info(TestCaseIDName+"=========CRM LOGIN INITIATE=============");
				KMBLog.logInfo("=========CRM LOGIN INITIATE=============");
				login.CRMLogin();
			//New Lead Creation
				leadCreate = new LeadCreation(driver);
				//log.info(TestCaseIDName+"=========NEW Lead Creation=============");
				KMBLog.logInfo("=========NEW Lead Creation=============");
				leadCreate.NewLead();
				leadCreate.CreateNewLead();
				Thread.sleep(2000);
				leadCreate.Edit();
				Thread.sleep(1000);
				leadCreate.FollowUpNew();
		//Customer acceptance
				//leadCreate = new LeadCreation(driver);
				custAccept = new CustomerAcceptance(driver);
				Thread.sleep(1000);
				//log.info(TestCaseIDName+"=======Customer Acceptance=======");
				KMBLog.logInfo("=========Customer Acceptance=============");
				leadCreate.Edit();
				custAccept.AppointmentFixed();
				Thread.sleep(1000);
				leadCreate.Edit();
				custAccept.DocumentPending();
				
		//File closed in CRMNext to Sent To LOS
				//leadCreate = new LeadCreation(driver);
				fileClosed = new POM.FileClosedInCRM(driver);
				Thread.sleep(1000);
				//log.info(TestCaseIDName+"=======FileClosedInCRM=======");
				KMBLog.logInfo("=========FileClosedInCRM=============");
				leadCreate.Edit();
				fileClosed.DocCollected();
				Thread.sleep(2000);
				leadCreate.Edit();
				fileClosed.SentToLOS();
				KMBLog.logInfo("=========Sent To LOS Completed=============");

		} //End of Lead Creation Method
}
