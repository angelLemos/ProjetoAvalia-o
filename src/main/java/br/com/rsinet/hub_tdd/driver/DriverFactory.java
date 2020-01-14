package br.com.rsinet.hub_tdd.driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

	static WebDriver driver;

	private DriverFactory() {
	}

	public static WebDriver inicializarDriver() {
		if (driver == null) {
			driver = new ChromeDriver();
			// driver.manage().window().maximize();
			driver.get("http://www.advantageonlineshopping.com/#/");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		return driver;
	}

	public static void fecharDriver() {
		if (driver != null)
			driver.quit();
		driver = null;
	}
}
