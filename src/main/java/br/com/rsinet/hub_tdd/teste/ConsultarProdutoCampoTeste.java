package br.com.rsinet.hub_tdd.teste;

import static br.com.rsinet.hub_tdd.utils.DriverFactory.fecharDriver;
import static br.com.rsinet.hub_tdd.utils.DriverFactory.inicializarDriver;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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

public class ConsultarProdutoCampoTeste {
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
		ExtentHtmlReporter reporte = new ExtentHtmlReporter("./Reports/pesquisaProdutoCampo.html");

		extensao = new ExtentReports();

		extensao.attachReporter(reporte);

		logger = extensao.createTest("ProdutoCampo");
		
		telaInicial.PesquisarProdutoCampo("Laptops");
		telaListaProdutos.SelecionarProdutoDoCampo();
		Assert.assertEquals("http://www.advantageonlineshopping.com/#/product/11?viewAll=Laptops", driver.getCurrentUrl());
		testName = new Throwable().getStackTrace()[0].getMethodName();
	}
	
	@Test
	public void pesquisarProdutoInexistente() throws InterruptedException {
		ExtentHtmlReporter reporte = new ExtentHtmlReporter("./Reports/pesquisarProdutoInexistente.html");

		extensao = new ExtentReports();

		extensao.attachReporter(reporte);

		logger = extensao.createTest("ProdutoInexistente");
		
		driver.findElement(By.id("menuSearch")).click();
		driver.findElement(By.id("autoComplete")).sendKeys("smartphones");
		driver.findElement(By.id("autoComplete")).sendKeys(Keys.RETURN);
		js = (JavascriptExecutor) driver;
        js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 1000);");
		Assert.assertTrue(driver.getPageSource().contains(" No results for \"smartphones\""));
		testName = new Throwable().getStackTrace()[0].getMethodName();
		
	}

	@AfterMethod
	public void finaliza(ITestResult resultado) throws IOException {
		if (resultado.getStatus() == ITestResult.FAILURE) {
			String tempo = ScreenshotUtils.getScreenshot(driver, testName);
			logger.fail(resultado.getThrowable().getMessage(),
					MediaEntityBuilder.createScreenCaptureFromPath(tempo).build());
		} else if (resultado.getStatus() == ITestResult.SUCCESS) {
			String tempo = ScreenshotUtils.getScreenshot(driver, testName);
			 logger.pass(testName, MediaEntityBuilder.createScreenCaptureFromPath(tempo).build());
		}
		extensao.flush();
		fecharDriver();
	}
}