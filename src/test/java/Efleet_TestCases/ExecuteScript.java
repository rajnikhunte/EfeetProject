package Efleet_TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExecuteScript {

	WebDriver driver;

	// Positive test case of login
	@Test(description = "Test case: Login with valid user name and valid password.", priority = 1)

	// Login with valid user name & valid password
	public void loginTestValidUsernamePassword() throws InterruptedException {

		// Created variable for simba browser and called
		Browser browser = new Browser();
		driver = browser.Browser();

		// Created variable for login and called
		Loginscript login = new Loginscript(driver);

		// Passing valid user name
		login.username(Constants.VALID_USER_NAME);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Passing valid password
		login.password(Constants.VALID_PASSWORD);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		login.login();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@Test(description = "Test case: New/New Remould Tyre Functionality.", priority = 2)
	public void NewRemouldTyreGRN() throws Exception {
		NewRemouldTyreGRN NewRemould = new NewRemouldTyreGRN(driver);
		NewRemould.NewRemouldTyreGRN();
	}

	@Test(description = "Test case: Chassis Tyre Functionality.", priority = 3)
	public void ChassisTyreGRN() throws Exception {
		ChassisTyreGRN NewChassis = new ChassisTyreGRN(driver);
		NewChassis.ChassisTyreGRN();
	}

//	@Test(description = "Test case: RemouldTyre Functionality.", priority = 4)
//	public void AgainstClaimGRN() throws Exception {
//		AgainstClaimGRN object = new AgainstClaimGRN(driver);
//		object.TestAgainstClaimGRN();
//	}

//	@Test(description = "Test case: RemouldTyre Functionality.", priority = 5)
//	public void RemouldTyreGRN() throws Exception {
//		RemouldTyreGRN object = new RemouldTyreGRN(driver);
//		object.TestRemouldTyreGRN();
//	}

}
