package br.com.rsinet.hub_tdd.formulario;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CriacaoDeConta {
	

	static WebDriver driver = new ChromeDriver();

	public static void main(String[] args) throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		String URL = "http://www.advantageonlineshopping.com/#/";
		driver.get(URL);

		driver.findElement(By.id("menuUserSVGPath")).click();
	
		Thread.sleep(3000);

		driver.findElement(By.linkText("CREATE NEW ACCOUNT")).click();
	

		driver.findElement(By.name("usernameRegisterPage")).sendKeys("Angélica");
	

		driver.findElement(By.name("emailRegisterPage")).sendKeys("angelica@hotmail.com");


		driver.findElement(By.name("passwordRegisterPage")).sendKeys("123456");
		

		driver.findElement(By.name("confirm_passwordRegisterPage")).sendKeys("123456");
		

		driver.findElement(By.name("first_nameRegisterPage")).sendKeys("Angelica");
		

		driver.findElement(By.name("last_nameRegisterPage")).sendKeys("Lemos");
		

		driver.findElement(By.name("phone_numberRegisterPage")).sendKeys("1110203040");
		

		Select select = new Select(driver.findElement(By.name("countryListboxRegisterPage")));
		select.selectByVisibleText("Brazil");
		Thread.sleep(2000);
		select.selectByIndex(29);
		Thread.sleep(2000);

		driver.findElement(By.name("cityRegisterPage")).sendKeys("Santos");
	

		driver.findElement(By.name("addressRegisterPage")).sendKeys("AV. Conselheiro Nébias");
	

		driver.findElement(By.name("state_/_province_/_regionRegisterPage")).sendKeys("São Paulo");
		

		driver.findElement(By.name("postal_codeRegisterPage")).sendKeys("11045003");
	

		driver.findElement(By.name("i_agree")).click();
		

//		driver.findElement(By.id("register_btnundefined")).click();

//		Thread.sleep(3000);
		driver.close();
	}
}