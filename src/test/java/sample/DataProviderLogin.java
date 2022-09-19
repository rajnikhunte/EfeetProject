package sample;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.NoInjection;


public class DataProviderLogin {
		
		 static ReadExcel readData;
		// Properties pro;
		// String winmaxUrl, userNameId,passwordId, chromeProp, chromeValue, loginBtnXpath;
		// int k=1;
		static String excelPath = "D:\\Rajni\\JavaProject\\Efleet_System_Project\\Excel\\Data.xlsx";
		public static Object[][] readExcelData() throws Exception {
		System.out.println("readExcelData");
		Thread.sleep(1000);
		readData = new ReadExcel();
		readData.setExcelFile(excelPath,"Sheet");
		Object[][] excelData = null;
		int rows = readData.getRowCountInSheet();
		int columns = readData.getColumnCountInRow();
		System.out.println("row : " +rows);
		System.out.println("col "+columns);
		excelData = new Object[rows-1][columns];
		for(int i=1; i<rows; i++)
		{
		for(int j=0; j<columns; j++)
		{
		excelData[i-1][j] = readData.getCellData(i,j);
		System.out.println("excelData >>>>>>>>>: " + excelData[i-1][j]);
		}
		}
		return excelData;
		}
		
		@DataProvider(name="sample")
		

		public static Object[][] userFormData() throws Exception {
		System.out.println("userFormData");
		Object[][] data = readExcelData();
		System.out.println("data ****** : " +data);
		return data;
		}
		
		
		}
		
		

