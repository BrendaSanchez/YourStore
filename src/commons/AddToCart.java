package commons;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/***
 * Class in order to add items to Cart after a search
 * 
 * @author anag.rivera
 *
 */
public class AddToCart {

	WebDriver driver;
	WebDriverWait wait;

	public AddToCart(WebDriver driver) {

		this.driver = driver;
		// Set wait time for the Web Driver
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	}

	public void addToCart() throws InterruptedException {

		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='button-cart']"))).click();

	}
}
