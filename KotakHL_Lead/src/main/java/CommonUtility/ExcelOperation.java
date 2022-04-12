package CommonUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.formula.functions.Columns;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelOperation implements AutoConst
{
	
	static HashMap<String, Integer> excelColumns = new HashMap<String, Integer>();
	
	public static int getRowCount(String sheet) throws IOException
	{
		File f = new File(ExcelPATH);
		
		//Create an object of FileInputStream class to read excel file
        FileInputStream inputStream = new FileInputStream(f);
        
        //creating workbook instance that refers to .xlsx file
        XSSFWorkbook wb=new XSSFWorkbook(inputStream); 
        
        int rowCount = wb.getSheet(sheet).getLastRowNum();
        
        return rowCount; 
	}
	
	//To read test data from excel sheet
	public static String readData(String sheet , int rowNum , int colNum) throws EncryptedDocumentException, IOException
	{
		//System.out.println("Write values : "+sheet +"|"+m+"|"+n+"|"+data);
		File f = new File(ExcelPATH);
		
		//Create an object of FileInputStream class to read excel file
        FileInputStream inputStream = new FileInputStream(f);
        
        //creating workbook instance that refers to .xls file
        XSSFWorkbook wb=new XSSFWorkbook(inputStream); 
        String data = null;
		Cell cell  = wb.getSheet(sheet).getRow(rowNum).getCell(colNum);
		
		DataFormatter formatter = new DataFormatter();
		data = formatter.formatCellValue(cell);
		System.out.println("Excel data = "+data);
		
		// wb.close();
		inputStream.close();
		return data;
	}	

	//To read excel data using column header
	public static String getCellData(String SheetName ,String columnName, int rowNum) throws EncryptedDocumentException, IOException 
	{
		File f = new File(ExcelPATH);
		
		//Create an object of FileInputStream class to read excel file
        FileInputStream inputStream = new FileInputStream(f);
        
        //creating workbook instance that refers to .xls file
        XSSFWorkbook wb=new XSSFWorkbook(inputStream); 
		
        XSSFSheet sh = wb.getSheet(SheetName);
        //XSSFSheet sh = wb.getSheetAt(0);    //0 - index of 1st sheet
        
        //adding all the column header names to the map 'columns'
	        sh.getRow(0).forEach(cell ->{
	        	excelColumns.put(cell.getStringCellValue(), cell.getColumnIndex());
	        });
        
		return readData(SheetName, rowNum, excelColumns.get(columnName));
	}
	
	
	//To write data into excel
	public static void writeToExcel(String sheet , int rowNum , int colNum, String data) throws Exception
	{
		try {
			Thread.sleep(1000);
			//System.out.println("Write values : "+sheet +"|"+rowNum+"|"+colNum+"|"+data);
			File f = new File(ExcelPATH);
			
			//Create an object of FileInputStream class to read excel file
	        FileInputStream inputStream = new FileInputStream(f);
	        
	        //creating workbook instance that refers to .xls file
	        XSSFWorkbook wb=new XSSFWorkbook(inputStream); 
			
	        //creating a Sheet object using the sheet Name
	        //XSSFSheet sh=wb.getSheetAt(1);
	        XSSFSheet sh = wb.getSheet(sheet);
	        
	        //Create a row object to retrieve row at index m
	        XSSFRow row=sh.getRow(rowNum);
	        if(row ==null)
            {
                row = sh.createRow(rowNum);
            }
	        
	        //create a cell object to enter value in it using cell Index
	        XSSFCell cell = row.getCell(colNum);
	        if (cell == null) 
	        {
                cell = row.createCell(colNum);
            }
            cell.setCellValue(data);
	        System.out.println("Row : "+rowNum+" | Cell :"+colNum+" | Data : "+data);
	        
	        // Write the data back in the Excel file
	        FileOutputStream outputStream = new FileOutputStream(ExcelPATH);
	        wb.write(outputStream);
			Thread.sleep(1000);
			
			inputStream.close();
			outputStream.flush();
			outputStream.close();
	        
		} catch (Exception e) {
			throw(e);		
			}
		
	}
	
	
		
	
}
