package commons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/***
 * Class that remove items in to wishlist
 * 
 * @author giovanni.gutierrez
 *
 */
public class RemoveToWishList {

	public WebDriver driver;

	private By btnWlist, btnRemove;

	public RemoveToWishList(WebDriver driver) {
		this.driver = driver;
		btnWlist = By.xpath("//*[@id='wishlist-total']");
		btnRemove = By.xpath("//*[@id='content']/div[1]/table/tbody/tr/td[6]/a");

	}

	public void removeItem() {
		driver.findElement(btnWlist).click();
		driver.findElement(btnRemove).click();
	}
}
