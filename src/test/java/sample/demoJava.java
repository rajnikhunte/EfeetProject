package sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Efleet_TestCases.Constants;

public class demoJava {
	
	public static ReadExcel readData;
	public static WebDriver driver;
	

	@Test(priority= 1)
	public void TestCase() {
		System.setProperty("webdriver.chrome.driver", Constants.CHROME_PATH);
        driver = new ChromeDriver();
        driver.get("https://tms.efleetsystems.com/login");
//		driver.findElement(By.xpath("//input[@value='Log in']")).click();
        
	}
	
	 @Test(priority = 2,dataProvider = "sample",dataProviderClass = DataProviderLogin.class)
	    public void read_write_Login_ExcelData(String userName, String password) throws InterruptedException {
	        System.out.println("loginDetails");
	        driver.findElement(By.xpath("//input[@id='userName']")).sendKeys(userName);
	        Thread.sleep(2000);	
			driver.findElement(By.id("password")).sendKeys(password);
		Thread.sleep(2000);		
		
	}
	 @Test(priority= 3)
	 public void Login() {
		 driver.findElement(By.xpath("//input[@value='Log in']")).click();
		 
	 }

}
