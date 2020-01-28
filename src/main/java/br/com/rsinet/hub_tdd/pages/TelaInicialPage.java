package br.com.rsinet.hub_tdd.pages;

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

	@FindBy(how = How.ID, using = "menuUserLink")
	private WebElement lnkUser;

	@FindBy(how = How.LINK_TEXT, using = "CREATE NEW ACCOUNT")
	private WebElement lnkCriarNovaConta;

	@FindBy(how = How.ID, using = "miceTxt")
	private WebElement txtPesquisarProdutoTela;
	
	@FindBy(how = How.ID, using = "details_10")
	private WebElement txtSelecionaProdutoDaTela;

	@FindBy(how = How.ID, using = "menuSearch")
	private WebElement lnkClicarLupa;
	
	@FindBy(how = How.ID, using = "autoComplete")
	private WebElement txtInserirNomeProduto;

	public TelaInicialPage(WebDriver driver) {
		this.driver = driver;
	}
	

	public void clicarEmMenuUsuario() {
		lnkUser.click();
	}

	public void ClicarEmCriarNovaConta() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("CREATE NEW ACCOUNT")));
		Actions actions = new Actions(driver);
		actions.moveToElement(lnkCriarNovaConta).click().perform();
		lnkCriarNovaConta.click();
      
	}
	
	public void ClicaEmNotebookTelaInicial() {
		// clica em notebook da tela inicial, para verificar abertura de outro produto
		txtSelecionaProdutoDaTela.click();
	}

	public void ClicarProdutoTelaInicial() {
		// Seleciona o produto na tela incial
		txtPesquisarProdutoTela.click();
	}
	
	public void clicarNaLupa() throws InterruptedException {
		lnkClicarLupa.click();
	}

	public void inserirProduto(String nomeProduto) {
		txtInserirNomeProduto.sendKeys(nomeProduto);
		txtInserirNomeProduto.sendKeys(Keys.RETURN);

	}

}
