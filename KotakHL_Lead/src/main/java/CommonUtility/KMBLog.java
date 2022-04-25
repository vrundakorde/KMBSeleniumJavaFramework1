package CommonUtility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import TestScript.leadCreationTest1;

public class KMBLog 
{
	public static Logger log =LogManager.getLogger(KMBLog.class.getName());

	//To write information messsage into log file
	public static void logInfo(String message)
	{
		log.info(leadCreationTest1.TestCaseIDName+" "+message);
	}
	
	public static void logError(String messsage)
	{
		log.error(leadCreationTest1.TestCaseIDName +" "+messsage);
	}
	
	public static void logDebug(String message)
	{
		log.debug(leadCreationTest1.TestCaseIDName+" "+message);
	}
	
}
