 package br.com.rsinet.hub_tdd.teste;

import static br.com.rsinet.hub_tdd.utils.DriverFactory.fecharDriver;
import static br.com.rsinet.hub_tdd.utils.DriverFactory.inicializarDriver;
import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import br.com.rsinet.hub_tdd.pages.TelaInicialPage;
import br.com.rsinet.hub_tdd.pages.TelaListaProdutosPage;
import br.com.rsinet.hub_tdd.utils.ReportConfig;

public class ConsultaProdutoTelaTeste {
	static WebDriver driver;

	private TelaInicialPage telaInicial;
	private TelaListaProdutosPage telaListaProdutos;
	private ExtentReports extensao;
	private ExtentTest test;
	private JavascriptExecutor js;
	private WebDriverWait wait;
	

	@BeforeTest
	public void setConfigReport() {
		//setando o reporte e enviando a string definindo o nome do arquivo report deste teste
		ReportConfig.setReport();
	}

	@BeforeMethod
	public void Inicializa() {

		driver = inicializarDriver();

		telaInicial = PageFactory.initElements(driver, TelaInicialPage.class);
		telaListaProdutos = PageFactory.initElements(driver, TelaListaProdutosPage.class);
		
		
	}

	@Test
	public void pesquisaProdutoTela() {
	
		
		telaInicial.ClicarProdutoTelaInicial();
		telaListaProdutos.SelecionarProdutoDaTela();
		Assert.assertEquals(driver.getCurrentUrl(), "http://www.advantageonlineshopping.com/#/product/31");
//		wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[3]/section[1]/article[1]/div[2]/div[2]/h1[1]")));
		js = (JavascriptExecutor) driver;
        js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 1000);");
        test = ReportConfig.createTest("pesquisaProdutoTela");
      
	}
	
	@Test
	public void validarAberturaProdutoErrado() {
		
		telaInicial.ClicaEmNotebookTelaInicial();
		String textoElement = driver.findElement(By.xpath("/html[1]/body[1]/div[3]/section[1]/article[1]/div[2]/div[2]/h1[1]")).getText();
		assertEquals( textoElement, "HP CHROMEBOOK 14 G1(ES)");
		test = ReportConfig.createTest("validarAberturaProdutoErrado");
	
	}
	

	@AfterMethod
	public void finaliza(ITestResult result) throws IOException {
		//condição para definir o status do teste no report
		ReportConfig.statusReported(test, result, driver);

		//fechando
		fecharDriver();
	}
	
	@AfterTest
	public void finalizaReport() {
		ReportConfig.quitExtent();
	}
}
