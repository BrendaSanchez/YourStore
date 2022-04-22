package test;

import org.testng.annotations.Test;
import commons.AddToCart;
import commons.DriverConnection;
import commons.Login;
import commons.RemoveToCart;
import commons.SearchItems;
import org.testng.annotations.BeforeClass;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class TC04_RemoveItemCart {

	public WebDriver driver;

	// Set the connection with WebDriver
	@BeforeClass
	public void beforeClass() {
		DriverConnection webDriver = new DriverConnection();
		webDriver.setUp();
		driver = webDriver.driver;
	}

	// Test Case 04: Remove items from the shopping cart for a user logged in page
	@Test(description = "Remove items from Cart", priority = 4)
	public void TC04() throws IOException, InterruptedException {
		Login login = new Login(driver);
		login.login();
		login.close();
		SearchItems search = new SearchItems(driver);
		search.searchItem();
		search.close();
		AddToCart addCart = new AddToCart(driver);
		addCart.addToCart();
		RemoveToCart removeCart = new RemoveToCart(driver);
		removeCart.removeItem();
		Thread.sleep(3000);
	}

	// Finish connection with WebDriver
	@AfterClass
	public void afterClass() {
		DriverConnection webDriver = new DriverConnection();
		webDriver.tearDown(driver);
	}

}
