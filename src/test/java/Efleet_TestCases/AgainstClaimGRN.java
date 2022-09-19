package Efleet_TestCases;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AgainstClaimGRN {
	private static String fileDownloadpath = "C:\\Users\\Lenovo\\Downloads";
	static WebDriver driver;

	public AgainstClaimGRN(WebDriver driver) {
		this.driver = driver;
	}

	public void TestAgainstClaimGRN() throws Exception {
		ReadData_Excel object3 = new ReadData_Excel();
		object3.dataReadtest();

		// Click on Tyre Dashboard
		driver.findElement(By.linkText("Tyre Dashboard")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Click on Tyre Inward
		driver.findElement(By.linkText("Tyre Inward")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

//		 Click On Against Claim GRN
		driver.findElement(By.linkText("Against Claim GRN")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// TestCases : To Verify the functionality of FromDate
		String month = ReadData_Excel.entryB2;
		int year = ReadData_Excel.entryC2;
		int day = ReadData_Excel.entryA2;

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
		String month1 = ReadData_Excel.entryE2;
		int year1 = ReadData_Excel.entryF2;
		int day1 = ReadData_Excel.entryD2;

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

		// TestCases 4: To verify the search functionality of Searchbox in Against Claim

		String VendorName = ReadData_Excel.entryVendorName;
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

//		To Verify the functionality of view( Click on View Icon)

		driver.findElement(By.xpath("//*[@id='table_responsive']/tbody/tr[1]/td[1]/a[1]/i")).click();
		Thread.sleep(8000);
		try {
			boolean linkExists = driver.findElement(By.xpath("//h2[normalize-space()='Claim Tyre Details']"))
					.isDisplayed();

			if (linkExists == true) {
				System.out.println("Claim Tyre Details page navigated Successfully – Passed");
			}
		} catch (NoSuchElementException e1) {
			System.out.println("Claim Tyre Details page not navigated – Failed");
		}
		Thread.sleep(5000);

		for (int i = 0; i <= 6; i++) {
			String s = driver
					.findElement(By
							.xpath("//*[@id='basicDetail']/div/div[1]/div/div/table/tbody/tr[" + (i + 1) + "]/td[1]/b"))
					.getText();
			String s1 = driver
					.findElement(
							By.xpath("//*[@id='basicDetail']/div/div[1]/div/div/table/tbody/tr[" + (i + 1) + "]/td[2]"))
					.getText();

			System.out.println(s + "====" + s1);

		}
		Thread.sleep(3000);

		for (int i = 0; i <= 6; i++) {
			String s2 = driver
					.findElement(By
							.xpath("//*[@id='basicDetail']/div/div[1]/div/div/table/tbody/tr[" + (i + 1) + "]/td[3]/b"))
					.getText();
			String s3 = driver
					.findElement(
							By.xpath("//*[@id='basicDetail']/div/div[1]/div/div/table/tbody/tr[" + (i + 1) + "]/td[4]"))
					.getText();

			System.out.println(s2 + "====" + s3);

		}
		Thread.sleep(3000);

		driver.findElement(By.xpath("//a[@id='Tyre']")).click();
		Thread.sleep(5000);
		for (int i = 0; i <= 14; i++) {
			String tablename = driver
					.findElement(By.xpath("//*[@id='TyreDetails']/div[1]/table/thead/tr/th[" + (i + 1) + "]"))
					.getText();

			String TYREDETAILS = driver
					.findElement(By.xpath("//*[@id='TyreDetails']/div[1]/table/tbody/tr/td[" + (i + 1) + "]"))
					.getText();
			System.out.println(tablename + "===" + TYREDETAILS);

		}

		driver.findElement(By.linkText("Back To Index")).click();
		Thread.sleep(10000);

//			To Verify the functionality of Edit( Click on Edit button)

		driver.findElement(By.xpath("//*[@id='table_responsive']/tbody/tr/td[1]/a[2]/i")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//i[@class='fa fa-pencil'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='tyre_autofocus']")).clear();
		driver.findElement(By.xpath("//*[@id='tyre_autofocus']")).sendKeys(ReadData_Excel.entryUpdateTyreNumber2);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='remarks']")).clear();
		driver.findElement(By.xpath("//input[@name='remarks']")).sendKeys("Update tyre details");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='TyreDetailsForm']/div[2]/div[5]/button")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		Thread.sleep(5000);

		String UpdateconfirmationMessage = driver.findElement(By.xpath("//div[@id='alert_success']")).getText();
		Thread.sleep(5000);
		System.out.println(UpdateconfirmationMessage);
		Thread.sleep(5000);
		
		
//		To Verify the functionality of Document Upload
		
            driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
            Thread.sleep(5000);
            driver.findElement(By.xpath("//input[@value='Add New Document']")).click();
            Thread.sleep(5000);
			WebElement dropdown1 = driver.findElement(By.id("typeId"));
			Select sel = new Select(dropdown1);
			sel.selectByVisibleText("Product Challan");

			Thread.sleep(5000);

			driver.findElement(By.xpath("//input[@name='document']"))
					.sendKeys("C:\\Users\\Lenovo\\Downloads\\flower (1).jpg");
			Thread.sleep(10000);
			driver.findElement(By.xpath("//input[@value='Add']")).click();
			Thread.sleep(10000);
			String confirmationMessage1 = driver.findElement(By.xpath("//div[@id='alert_success']")).getText();
			Thread.sleep(3000);
			System.out.println(confirmationMessage1);
			System.out.println(confirmationMessage1 + " " + " Document details saved successfully");
			 Thread.sleep(5000);

		driver.findElement(By.linkText("Back To Index")).click();
		Thread.sleep(10000);

//			Verify the functionality of Export Summary
		driver.findElement(By.xpath("//button[normalize-space()='Export Summary']")).click();
		Thread.sleep(6000);
		Assert.assertTrue(
				isFileDownloaded(fileDownloadpath, "Claim_Tyre_GRN_Summary_Report_(05_03_2022_to_24_08_2022).csv"),
				"Failed to download Expected document");

//			Verify the functionality of Export Details
		driver.findElement(By.xpath("//button[normalize-space()='Export Details']")).click();
		Thread.sleep(6000);
		Assert.assertTrue(
				isFileDownloaded(fileDownloadpath, "Claim_Tyre_GRN_Details_Report_(05_03_2022_to_24_08_2022).csv"),
				"Failed to download Expected document");

//	To Verify the functionality of Manage Claim Tyres
		driver.findElement(By.linkText("Manage Claim Tyres")).click();
		Thread.sleep(2000);

//   To check current date is displayed
		WebElement GRNDate = driver.findElement(By.id("DocumentDate"));
		String elementval = GRNDate.getAttribute("value");
		System.out.println(elementval);

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		String date1 = dateFormat.format(date);
		Assert.assertEquals(date1, elementval);
		System.out.println(elementval + " " + "Current date selected in GRN date By default");

//	To verify the functionality of office
		
		for(int i=0; i<5; i++) {
			driver.findElement(By.xpath("//div[@id='ClaimTyreDetail']//div[2]//div[1]//div[2]//div[1]//input[1]"))
			.sendKeys(ReadData_Excel.entry42);
	        Thread.sleep(5000);
	        
	        
	        boolean linkExists = driver.findElement(By.xpath("//*[@id='error-office-code']"))
					.isDisplayed();

			if (linkExists == true) {
				driver.findElement(By.xpath("//div[@id='ClaimTyreDetail']//div[2]//div[1]//div[2]//div[1]//input[1]")).clear();
				Thread.sleep(5000);
				  continue;
			}else {
				System.out.println("Office is selected");
				break;
			}
			
		}


//	Enter Vendor

		driver.findElement(By.xpath("//input[@name='vendorName']")).sendKeys(ReadData_Excel.entry43);
		Thread.sleep(3000);
		List<WebElement> option2 = driver.findElements(By.xpath("//button[@class='dropdown-item ng-star-inserted']"));
		for (WebElement option : option2) {
			if (option.getText().equals(ReadData_Excel.entry43)) {
				System.out.print(option.getText());
				option.click();
				Thread.sleep(3000);
				break;
			}
		}

//		To Verify The functionality of Vendor Office field

		String Vendoroffice = driver.findElement(By.xpath("//input[@name='vendorOfficeMasterName']")).getAttribute("class");
		if (Vendoroffice.equals("form-control ng-untouched ng-pristine ng-valid")) {
			System.out.println("Vendor Office is selected");
		} else {
			System.out.println("Vendor Office is  not selected");
		}

//		To Verify The functionality of State
		WebElement State = driver.findElement(By.xpath("//input[@name='stateName']"));
		String readonly = State.getAttribute("readonly");
		Assert.assertNotNull(readonly);

		WebElement Stateval = driver
				.findElement(By.xpath("//*[@id='ClaimTyreform']/div[2]/div[1]/div[5]/div/input[2]"));
		String checkvalue = Stateval.getAttribute("value");
		System.out.println("state is selected" + " " + checkvalue);

//			To Verify The functionality of GSTNo	

		WebElement GSTNo = driver.findElement(By.xpath("//input[@name='gstNo']"));
		String GST = GSTNo.getAttribute("readonly");
		Assert.assertNotNull(GST);

//			Click On 'Challan cum Invoice' checkbox
		driver.findElement(By.xpath("//*[@id='DocumentTypeId']")).click();
		Thread.sleep(1000);

//	      To verify the functionality of Challan Number
		WebElement ChallanNo = driver.findElement(By.xpath("//input[@name='challanNumber']"));
		ChallanNo.sendKeys(ReadData_Excel.entry44);
		Thread.sleep(1000);

//	 		Verify the functionality of Challan Date

		WebElement ChallanDate = driver.findElement(By.id("ChallanDate"));
		String elementval1 = ChallanDate.getAttribute("value");
		Assert.assertEquals(date1, elementval1);
		System.out.println(elementval1 + " " + "Current date selected in Challan date By default");

//	      To Verify the functionality of invoice number

		WebElement invoiceNumber = driver.findElement(By.xpath("//input[@name='invoiceNumber']"));
		invoiceNumber.sendKeys(ReadData_Excel.entry45);
		Thread.sleep(1000);

//	 		Verify the functionality of Invoice Date	

		WebElement InvoiceDate = driver.findElement(By.id("InvoiceDate"));
		String elementval2 = InvoiceDate.getAttribute("value");
		Assert.assertEquals(date1, elementval2);
		System.out.println(elementval2 + " " + "Current date selected in Invoice date By default");

		driver.findElement(By.xpath("//input[@name='remark']")).click();
		driver.findElement(By.xpath("//input[@name='remark']")).sendKeys(ReadData_Excel.entry46);
		Thread.sleep(1000);
				

		driver.findElement(By.xpath(
				"//*[@id='ClaimTyreDetail']/div[3]/table/tbody/tr/td[1]/input[1]"))
				.click();
		Thread.sleep(5000);


		driver.findElement(By.xpath(
				"//*[@id='ClaimTyreDetail']/div[3]/table/tbody/tr/td[2]/a/i"))
				.click();
		Thread.sleep(5000);

//       Enter Tyre no
		driver.findElement(By.id("tyre_autofocus")).click();
		driver.findElement(By.id("tyre_autofocus")).sendKeys(ReadData_Excel.entry47);
		Thread.sleep(3000);

//      Enter card no
		driver.findElement(By.name("productCardNumber")).click();
		driver.findElement(By.name("productCardNumber")).sendKeys(ReadData_Excel.entry48);
		Thread.sleep(3000);

		driver.findElement(By.xpath("//input[@name='additionalAmount']"))
				.sendKeys(String.valueOf(ReadData_Excel.entry49));
		Thread.sleep(3000);

		driver.findElement(By.name("productAmount")).click();
		driver.findElement(By.name("productAmount")).sendKeys(String.valueOf(ReadData_Excel.entry50));
		Thread.sleep(3000);

//		driver.findElement(By.xpath("//button[normalize-space()='Update']")).click();
//		Thread.sleep(3000);
//
//		driver.findElement(By.xpath("//input[@class='btn btn-success btn-add']")).click();
		Thread.sleep(9000);
		
		
		Thread.sleep(5000);
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