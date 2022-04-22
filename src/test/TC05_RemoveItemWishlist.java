package test;

import org.testng.annotations.Test;
import commons.AddToWishList;
import commons.DriverConnection;
import commons.Login;
import commons.RemoveToWishList;
import commons.SearchItems;
import org.testng.annotations.BeforeClass;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class TC05_RemoveItemWishlist {

	public WebDriver driver;

	// Set the connection with WebDriver
	@BeforeClass
	public void beforeClass() {
		DriverConnection webDriver = new DriverConnection();
		webDriver.setUp();
		driver = webDriver.driver;
	}

	// Test Case 05: Remove items from the wishlist for a user logged in page
	@Test(description = "Remove items from Wishlist", priority = 5)
	public void TC05() throws IOException, InterruptedException {
		Login login = new Login(driver);
		login.login();
		login.close();
		SearchItems search = new SearchItems(driver);
		search.searchItem();
		search.close();
		AddToWishList addToWL = new AddToWishList(driver);
		addToWL.addToWishList();
		RemoveToWishList removeWL = new RemoveToWishList(driver);
		removeWL.removeItem();
		Thread.sleep(3000);
	}

	// Finish connection with WebDriver
	@AfterClass
	public void afterClass() {
		DriverConnection webDriver = new DriverConnection();
		webDriver.tearDown(driver);
	}

}
