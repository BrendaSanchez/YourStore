package commons;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ReadExcel;

/***
 * Class that is responsible for reading an excel and performing the search for
 * elements according to the data read
 * 
 * @author brendal.sanchez
 *
 */
public class SearchItems {

	WebDriver driver;
	WebDriverWait wait;
	ReadExcel excel;

	public SearchItems(WebDriver webDriver) throws IOException {
		driver = webDriver;
		// Set wait time for the Web Driver
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		// Send to ReadExcel Class the location of the file that contains the input data
		// for checkout
		excel = new ReadExcel("C:\\Academy2204\\YourStore_Team2\\src\\resources\\Items.xls");
	}

	/***
	 * Principal Method to capture the checkout form using another class for reading
	 * and getting data from an excel file using the Apache POI library
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void searchItem() throws IOException {
		String value = excel.getCellText();
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.name("search")));
		element.clear();
		element.sendKeys(value + Keys.ENTER);

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".product-layout .product-thumb .image a"))).click();
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