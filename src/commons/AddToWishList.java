package commons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddToWishList {

	public static WebDriver driver;

	public AddToWishList(WebDriver webDriver) {
		driver = webDriver;
	}

	public void addToWishList() {

		select(driver, "#content .row button .fa-heart");
		select(driver, "#top-links .list-inline #wishlist-total");
	}

	public static void select(WebDriver driver, String valSelector) {
		WebElement element = driver.findElement(By.cssSelector(valSelector));
		element.click();
	}
}