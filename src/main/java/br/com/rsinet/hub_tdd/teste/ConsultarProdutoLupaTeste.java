package br.com.rsinet.hub_tdd.teste;

import static br.com.rsinet.hub_tdd.utils.DriverFactory.fecharDriver;
import static br.com.rsinet.hub_tdd.utils.DriverFactory.inicializarDriver;
import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import br.com.rsinet.hub_tdd.pages.TelaInicialPage;
import br.com.rsinet.hub_tdd.pages.TelaListaProdutosPage;
import br.com.rsinet.hub_tdd.utils.ScreenshotUtils;

public class ConsultarProdutoLupaTeste {
	static WebDriver driver;

	TelaInicialPage telaInicial;
	TelaListaProdutosPage telaListaProdutos;
	ExtentReports extensao;
	ExtentTest logger;
	JavascriptExecutor js;

	private String testName;

	@BeforeMethod

	public void Inicializa() {
		driver = inicializarDriver();

		telaInicial = PageFactory.initElements(driver, TelaInicialPage.class);
		telaListaProdutos = PageFactory.initElements(driver, TelaListaProdutosPage.class);

	}

	@Test
	public void pesquisaProdutoCampo() {
		// Geracao de report 
		ExtentHtmlReporter reporte = new ExtentHtmlReporter("./Reports/pesquisaProdutoCampo.html");

		extensao = new ExtentReports();

		extensao.attachReporter(reporte);
		
		telaInicial.inserirProduto("Laptops");
		telaListaProdutos.SelecionarProdutoDoCampo();
		js = (JavascriptExecutor) driver;
        js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 1000);");
		Assert.assertEquals("http://www.advantageonlineshopping.com/#/product/11?viewAll=Laptops", driver.getCurrentUrl());
		testName = new Throwable().getStackTrace()[0].getMethodName();
		logger = extensao.createTest("Pesquisa produto campo");
	}
	
	@Test
	public void pesquisarProdutoInexistente() throws InterruptedException {

		telaInicial.clicarNaLupa();
		telaInicial.inserirProduto("smartphones");
		js = (JavascriptExecutor) driver;
		js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 2000);");
		
		String textoElement = driver.findElement(By.xpath("/html[1]/body[1]/div[3]/section[1]/article[1]/div[3]/div[1]/label[1]/span[1]")).getText();
		assertEquals(textoElement, "No results for \"smartphones\"");
		testName = new Throwable().getStackTrace()[0].getMethodName();
		
		logger = extensao.createTest("Produto Inexistente");
		
	}

	@AfterMethod
	public void finaliza(ITestResult resultado) throws IOException {
		if (resultado.getStatus() == ITestResult.FAILURE) {
			String tempo = ScreenshotUtils.getScreenshot(driver, testName);
			logger.fail(resultado.getThrowable().getMessage(),
					MediaEntityBuilder.createScreenCaptureFromPath(tempo).build());
		} else
		if (resultado.getStatus() == ITestResult.SUCCESS) {
			String tempo = ScreenshotUtils.getScreenshot(driver, testName);
			 logger.pass(testName, MediaEntityBuilder.createScreenCaptureFromPath(tempo).build());
		}
		extensao.flush();
		fecharDriver();
	}
}
