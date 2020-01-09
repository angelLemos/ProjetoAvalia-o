package br.com.rsinet.hub_tdd.formulario;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class CriacaoDeConta_Page {
	
	static WebDriver driver;
	
	@FindBy(how = How.ID, using = "menuUser")
	static WebElement user;
	
	@FindBy(how = How.LINK_TEXT, using = "CREATE NEW ACCOUNT" )
	static WebElement novaConta;
	
	@FindBy(how = How.NAME, using = "usernameRegisterPage")
	static WebElement userName;
	
	@FindBy(how = How.NAME, using = "emailRegisterPage")
	static WebElement email;
	
	@FindBy(how = How.NAME, using = "passwordRegisterPage")
	static WebElement password;
	
	@FindBy(how = How.NAME, using = "confirm_passwordRegisterPage")
	static WebElement confirmPassword;
	
	@FindBy(how = How.NAME, using = "first_nameRegisterPage")
	static WebElement nome;
	
	@FindBy(how = How.NAME, using = "last_nameRegisterPage")
	static WebElement sobrenome;
	
	@FindBy(how = How.NAME, using = "phone_numberRegisterPage")
	static WebElement telefone;
	
	
	public static void main(String[] args) throws InterruptedException{
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.advantageonlineshopping.com/#/");

		PageFactory.initElements(driver, CriacaoDeConta_Page.class);
		
		user.click();
		novaConta.click();
		userName.sendKeys("Angélica");
		email.sendKeys("angelica@gmail.com");
		password.sendKeys("123456");
		confirmPassword.sendKeys("123456");
		nome.sendKeys("Angélica");
		sobrenome.sendKeys("Lemos");
		telefone.sendKeys("1187655272");
		
		
		driver.quit();
		
	
		
		
	}

}
