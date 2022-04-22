package test;

import org.testng.annotations.Test;
import commons.AddToCart;
import commons.DriverConnection;
import commons.Login;
import commons.ReturningCustomerCheckout;
import commons.SearchItems;
import org.testng.annotations.BeforeClass;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class TC02_CheckoutItems {

	public WebDriver driver;

	// Set the connection with WebDriver
	@BeforeClass
	public void beforeClass() {
		DriverConnection webDriver = new DriverConnection();
		webDriver.setUp();
		driver = webDriver.driver;
	}

	// Test Case 02: Checkout Items from the shopping cart for a user logged in page
	@Test(description = "Checkout Items for login user", priority = 2)
	public void TC02() throws IOException, InterruptedException {
		Login login = new Login(driver);
		login.login();
		login.close();
		SearchItems search = new SearchItems(driver);
		search.searchItem();
		search.close();
		AddToCart addCart = new AddToCart(driver);
		addCart.addToCart();
		ReturningCustomerCheckout checkout = new ReturningCustomerCheckout(driver);
		checkout.checkout();
		checkout.close();
	}

	// Finish connection with WebDriver
	@AfterClass
	public void afterClass() {
		DriverConnection webDriver = new DriverConnection();
		webDriver.tearDown(driver);
	}

}
