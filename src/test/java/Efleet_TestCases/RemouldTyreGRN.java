package Efleet_TestCases;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class RemouldTyreGRN {

	private static String fileDownloadpath = "C:\\Users\\Lenovo\\Downloads";
	static WebDriver driver;

	public RemouldTyreGRN(WebDriver driver) throws InterruptedException {
		this.driver = driver;
	}

	@SuppressWarnings({ "deprecation", "unused" })
	public void TestRemouldTyreGRN() throws Exception {
		ReadData_Excel object2 = new ReadData_Excel();
		object2.dataReadtest();

		// Click on Tyre Dashboard
		driver.findElement(By.linkText("Tyre Dashboard")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(2000);

		// Click on Tyre Inward

		driver.findElement(By.linkText("Tyre Inward")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

//			Click on Remould Tyre
		driver.findElement(By.linkText("Remould Tyre GRN")).click();
		Thread.sleep(5000);

//	    Verify the functionality of add new Remould GRN   
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

//To verify the functionality of Office

		for (int i = 0; i < 7; i++) {
			driver.findElement(By.xpath(
					"//body[1]/app-root[1]/app-master[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-remouldtyregrn[1]/app-remouldtyregrnform[1]/div[6]/div[1]/div[1]/div[1]/form[1]/div[2]/div[1]/div[2]/div[1]/input[1]"))
					.sendKeys(ReadData_Excel.entry32);
			Thread.sleep(5000);
			boolean linkExists = driver.findElement(By.xpath("//*[@id='error-office-code']")).isDisplayed();

			if (linkExists == true) {
				driver.findElement(By.xpath(
						"//body[1]/app-root[1]/app-master[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-remouldtyregrn[1]/app-remouldtyregrnform[1]/div[6]/div[1]/div[1]/div[1]/form[1]/div[2]/div[1]/div[2]/div[1]/input[1]"))
						.clear();
				Thread.sleep(3000);
				continue;
			} else {
				System.out.println("Office is selected");
				break;
			}

		}
		Thread.sleep(3000);

//		To verify the functionality of Vendor

		for (int i = 0; i < 7; i++) {
			driver.findElement(By.xpath("//input[@name='vendorName']")).sendKeys(ReadData_Excel.entry33);
			Thread.sleep(6000);
			boolean linkExists = driver.findElement(By.xpath("//*[@id='error-vendor-code']")).isDisplayed();

			if (linkExists == true) {
				driver.findElement(By.xpath("//*[@id='error-vendor-code']")).clear();
				Thread.sleep(3000);
				continue;
			} else {
				System.out.println("Vendor is selected");
				break;
			}

		}

//		To Verify The functionality of Vendor Office field

		String Vendoroffice = driver.findElement(By.xpath("//div[@class='col-sm-6']//div[4]//div[1]//input[1]"))
				.getAttribute("class");
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
				.findElement(By.xpath("//*[@id='RemouldTyreform']/div[2]/div[1]/div[5]/div/input[2]"));
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
		ChallanNo.sendKeys(String.valueOf(ReadData_Excel.entry34));
		Thread.sleep(1000);

// 		Verify the functionality of Challan Date

		WebElement ChallanDate = driver.findElement(By.id("ChallanDate"));
		String elementval1 = ChallanDate.getAttribute("value");
		Assert.assertEquals(date1, elementval1);
		System.out.println(elementval1 + " " + "Current date selected in Challan date By default");

//      To Verify the functionality of invoice number

		WebElement invoiceNumber = driver.findElement(By.xpath("//input[@name='invoiceNumber']"));
		invoiceNumber.sendKeys(String.valueOf(ReadData_Excel.entry35));
		Thread.sleep(1000);

// 		Verify the functionality of Invoice Date	

		WebElement InvoiceDate = driver.findElement(By.id("InvoiceDate"));
		String elementval2 = InvoiceDate.getAttribute("value");
		Assert.assertEquals(date1, elementval2);
		System.out.println(elementval2 + " " + "Current date selected in Invoice date By default");

//	Enter Remark
		driver.findElement(By.xpath("//input[@name='remark']")).click();
		driver.findElement(By.xpath("//input[@name='remark']")).sendKeys(ReadData_Excel.entry36);
		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[@id='RemouldTyreDetail']/div[3]/table/tbody/tr[1]/td[1]")).click();
		Thread.sleep(8000);
		
		for (int second = 0;; second++) {
			if (second >= 60) {
				break;
			}
			((JavascriptExecutor) driver).executeScript("window.scrollBy(2000,0)");
		}
		Thread.sleep(8000);
		driver.findElement(By.xpath("//i[@class='fa fa-pencil']")).click();
//		driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-master[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-remouldtyregrn[1]/app-remouldtyregrnform[1]/div[6]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[18]/a[1]/i[1]")).click();
		Thread.sleep(8000);
		

//	Select Rubber Brand
		for (int i = 0; i < 7; i++) {
			driver.findElement(By.xpath("//input[@name='productRubberBrandName']")).sendKeys(ReadData_Excel.entry37);
			Thread.sleep(6000);
			boolean linkExists = driver.findElement(By.xpath("//*[@id='error-brand-code']")).isDisplayed();

			if (linkExists == true) {
				driver.findElement(By.xpath("//input[@name='productRubberBrandName']")).clear();
				Thread.sleep(3000);
				continue;
			} else {
				System.out.println("Rubber Brand is selected");
				break;
			}

		}

		driver.findElement(By.id("rubber")).click();
		{
			WebElement dropdown = driver.findElement(By.id("rubber"));
			dropdown.findElement(By.xpath("//*[@id='rubber']/option[1]")).click();
		}

//	To verify the functionality of Amount

		String AmountValidationMessage = driver
				.findElement(By.xpath("//*[@id='TyreDetailsForm']/div[2]/div[3]/div[1]/div/label")).getText();
		Thread.sleep(3000);
		if (AmountValidationMessage.equals("[Amount should be between 3000 and 10000]")) {
			Thread.sleep(3000);
			driver.findElement(By.name("productAmount")).click();
			driver.findElement(By.name("productAmount")).sendKeys(String.valueOf(ReadData_Excel.entry39));
		} else {
			Thread.sleep(3000);
			driver.findElement(By.name("productAmount")).click();
			driver.findElement(By.name("productAmount")).sendKeys(String.valueOf(ReadData_Excel.entry38));
		}
		System.out.println(AmountValidationMessage);

//	Enter TransferPrice

		driver.findElement(By.name("additionalAmount")).click();
		driver.findElement(By.name("additionalAmount")).sendKeys((String.valueOf(ReadData_Excel.entry40)));
		Thread.sleep(3000);

//	Click on Update button

		driver.findElement(By.xpath("//button[normalize-space()='Update']")).click();
		Thread.sleep(3000);

//	Click on save button
		driver.findElement(By.xpath("//*[@id='RemouldTyreform']/div[5]/div[2]/div/div/input")).click();
		Thread.sleep(3000);

		// TestCases : To Verify the functionality of FromDate
		String month = ReadData_Excel.entryB1;
		int year = ReadData_Excel.entryC1;
		int day = ReadData_Excel.entryA1;

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
		String month1 = ReadData_Excel.entryE1;
		int year1 = ReadData_Excel.entryF1;
		int day1 = ReadData_Excel.entryD1;

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
//		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, document.body.scrollTop)");
//		JavascriptExecutor js1 = (JavascriptExecutor) driver;
//		js1.executeScript("window.scrollBy(0,2000)");
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
		// TestCases 4: To verify the search functionality of Searchbox in Remould tyre
		// GRN

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

//			To Verify the functionality of view( Click on View Icon)
		driver.findElement(By.xpath("//input[@value='Search']")).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath("//*[@id='table_responsive']/tbody/tr[1]/td[1]/a[1]/i")).click();
		Thread.sleep(5000);
		try {
			boolean linkExists = driver.findElement(By.xpath("//h2[normalize-space()='Remould Tyre Details']"))
					.isDisplayed();

			if (linkExists == true) {
				System.out.println("Remould Tyre Details page navigated Successfully – Passed");
			}
		} catch (NoSuchElementException e1) {
			System.out.println("Remold Tyre detail page not navigated – Failed");
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

//			To Verify the functionality of Edit( Click on Edit button)

		driver.findElement(By.xpath("//*[@id='table_responsive']/tbody/tr[1]/td[1]/a[2]/i")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='RemouldTyreform']/div[2]/div[2]/div[4]/div/input")).clear();
		driver.findElement(By.xpath("//*[@id='RemouldTyreform']/div[2]/div[2]/div[4]/div/input"))
				.sendKeys(" Update remould Tyre Details");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		Thread.sleep(5000);

		String UpdateconfirmationMessage = driver.findElement(By.xpath("//div[@id='alert_success']")).getText();
		Thread.sleep(5000);
		System.out.println(UpdateconfirmationMessage);

		driver.findElement(By.linkText("Back To Index")).click();
		Thread.sleep(10000);

//			TestCases 5: To verify the download functionality of Export Summary
		driver.findElement(By.xpath("//button[normalize-space()='Export Summary']")).click();
		Thread.sleep(6000);
		Assert.assertTrue(
				isFileDownloaded(fileDownloadpath, "Remould_Tyre_GRN_Summary_Report_(01_07_2022_to_24_08_2022).csv"),
				"Failed to download Expected document");

//			TestCases 6: To verify the download functionality of Export Details

		driver.findElement(By.xpath("//button[normalize-space()='Export Details']")).click();
		Thread.sleep(6000);
		Assert.assertTrue(
				isFileDownloaded(fileDownloadpath, "Remould_Tyre_GRN_Details_Report_(01_07_2022_to_24_08_2022).csv"),
				"Failed to download Expected document");

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