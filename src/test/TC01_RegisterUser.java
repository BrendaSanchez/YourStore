package test;

import org.testng.annotations.Test;
import commons.DriverConnection;
import commons.LogOut;
import commons.Register;
import org.testng.annotations.BeforeClass;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class TC01_RegisterUser {

	public WebDriver driver;

	// Set the connection with WebDriver
	@BeforeClass
	public void beforeClass() {
		DriverConnection webDriver = new DriverConnection();
		webDriver.setUp();
		driver = webDriver.driver;
	}

	// Test Case 01: Register a new user in "Your Store" page
	@Test(description = "Register new user", priority = 1)
	public void TC01() throws IOException, InterruptedException {
		Register register = new Register(driver);
		register.register();
		Thread.sleep(5000);
		LogOut logout = new LogOut(driver);
		logout.logOut();
	}

	// Finish connection with WebDriver
	@AfterClass
	public void afterClass() {
		DriverConnection webDriver = new DriverConnection();
		webDriver.tearDown(driver);
	}

}
