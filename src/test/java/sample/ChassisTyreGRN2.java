package sample;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Efleet_TestCases.Constants;
import sample.DataProviderLogin;
import sample.ReadExcel;

public class ChassisTyreGRN2 {
	public static ReadExcel readData;
	public static WebDriver driver;

	@Test(priority = 1)
	public void TestCase() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", Constants.CHROME_PATH);
		driver = new ChromeDriver();
		driver.get("https://tms.efleetsystems.com/login");
		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("jeswin");
		Thread.sleep(2000);
		driver.findElement(By.id("password")).sendKeys("tms@2022");
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[3]/div/form/div[2]/input")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[4]/button")).click();
		Thread.sleep(8000);
	}

	@Test(priority = 2)
	public void OpenTyreDashboard() throws InterruptedException {

//		/ Click on Tyre Dashboard
		driver.findElement(By.linkText("Tyre Dashboard")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Click on Tyre Inward

		driver.findElement(By.linkText("Tyre Inward")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

//		Click on Chassis Tyre
		driver.findElement(By.linkText("Chassis Tyre GRN")).click();

//	   Click on Add button	
		driver.findElement(By.linkText("Add New")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(5000);

		// To check current date is displayed
		WebElement GRNDate = driver.findElement(By.id("DocumentDate"));
		String elementval = GRNDate.getAttribute("value");
		System.out.println(elementval);

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		String date1 = dateFormat.format(date);
		Assert.assertEquals(date1, elementval);
		System.out.println(elementval + " " + "Current date selected in GRN date By default");
		Thread.sleep(3000);
	}

	@Test(priority = 3, dataProvider = "sample", dataProviderClass = DataProviderLogin.class)
	public void VerifyVehicleNo(String VehicleNo, String OdometerReading)
			throws InterruptedException {

//		Enter Vehicle No
		driver.findElement(By.id("typeahead-basic")).sendKeys(VehicleNo);
		Thread.sleep(5000);
//		Enter OdometerReading
		driver.findElement(By.name("VehicleReading")).click();
		driver.findElement(By.name("VehicleReading")).sendKeys(OdometerReading);
		Thread.sleep(2000);
		
	}	
		@Test(priority = 4, dataProvider = "sample", dataProviderClass = DataProviderLogin.class)
		public void VerifyOfficeNo(String Office, String Vendor)
				throws InterruptedException {
			// To Verify the functionality of Office

			driver.findElement(By.xpath(
					"//body[1]/app-root[1]/app-master[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-grnchassis[1]/app-addgrnchassis[1]/div[5]/div[1]/form[1]/div[2]/div[1]/div[4]/div[1]/input[1]"))
					.sendKeys(Office);
			Thread.sleep(6000);
			List<WebElement> option1 = driver.findElements(By.xpath("//button[@class='dropdown-item ng-star-inserted']"));
			for (WebElement option : option1) {
				if (option.getText().equals(Office)) {
					System.out.print(option.getText());
					option.click();
					Thread.sleep(3000);
					break;
				}
			}
			
			
//			To Verify the functionality of Vendor

			driver.findElement(By.xpath("//form[@id='GRNChassisform']//div[2]//div[2]//div[1]//div[1]//input[1]"))
					.sendKeys(Vendor);
			Thread.sleep(6000);
			List<WebElement> option2 = driver.findElements(By.xpath("//button[@class='dropdown-item ng-star-inserted']"));
			for (WebElement option : option2) {
				if (option.getText().equals(Vendor)) {
					System.out.print(option.getText());
					option.click();
					Thread.sleep(3000);
					break;
				}
			}
		

		
	}

}
