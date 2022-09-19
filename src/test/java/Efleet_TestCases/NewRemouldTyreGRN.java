package Efleet_TestCases;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class NewRemouldTyreGRN {
	private static String fileDownloadpath = "C:\\Users\\Lenovo\\Downloads";
	static WebDriver driver;

	public NewRemouldTyreGRN(WebDriver driver) {
		this.driver = driver;

	}

	@SuppressWarnings("deprecation")
	public void NewRemouldTyreGRN() throws Exception {
		ReadData_Excel object = new ReadData_Excel();
		object.dataReadtest();

		// Click on Tyre Dashboard
		driver.findElement(By.linkText("Tyre Dashboard")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Click on Tyre Inward
		driver.findElement(By.linkText("Tyre Inward")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Click on New/ New Remould GRN

		driver.findElement(By.xpath(
				"/html[1]/body[1]/app-root[1]/app-master[1]/div[1]/div[1]/app-dynamicmenu[1]/div[2]/ul[1]/li[5]/div[1]/div[2]/ul[1]/li[1]/a[1]/span[1]"))
				.click();
//		driver.findElement(By.linkText(" New /New-Remould GRN ")).click();

//		TestCases 1: To verify the functionality Add new/new remould tyre
		String Office = ReadData_Excel.entry8;
		String Vendor = ReadData_Excel.entry9;
		String challanReadData = ReadData_Excel.entry10;
		String InvoiceReadData = ReadData_Excel.entry11;
		String Remark = ReadData_Excel.entry12;
		String TyreNoReadData = ReadData_Excel.entry13;
		String CardNoReadData = ReadData_Excel.entry14;
		String Brand = ReadData_Excel.entry16;
		String RubberBrand = ReadData_Excel.entry17;

		driver.findElement(By.linkText("Add New/New Remould")).click();
		Thread.sleep(3000);

//To check current date is displayed
		WebElement GRNDate = driver.findElement(By.id("DocumentDate"));
		String elementval = GRNDate.getAttribute("value");
		System.out.println(elementval);

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		String date1 = dateFormat.format(date);
		Assert.assertEquals(date1, elementval);
		System.out.println(elementval + " " + "Current date selected in GRN date By default");

//      Select Office	
		
		for(int i=0; i<5; i++) {
			driver.findElement(By.xpath("//input[@name='officeName']")).sendKeys(Office);
			 Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='officeName']")).sendKeys(Keys.SPACE);
			 Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='officeName']")).sendKeys(Keys.BACK_SPACE);	
	        Thread.sleep(5000);       
	        boolean linkExists = driver.findElement(By.xpath("//*[@id='error-office-code']"))
					.isDisplayed();

			if (linkExists == true) {
				driver.findElement(By.xpath("//input[@name='officeName']")).clear();
				Thread.sleep(3000);
				  continue;
			}else {
				System.out.println("Office is selected");
				break;
			}
			
		}

//      Select Vendor
		
		for(int i=0; i<5; i++) {
			driver.findElement(By.xpath("//input[@name='vendorName']")).sendKeys(Vendor);
			Thread.sleep(2000);  
			driver.findElement(By.xpath("//input[@name='vendorName']")).sendKeys(Keys.SPACE);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='vendorName']")).sendKeys(Keys.BACK_SPACE);
	        Thread.sleep(5000);       
	        boolean linkExists = driver.findElement(By.xpath("//*[@id='error-vendor-code']"))
					.isDisplayed();

			if (linkExists == true) {
				driver.findElement(By.xpath("//input[@name='vendorName']")).clear();
				Thread.sleep(3000);
				  continue;
			}else {
				System.out.println("Vendor is selected");
				break;
			}
			
		}

//	To Verify The functionality of Vendor Office field

		String Vendoroffice = driver.findElement(By.xpath("//input[@name='vendorOfficeName']")).getAttribute("class");
		if (Vendoroffice.equals("form-control ng-untouched ng-pristine ng-valid")) {
			System.out.println("Vendor Office is selected");
		} else {
			System.out.println("Vendor Office is  not selected");
		}

//	To Verify The functionality of State
		WebElement State = driver.findElement(By.xpath("//input[@name='stateName']"));
		String readonly = State.getAttribute("readonly");
		Assert.assertNotNull(readonly);

		WebElement Stateval = driver
				.findElement(By.xpath("//*[@id=\"NewRemouldform\"]/div[2]/div[1]/div[5]/div/input[2]"));
		String checkvalue = Stateval.getAttribute("value");
		System.out.println("state is selected" + " " + checkvalue);

//		To Verify The functionality of GSTNo	

		WebElement GSTNo = driver.findElement(By.xpath("//input[@name='gstNo']"));
		String GST = GSTNo.getAttribute("readonly");
		Assert.assertNotNull(GST);

//		Click On 'Challan cum Invoice' checkbox
		driver.findElement(By.xpath("//*[@id='DocumentTypeId']")).click();
		Thread.sleep(1000);

//      To verify the functionality of Challan Number
		WebElement ChallanNo = driver.findElement(By.xpath("//input[@name='challanNumber']"));
		ChallanNo.sendKeys(challanReadData);
		Thread.sleep(1000);

// 		Verify the functionality of Challan Date

		WebElement ChallanDate = driver.findElement(By.id("ChallanDate"));
		String elementval1 = ChallanDate.getAttribute("value");
		Assert.assertEquals(date1, elementval1);
		System.out.println(elementval1 + " " + "Current date selected in Challan date By default");

//      To Verify the functionality of invoice number

		WebElement invoiceNumber = driver.findElement(By.xpath("//input[@name='invoiceNumber']"));
		invoiceNumber.sendKeys(InvoiceReadData);
		Thread.sleep(1000);

// 		Verify the functionality of Invoice Date	

		WebElement InvoiceDate = driver.findElement(By.id("InvoiceDate"));
		String elementval2 = InvoiceDate.getAttribute("value");
		Assert.assertEquals(date1, elementval2);
		System.out.println(elementval2 + " " + "Current date selected in Invoice date By default");

		driver.findElement(By.xpath("//*[@id=\"NewRemouldform\"]/div[2]/div[2]/div[6]/div/input")).click();
		driver.findElement(By.xpath("//*[@id=\"NewRemouldform\"]/div[2]/div[2]/div[6]/div/input")).sendKeys(Remark);
		Thread.sleep(1000);

//  To Verify the functionality of PPU Checkbox
		driver.findElement(By.name("isPpu")).click();
		Thread.sleep(1000);

//	To Verify the functionality of Tyre Number


		driver.findElement(By.id("tyre_autofocus")).click();
		driver.findElement(By.id("tyre_autofocus")).sendKeys(TyreNoReadData);
		Thread.sleep(3000);

//		To Verify the functionality of Card Number


		driver.findElement(By.name("productCardNumber")).click();
		driver.findElement(By.name("productCardNumber")).sendKeys(CardNoReadData);
		Thread.sleep(3000);

//		To Verify the functionality of Production Month

		driver.findElement(By.name("productionMonth")).click();
		driver.findElement(By.name("productionMonth")).sendKeys("09/2022");
		Thread.sleep(2000);

// 		To Verify the functionality of Brand Size

		driver.findElement(By.id("Size")).click();
		{
			WebElement dropdown = driver.findElement(By.id("Size"));
			dropdown.findElement(By.xpath("//*[@id='Size']/option[10]")).click();
		}
		Thread.sleep(10000);

//		To Verify the functionality of Brand 
		
		for(int i=0; i<5; i++) {
			driver.findElement(By.xpath("//input[@name='brandName']")).sendKeys(Brand);
			 Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='brandName']")).sendKeys(Keys.SPACE);
			 Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='brandName']")).sendKeys(Keys.BACK_SPACE);
	        Thread.sleep(5000);
	        
	        
	        boolean linkExists = driver.findElement(By.xpath("//*[@id='error-brand-code']"))
					.isDisplayed();

			if (linkExists == true) {
				driver.findElement(By.xpath("//input[@name='brandName']")).clear();
				Thread.sleep(3000);
				  continue;
			}else {
				System.out.println("Brand is selected");
				break;
			}
			
		}

		driver.findElement(By.xpath("//input[@name='remould']")).click();
		Thread.sleep(5000);

//		To Verify the functionality of Rubber Brand 
		
		for(int i=0; i<5; i++) {
			driver.findElement(By.xpath("//input[@name='rubberBrandName']")).sendKeys(RubberBrand);
			 Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='rubberBrandName']")).sendKeys(Keys.SPACE);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='rubberBrandName']")).sendKeys(Keys.BACK_SPACE);
	        Thread.sleep(5000);
	        
	        
	        boolean linkExists = driver.findElement(By.xpath("//*[@id='error-rubberBrand-code']"))
					.isDisplayed();

			if (linkExists == true) {
				driver.findElement(By.xpath("//input[@name='rubberBrandName']")).clear();
				Thread.sleep(3000);
				  continue;
			}else {
				System.out.println("RubberBrand is selected");
				break;
			}
			
		}

//	Select Rubber Type	
		driver.findElement(By.id("rubber")).click();
		{
			WebElement dropdown = driver.findElement(By.id("rubber"));
			dropdown.findElement(By.xpath("//*[@id='rubber']/option[1]")).click();
		}
		Thread.sleep(3000);

//		Enter Remark
		driver.findElement(By.xpath("//*[@id=\"TyreDetailsForm\"]/div[2]/div[2]/div[4]/div/input")).sendKeys("testing");
		Thread.sleep(3000);

//		To verify the functionality of Amount

		String AmountValidationMessage = driver
				.findElement(By.xpath("//*[@id=\"TyreDetailsForm\"]/div[2]/div[2]/div[5]/div/label")).getText();
		Thread.sleep(3000);
		if (AmountValidationMessage.equals("[Amount should be between 5000 and 10000]")) {
			Thread.sleep(3000);
			driver.findElement(By.name("productAmount")).click();
			driver.findElement(By.name("productAmount")).sendKeys(String.valueOf(ReadData_Excel.entry19));
		} else {
			Thread.sleep(3000);
			driver.findElement(By.name("productAmount")).click();
			driver.findElement(By.name("productAmount")).sendKeys(String.valueOf(ReadData_Excel.entry18));
		}
		System.out.println(AmountValidationMessage);

//      Enter Discount
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='discountPercentage']")).clear();
		driver.findElement(By.xpath("//input[@name='discountPercentage']")).sendKeys("10");

//		Enter Cgst
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//input[@name='cgstamount']")).clear();
//		driver.findElement(By.xpath("//input[@name='cgstamount']")).sendKeys("9");

//  	Enter sgst	
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//input[@name='sgstamount']")).clear();
//		driver.findElement(By.xpath("//input[@name='sgstamount']")).sendKeys("9");

// To verify the functionality of Discount Amount
		WebElement DiscountAmt = driver
				.findElement(By.xpath("//*[@id=\"TyreDetailsForm\"]/div[2]/div[3]/div[5]/div/input"));
		String Discountval = DiscountAmt.getAttribute("value");
		System.out.println("Discount amount is" + " " + Discountval);

// To Verify the functionality of Total Amount	
		WebElement TotalAmt = driver.findElement(By.xpath("//input[@name='totalAmount']"));
		String TotalAmountval = TotalAmt.getAttribute("value");
		System.out.println("Total amount is" + " " + TotalAmountval);

// To verify the functionality of Add button
		driver.findElement(By.xpath("//input[@value='Add']")).click();
		Thread.sleep(3000);

// To verify the functionality of Save button	
		driver.findElement(By.xpath("//*[@id='NewRemouldform']/div[5]/div[2]/div/div/input")).click();
		Thread.sleep(6000);

// Capture the confirmation Message
		String confirmationMessage = driver.findElement(By.xpath("//div[@id='alert_success']")).getText();
		Thread.sleep(5000);
		System.out.println(confirmationMessage);
		System.out.println(confirmationMessage + " " + " All Tyre details saved successfully");

// Click on the Next button
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='newRemouldTyreDetail']/div[4]/button")).click();
		Thread.sleep(2000);

//	To Verify the functionality of Document Upload
		WebElement dropdown1 = driver.findElement(By.id("documentTypeId"));
		Select sel = new Select(dropdown1);
		sel.selectByVisibleText("Product Challan");

		Thread.sleep(5000);

		driver.findElement(By.xpath("//input[@name='document']"))
				.sendKeys("C:\\Users\\Lenovo\\Downloads\\flower (1).jpg");
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@id=\"Documents\"]/div[1]/div/form/div[4]/div/input")).click();
		Thread.sleep(10000);
		String confirmationMessage1 = driver.findElement(By.xpath("//div[@id='alert_success']")).getText();
		Thread.sleep(3000);
		System.out.println(confirmationMessage1);
		System.out.println(confirmationMessage1 + " " + " Document details saved successfully");

//		Click on Back to Index button
		driver.findElement(By.linkText("Back To Index")).click();
		Thread.sleep(9000);

//	To Verify the functionality of view( Click on View Icon)
		driver.findElement(By.xpath("//input[@value='Search']")).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath("//*[@id='table_responsive']/tbody/tr[1]/td[1]/a[1]/i")).click();
		Thread.sleep(5000);
		try {
			boolean linkExists = driver.findElement(By.xpath("//h4[normalize-space()='New/New-Remould Tyre Details']")).isDisplayed();

			if (linkExists == true) {
				System.out.println("New/New-Remould Tyre Details page navigated Successfully – Passed");
			}
		} catch (NoSuchElementException e1) {
			System.out.println("New/new-remold Tyre detail page not navigated – Failed");
		}
		Thread.sleep(5000);

		for (int i = 0; i <= 7; i++) {
			String s = driver.findElement(By.xpath("//*[@id='tblGeneralDtls']/tbody/tr[" + (i + 1) + "]/td[1]/b"))
					.getText();
			String s1 = driver.findElement(By.xpath("//*[@id='tblGeneralDtls']/tbody/tr[" + (i + 1) + "]/td[2]"))
					.getText();

			System.out.println(s + "  " + s1);

		}

		for (int i = 0; i <= 7; i++) {
			String s2 = driver.findElement(By.xpath("//*[@id=\"tblGeneralDtls\"]/tbody/tr[" + (i + 1) + "]/td[3]/b"))
					.getText();
			String s3 = driver.findElement(By.xpath("//*[@id=\"tblGeneralDtls\"]/tbody/tr[" + (i + 1) + "]/td[4]"))
					.getText();

			System.out.println(s2 + "  " + s3);

		}
		String p = driver.findElement(By.xpath("//*[@id='tblGeneralDtls']/tbody/tr[5]/td[2]")).getText();
		System.out.println(p);
		Thread.sleep(3000);

		driver.findElement(By.xpath("//a[@id='Tyre']")).click();
		Thread.sleep(5000);
		for (int i = 0; i <= 15; i++) {
			String tablename = driver
					.findElement(By.xpath("//*[@id='TyreDetails']/div[1]/div/div/table/thead/tr/th[" + (i + 1) + "]"))
					.getText();

			String TYREDETAILS = driver
					.findElement(By.xpath("//*[@id='TyreDetails']/div[1]/div/div/table/tbody/tr/td[" + (i + 1) + "]"))
					.getText();
			System.out.println(tablename + "  " + TYREDETAILS);

		}

		driver.findElement(By.linkText("Back To Index")).click();
		Thread.sleep(10000);

//		To Verify the functionality of Edit( Click on Edit button)

		driver.findElement(By.xpath("//*[@id=\"table_responsive\"]/tbody/tr[1]/td[1]/a[2]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//i[@class='fa fa-pencil'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='TyreDetailsForm']/div[2]/div[2]/div[4]/div/input")).clear();
		driver.findElement(By.xpath("//*[@id='TyreDetailsForm']/div[2]/div[2]/div[4]/div/input"))
				.sendKeys(" Update Tyre Details");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value='Add']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		Thread.sleep(5000);

		String UpdateconfirmationMessage = driver.findElement(By.xpath("//div[@id='alert_success']")).getText();
		Thread.sleep(5000);
		System.out.println(UpdateconfirmationMessage);
		

		driver.findElement(By.linkText("Back To Index")).click();
		Thread.sleep(10000);

//   TestCases 2: To Verify the functionality of FromDate
		String month = ReadData_Excel.entry2;
		int year = ReadData_Excel.entry3;
		int day = ReadData_Excel.entry1;

		if (month.equals("February") && (day) > 29) {
			System.out.println("Wrong Date: Please Select Correct date");
			return;
		}

		if (day > 31) {
			System.out.println("Wrong Date: Please Select Correct date");
			return;
		}

		driver.findElement(By.cssSelector("#limitFromDate")).clear();
		driver.findElement(By.cssSelector("#limitFromDate")).click();
		while (true) {
			String text = driver.findElement(By.xpath(
					"/html/body/bs-datepicker-container/div/div/div[1]/div/bs-days-calendar-view/bs-calendar-layout/div[1]/bs-datepicker-navigation-view/button[2]/span"))
					.getText();
			int Years = Integer.parseInt(driver.findElement(By.xpath(
					"/html/body/bs-datepicker-container/div/div/div[1]/div/bs-days-calendar-view/bs-calendar-layout/div[1]/bs-datepicker-navigation-view/button[3]/span"))
					.getText());

			if (text.equals(month) && Years == year) {
				break;

			} else {
				Thread.sleep(1000);
				driver.findElement(By.xpath("//button[@class=\"previous\"]")).click();
			}
		}

		driver.findElement(By.xpath("//td[@role='gridcell']/span[text()= " + day + "]")).click();

		// TestCases 2: To Verify the functionality of ToDate
		String month1 = ReadData_Excel.entry5;
		int year1 = ReadData_Excel.entry6;
		int day1 = ReadData_Excel.entry4;

		if (month1.equals("February") && (day1) > 29) {
			System.out.println("Wrong Date: Please Select Correct date");
			return;
		}

		if (day1 > 31) {
			System.out.println("Wrong Date: Please Select Correct date");
			return;
		}

		driver.findElement(By.cssSelector("#limitToDate")).clear();
		driver.findElement(By.cssSelector("#limitToDate")).click();
		while (true) {
			String text = driver.findElement(By.xpath(
					"/html/body/bs-datepicker-container/div/div/div[1]/div/bs-days-calendar-view/bs-calendar-layout/div[1]/bs-datepicker-navigation-view/button[2]/span"))
					.getText();
			int Years = Integer.parseInt(driver.findElement(By.xpath(
					"/html/body/bs-datepicker-container/div/div/div[1]/div/bs-days-calendar-view/bs-calendar-layout/div[1]/bs-datepicker-navigation-view/button[3]/span"))
					.getText());

			if (text.equals(month1) && Years == year1) {
				break;

			} else {
				Thread.sleep(1000);
				driver.findElement(By.xpath("//button[@class=\"previous\"]")).click();
			}
		}

		driver.findElement(By.xpath("//td[@role='gridcell']/span[text()= " + day1 + "]")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

// TestCases 3: To verify the functionality of Search button 

		// Click on search button
		driver.findElement(By.xpath("//input[@value=\"Search\"]")).click();
		Thread.sleep(3000);
		// Scroll down
		for (int second = 0;; second++) {
			if (second >= 60) {
				break;
			}
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,100)", "");
		}
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, document.body.scrollTop)");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2000)");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		// No.of Columns
		List<WebElement> col = driver.findElements(By.xpath("//*[@id=\"table_responsive\"]/thead/tr/th"));
		System.out.println("No of cols are : " + col.size());
		// No.of rows
		List<WebElement> rows = driver.findElements(By.xpath("//*[@id=\"table_responsive\"]/tbody/tr/td[4]"));
		System.out.println("No of rows are : " + rows.size());
		for (int i = 0; i < rows.size(); i++) {
			String d1 = driver.findElement(By.xpath("//*[@id=\"table_responsive\"]/tbody/tr[" + (i + 1) + "]/td[4]"))
					.getText();
			System.out.println(d1);
		}

// TestCases 4: To verify the search functionality of Searchbox in New/New - Remould tyre	

		String VendorName = ReadData_Excel.entry7;
		try {

			WebElement txtbx_search = driver.findElement(By.xpath("//*[@id=\"Searchtext\"]"));
			txtbx_search.sendKeys(VendorName);

			driver.findElement(By.xpath("//i[@class='fa fa-search']")).click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Thread.sleep(9000);

			List<WebElement> collection_VendorName_links = driver
					.findElements(By.xpath("//*[@id=\"table_responsive\"]/tbody/tr/td[5]"));

			for (int i = 0; i < collection_VendorName_links.size(); i++) {
				String temp = driver
						.findElement(By.xpath("//*[@id=\"table_responsive\"]/tbody/tr[" + (i + 1) + "]/td[5]"))
						.getText();
				Thread.sleep(3000);
				if (temp.equals(VendorName)) {
					Assert.assertTrue(true, VendorName + " is displayed on VendorName title VendorName Title: " + temp);
				} else {
					Assert.assertTrue(false,
							VendorName + " is not displayed on VendorName title VendorName Title: " + temp);

				}

				System.out.println(
						temp + " " + "List will get appeared according to the same result which has been searched");
			}

		} catch (Exception e) {
			Assert.assertFalse(false, "Exception thrown. Exception: " + e.toString());
			;
		}

//		TestCases 5: To verify the download functionality of Export Summary
		driver.findElement(By.xpath("//button[normalize-space()='Export Summary']")).click();
		Thread.sleep(6000);
		Assert.assertTrue(
				isFileDownloaded(fileDownloadpath, "New_New_Remould_Summary_Report_(01_07_2022_to_24_08_2022).csv"),
				"Failed to download Expected document");

//		TestCases 6: To verify the download functionality of Export Details

		driver.findElement(By.xpath("//button[normalize-space()='Export Details']")).click();
		Thread.sleep(6000);
		Assert.assertTrue(
				isFileDownloaded(fileDownloadpath, "New_New_Remould_Details_Report_(01_07_2022_to_24_08_2022).csv"),
				"Failed to download Expected document");
		
		Thread.sleep(9000);
		driver.close();

	}

	public boolean isFileDownloaded(String fileDownloadpath, String fileName) {

		boolean flag = false;

		File directory = new File(fileDownloadpath);

		File[] content = directory.listFiles();

		for (int i = 0; i < content.length; i++) {
			if (content[i].getName().equals(fileName))
				return flag = true;
		}
		return flag;

	}
}
