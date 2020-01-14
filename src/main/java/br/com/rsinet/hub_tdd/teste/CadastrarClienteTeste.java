package br.com.rsinet.hub_tdd.teste;

import static br.com.rsinet.hub_tdd.driver.DriverFactory.fecharDriver;
import static br.com.rsinet.hub_tdd.driver.DriverFactory.getDriver;

import java.io.IOException;

//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import br.com.rsinet.hub_tdd.pages.TelaFormularioCadastroPage;
import br.com.rsinet.hub_tdd.pages.TelaInicialPage;

public class CadastrarClienteTeste {

	static WebDriver driver;

	TelaInicialPage telaInicial;

	TelaFormularioCadastroPage formulario;

	@BeforeMethod

	public void Inicializa() throws IOException {

		driver = getDriver();

		telaInicial = PageFactory.initElements(driver, TelaInicialPage.class);

		formulario = PageFactory.initElements(driver, TelaFormularioCadastroPage.class);
		
		System.out.println("Cadastro realizado com sucesso!");

		ExtentHtmlReporter reporte = new ExtentHtmlReporter("./Reports/formulario.html");

		ExtentReports extensao = new ExtentReports();

		extensao.attachReporter(reporte);

		ExtentTest logger = extensao.createTest("Cadastrado com sucesso!");
		logger.log(Status.INFO, "Cadastro realizado com sucesso!");
		logger.log(Status.PASS, "Cadastro verificado");

		extensao.flush();

		ExtentTest logger2 = extensao.createTest("Cadastro nao realizado!");
		logger2.log(Status.FAIL, "Cadastro verificado");

		logger2.fail("Falha em registrar", MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\angelica.jesus\\Pictures\\Logotipo.jpg").build());
		
		logger2.pass("Sucesso em registrar", MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\angelica.jesus\\Pictures\\Logotipo.jpg").build());
		
		//logger2.addScreenCaptureFromPath("C:\\Users\\angelica.jesus\\Pictures\\Logotipo.jpg");
		extensao.flush();
		
	}

	@Test
	public void cadastrarCliente() {
		telaInicial.ClicarEmCriarNovaConta();
		formulario.PreencherDetalhesDaConta("Angelica", "angelica.a@hot.com", "A12345", "A12345");
		formulario.PreencherDetalhesPessoais("Angelica", "Lemos", "1190876545");
		formulario.PreencherEndereco("Santos", "Av.Conselheiro", "Sao Paulo", "90876567");
		formulario.ClicarEmAceitarTermos();
		//formulario.ClicarEmRegistrar();
	}

	@AfterMethod
	public void finaliza() {
		fecharDriver();
	}
}
