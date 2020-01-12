package br.com.rsinet.hub_tdd.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TelaInicialPage {

	final WebDriver driver;

	@FindBy(how = How.ID, using = "menuUser")
	public WebElement lnkUser;

	@FindBy(how = How.LINK_TEXT, using = "CREATE NEW ACCOUNT")
	public WebElement lnkCriarNovaConta;

	@FindBy(how = How.ID, using = "miceTxt")
	public WebElement txtPesquisarProdutoTela;

	@FindBy(how = How.NAME, using = "mobile_search")
	public WebElement lnkPesquisaProdutoCampo;

	public TelaInicialPage(WebDriver driver) {
		this.driver = driver;
	}

	public void ClicarEmCriarNovaConta() {
		lnkUser.click();

		// Comando de espera e seleciona o link Criar Nova Conta
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("CREATE NEW ACCOUNT")));
		Actions actions = new Actions(driver);
		actions.moveToElement(lnkCriarNovaConta).click().perform();
		lnkCriarNovaConta.click();
	}

	public void ClicarProdutoTelaInicial() {
		// Seleciona o produto na tela incial
		txtPesquisarProdutoTela.click();
	}

	public void PesquisarProdutoCampo(String nomeProduto) {
		// Busca produto por pesquisa

	    lnkPesquisaProdutoCampo.sendKeys(nomeProduto);
		lnkPesquisaProdutoCampo.sendKeys(Keys.RETURN);



	}

}
