package POM;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
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

public class LeadCreation extends SetUp
{
	public WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(30));
	public int row;
	public LeadCreation(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	/*******************For NEW LEAD ***********************/
	
		//Homepage
		
		@FindBy(xpath="//body/div[@id='main']/div[1]/div[1]/ul[1]/li[3]/div[1]/div[1]/a[1]")  //Sales
		//@FindBy(xpath="//div[@id='topnavdiv']//a[text()='Leads']")
		private WebElement sales;
		public WebElement sales()
		{
			return sales;
		}
		
		@FindBy(xpath="//span[contains(text(),'Leads')]")   //Clicking on Leads
		private WebElement Leads;
		public WebElement Leads() 
		{
			return Leads;
		}

		@FindBy(xpath="//div[@class='page-title__link']//*[text()='New']")    //New button 
		private WebElement New;
		public WebElement New()
		{
			return New;
		}
		
		@FindBy(xpath="//span[contains(text(),'Home Loan')]")
		private WebElement HomeLoan;
		public WebElement HomeLoan()
		{
			return HomeLoan;
		}
		
	
	public void NewLead() throws Exception
	{
		
		CommonMethods.ExWait(sales);
		CommonMethods.highLight(sales);
		// GenericUtils.mouseHover(login.sales());
		sales.click();
		ScreenShot.takeSnapShot(driver,"sales.png");
		 
		try 
		{
			CommonMethods.ExWait(Leads);
			CommonMethods.highLight(Leads());
			Leads().click();
			ScreenShot.takeSnapShot(driver,"Leads.png");
		}catch(Exception e){}
		
		//CommonMethods.ExWait(New);
		CommonMethods.highLight(New);
		CommonMethods.mouseHover(New);
		ScreenShot.takeSnapShot(driver,"new.png");

		CommonMethods.ExWait(HomeLoan);
		CommonMethods.highLight(HomeLoan);
		HomeLoan.click();
		 
		 //ScreenShot.takeSnapShot(driver,"C:\\Users\\Vrunda Vibhute\\eclipse-workspace\\KotakHL_Lead\\Screenshots\\newLead.png");
		 //ScreenShot.Ashot(driver,"C:\\Users\\Vrunda Vibhute\\eclipse-workspace\\KotakHL_Lead\\Screenshots\\ashot1.jpg");
	}
	
	/*******************************END NEW LEAD ************************************/
	
	
	//webelements locators for LeadCreation Page
	
	@FindBy(xpath="//label[@title='Lead Source']")     //Lead Source Label
	private WebElement leadSourceLbl;
	public WebElement leadSourceLbl()
	{
		return leadSourceLbl;
	}
	
	@FindBy(xpath="//select[@name='LE_LEADSOURCE']")	//Lead Source Field LOVs
	private WebElement leadSrcLOV;
	public WebElement leadSrcLOV()
	{
		return leadSrcLOV;
	}
	
	@FindBy(xpath="//div[@data-autoid='LE_LEADSOURCE']//span[@class='error-message pt1 db']")   //Lead Source Error message
	private WebElement leadSrcError;
	public WebElement leadSrcError()
	{
		return leadSrcError;
	}
	
	
	@FindBy(xpath="//label[@title='Sub-Source']")   //Sub Source Label
	private WebElement subSrcLbl;
	public WebElement subSrcLbl()
	{
		return subSrcLbl;
	}

	@FindBy(xpath="//select[@name='cust_113']")    //Sub Source LOVS
	private WebElement subSrcLOV;
	public WebElement subSrcLov()
	{
		return subSrcLOV;
	}
	
	@FindBy(xpath="//label[@title='Lead Priority']")   //Lead Priority label
	private WebElement leadPriorityLbl;
	public WebElement leadPriorityLbl()
	{
		return leadPriorityLbl;
	}

	@FindBy(xpath="//select[@name='LE_LEADRATING']")     //Lead Priority LOVS
	private WebElement leadPriorityLOV;
	public WebElement leadPriorityLOV()
	{
		return leadPriorityLOV;
	}

	@FindBy(xpath="//div[@data-autoid='cust_103']/label")   //Application Type Label
	private WebElement appTypeLbl;
	public WebElement appTypeLbl()
	{
		return appTypeLbl;
	}
	
	@FindBy(xpath="//select[@name='cust_103']")     //Application Type LOV
	private WebElement applicationType;
	public WebElement applcationType()
	{
		return applicationType;
	}
	
	@FindBy(xpath="//div[@data-autoid='LE_PRODUCT']/label")   //Product Type Label
	private WebElement prodTypeLbl;
	public WebElement prodTypeLbl()
	{
		return prodTypeLbl;
	}
		
	@FindBy(xpath="//div[@data-autoid='LE_PRODUCT']//select[@name='LE_PRODUCT']")   //Product Type LOVs
	private WebElement prodTypeLov;
	public WebElement prodTypeLov()
	{
		return prodTypeLov;
	}

	@FindBy(xpath="//div[@data-autoid='LE_NAME']/label")   //Applicant Name Label
	private WebElement appNameLbl;
	public WebElement appNameLbl()
	{
			return appNameLbl;
	}
	
	@FindBy(xpath="//select[@data-autoid='SALUTATION_ctrl']")  //Applicant salutation lovs
	private WebElement salutation;
	public WebElement salutation()
	{
		return salutation;
	}
	
	@FindBy(xpath="//input[@data-autoid='FIRSTNAME_ctrl']")   //FirstName txt field
	private WebElement firstName;
	public WebElement firstName()
	{
		return firstName;
	}
	
	@FindBy(xpath="//input[@data-autoid='MIDDLENAME_ctrl']")   //MiddleName txt field
	private WebElement middleName;
	public WebElement middleName()
	{
		return middleName;
	}
	
	@FindBy(xpath="//input[@data-autoid='LASTNAME_ctrl']")   //LastName txt field
	private WebElement lastName;
	public WebElement lastName()
	{
		return lastName;
	}
	
	@FindBy(xpath="//div[@data-autoid='LASTNAME']//span")  //LastName Error message
	private WebElement lastNameError;
	public WebElement lastNameError()
	{
		return lastNameError;
	}
	
	@FindBy(xpath="//div[@data-autoid='LE_MOBILE']/label")  //Mobile Number label
	private WebElement mobileNoLbl;
	public WebElement mobileNoLbl()
	{
		return mobileNoLbl;
	}
	
	@FindBy(xpath="//input[@data-autoid='LE_MOBILE_ctrl']")  //Mobile Number field
	private WebElement mobileNo;
	public WebElement mobileNo()
	{
		return mobileNo;
	}
	
	@FindBy(xpath="//div[@data-autoid='LE_MOBILE']//span")  //Mobile Number error message
	private WebElement mobileNoError;
	public WebElement mobileNoError()
	{
		return mobileNoError;
	}
	
	
	@FindBy(xpath="//div[@data-autoid='LE_EMAIL']/label")  //Email label
	private WebElement eMailLbl;
	public WebElement eMailLbl()
	{
		return eMailLbl;
	}

	@FindBy(xpath="//input[@data-autoid='LE_EMAIL_ctrl']")  //Email Txt field
	private WebElement eMail;
	public WebElement eMail()
	{
		return eMail;
	}
	
	@FindBy(xpath="//div[@data-autoid='LE_EMAIL']//span")  //Email Error message
	private WebElement eMailError;
	public WebElement eMailError()
	{
		return eMailError;
	}
	
	@FindBy(xpath="//div[@data-autoid='LE_DATEOFBIRTH']/label")  //DOB label
	private WebElement DOBLbl;
	public WebElement DOBLbl()
	{
		return DOBLbl;
	}
	
	@FindBy(xpath="//input[@data-autoid='LE_DATEOFBIRTH_ctrl']")  //DOB field
	private WebElement DOBField;
	public WebElement DOBField()
	{
		return DOBField;
	}
	
	@FindBy(xpath="//div[@data-autoid='LE_DATEOFBIRTH']//span[2]")  //DOB Error message
	private WebElement DOBError;
	public WebElement DOBError()
	{
		return DOBError;
	}
	
	@FindBy(xpath="//input[@data-autoid='cust_314_ctrl']")  //Gross Annual Income field
	private WebElement AnnualIncome;
	public WebElement AnnualIncome()
	{
		return AnnualIncome;
	}
	
	@FindBy(xpath="//input[@data-autoid='cust_314_ctrl']")  //Gross Annual Income lable
	private WebElement AnnualIncomeLbl;
	public WebElement AnnualIncomeLbl()
	{
		return AnnualIncomeLbl;
	}
	
	
	@FindBy(xpath="//div[@data-autoid='cust_120']/label")  //Property Identified label
	private WebElement PropIdentifiedLbl;
	public WebElement PropIdentifiedLbl()
	{
		return PropIdentifiedLbl;
	}
	
	@FindBy(xpath="//select[@data-autoid='cust_120_ctrl']")  //Property Identified LOVs
	private WebElement PropIdentifiedFld;
	public WebElement PropIdentifiedFld()
	{
		return PropIdentifiedFld;
	}
	
	@FindBy(xpath="//div[@data-autoid='LE_AMOUNT']/label")  //Loan amount label
	private WebElement loanAmtLbl;
	public WebElement loanAmtLbl()
	{
		return loanAmtLbl;
	}
	
	@FindBy(xpath="//input[@data-autoid='LE_AMOUNT_ctrl']")  //Loan amount Field
	private WebElement loanAmtFld;
	public WebElement loanAmtFld()
	{
		return loanAmtFld;
	}
	
	@FindBy(xpath="//div[@data-autoid='cust_73']/label")  //Loan Tenure label
	private WebElement loanTenureLbl;
	public WebElement loanTenureLbl()
	{
		return loanTenureLbl;
	}
	
	@FindBy(xpath="//input[@data-autoid='cust_73_ctrl']")  //Loan Tenure field
	private WebElement loanTenureFld;
	public WebElement loanTenureFld()
	{
		return loanTenureFld;
	}
	
	
	@FindBy(xpath="//a[@data-autoid='FlowNext']")  // Save & Proceed Button
	private WebElement saveProceedBtn;
	public WebElement saveProceedBtn()
	{
		return saveProceedBtn;
	}
		
	@FindBy(xpath="//div[@class='mobPopupBox db']/div")  // Save & Proceed Button, error pop up
	private WebElement saveProcError;
	public WebElement saveProcError()
	{
		return saveProcError;
	}
	
	/***************************NEW LEAD CREATE***********************************************/
	public void CreateNewLead()
	{
		try {
			
		//Source
			wait.until(ExpectedConditions.visibilityOf(leadSourceLbl()));
			//CommonMethods.selectByText(leadSrcLOV(),ExcelOperation.readData("Sheet1", 1, 2));
			CommonMethods.selectByText(leadSrcLOV(),ExcelOperation.getCellData("Sheet1","Lead Source",1));
			System.out.println(leadSourceLbl().getText()+"LOVS :"+leadSrcLOV().getText());
			
		//SubSource
			Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOf(leadSourceLbl()));
			//CommonMethods.selectByText(subSrcLov(),ExcelOperation.readData("Sheet1", 1, 3));
			CommonMethods.selectByText(subSrcLov(),ExcelOperation.getCellData("Sheet1","Sub Source",1));
			System.out.println(subSrcLbl().getText()+"LOVs : "+subSrcLov().getText());
			
		//Lead Priority
			wait.until(ExpectedConditions.visibilityOf(leadPriorityLbl()));
			//CommonMethods.selectByText(leadPriorityLOV(),ExcelOperation.readData("Sheet1", 1, 4));
			CommonMethods.selectByText(leadPriorityLOV(),ExcelOperation.getCellData("Sheet1","Lead Priority",1));
			System.out.println(leadPriorityLbl().getText()+"LOVs : "+leadPriorityLOV().getText());
		
		//Applicant Type
			wait.until(ExpectedConditions.visibilityOf(applcationType()));
			//CommonMethods.selectByText(applcationType(), ExcelOperation.readData("Sheet1", 1, 5));
			CommonMethods.selectByText(applcationType(), ExcelOperation.getCellData("Sheet1","Applicant Type",1));
			System.out.println(appTypeLbl().getText()+ "LOVs : "+applcationType().getText());

			ScreenShot.takeSnapShot(driver,"Leadcreate1.png");

			CommonMethods.scrollByVisibilityofElement(prodTypeLov());
			
		//Product Type
			wait.until(ExpectedConditions.visibilityOf(prodTypeLbl()));
			//CommonMethods.selectByText(prodTypeLov(),ExcelOperation.readData("Sheet1",1, 6));
			CommonMethods.selectByText(prodTypeLov(),ExcelOperation.getCellData("Sheet1","Product Type",1));
			System.out.println(prodTypeLbl().getText()+"LOVs :"+prodTypeLov().getText());
			
			
		//Salutation
			wait.until(ExpectedConditions.visibilityOf(salutation()));
			//CommonMethods.selectByText(salutation(),ExcelOperation.readData("Sheet1",1,7));
			CommonMethods.selectByText(salutation(),ExcelOperation.getCellData("Sheet1","Salutation",1));
			System.out.println(appNameLbl().getText()+ "LOVs :"+salutation().getText());
			
		//FirstName
			wait.until(ExpectedConditions.visibilityOf(firstName()));
			//firstName().sendKeys(ExcelOperation.readData("Sheet1", 1, 8));
			firstName().sendKeys(ExcelOperation.getCellData("Sheet1","First Name",1));
			System.out.println(appNameLbl().getText()+" = "+firstName().getAttribute("value"));
		
		//Middle Name
			//middleName().sendKeys(ExcelOperation.readData("Sheet1", 1, 9));
			//System.out.println(appNameLbl().getText()+ "= "+middleName().getAttribute("value"));
			
		//Lastname
			//lastName().sendKeys(ExcelOperation.readData("Sheet1", 1, 10));
			lastName().sendKeys(ExcelOperation.getCellData("Sheet1","Last Name",1));
			System.out.println(appNameLbl().getText()+ "= "+lastName().getAttribute("value"));
			
		//Mobile No
			wait.until(ExpectedConditions.visibilityOf(mobileNo()));
			mobileNo().sendKeys(ExcelOperation.getCellData("Sheet1","Mobile No",1));
			//mobileNo().sendKeys(ExcelOperation.readData("Sheet1", 1, 11));
			System.out.println(mobileNoLbl().getText()+ "= "+mobileNo().getAttribute("value"));
			String MobileNoLbl = mobileNoLbl().getText();
			String MobileNo = mobileNo().getAttribute("value");
			
		//EmailID	
			wait.until(ExpectedConditions.visibilityOf(eMail()));
			//eMail().sendKeys(ExcelOperation.readData("Sheet1", 1, 12));
			eMail().sendKeys(ExcelOperation.getCellData("Sheet1","Email",1));
			System.out.println(eMailLbl().getText()+ "= "+eMail().getAttribute("value"));
			
		//DOB
			wait.until(ExpectedConditions.visibilityOf(DOBField()));
			//DOBField().sendKeys(ExcelOperation.readData("Sheet1", 1, 13));
			DOBField().sendKeys(ExcelOperation.getCellData("Sheet1","DOB",1));
			System.out.println(DOBLbl().getText()+ "= "+DOBField().getAttribute("value"));
		
		//Gross Annual Income
			wait.until(ExpectedConditions.visibilityOf(AnnualIncome()));
			AnnualIncome().clear();
			//AnnualIncome().sendKeys(ExcelOperation.readData("Sheet1", 1, 14));
			AnnualIncome().sendKeys(ExcelOperation.getCellData("Sheet1", "Annual Income",1));
			System.out.println(AnnualIncomeLbl().getText() +" = "+AnnualIncome().getAttribute("value"));
			
		//Property Identified
			wait.until(ExpectedConditions.visibilityOf(PropIdentifiedFld()));
			//CommonMethods.selectByText(PropIdentifiedFld(),ExcelOperation.readData("Sheet1", 1, 15));
			CommonMethods.selectByText(PropIdentifiedFld(),ExcelOperation.getCellData("Sheet1","Property Identified",1));
			System.out.println(PropIdentifiedLbl().getText()+" = "+PropIdentifiedFld().getAttribute("value"));
		
		//Loan Amount
			wait.until(ExpectedConditions.visibilityOf(loanAmtFld()));
			//loanAmtFld().sendKeys(ExcelOperation.readData("Sheet1", 1, 16));
			loanAmtFld().sendKeys(ExcelOperation.getCellData("Sheet1", "Loan Amount",1));
			System.out.println(loanAmtLbl().getText() +" = "+loanAmtFld().getAttribute("value"));
			
		//Loan Tenure
			Thread.sleep(1000);
			loanTenureFld().clear();
			//loanTenureFld().sendKeys(ExcelOperation.readData("Sheet1", 1, 17));
			loanTenureFld().sendKeys(ExcelOperation.getCellData("Sheet1", "Loan Tenure",1));
			System.out.println(loanTenureLbl().getText()+" = "+loanTenureFld().getAttribute("value"));
			
			
			ScreenShot.takeSnapShot(driver,"Leadcreate2.png");
		
			//Save and Proceed button
			
			CommonMethods.highLight(saveProceedBtn());
			Thread.sleep(1000);
			saveProceedBtn().click();
			try 
			{	
				//System.out.println("Error clicking on Save & Continue");
				System.out.println("Lead Source error :" +leadSrcError().getText());
				System.out.println("Mobile Number Error :" +mobileNoError().getText());
				System.out.println("Save & Proceed Error pop up : "+saveProcError().getText());
			} catch (Exception e) 
			{			}
			Thread.sleep(2000);
			
			  //Write Data into excel 
			try {
				wait.until(ExpectedConditions.visibilityOf(leadStatusCodeLbl()));
			  	row = ExcelOperation.getRowCount("Output");
			  	System.out.println("No of Rows :" +row);
				Thread.sleep(2000);
				
			  	ExcelOperation.writeToExcel("Output", 0, 0, MobileNoLbl);
			  	ExcelOperation.writeToExcel("Output", row+1, 0, MobileNo);
			  	ExcelOperation.writeToExcel("Output", 0, 1, leadIDLbl().getText());
			  	ExcelOperation.writeToExcel("Output", row+1, 1, leadID().getText());
			  	ExcelOperation.writeToExcel("Output", 0, 2, leadStatusCodeLbl().getText());
			  	ExcelOperation.writeToExcel("Output", row+1, 2, leadStatusCodeVal().getText());
			  	ExcelOperation.writeToExcel("Output", 0, 3 ,leadLastModifyLbl().getText());
			  	ExcelOperation.writeToExcel("Output", row+1, 3, leadLastModifyVal().getText());
				Thread.sleep(2000);
				ScreenShot.takeSnapShot(driver,"Leadcreate3.png");

			  	String leadStatus = ExcelOperation.getCellData("Output", "Lead Status", row+1);
				System.out.println("Lead status = "+leadStatus);
				if(leadStatus.equalsIgnoreCase("New Lead"))
				{
					ExcelOperation.writeToExcel("Output",row+1, 4, "PASS");
				}
				else
				{
					ExcelOperation.writeToExcel("Output", row+1, 4, "FAIL");
				}
				
			  }
			  catch (Exception e) {}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());	
			}
	}

	/*****************************Follow Up NEW****************************************************/
	
	@FindBy(xpath="//div[@data-autoid='LE_NUMBER']/label")   //Lead ID label
	private WebElement leadIDLbl;
	public WebElement leadIDLbl()
	{
		return leadIDLbl;
	}

	@FindBy(xpath="//span[@data-autoid='LE_NUMBER_ctrl']")   //Lead ID label
	private WebElement leadID;
	public WebElement leadID()
	{
		return leadID;
	}	
	
	@FindBy(xpath="//div[@data-autoid='LE_STATUSCODE']/label")   //Lead Status code label
	private WebElement leadStatusCodeLbl;
	public WebElement leadStatusCodeLbl()
	{
		return leadStatusCodeLbl;
	}

	
	@FindBy(xpath="//span[@data-autoid='LE_STATUSCODE_ctrl']")   //Lead Status code value
	private WebElement leadStatusCodeVal;
	public WebElement leadStatusCodeVal()
	{
		return leadStatusCodeVal;
	}
	
	@FindBy(xpath="//label[contains(text(),'Last Modified On')]")   //Lead Last Modified on label
	private WebElement leadLastModifyLbl;
	public WebElement leadLastModifyLbl()
	{
		return leadLastModifyLbl;
	}
	
	@FindBy(xpath="//span[@data-autoid='Band_lastmodifiedon_ctrl']")   //Lead Last Modified on value
	private WebElement leadLastModifyVal;
	public WebElement leadLastModifyVal()
	{
		return leadLastModifyVal;
	}
	
	@FindBy(xpath="//div[@title='click here to see more actions']")   //Click here to see more actions
	private WebElement LeadMoreAction;
	public WebElement LeadMoreAction()
	{
		return LeadMoreAction;
	}
	
	@FindBy(xpath="//a[@data-autoid='Edit_1']/span[1]")   //Lead Edit button
	private WebElement LeadEdit;
	public WebElement LeadEdit()
	{
		return LeadEdit;
	}
	
	@FindBy(xpath="//div[@id='state_0']")   //Follow-up New button Tab
	private WebElement followUp;
	public WebElement followUp()
	{
		return followUp;
	}
	
	@FindBy(xpath="//div[@data-autoid='cust_402']/label")   //Follow-up date time label
	private WebElement followUpDtTimeLbl;
	public WebElement followUpDtTimeLbl()
	{
		return followUpDtTimeLbl;
	}
	
	@FindBy(xpath="//div[@data-autoid='cust_402']//div[1]//div[1]//div[1]//div[1]//div[1]//input")   //Follow-up date 
	private WebElement followUpDate;
	public WebElement followUpDate()
	{
		return followUpDate;
	}
	
	@FindBy(xpath="//div[@data-autoid='cust_402']//div[1]//div[1]//div[1]//div[1]//div[1]//a[@title='Today Date']")   //Follow-up today date 
	private WebElement followUpTodayDate;
	public WebElement followUpTodayDate()
	{
		return followUpTodayDate;
	}
	
	@FindBy(xpath="//div[@data-autoid='cust_402']//div[1]//div[1]//div[2]//div[1]//div[1]//input")   //Follow-up Time 
	private WebElement followUpTime;
	public WebElement followUpTime()
	{
		return followUpTime;
	}
	
	@FindBy(xpath="//div[@data-autoid='cust_132']/label")   //Follow-up Reason label
	private WebElement followUpReasonLbl;
	public WebElement followUpReasonLbl()
	{
		return followUpReasonLbl;
	}
	
	@FindBy(xpath="//select[@name='cust_132']")   //Follow-up Reason select lovs
	private WebElement followUpReasonLOV;
	public WebElement followUpReasonLOV()
	{
		return followUpReasonLOV;
	}
	
	@FindBy(xpath="//div[@data-autoid='cust_46']/label")   //Follow-up Remark label
	private WebElement followUpRemarkLbl;
	public WebElement followUpRemarkLbl()
	{
		return followUpRemarkLbl;
	}
	
	@FindBy(xpath="//textarea[@data-autoid='cust_46_ctrl']")   //Follow-up Remark text area
	private WebElement followUpRemarkTextFld;
	public WebElement followUpRemarkTextFld()
	{
		return followUpRemarkTextFld;
	}
	
/**********************EDIT LEAD from View **************************/
	
		
	@FindBy(xpath="//select[@data-autoid='QueryCategoryId_ctrl']")   //Category LOVs
	private WebElement ViewCategory;
	public WebElement ViewCategory()
	{
		return ViewCategory;
	}
	
	@FindBy(xpath="//select[@name='QueryViewId' or @data-autoid='QueryViewId_ctrl']")   //View Sub-Category LOVs
	private WebElement ViewSubCat;
	public WebElement ViewSubCat()
	{
		return ViewSubCat;
	}
	
	@FindBy(xpath="//a[@data-autoid='gridHF_View0']")   //Category ViewSrchArrow icon
	private WebElement ViewSrchArrow;
	public WebElement ViewSrchArrow()
	{
		return ViewSrchArrow;
	}

	@FindBy(xpath="//a[@data-autoid='LeadID_0']")   //first lead id to edit
	private WebElement LeadIdToEdit;
	public WebElement LeadIdToEdit()
	{
		return LeadIdToEdit;
	}
	
	//Edit function to perform Edit operation on Lead
	public void Edit() throws InterruptedException, EncryptedDocumentException, IOException
	{
		try 
		{
			row=ExcelOperation.getRowCount("Output");
			CommonMethods.ExWait(sales);
			CommonMethods.highLight(sales);
			// GenericUtils.mouseHover(login.sales());
			wait.until(ExpectedConditions.elementToBeClickable(sales)).click();
	
			//sales.click();
			Thread.sleep(1000);
			
			//System.out.println("View Category :" +ExcelOperation.getCellData("Sheet1", "Product Type",1));
			//System.out.println("View Sub Category :" +ExcelOperation.getCellData("Output","Lead Status",row));
	
			CommonMethods.ExWait(ViewCategory);
			//CommonMethods.selectByText(ViewCategory,ExcelOperation.readData("Sheet1", 1, 6));
			CommonMethods.selectByText(ViewCategory,ExcelOperation.getCellData("Sheet1", "Product Type",1));
			Thread.sleep(1000);
			
			//CommonMethods.selectByText(ViewSubCat, ExcelOperation.readData("Output", 1, 2));
			CommonMethods.selectByText(ViewSubCat, ExcelOperation.getCellData("Output","Lead Status",row));
			
			Thread.sleep(1000);
			ViewSrchArrow.click();
		
		try {
			Thread.sleep(1000);
			CommonMethods.ExWait(LeadIdToEdit);
			String ViewLeadID = LeadIdToEdit.getText();
			String ExcelLeadID = ExcelOperation.getCellData("Output", "Lead ID", row);
			
			if(ViewLeadID.equalsIgnoreCase(ExcelLeadID))
			{
				CommonMethods.highLight(LeadIdToEdit);
				LeadIdToEdit.click();
			}
			
			} catch (Exception e) {	}
			
			Thread.sleep(1000);
			CommonMethods.scrollByVisibilityofElement(LeadEdit);
			CommonMethods.highLight(LeadEdit);
			LeadEdit.click();
			Thread.sleep(1000);
		} 
		catch (Exception e) 
		{
			System.out.println("Edit Lead exception:"+e.getMessage());
		}
	}
	/***************************END EDIT********************************************/
	//Edit Lead to Follow up new appointment
	public void FollowUpNew()   
	{
		try 
		{	
			//Thread.sleep(2000);
			//CommonMethods.scrollByVisibilityofElement(LeadEdit);
			//CommonMethods.highLight(LeadEdit);
			//LeadEdit.click();
			//Thread.sleep(1000);
			
			followUp.click();
			Thread.sleep(1000);
			//followUpDate.sendKeys(ReadExcel.readData("Sheet1",1 ,18 ));
			followUpTodayDate.click();
			System.out.println(followUpDtTimeLbl.getText()+" = "+followUpDate.getAttribute("value"));
			
			Thread.sleep(1000);
			//followUpTime.sendKeys(ExcelOperation.readData("Sheet1", 1, 19));
			followUpTime.clear();
			followUpTime.sendKeys(ExcelOperation.getCellData("Sheet1","Follow up Time",1));
			System.out.println(followUpDtTimeLbl.getText()+" = "+followUpTime.getAttribute("value"));
			
			Thread.sleep(1000);
			//CommonMethods.selectByText(followUpReasonLOV, ExcelOperation.readData("Sheet1", 1, 20));
			CommonMethods.selectByText(followUpReasonLOV, ExcelOperation.getCellData("Sheet1", "Follow Up Reason", 1));
			System.out.println(followUpReasonLbl.getText()+"="+ExcelOperation.readData("Sheet1", 1, 20));
			
			Thread.sleep(1000);
			//followUpRemarkTextFld.sendKeys(ExcelOperation.readData("Sheet1", 1, 21));
			followUpRemarkTextFld.clear();
			followUpRemarkTextFld.sendKeys(ExcelOperation.getCellData("Sheet1","Follow Up Remark",1));
			System.out.println(followUpRemarkLbl.getText()+" = "+followUpRemarkTextFld.getAttribute("value"));
			
			ScreenShot.takeSnapShot(driver,"FollowupNew.png");

			Thread.sleep(2000);
			saveProceedBtn.click();      //Save Button
			try 
			{
				Thread.sleep(2000);
				System.out.println("Warning : "+driver.findElement(By.xpath("//div[@class='warning__message']")).getText());
				driver.findElement(By.xpath("//button[contains(text(),'Ok')]")).click();
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			Thread.sleep(2000);
			//Write Data into excel 
			try {
				wait.until(ExpectedConditions.visibilityOf(leadStatusCodeLbl()));
			  
			  	//ExcelOperation.writeToExcel("Output", row+1, 2, leadStatusCodeVal().getText());
			  	ExcelOperation.writeToExcel("Output", row, 2,"Follow-Up New" );
			  	ExcelOperation.writeToExcel("Output", row, 3, leadLastModifyVal().getText());
			  	
			  	String leadStatus = ExcelOperation.getCellData("Output", "Lead Status", row);
				System.out.println("Lead status = "+leadStatus);
				if(leadStatus.equalsIgnoreCase("Follow-Up New"))
				{
					ExcelOperation.writeToExcel("Output",row, 4, "PASS");
				}
				else
				{
					ExcelOperation.writeToExcel("Output", row, 4, "FAIL");
				}
				
			  }
			  catch (Exception e) {}
			 
			ScreenShot.takeSnapShot(driver,"FollowupNew2.png");
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
/*****************************END Follow Up NEW****************************************************/

	
	
	
	
	
}


