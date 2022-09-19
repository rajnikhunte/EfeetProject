package Efleet_TestCases;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

@Test
public class ReadData_Excel {
	public static int entry1;
	public static String entry2;
	public static int entry3;
	public static int entry4;
	public static String entry5;
	public static int entry6;
	public static int entryA;
	public static String entryB;
	public static int entryC;
	public static int entryD;
	public static String entryE;
	public static int entryF;
	public static int entryA1;
	public static String entryB1;
	public static int entryC1;
	public static int entryD1;
	public static String entryE1;
	public static int entryF1;
	public static int entryA2;
	public static String entryB2;
	public static int entryC2;
	public static int entryD2;
	public static String entryE2;
	public static int entryF2;
	public static String entry7;
	public static String entry8;
	public static String entry9;
	public static String entry10;
	public static String entry11;
	public static String entry12;
	public static String entry13;
	public static String entry14;
	public static String entry16, entry17;
	public static int entry18;
	public static int entry19;
	public static String entry20;
	public static String entry21;
	public static String entry22;
	public static String entry23;
	public static int entry24;
	public static String entry25;
	public static int entry26;
	public static String entry27;
	public static String entry28;
	public static int entry29;
	public static int entry30;
	public static int entry31;
	public static String entryVendorName;
	public static String entryVendorName2,entryUpdateTyreNumber2;
	public static String entry32, entry33, entry34, entry35, entry36, entry37;
	public static String entry42, entry43, entry44, entry45, entry46, entry47,entry48;
	public static int entry38,entry39,entry40;
	public static int entry49;
	public static int entry50;
	public static String entryVN,entryON;
	


	public void dataReadtest() throws Exception {

		String ProjectPath = System.getProperty("user.dir");
		String excelPath = ProjectPath + "/Excel/TestData.xlsx";
//		File src = new File("D:\\CoReCo\\TestData.xlsx");
		File src = new File(excelPath);
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook xsf = new XSSFWorkbook(fis);

//		for .xml file
//		HSSFWorkbook xsf = new HSSFWorkbook(fis);

//		for excel another tab file
		XSSFSheet sheet = xsf.getSheetAt(0);
		XSSFSheet sheet1 = xsf.getSheetAt(1);
		XSSFSheet sheet2 = xsf.getSheetAt(2);
		XSSFSheet sheet3 = xsf.getSheetAt(3);
//	Date picker	
		entry1 = (int) sheet.getRow(1).getCell(0).getNumericCellValue();
		entry2 = sheet.getRow(1).getCell(1).getStringCellValue();
		entry3 = (int) sheet.getRow(1).getCell(2).getNumericCellValue();
		entry4 = (int) sheet.getRow(2).getCell(0).getNumericCellValue();
		entry5 = sheet.getRow(2).getCell(1).getStringCellValue();
		entry6 = (int) sheet.getRow(2).getCell(2).getNumericCellValue();
// Vendor Name
		entry7 = sheet.getRow(5).getCell(1).getStringCellValue();

// Office
		entry8 = sheet.getRow(8).getCell(1).getStringCellValue();
//vendor	
		entry9 = sheet.getRow(8).getCell(2).getStringCellValue();

//	Challan No
		entry10 = sheet.getRow(8).getCell(3).getStringCellValue();
// Invoice No
		entry11 = sheet.getRow(8).getCell(4).getStringCellValue();
// Remark
		entry12 = sheet.getRow(8).getCell(5).getStringCellValue();
//	Tyre No	

		entry13 = sheet.getRow(8).getCell(6).getStringCellValue();

//	card No
		entry14 = sheet.getRow(8).getCell(7).getStringCellValue();
////	Production month
//		entry15 = (int)sheet.getRow(8).getCell(8).getNumericCellValue();
//	Brand
		entry16 = sheet.getRow(8).getCell(9).getStringCellValue();
//	rubber brand
		entry17 = sheet.getRow(8).getCell(10).getStringCellValue();
// Amount
		entry18 = (int) sheet.getRow(8).getCell(11).getNumericCellValue();
		entry19 = (int) sheet.getRow(8).getCell(12).getNumericCellValue();

//	Chassis data	
		entryA = (int) sheet1.getRow(1).getCell(0).getNumericCellValue();
		entryB = sheet1.getRow(1).getCell(1).getStringCellValue();
		entryC = (int) sheet1.getRow(1).getCell(2).getNumericCellValue();
		entryD = (int) sheet1.getRow(2).getCell(0).getNumericCellValue();
		entryE = sheet1.getRow(2).getCell(1).getStringCellValue();
		entryF = (int) sheet1.getRow(2).getCell(2).getNumericCellValue();
	
//		Search
		entryVN = sheet1.getRow(5).getCell(1).getStringCellValue();
		entryON = sheet1.getRow(5).getCell(2).getStringCellValue();
		
		entry20 = sheet1.getRow(8).getCell(1).getStringCellValue();
		entry21 = sheet1.getRow(8).getCell(3).getStringCellValue();
		entry22 = sheet1.getRow(8).getCell(4).getStringCellValue();
		entry23 = sheet1.getRow(8).getCell(6).getStringCellValue();
		entry24 = (int) sheet1.getRow(8).getCell(7).getNumericCellValue();
		entry25 = sheet1.getRow(8).getCell(8).getStringCellValue();
		entry26 = (int) sheet1.getRow(8).getCell(10).getNumericCellValue();
		entry27 = sheet1.getRow(8).getCell(11).getStringCellValue();
		entry28 = sheet1.getRow(8).getCell(12).getStringCellValue();
		entry29 = (int) sheet1.getRow(8).getCell(13).getNumericCellValue();
		entry30 = (int) sheet1.getRow(8).getCell(14).getNumericCellValue();
//		odometer
		entry31 = (int) sheet1.getRow(8).getCell(2).getNumericCellValue();

//		RemouldGRN Data
		entryA1 = (int) sheet2.getRow(1).getCell(0).getNumericCellValue();
		entryB1 = sheet2.getRow(1).getCell(1).getStringCellValue();
		entryC1 = (int) sheet2.getRow(1).getCell(2).getNumericCellValue();
		entryD1 = (int) sheet2.getRow(2).getCell(0).getNumericCellValue();
		entryE1 = sheet2.getRow(2).getCell(1).getStringCellValue();
		entryF1 = (int) sheet2.getRow(2).getCell(2).getNumericCellValue();
		
		entryVendorName = sheet2.getRow(5).getCell(1).getStringCellValue();

		entry32 = sheet2.getRow(8).getCell(1).getStringCellValue();
		entry33 = sheet2.getRow(8).getCell(2).getStringCellValue();
		entry34 = sheet2.getRow(8).getCell(3).getStringCellValue();
		entry35 = sheet2.getRow(8).getCell(4).getStringCellValue();
		entry36 = sheet2.getRow(8).getCell(5).getStringCellValue();
		entry37 = sheet2.getRow(8).getCell(6).getStringCellValue();
		entry38 = (int)sheet2.getRow(8).getCell(7).getNumericCellValue();
		entry39 = (int)sheet2.getRow(8).getCell(8).getNumericCellValue();
		entry40 = (int)sheet2.getRow(8).getCell(9).getNumericCellValue();
		
//		Against Claim GRN Data	
		
		entryA2 = (int) sheet3.getRow(1).getCell(0).getNumericCellValue();
		entryB2 = sheet3.getRow(1).getCell(1).getStringCellValue();
		entryC2 = (int) sheet3.getRow(1).getCell(2).getNumericCellValue();
		entryD2 = (int) sheet3.getRow(2).getCell(0).getNumericCellValue();
		entryE2 = sheet3.getRow(2).getCell(1).getStringCellValue();
		entryF2 = (int) sheet3.getRow(2).getCell(2).getNumericCellValue();
		entryVendorName2 = sheet3.getRow(5).getCell(1).getStringCellValue();
		entryUpdateTyreNumber2 = sheet3.getRow(11).getCell(0).getStringCellValue();
		entry42 = sheet3.getRow(8).getCell(1).getStringCellValue();
		entry43 = sheet3.getRow(8).getCell(2).getStringCellValue();
		entry44 = sheet3.getRow(8).getCell(3).getStringCellValue();
		entry45 = sheet3.getRow(8).getCell(4).getStringCellValue();
		entry46 = sheet3.getRow(8).getCell(5).getStringCellValue();
		entry47 = sheet3.getRow(8).getCell(6).getStringCellValue();
		entry48 = sheet3.getRow(8).getCell(7).getStringCellValue();
		entry49 = (int) sheet3.getRow(8).getCell(8).getNumericCellValue();
		entry50 = (int) sheet3.getRow(8).getCell(9).getNumericCellValue();

		
		
	}
	
	

}
