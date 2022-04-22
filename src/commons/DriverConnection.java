package commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverConnection {

	/***
	 * Class to establish a connection with the Web Driver
	 * 
	 * @author anag.rivera
	 *
	 */

	public WebDriver driver;

	public WebDriver setUp() {

		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://opencart.abstracta.us/");
		return driver;
	}

	public void tearDown(WebDriver driver) {
		driver.quit();
	}
}
