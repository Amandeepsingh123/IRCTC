package com.irctc.project;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.irctcpage.project.IrctcPage;

@Listeners({com.irctc.project.TestListener.class})
public class IrctcTest
{
	 private  XSSFSheet ExcelWSheet;
	 private  XSSFWorkbook ExcelWBook;
	 private  XSSFCell Cell;
	
	@Test(dataProvider="dp")
	public void irctcTest(String a, String b) throws InterruptedException, IOException
	{
	
	WebDriver driver = new FirefoxDriver();
	driver.manage().window().maximize();  //command to maximize the window
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get("https://www.irctc.co.in/eticketing/loginHome.jsf");
	IrctcPage ip = new IrctcPage(driver);
	//Call function which wil click on flight
	ip.ClickFlight();
	Thread.sleep(5000);
    //Switch window
	ip.SwitchWindow();
	String s = driver.getCurrentUrl();
	Assert.assertTrue(s.contains("air"));
	
	//sending source key
	ip.Enter_Source(a);
	//click on source station
//	ip.Click_Source();
	// sending destination key
	ip.Enter_Destination(b);
	// click on destination
//	ip.Click_Destination();
	// click on calendar button
	ip.Click_Calendar();
	// click on selected date
	ip.Enter_Date();
	// Select no of Adults
	ip.Select_Adult();
	// Select no of childs
	ip.Select_Child();
	// click on search field
	ip.ClickSearch();
	// calculate no of Flights
	ip.TotalFlights();
	Thread.sleep(5000);
	driver.quit();

	}
	@DataProvider
	 public Object[][] dp(){
	  Object[][] tabArray = null;
	  try {
		String localpath= "src/test/resources/";  
	   //FileInputStream ExcelFile = new FileInputStream("C:\\Users\\User\\Desktop\\Irctc.xlsx");
	   FileInputStream ExcelFile = new FileInputStream(localpath+"IrctcTest.xlsx");
	   // Access the required test data sheet
	   ExcelWBook = new XSSFWorkbook(ExcelFile);
	   ExcelWSheet = ExcelWBook.getSheetAt(0);
	   int startRow = 1;
	   int startCol = 0;
	   int ci, cj;
	   int totalRows = ExcelWSheet.getLastRowNum();
	   System.out.println("TR = "+totalRows);
	   int totalCols = ExcelWSheet.getRow(1).getLastCellNum();
	   System.out.println("TC = "+totalCols);
	   tabArray = new String[totalRows][totalCols];
	   ci = 0;
	   for (int i = startRow; i <= totalRows; i++, ci++) {
	    cj = 0;
	    for (int j = startCol; j < totalCols; j++, cj++) {
	     try {
	      tabArray[ci][cj] = getCellData(i, j);
	     } catch (Exception e) {
	      break;
	     }
	    }
	   }

	  }

	  catch (FileNotFoundException e) {
	   e.printStackTrace();
	  }

	  catch (IOException e) {
	   e.printStackTrace();
	  }
	  return (tabArray);
	 }

	 public Object getCellData(int RowNum, int ColNum) throws Exception {

	  try {

	   Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

	   int dataType = Cell.getCellType();

	   if (dataType == 3) {

	    return "";

	   } else if (dataType == 0) {
	    Object CellData = Cell.getRawValue();
	    return CellData;

	   } else {
	    Object CellData = Cell.getStringCellValue();
	    return CellData;
	   }

	  } catch (Exception e) {

	   System.out.println(e.getMessage());

	   throw (e);

	  }
	 }

}