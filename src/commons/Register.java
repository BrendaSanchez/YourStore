package commons;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ReadExcel;

/***
 * Class that runs the checkout process for a returning customer
 * 
 * @author omar.paz
 *
 */

public class Register {

	WebDriver driver;
	WebDriverWait wait;
	ReadExcel excel;

	public Register(WebDriver webDriver) throws IOException {
		driver = webDriver;
		// Set wait time for the Web Driver
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		// Send to ReadExcel Class the location of the file that contains the input data
		// for checkout
		excel = new ReadExcel("C:\\Academy2204\\YourStore_Team2\\src\\resources\\User.xls");
	}

	/***
	 * Principal Method to register a new user form using another class for reading
	 * and getting data from an excel file using the Apache POI library
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void register() throws IOException {

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@title='My Account']"))).click();
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='dropdown-menu dropdown-menu-right']//a")))
				.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='firstname']")))
				.sendKeys(excel.getCellText());
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='lastname']")))
				.sendKeys(excel.getCellText());
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='email']")))
				.sendKeys(excel.getCellText());
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='telephone']")))
				.sendKeys(excel.getCellText());
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='password']")))
				.sendKeys(excel.getCellText());
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='confirm']")))
				.sendKeys(excel.getCellText());
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='radio-inline']/input"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.name("agree"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".buttons .pull-right .btn-primary")))
				.click();

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
