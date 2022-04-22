package commons;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ReadExcel;

/***
 * Class that runs the checkout process for a returning customer
 * 
 * @author anag.rivera
 *
 */

public class ReturningCustomerCheckout {

	WebDriver driver;
	WebDriverWait wait;
	ReadExcel excel;

	// The driver is received for Constructor
	public ReturningCustomerCheckout(WebDriver webDriver) throws IOException {
		driver = webDriver;
		// Set wait time for the Web Driver
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		// Send to ReadExcel Class the location of the file that contains the input data
		// for checkout
		excel = new ReadExcel("C:\\Academy2204\\YourStore_Team2\\src\\resources\\BillingDetails.xls");
	}

	/***
	 * Principal Method to capture the checkout form using another class for reading
	 * and getting data from an excel file using the Apache POI library
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void checkout() throws IOException, InterruptedException {

		// Wait until find the Checkout button and click in order to go to Checkout Page
		wait.until(
				ExpectedConditions.elementToBeClickable(By.cssSelector("#top-links .list-inline a[title='Checkout']")))
				.click();

		// BILLING DETAILS//
		// Wait until find by Id the inputs and send the values from the excel file for
		// each form field

		wait.until(ExpectedConditions.elementToBeClickable(By.id("input-payment-firstname")))
				.sendKeys(excel.getCellText());
		wait.until(ExpectedConditions.elementToBeClickable(By.id("input-payment-lastname")))
				.sendKeys(excel.getCellText());
		wait.until(ExpectedConditions.elementToBeClickable(By.id("input-payment-company")))
				.sendKeys(excel.getCellText());
		wait.until(ExpectedConditions.elementToBeClickable(By.id("input-payment-address-1")))
				.sendKeys(excel.getCellText());
		wait.until(ExpectedConditions.elementToBeClickable(By.id("input-payment-address-2")))
				.sendKeys(excel.getCellText());
		wait.until(ExpectedConditions.elementToBeClickable(By.id("input-payment-city"))).sendKeys(excel.getCellText());
		wait.until(ExpectedConditions.elementToBeClickable(By.id("input-payment-postcode")))
				.sendKeys(excel.getCellText());
		wait.until(ExpectedConditions.elementToBeClickable(By.id("input-payment-country")))
				.sendKeys(Keys.ENTER + excel.getCellText() + Keys.ENTER);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("input-payment-zone")))
				.sendKeys(Keys.ENTER + excel.getCellText() + Keys.ENTER);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Find by id and Click Continue button in this section for the next step

		WebElement element = driver.findElement(By.id("button-payment-address"));

		// This will scroll the page till the element is found
		js.executeScript("arguments[0].scrollIntoView();", element);

		wait.until(ExpectedConditions.elementToBeClickable(By.id("button-payment-address"))).click();

		// DELIVERY DETAILS

		// Find and Click on payment address radio button and shipping address button
		// Locate fields using their attributes

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='button-shipping-address']"))).click();

		// DELIVERY METHOD//

		// Find and Click on radio button and shipping method button
		// Locate fields using their attributes

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='button-shipping-method']"))).click();

		// PAYMENT METHOD//

		// Wait until find the input and send the value from the excel file
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//textarea[@name='comment']")))
				.sendKeys(excel.getCellText());
		// Find and Click on agree checkbox and payment method button
		// Locate fields using their attributes
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='agree']"))).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='button-payment-method']"))).click();

		// CONFIRM ORDER//

		// Find by Id and Click on Confirm button for finish the process
		wait.until(ExpectedConditions.elementToBeClickable(By.id("button-confirm"))).click();

	}

	/***
	 * Method to close the FileInputStream in order to read the excel file
	 * 
	 * @throws IOException
	 */
	public void close() throws IOException {
		excel.close();
	}

}
