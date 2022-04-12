package CommonUtility;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class ScreenShot 
{
	static String folderDate = null;
	static String FileDateTime = null;
	static String FilePath = null;
	public static String screenShotFolder(String fileName)
	{
		  try {
			folderDate = java.time.LocalDate.now().toString();
		   
		   File mFolder = new File("C:\\Users\\Vrunda Vibhute\\eclipse-workspace\\KotakHL_Lead\\Screenshots\\SS" + folderDate + "\\"); 
		        if (!mFolder.exists()) {
		            if (mFolder.mkdir()) {
		                System.out.println("Directory is created!");
		            } else {
		                System.out.println("Failed to create directory!");
		            }
		        }
		       
		       FilePath = mFolder+"\\"+fileName;
		  }catch(Exception e)
		  {
			  System.out.println(e.getMessage());
		  }
		return FilePath;
	}
	
	
	//To capture screen shots of web page display on screen 
	public static void takeSnapShot(WebDriver webdriver,String fileName) throws Exception
	{

        //Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);

        //Call getScreenshotAs method to create image file
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

            //Move image file to new destination
			File DestFile=new File(screenShotFolder(fileName));

                //Copy file at destination
				FileUtils.copyFile(SrcFile, DestFile);

    }
	
	//To capture screen shot of complete web page from start to end
	public static void Ashot(WebDriver driver,String fileName) throws IOException
	{
		Screenshot ss= new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);

		ImageIO.write(ss.getImage(), "jpg", new File(screenShotFolder(fileName)));
			
	}

}

