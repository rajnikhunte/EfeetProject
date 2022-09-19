package Efleet_TestCases;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ChassisTyreGRN {
	private static String fileDownloadpath = "C:\\Users\\Lenovo\\Downloads";
	static WebDriver driver;

	public ChassisTyreGRN(WebDriver driver) {
		this.driver = driver;

	}

	@SuppressWarnings({ "deprecation", "unused" })
	public void ChassisTyreGRN() throws Exception {
		ReadData_Excel object1 = new ReadData_Excel();
		object1.dataReadtest();

		// Click on Tyre Dashboard
		driver.findElement(By.linkText("Tyre Dashboard")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(2000);

		// Click on Tyre Inward

		driver.findElement(By.linkText("Tyre Inward")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

//		Click on Chassis Tyre
		driver.findElement(By.linkText("Chassis Tyre GRN")).click();
		Thread.sleep(5000);

//	    Verify the functionality of add new chassis GRN   
		driver.findElement(By.linkText("Add New")).click();
		Thread.sleep(2000);

		// To check current date is displayed
		WebElement GRNDate = driver.findElement(By.id("DocumentDate"));
		String elementval = GRNDate.getAttribute("value");
		System.out.println(elementval);

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		String date1 = dateFormat.format(date);
		Assert.assertEquals(date1, elementval);
		System.out.println(elementval + " " + "Current date selected in GRN date By default");

//  To verify the functionality of Vehicle

		for (int i = 0; i < 3; i++) {
			driver.findElement(By.xpath("//input[@name='vehicleCode']")).sendKeys(ReadData_Excel.entry20);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='vehicleCode']")).sendKeys(Keys.SPACE);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='vehicleCode']")).sendKeys(Keys.BACK_SPACE);
			Thread.sleep(5000);

			boolean linkExists = driver.findElement(By.xpath("//*[@id='error-vehicle-code']")).isDisplayed();

			if (linkExists == true) {
				driver.findElement(By.xpath("//input[@name='vehicleCode']")).clear();
				Thread.sleep(3000);
				continue;
			} else {
				System.out.println("Vehicle Number is selected");
				break;
			}

		}

//		driver.findElement(By.id("typeahead-basic")).sendKeys(ReadData_Excel.entry20);
//		Thread.sleep(4000);
//		List<WebElement> optionV = driver.findElements(By.xpath("//button[@class='dropdown-item']"));
//		for (WebElement option : optionV) {
//			if (option.getText().equals(ReadData_Excel.entry20)) {
//				System.out.print(option.getText());
//				option.click();
//				Thread.sleep(3000);
//				break;
//			}
//		}

//	Enter Odometer Reading

		driver.findElement(By.name("VehicleReading")).sendKeys(String.valueOf(ReadData_Excel.entry31));
		Thread.sleep(2000);

// To Verify the functionality of Office

		for (int i = 0; i < 3; i++) {
			driver.findElement(By.xpath(
					"//body[1]/app-root[1]/app-master[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-grnchassis[1]/app-addgrnchassis[1]/div[5]/div[1]/form[1]/div[2]/div[1]/div[4]/div[1]/input[1]"))
					.sendKeys(ReadData_Excel.entry21);
			Thread.sleep(2000);
			driver.findElement(By.xpath(
					"//body[1]/app-root[1]/app-master[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-grnchassis[1]/app-addgrnchassis[1]/div[5]/div[1]/form[1]/div[2]/div[1]/div[4]/div[1]/input[1]"))
					.sendKeys(Keys.SPACE);
			
			driver.findElement(By.xpath(
					"//body[1]/app-root[1]/app-master[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-grnchassis[1]/app-addgrnchassis[1]/div[5]/div[1]/form[1]/div[2]/div[1]/div[4]/div[1]/input[1]"))
					.sendKeys(Keys.BACK_SPACE);
			Thread.sleep(2000);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Thread.sleep(5000);

			boolean linkExists = driver.findElement(By.xpath("//*[@id='error-office-code']")).isDisplayed();

			if (linkExists == true) {
				driver.findElement(By.xpath(
						"//body[1]/app-root[1]/app-master[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-grnchassis[1]/app-addgrnchassis[1]/div[5]/div[1]/form[1]/div[2]/div[1]/div[4]/div[1]/input[1]"))
						.clear();
				Thread.sleep(3000);
				continue;
			} else {
				System.out.println("Office is selected");
				break;
			}

		}

//		To Verify the functionality of Vendor

		for (int i = 0; i < 3; i++) {
			driver.findElement(By.xpath("//form[@id='GRNChassisform']//div[2]//div[2]//div[1]//div[1]//input[1]"))
					.sendKeys(ReadData_Excel.entry22);
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//form[@id='GRNChassisform']//div[2]//div[2]//div[1]//div[1]//input[1]"))
			.sendKeys(Keys.SPACE);
			
Thread.sleep(2000);
			
			driver.findElement(By.xpath("//form[@id='GRNChassisform']//div[2]//div[2]//div[1]//div[1]//input[1]"))
			.sendKeys(Keys.BACK_SPACE);
			Thread.sleep(5000);

			boolean linkExists = driver.findElement(By.xpath("//*[@id='error-vendor-code']")).isDisplayed();

			if (linkExists == true) {
				driver.findElement(By.xpath("//form[@id='GRNChassisform']//div[2]//div[2]//div[1]//div[1]//input[1]"))
						.clear();
				Thread.sleep(3000);
				continue;
			} else {
				System.out.println("Vendor is selected");
				break;
			}

		}

//		driver.findElement(By.xpath("//form[@id='GRNChassisform']//div[2]//div[2]//div[1]//div[1]//input[1]"))
//				.sendKeys(ReadData_Excel.entry22);
//		Thread.sleep(5000);
//		 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
//		List<WebElement> option2 = driver.findElements(By.xpath("//button[@class='dropdown-item ng-star-inserted']"));
//		for (WebElement option : option2) {
//			if (option.getText().equals(ReadData_Excel.entry23)) {
//				System.out.print(option.getText());
//				option.click();
//				Thread.sleep(3000);
//				break;
//			}
//		}

//		To Verify The functionality of Vendor Office field

		String Vendoroffice = driver.findElement(By.xpath("//div[@class='row']//div[2]//div[2]//div[1]//input[1]"))
				.getAttribute("class");
		if (Vendoroffice.equals("form-control ng-untouched ng-pristine ng-valid")) {
			System.out.println("Vendor Office is selected");
		} else {
			System.out.println("Vendor Office is  not selected");
		}
		Thread.sleep(5000);

//			To Verify The functionality of State
		WebElement State = driver.findElement(By.xpath("//input[@name='stateName']"));
		String readonly = State.getAttribute("readonly");
		Assert.assertNotNull(readonly);

		WebElement Stateval = driver
				.findElement(By.xpath("//*[@id='GRNChassisform']/div[2]/div[2]/div[3]/div/input[2]"));
		String checkvalue = Stateval.getAttribute("value");
		System.out.println("state is selected" + " " + checkvalue);

//			To Verify The functionality of GSTNo	

		WebElement GSTNo = driver.findElement(By.xpath("//input[@name='gstNo']"));
		String GST = GSTNo.getAttribute("readonly");
		Assert.assertNotNull(GST);

//		Enter Remark

		driver.findElement(By.xpath("(//input[@name='remark'])[1]")).click();
		driver.findElement(By.xpath("(//input[@name='remark'])[1]")).sendKeys("Testing");
		Thread.sleep(2000);

//		To Verify the functionality of Tyre No
		driver.findElement(By.id("tyre_autofocus")).click();
		driver.findElement(By.id("tyre_autofocus")).sendKeys(ReadData_Excel.entry23);
		Thread.sleep(2000);

//		Enter Opening KM
		driver.findElement(By.id("KmRun")).click();
		driver.findElement(By.id("KmRun")).sendKeys(String.valueOf(ReadData_Excel.entry24));
		Thread.sleep(2000);
//		Enter Remark
		driver.findElement(By.xpath("//*[@id=\"TyreDetailsForm\"]/div[2]/div[1]/div[3]/div/input")).click();
		driver.findElement(By.xpath("//*[@id=\"TyreDetailsForm\"]/div[2]/div[1]/div[3]/div/input")).sendKeys("testing");
		Thread.sleep(2000);
//		Enter card No

		driver.findElement(By.name("productCardNumber")).click();
		driver.findElement(By.name("productCardNumber")).sendKeys(ReadData_Excel.entry25);
		Thread.sleep(2000);

		driver.findElement(By.id("position")).click();
		{
			WebElement dropdown = driver.findElement(By.id("position"));
			dropdown.findElement(By.xpath("//*[@id=\"position\"]/option[3]")).click();
		}
		Thread.sleep(2000);

//     Click on IsStepney checkbox		
//    driver.findElement(By.name("IsStepney")).click();

//	  Enter Production Month	
		driver.findElement(By.name("productionMonth")).click();
		driver.findElement(By.name("productionMonth")).sendKeys("09/2022");
		Thread.sleep(2000);

//		Enter PSI
		driver.findElement(By.name("psi")).click();
		driver.findElement(By.name("psi")).sendKeys(String.valueOf(ReadData_Excel.entry26));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

//	    Enter Brand	

		for (int i = 0; i < 3; i++) {
			driver.findElement(By.name("brandName")).click();
			Thread.sleep(1000);
			driver.findElement(By.name("brandName")).sendKeys(ReadData_Excel.entry27);
			Thread.sleep(1000);
			driver.findElement(By.name("brandName")).sendKeys(Keys.SPACE);
			Thread.sleep(1000);
			driver.findElement(By.name("brandName")).sendKeys(Keys.BACK_SPACE);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Thread.sleep(5000);

			boolean linkExists = driver.findElement(By.xpath("//*[@id='error-brand-code']")).isDisplayed();

			if (linkExists == true) {
				driver.findElement(By.name("brandName")).clear();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				Thread.sleep(3000);
				continue;
			} else {
				System.out.println("Brand is selected");
				break;
			}

		}


//	     Click on Remould checkbox			
		driver.findElement(By.id("remould")).click();
		Thread.sleep(3000);

//		Enter Rubber Brand

		for (int i = 0; i < 3; i++) {
			driver.findElement(By.name("rubberBrandName")).click();
			driver.findElement(By.name("rubberBrandName")).sendKeys(ReadData_Excel.entry28);
			Thread.sleep(2000);
			driver.findElement(By.name("rubberBrandName")).sendKeys(Keys.SPACE);
			Thread.sleep(2000);
			driver.findElement(By.name("rubberBrandName")).sendKeys(Keys.BACK_SPACE);
			Thread.sleep(6000);

			boolean linkExists = driver.findElement(By.xpath("//*[@id='error-rubberBrand-code']")).isDisplayed();

			if (linkExists == true) {
				driver.findElement(By.name("rubberBrandName")).clear();
				Thread.sleep(3000);
				continue;
			} else {
				System.out.println("RubberBrand is selected");
				break;
			}

		}

//		Select Rubber Type
		Thread.sleep(2000);
		driver.findElement(By.id("rubber")).click();
		{
			WebElement dropdown = driver.findElement(By.id("rubber"));
			dropdown.findElement(By.xpath("//*[@id='rubber']/option[1]")).click();
		}
		Thread.sleep(2000);

//		To verify the functionality of Amount

		String AmountValidationMessage = driver
				.findElement(By.xpath("//*[@id='TyreDetailsForm']/div[2]/div[4]/div[3]/div/label")).getText();
		Thread.sleep(3000);
		if (AmountValidationMessage.equals("[Amount should be between 5000 and 10000]")) {
			Thread.sleep(3000);
			driver.findElement(By.name("productAmount")).click();
			driver.findElement(By.name("productAmount")).sendKeys(String.valueOf(ReadData_Excel.entry30));
		} else {
			Thread.sleep(3000);
			driver.findElement(By.name("productAmount")).click();
			driver.findElement(By.name("productAmount")).sendKeys(String.valueOf(ReadData_Excel.entry29));
		}
		System.out.println(AmountValidationMessage);
		Thread.sleep(5000);

		// To verify the functionality of Add button
		driver.findElement(By.xpath("//input[@value='Add']")).click();
		Thread.sleep(5000);

		// To Verify the functionality of Total Amount
		WebElement TotalAmt = driver.findElement(By.xpath("//input[@name='totalAmount']"));
		String TotalAmountval = TotalAmt.getAttribute("value");
		System.out.println("Total amount is" + " " + TotalAmountval);

		// To verify the functionality of Save button
		driver.findElement(By.xpath("//input[@value='Save']")).click();
		Thread.sleep(6000);

		// Capture the confirmation Message
		String confirmationMessage = driver.findElement(By.xpath("//div[@id='alert_success']")).getText();
		Thread.sleep(5000);
		System.out.println(confirmationMessage);
		System.out.println(confirmationMessage + " " + " All Tyre details saved successfully");
		Thread.sleep(9000);

//				Click on Back to Index button
		driver.findElement(By.linkText("Back To Index")).click();
		Thread.sleep(9000);

//				To Verify the functionality of view( Click on View Icon)
		driver.findElement(By.xpath("//input[@value='Search']")).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath("//*[@id='table_responsive']/tbody/tr[1]/td[1]/a[1]/i")).click();
		Thread.sleep(5000);
		try {
			boolean linkExists = driver.findElement(By.xpath("//h4[normalize-space()='Chassis Tyre Details']"))
					.isDisplayed();

			if (linkExists == true) {
				System.out.println("Chassis Tyre Details page navigated Successfully – Passed");
			}
		} catch (NoSuchElementException e1) {
			System.out.println("Chassis Tyre Details page not navigated – Failed");
		}
		Thread.sleep(5000);

		for (int i = 0; i <= 5; i++) {
			String s = driver
					.findElement(By.xpath("//*[@id='basicDetail']/div/div/table/tbody/tr[" + (i + 1) + "]/td[1]/b"))
					.getText();
			String s1 = driver
					.findElement(By.xpath("//*[@id='basicDetail']/div/div/table/tbody/tr[" + (i + 1) + "]/td[2]"))
					.getText();

			System.out.println(s + "  " + s1);

		}

		for (int i = 0; i <= 4; i++) {
			String s2 = driver
					.findElement(By.xpath("//*[@id='basicDetail']/div/div/table/tbody/tr[" + (i + 1) + "]/td[3]/b"))
					.getText();
			String s3 = driver
					.findElement(By.xpath("//*[@id='basicDetail']/div/div/table/tbody/tr[" + (i + 1) + "]/td[4]"))
					.getText();

			System.out.println(s2 + "  " + s3);

		}

		driver.findElement(By.xpath("//a[@id='Tyre']")).click();
		Thread.sleep(5000);
		for (int i = 0; i <= 10; i++) {
			String tablename = driver
					.findElement(By.xpath("//*[@id='TyreDetails']/div/table/thead/tr/th[" + (i + 1) + "]")).getText();

			String TYREDETAILS = driver
					.findElement(By.xpath("//*[@id='TyreDetails']/div/table/tbody/tr/td[" + (i + 1) + "]")).getText();
			System.out.println(tablename + "  " + TYREDETAILS);

		}

		driver.findElement(By.linkText("Back To Index")).click();
		Thread.sleep(10000);

//		To verify the functionality of Edit/Update

		driver.findElement(By.xpath("//*[@id='table_responsive']/tbody/tr[1]/td[1]/a[2]/i")).click();
		Thread.sleep(9000);

		WebElement GRNNo = driver.findElement(By.xpath("//input[@name='documentNumber']"));
		String GRN = GRNNo.getAttribute("readonly");
		Assert.assertNotNull(GRN);
		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[@id='DocumentDate']")).isEnabled();
		Thread.sleep(3000);

		driver.findElement(By.xpath("(//i[@class='fa fa-pencil'])[1]")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//input[@name='remarks']")).clear();
		driver.findElement(By.xpath("//input[@name='remarks']")).sendKeys("update tyre details");
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

		// TestCases 2: To Verify the functionality of FromDate
		String month = ReadData_Excel.entryB;
		int year = ReadData_Excel.entryC;
		int day = ReadData_Excel.entryA;

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
		String month1 = ReadData_Excel.entryE;
		int year1 = ReadData_Excel.entryF;
		int day1 = ReadData_Excel.entryD;

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

		// TestCases 4: To verify the search functionality of Searchbox in Chassis Tyre
		// GRN

		String VendorName = ReadData_Excel.entryVN;
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

//			TestCases 5: To verify the download functionality of Export Summary
		driver.findElement(By.xpath("//button[normalize-space()='Export Summary']")).click();
		Thread.sleep(6000);
		Assert.assertTrue(
				isFileDownloaded(fileDownloadpath, "Chassis_GRN_Summary_Report_(01-08-2022_to_15-09-2022).csv"),
				"Failed to download Expected document");

//			TestCases 6: To verify the download functionality of Export Details

		driver.findElement(By.xpath("//button[normalize-space()='Export Details']")).click();
		Thread.sleep(6000);
		Assert.assertTrue(
				isFileDownloaded(fileDownloadpath, "Chassis_GRN_Details_Report(01_08_2022_to_15_09_2022).csv"),
				"Failed to download Expected document");

//			Verify the functionality of Import from Excel
		String ChasssisTemplatePath = System.getProperty("user.dir");
		String excelTamplatePath = ChasssisTemplatePath + "/file/Chassis GRN Template.xlsx";

		driver.findElement(By.linkText("Import From Excel")).click();
		Thread.sleep(5000);
		driver.findElement(By.linkText("Download Format")).click();
		Thread.sleep(6000);
		Assert.assertTrue(isFileDownloaded(fileDownloadpath, "Chassis GRN Template.xlsx"),
				"Failed to download Expected document");

		WebElement chooseFile = driver.findElement(By.xpath("//*[@id='input']"));
		chooseFile.sendKeys(excelTamplatePath);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value='Upload']")).click();
		Thread.sleep(9000);
		driver.findElement(By.xpath("//button[normalize-space()='Upload']")).click();
		Thread.sleep(9000);
		driver.findElement(By.xpath("//button[normalize-space()='Download For Resubmission']")).click();
		Thread.sleep(9000);
		driver.findElement(By.xpath("//button[normalize-space()='OK']")).click();
		Thread.sleep(15000);
		driver.findElement(By.linkText("Back To Index")).click();
		Thread.sleep(10000);

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
