package br.com.rsinet.hub_tdd.teste;

import static br.com.rsinet.hub_tdd.driver.DriverFactory.inicializarDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import br.com.rsinet.hub_tdd.pages.TelaFormularioCadastroPage;
import br.com.rsinet.hub_tdd.pages.TelaInicialPage;
import br.com.rsinet.hub_tdd.suporte.ExcelDadosConfig;
import br.com.rsinet.hub_tdd.suporte.Utilitario;

public class CadastrarClienteTeste {

	WebDriver driver;
	ExtentReports extensao;
	ExtentTest logger;

	TelaInicialPage telaInicial;

	TelaFormularioCadastroPage formulario;

	@BeforeMethod
	public void Inicializa() throws Exception {

		driver = inicializarDriver();

		telaInicial = PageFactory.initElements(driver, TelaInicialPage.class);

		formulario = PageFactory.initElements(driver, TelaFormularioCadastroPage.class);

		ExcelDadosConfig.setExcelFile("target/Excel/dados.xlsx", "Planilha1");
		//ExcelDadosConfig.setExcelFile("C:\\Users\\angelica.jesus\\ExcelDados\\dados.xlsx", "Planilha1");

		// Report
		ExtentHtmlReporter reporte = new ExtentHtmlReporter("./Reports/cadastro.html");

		extensao = new ExtentReports();

		extensao.attachReporter(reporte);

		logger = extensao.createTest("CadastroTeste");

	}

	@Test
	public void cadastrarCliente() throws Exception {

		// String criarConta = ExcelDadosConfig.getCellData(1, 12);
		String userName = ExcelDadosConfig.getCellData(1, 0);
		String email = ExcelDadosConfig.getCellData(1, 1);
		String confirmSenha = ExcelDadosConfig.getCellData(1, 2);
		String senha = ExcelDadosConfig.getCellData(1, 3);

		String nome = ExcelDadosConfig.getCellData(1, 4);
		String sobrenome = ExcelDadosConfig.getCellData(1, 5);
		String telefone = ExcelDadosConfig.getCellData(1, 6);
		String pais = ExcelDadosConfig.getCellData(1, 7);
		String cidade = ExcelDadosConfig.getCellData(1, 8);
		String endereco = ExcelDadosConfig.getCellData(1, 9);
		String estado = ExcelDadosConfig.getCellData(1, 10);
		String cep = ExcelDadosConfig.getCellData(1, 11);

		telaInicial.ClicarEmCriarNovaConta();
		formulario.PreencherDetalhesDaConta(userName, email, senha, confirmSenha);
		formulario.PreencherDetalhesPessoais(nome, sobrenome, telefone);
		formulario.PreencherEndereco(pais, cidade, endereco, estado, cep);
		formulario.ClicarEmAceitarTermos();
		formulario.ClicarEmRegistrar();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.findElement(By.id("speakersTxt"));
		Assert.assertEquals(driver.getCurrentUrl(), "http://www.advantageonlineshopping.com/");
	}

	@AfterTest
	public void finaliza(ITestResult resultado) throws IOException {
		if (resultado.getStatus() == ITestResult.FAILURE || resultado.getStatus() == ITestResult.SUCCESS) {
			String tempo = Utilitario.getScreenshot(driver);
			logger.fail(resultado.getThrowable().getMessage(),
					MediaEntityBuilder.createScreenCaptureFromPath(tempo).build());
//			logger.pass(resultado.getThrowable().getMessage(),
//					MediaEntityBuilder.createScreenCaptureFromPath(tempo).build());
			

		}
		extensao.flush();
		//fecharDriver();
	}
}
