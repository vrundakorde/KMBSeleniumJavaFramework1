package TestScript;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import CommonUtility.ExcelOperation;
import CommonUtility.CommonMethods;
import CommonUtility.ScreenShot;
import CommonUtility.SetUp;
import POM.CustomerAcceptance;
import POM.LeadCreation;
import POM.LoginPage;

//@Listeners(CommonUtility.ListenersTest.class)
public class LeadCreationTest extends SetUp 
{
	public LoginPage login;
	public POM.LeadCreation leadCreate; 
	public CustomerAcceptance custAccept;
	public POM.FileClosedInCRM fileClosed;
	
	
	//UserLogin function perform actions on Login page
	@Test(priority = 1)
	void Userlogin()throws InterruptedException
	{
		try 
		{
			login = new LoginPage(driver);
			System.out.println("\n=========CRM LOGIN INITIATE=============");
			login.CRMLogin();
			
		} catch (Exception e) {
			System.out.println("CRM Login Exception :"+e.getMessage());
		}
	}
	
	
	@Test(priority = 2, enabled = true)
	void LeadCreation()
	{
		try 
		{
			leadCreate = new LeadCreation(driver);
			System.out.println("\n=======NEW Lead Creation=====");
			leadCreate.NewLead();
			leadCreate.CreateNewLead();
			Thread.sleep(2000);
			leadCreate.Edit();
			Thread.sleep(1000);
			leadCreate.FollowUpNew();
		} catch (Exception e)
		{
			System.out.println("Lead Creation Exception:"+e.getMessage());
		}
	}
	@Test(priority = 3, enabled = true)
	void CustomerAccptance()
	{
		try 
		{
			leadCreate = new LeadCreation(driver);
			custAccept = new CustomerAcceptance(driver);
			Thread.sleep(1000);

			System.out.println("\n=====Customer Acceptance=======");
			leadCreate.Edit();
			custAccept.AppointmentFixed();
			Thread.sleep(1000);
			leadCreate.Edit();
			custAccept.DocumentPending();
			
		} catch (Exception e) {
			System.out.println("Customer Acceptance Exception: "+e.getMessage());
		}
	}
	
	@Test(priority = 4)
	void FileClosedInCRM()
	{
		try {
			leadCreate = new LeadCreation(driver);

			fileClosed = new POM.FileClosedInCRM(driver);
			Thread.sleep(1000);
			System.out.println("/n=====FileClosedInCRM=======");
			leadCreate.Edit();
			fileClosed.DocCollected();
			Thread.sleep(2000);
			leadCreate.Edit();
			fileClosed.SentToLOS();
			
		} catch (Exception e) 
		{
			System.out.println("File ClosedIN CRM Exception: "+e.getMessage());
		}
	}
	
	
}//End of Testcase1 class
