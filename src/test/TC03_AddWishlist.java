package test;

import org.testng.annotations.Test;
import commons.AddToWishList;
import commons.DriverConnection;
import commons.LogOut;
import commons.Login;
import commons.SearchItems;
import org.testng.annotations.BeforeClass;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class TC03_AddWishlist {

	public WebDriver driver;

	// Set the connection with WebDriver
	@BeforeClass
	public void beforeClass() {
		DriverConnection webDriver = new DriverConnection();
		webDriver.setUp();
		driver = webDriver.driver;
	}

	// Test Case 03: Add items to the wishlist for a user logged in page
	@Test(description = "Add items to Wishlist", priority = 3)
	public void TC03() throws IOException, InterruptedException {
		Login login = new Login(driver);
		login.login();
		login.close();
		Thread.sleep(3000);
		SearchItems search = new SearchItems(driver);
		search.searchItem();
		search.close();
		AddToWishList addToWL = new AddToWishList(driver);
		addToWL.addToWishList();
		Thread.sleep(3000);
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
