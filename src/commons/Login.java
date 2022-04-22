package commons;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ReadExcel;


/***
 * Class used for the start a new session in the shopping page
 * 
 * @author omar.paz
 *
 */

public class Login {

	WebDriver driver;
	WebDriverWait wait;
	ReadExcel excel;

	public Login(WebDriver webDriver) throws IOException {
		driver = webDriver;
		// Set wait time for the Web Driver
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		// Send to ReadExcel Class the location of the file that contains the input data
		// for checkout
		excel = new ReadExcel("C:\\Academy2204\\YourStore_Team2\\src\\resources\\LoginUser.xls");
	}

	/***
	 * Principal Method to capture the login form using another class for reading
	 * and getting data from an excel file using the Apache POI library
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void login() throws IOException {

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@title='My Account']"))).click();
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@class='dropdown-menu dropdown-menu-right']//li[2]//a"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='email']")))
				.sendKeys(excel.getCellText());
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='password']")))
				.sendKeys(excel.getCellText());
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Login']"))).click();

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
