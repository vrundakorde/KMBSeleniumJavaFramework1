package POM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import CommonUtility.ExcelOperation;
import CommonUtility.KMBLog;
import CommonUtility.CommonMethods;
import CommonUtility.ScreenShot;
import CommonUtility.SetUp;
import TestScript.leadCreationTest1;

public class LoginPage extends SetUp
{
	//String temp = null;
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Login Page
	
	@FindBy(xpath="//input[@id='TxtName']")     //UserName field
	private WebElement userName;
	public WebElement userName()
	{
		return userName;
	}
	
	@FindBy(xpath="//input[@id='TxtPassword']")   //Password field
	private WebElement password;
	public WebElement password()
	{
		return password;
	}
	
	@FindBy(xpath= "//input[@name='command']")   //Login button
	private WebElement loginBtn;
	public WebElement loginBtn()
	{
		return loginBtn;
	}
	
	//To change User Role
			@FindBy(xpath= "//header/div[1]/div[3]/div[3]/a[1]/img[1]")   //Profile button
			private WebElement ProfileBtn;
			public WebElement ProfileBtn()
			{
				return ProfileBtn;
			}
			
			@FindBy(xpath= "//div[@data-autoid='header_loginroles']/div[1]/div[1]/div[1]/div[1]/div[1]/select[1]")   //User Role LOVs
			private WebElement UserRoleLOVs;
			public WebElement UserRoleLOVs()
			{
				return UserRoleLOVs;
			}
			
	
	public void CRMLogin() throws Exception
	{
		try 
		{
				ScreenShot.takeSnapShot("Login");
				//ScreenShot.ExtentTest.log(Status.PASS," CRM Login intiated ", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());

				CommonMethods.ExWait(userName());
				userName().click();
				KMBLog.logDebug("Clicked on Username textbox");
				CommonMethods.input(userName,"HLNewLead","Username", 1);
				KMBLog.logInfo("Username =" +userName().getAttribute("value"));
			
				CommonMethods.ExWait(password()); 
				password().click();
				KMBLog.logDebug("Clicked on Password textbox");
				CommonMethods.input(password,"HLNewLead","Password", 1);
				KMBLog.logInfo("Password ="+password().getAttribute("value"));

				CommonMethods.ExWait(loginBtn());
				CommonMethods.highLight(loginBtn());
				loginBtn().click();
				KMBLog.logDebug("Clicked on Login Button");

				ScreenShot.takeSnapShot("HomePage");
				//ScreenShot.ExtentTest.log(Status.PASS," Home Page Open ", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());

				try {
					Thread.sleep(1000);
					CommonMethods.ExWait(ProfileBtn());
					CommonMethods.highLight(ProfileBtn());
					ProfileBtn().click();
					KMBLog.logDebug("Clicked on Profile icon");
					Thread.sleep(1000);
					CommonMethods.highLight(UserRoleLOVs());
					Thread.sleep(1000);
					CommonMethods.selectByText(UserRoleLOVs(),"HLNewLead","UserRole", 1);
					KMBLog.logInfo("User role selected as "+ExcelOperation.getCellData("HLNewLead", "UserRole", 1));

					Thread.sleep(1000);
					
				}catch(Exception e) {System.out.println("Profile exception:"+e.getMessage());}
				
		}catch (Exception e) 
		{
			ScreenShot.takeSnapShot("Login Exception");
			System.out.println("Login Exception :"+e.getMessage());
			KMBLog.logError("Login Exception :"+e.getMessage());
			
		}
	}
	
	/******************LOGOUT*************************/
	
	@FindBy(xpath="//div[@data-autoid='Logout']/a")
	private WebElement logOutBtn;
	public WebElement logOutBtn()
	{
		return logOutBtn;
	}
	
	public void Logout()
	{
		try 
		{
			Thread.sleep(1000);
			CommonMethods.ExWait(ProfileBtn());
			CommonMethods.highLight(ProfileBtn());
			ProfileBtn().click();
			Thread.sleep(1000);
			CommonMethods.highLight(logOutBtn);
			logOutBtn.click();
			System.out.println("Sucessfully logout..");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
