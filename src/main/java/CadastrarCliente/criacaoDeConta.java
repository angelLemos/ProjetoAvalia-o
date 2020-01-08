package CadastrarCliente;

import static DriverFactory.DriverFactory.fecharDriver;
import static DriverFactory.DriverFactory.getDriver;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;


public class criacaoDeConta {


	@Before
	public void inicializa() {
		getDriver().get("https://www.advantageonlineshopping.com/#/");

	}
	@After
	public void finaliza() {
		fecharDriver();

	}
	
//@Test
//	public void teste() {
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.findElement(By.id("menuUserSVGPath")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.linkText("CREATE NEW ACCOUNT")).click();
//		driver.findElement(By.name("usernameRegisterPage")).sendKeys("Angélica");
//		driver.findElement(By.name("emailRegisterPage")).sendKeys("angelica@gmail.com");
//		driver.findElement(By.name("passwordRegisterPage")).sendKeys("123456");
//		driver.findElement(By.name("confirm_passwordRegisterPage")).sendKeys("123456");
//		driver.findElement(By.name("first_nameRegisterPage")).sendKeys("Angélica");
//		driver.findElement(By.name("last_nameRegisterPage")).sendKeys("Lemos");
//		driver.findElement(By.name("phone_numberRegisterPage")).sendKeys("1187655272");
//		
//
//	}

}
