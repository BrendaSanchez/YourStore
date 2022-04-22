package commons;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/***
 * Class used for finish a session in the shopping page
 * 
 * @author omar.paz
 *
 */
public class LogOut {

	WebDriver driver;

	public LogOut(WebDriver webDriver) throws IOException {
		driver = webDriver;
	}

	public void logOut() throws IOException {

		// Find by xpath the element in the page needed to logout session
		WebElement myAccount = driver.findElement(By.xpath("//*[@title='My Account']"));
		myAccount.click();
		WebElement logout = driver.findElement(By.xpath("//*[@class='dropdown-menu dropdown-menu-right']//li[5]//a"));
		logout.click();
		WebElement next = driver.findElement(By.xpath("//*[@class='pull-right']//a"));
		next.click();
	}

}