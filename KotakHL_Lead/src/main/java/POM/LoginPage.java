package POM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import CommonUtility.ExcelOperation;
import CommonUtility.CommonMethods;
import CommonUtility.ScreenShot;
import CommonUtility.SetUp;

public class LoginPage extends SetUp
{
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
			
	
	public void CRMLogin()
	{
		try 
		{
				ScreenShot.takeSnapShot(driver,"login.png");
			
				CommonMethods.ExWait(userName());
				userName().click();
				//userName().sendKeys(ExcelOperation.readData("Sheet1",1,0));
				userName().sendKeys(ExcelOperation.getCellData("Sheet1","Username", 1));
				System.out.println("Username =" +userName().getAttribute("value"));
			
				CommonMethods.ExWait(password()); 
				password().click();
				//password().sendKeys(ExcelOperation.readData("Sheet1",1,1));
				password().sendKeys(ExcelOperation.getCellData("Sheet1","Password", 1));
				System.out.println("Password ="+password().getAttribute("value"));

				CommonMethods.ExWait(loginBtn());
				CommonMethods.highLight(loginBtn());
				loginBtn().click();
				 
				ScreenShot.takeSnapShot(driver,"homepage.png");
				 
				try {
					Thread.sleep(1000);
					CommonMethods.ExWait(ProfileBtn());
					CommonMethods.highLight(ProfileBtn());
					ProfileBtn().click();
					Thread.sleep(1000);
					CommonMethods.highLight(UserRoleLOVs());
					Thread.sleep(1000);

					CommonMethods.selectByText(UserRoleLOVs(),"Relationship Manager");
					Thread.sleep(1000);
				}catch(Exception e) {System.out.println("Profile exception:"+e.getMessage());}
				
		}catch (Exception e) 
		{
			System.out.println("Exception :"+e);
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
