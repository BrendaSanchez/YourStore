package test;

import org.testng.annotations.Test;
import commons.AddToCart;
import commons.AddToWishList;
import commons.DriverConnection;
import commons.LogOut;
import commons.Login;
import commons.Register;
import commons.RemoveToCart;
import commons.RemoveToWishList;
import commons.ReturningCustomerCheckout;
import commons.SearchItems;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;

/***
 * Class that executes the test suite for a web page Your Store
 * 
 * @author Team 2
 *
 */

public class TS_YourStore {

	public WebDriver driver;

	// Test Case 01: Register a new user in "Your Store" page
	@Test(description = "Register new user", priority = 1)
	public void TC01_RegisterUser() throws IOException, InterruptedException {
		Register register = new Register(driver);
		register.register();
		Thread.sleep(5000);
		LogOut logout = new LogOut(driver);
		logout.logOut();
	}

	// Test Case 02: Checkout Items from the shopping cart for a user logged in page
	@Test(description = "Checkout Items for login user", priority = 2)
	public void TC02_CheckoutItems() throws IOException, InterruptedException {
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

	// Test Case 03: Add items to the wishlist for a user logged in page
	@Test(description = "Add items to Wishlist", priority = 3)
	public void TC03_AddWishlist() throws IOException, InterruptedException {
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

	// Test Case 04: Remove items from the shopping cart for a user logged in page
	@Test(description = "Remove items from Cart", priority = 4)
	public void TC04_RemoveItemCart() throws IOException, InterruptedException {
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

	// Test Case 05: Remove items from the wishlist for a user logged in page
	@Test(description = "Remove items from Wishlist", priority = 5)
	public void TC05_RemoveItemWishlist() throws IOException, InterruptedException {
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

	// Set the connection with WebDriver
	@BeforeClass
	public void beforeClass() {
		DriverConnection webDriver = new DriverConnection();
		webDriver.setUp();
		driver = webDriver.driver;
	}

	// Finish connection with WebDriver
	@AfterClass
	public void afterClass() {
		DriverConnection webDriver = new DriverConnection();
		webDriver.tearDown(driver);
	}
}
