package Efleet_TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Loginscript {
    static WebDriver driver;
 
    public Loginscript(WebDriver driver) {
        this.driver = driver;
    }
 
    // Giving path of user name and passing string value
    public void username(String string) {
        driver.findElement(By.id("userName")).sendKeys(string);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
 
    }
 
    // Giving path of password and passing string value
    public void password(String string) throws InterruptedException {
        driver.findElement(By.id("password")).sendKeys(string);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
 
    // Giving path of sign in button and clicking on it.
    public void login() throws InterruptedException {
        driver.findElement(By.xpath("//body/app-root[1]/app-login[1]/div[1]/div[1]/form[1]/div[3]/input[1]")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        //Click on Radio button
        driver.findElement(By.xpath("//body/ngb-modal-window[1]/div[1]/div[1]/div[3]/div[1]/form[1]/div[2]/input[1]")).click();

        //Click on submit button
        driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
 
    }
 
}







//public class loginScript {
//
//		static WebDriver driver;
//
//		public void Loginscript(WebDriver driver) {
//			this.driver = driver;
//		}
//
//		// Giving path of user name and passing string value
//		public void username(String string) {
//			driver.findElement(By.id("userName")).sendKeys(string);
//			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//
//		}
//
//		// Giving path of password and passing string value
//		public void password(String string) throws InterruptedException {
//			driver.findElement(By.id("password")).sendKeys(string);
//			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		}
//
//		// Giving path of sign in button and clicking on it.
//		public void login() throws InterruptedException {
//			driver.findElement(By.xpath("//body/app-root[1]/app-login[1]/div[1]/div[1]/form[1]/div[3]/input[1]")).click();
//			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//			
//			//Click on Radio button
//			driver.findElement(By.xpath("//body/ngb-modal-window[1]/div[1]/div[1]/div[3]/div[1]/form[1]/div[2]/input[1]")).click();
//			
//			//Click on submit button
//			driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
//			
//
//		}
//
//	}



