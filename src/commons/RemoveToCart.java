package commons;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/***
 * Class that remove items in to shopping cart
 * 
 * @author giovanni.gutierrez
 *
 */
public class RemoveToCart {

	public WebDriver driver;
	WebDriverWait wait;

	public RemoveToCart(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	}

	public void removeItem() throws InterruptedException {

		// wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn-group
		// .btn-block"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("cart-total"))).click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Remove']"))).click();
		Thread.sleep(5000);
	}
}
