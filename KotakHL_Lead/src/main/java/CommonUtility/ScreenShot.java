package CommonUtility;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import TestScript.leadCreationTest1;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class ScreenShot extends SetUp implements AutoConst
{
	
	static String FileDateTime = null;
	static File FilePath = null;
	
	//Variables for Screenshots location 
		public static String currentDir;
		public static String outPutFolder;
		public static String ScreenShotFolder ;
		public static String FailedScreenShotFolder;
		public static File flOutput;
		public static File flScreenShotFolder, src, dest;
		public static File flFailedScreenShotFolder;
		public static String PassScreenShot;
		public static String FailedScreenShot;
		
	
	//Create a folder to save Pass screenshots	
	public static File screenShotFolder()
	{
		
			//folderDate = java.time.LocalDate.now().toString();
		   //folderDate = new SimpleDateFormat("dd-MM-yyyy HH").format(new Date());
		   PassScreenShot = "PassScreenShot_"+folderDate;
		   
			currentDir = System.getProperty("user.dir")+"\\Screenshots";
			
			outPutFolder = currentDir +"\\Output_"+folderDate;
			ScreenShotFolder = outPutFolder+"\\"+PassScreenShot;

			flOutput = new File(outPutFolder);
			if(!flOutput.exists()) {
				if(flOutput.mkdir()) {
					System.out.println("Directory is created!");
					}
				else {
	                System.out.println("Failed to create directory!");
					}
				}
			
			flScreenShotFolder = new File(ScreenShotFolder);
			if(!flScreenShotFolder.exists()) {
				if(flScreenShotFolder.mkdir()) {
					System.out.println("Directory is created!");
					}
				else {
	                System.out.println("Failed to create directory!");
					}
				}
				FilePath = flScreenShotFolder;

				//FilePath = flScreenShotFolder+"\\"+leadCreationTest1.TestCaseDesc+"_"+fileName+".jpeg";
				return FilePath;
		  
			
	}
	
	
	//To capture screen shots of Pass cases and web page display on screen 
	public static String takeSnapShot(String name) throws Exception
	{
		String ScreenShotPath =null;
		try {
			//Convert web driver object to TakeScreenshot
			TakesScreenshot scrShot =((TakesScreenshot)driver);

			//Call getScreenshotAs method to create image file
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			//ScreenShotPath=ScreenShotFolder+"\\"+leadCreationTest1.TestCaseDesc+" "+name+".jpeg";

			//Move image file to new destination
			//File DestFile=new File(screenShotFolder(name));
			File DestFile=new File(screenShotFolder()+"\\"+leadCreationTest1.TestCaseDesc+"_"+name+".jpeg");

			//Copy file at destination
			FileUtils.copyFile(SrcFile, DestFile);
			
			
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return ScreenShotPath;
    }
	
	//To capture screen shot of complete web page from start to end
	public static void Ashot(String fileName) throws IOException
	{
		try {
		Screenshot ss= new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		String ScreenShotPath=screenShotFolder()+"\\"+" "+leadCreationTest1.TestCaseDesc+" "+fileName+".jpeg";
		
		ImageIO.write(ss.getImage(), "jpeg", new File(ScreenShotPath));
		}
		catch(Exception e) {}
	}

}

