package br.com.rsinet.hub_tdd.teste;

import static br.com.rsinet.hub_tdd.utils.DriverFactory.fecharDriver;
import static br.com.rsinet.hub_tdd.utils.DriverFactory.inicializarDriver;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import br.com.rsinet.hub_tdd.pages.TelaFormularioCadastroPage;
import br.com.rsinet.hub_tdd.pages.TelaInicialPage;
import br.com.rsinet.hub_tdd.utils.ExcelDadosConfig;
import br.com.rsinet.hub_tdd.utils.ScreenshotUtils;

public class CadastrarClienteTeste {

	WebDriver driver;
	ExtentReports extensao;
	ExtentTest logger;

	TelaInicialPage telaInicial;

	TelaFormularioCadastroPage formulario;
	private String testName;

	@BeforeMethod
	public void Inicializa() throws Exception {

		driver = inicializarDriver();

		telaInicial = PageFactory.initElements(driver, TelaInicialPage.class);

		formulario = PageFactory.initElements(driver, TelaFormularioCadastroPage.class);

		ExcelDadosConfig.setExcelFile("target/Excel/dados.xlsx", "Planilha1");

//		ExtentHtmlReporter reporte = new ExtentHtmlReporter("./Reports/cadastroCliente.html");
//
//		extensao = new ExtentReports();
//
//		extensao.attachReporter(reporte);
//
//		logger = extensao.createTest("Cadastro Realizado!");

	}

	@Test
	public void testeSucessoCadastrarCliente() throws Exception {

		String userName = ExcelDadosConfig.getCellData(1, 0);
		String email = ExcelDadosConfig.getCellData(1, 1);
		String senha = ExcelDadosConfig.getCellData(1, 2);
		String confirmSenha = ExcelDadosConfig.getCellData(1, 3);

		String nome = ExcelDadosConfig.getCellData(1, 4);
		String sobrenome = ExcelDadosConfig.getCellData(1, 5);
		String telefone = ExcelDadosConfig.getCellData(1, 6);
		String pais = ExcelDadosConfig.getCellData(1, 7);
		String cidade = ExcelDadosConfig.getCellData(1, 8);
		String endereco = ExcelDadosConfig.getCellData(1, 9);
		String estado = ExcelDadosConfig.getCellData(1, 10);
		String cep = ExcelDadosConfig.getCellData(1, 11); 

		ExtentHtmlReporter reporte = new ExtentHtmlReporter("./Reports/cadastroCliente.html");

		extensao = new ExtentReports();

		extensao.attachReporter(reporte);

		logger = extensao.createTest("Cadastro Realizado!");

		telaInicial.ClicarEmCriarNovaConta();
		formulario.PreencherDetalhesDaConta(userName, email, senha, confirmSenha);
		formulario.PreencherDetalhesPessoais(nome, sobrenome, telefone);
		formulario.PreencherEndereco(pais, cidade, endereco, estado, cep);
		formulario.ClicarEmAceitarTermos();
		formulario.ClicarEmRegistrar();
//		WebDriverWait wait = new WebDriverWait(driver, 20);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("menuUserLink")));
		Thread.sleep(4000);
		assertEquals(userName, driver.findElement(By.id("menuUserLink")).getText());
		testName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test
	// Teste de validação do botao registrar desabilitado sem dados preenchidos
	public void validarBotaoRegistrarDesabilitadoSemDadosPreenchidos() throws Exception {
		ExtentHtmlReporter reporte = new ExtentHtmlReporter("./Reports/validacaoBotao.html");

		extensao = new ExtentReports();

		extensao.attachReporter(reporte);

		logger = extensao.createTest("Validacao botao registrar");

		telaInicial.ClicarEmCriarNovaConta();
		formulario.ClicarEmAceitarTermos();
		assertFalse(formulario.verificarSeRegistrarEstaDisponivel());
	   testName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@AfterMethod
	public void finaliza(ITestResult resultado) throws IOException {
		if (resultado.getStatus() == ITestResult.FAILURE) {
			String tempo = ScreenshotUtils.getScreenshot(driver, testName );
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

