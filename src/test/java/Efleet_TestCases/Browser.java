package Efleet_TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {
	
	public ChromeDriver Browser() {
		
		System.setProperty("webdriver.chrome.driver", Constants.CHROME_PATH);
        ChromeDriver driver = new ChromeDriver();
        
        driver.get(Constants.WEBSITE_URL);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        return driver;		
		
		
		
	}
	
	
	
}