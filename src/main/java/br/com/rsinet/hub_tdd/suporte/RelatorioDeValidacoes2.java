package br.com.rsinet.hub_tdd.suporte;

import static br.com.rsinet.hub_tdd.driver.DriverFactory.fecharDriver;
import static br.com.rsinet.hub_tdd.driver.DriverFactory.inicializarDriver;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class RelatorioDeValidacoes2 {

	ExtentReports extensao;
	ExtentTest logger;
	WebDriver driver;

	@BeforeMethod
	public void configuracao() {

		driver = inicializarDriver();

		ExtentHtmlReporter reporte = new ExtentHtmlReporter("./Reports/projeto1.html");

		extensao = new ExtentReports();

		extensao.attachReporter(reporte);

		logger = extensao.createTest("CadastroTeste");
	}

	@Test
	public void loginTest() throws IOException {
		System.out.println("title is " + driver.getTitle());
		Assert.assertTrue(driver.getTitle().contains("Angélica"));
	}

	@AfterMethod
	public void destruir(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			String tempo = Utilitario.getScreenshot(driver);
			logger.fail(result.getThrowable().getMessage(),
					MediaEntityBuilder.createScreenCaptureFromPath(tempo).build());
		}
		extensao.flush();
		fecharDriver();
	}
}
