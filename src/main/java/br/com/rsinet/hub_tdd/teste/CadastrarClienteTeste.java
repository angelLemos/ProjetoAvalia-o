package br.com.rsinet.hub_tdd.teste;

import static br.com.rsinet.hub_tdd.utils.DriverFactory.fecharDriver;
import static br.com.rsinet.hub_tdd.utils.DriverFactory.inicializarDriver;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import br.com.rsinet.hub_tdd.pages.TelaFormularioCadastroPage;
import br.com.rsinet.hub_tdd.pages.TelaInicialPage;
import br.com.rsinet.hub_tdd.utils.ExcelDadosConfig;
import br.com.rsinet.hub_tdd.utils.MassaDeDados;
import br.com.rsinet.hub_tdd.utils.ReportConfig;

public class CadastrarClienteTeste {

	WebDriver driver;
	ExtentReports extensao;
	ExtentTest test;
	JavascriptExecutor js;

	TelaInicialPage telaInicial;

	TelaFormularioCadastroPage formulario;
	private MassaDeDados excel;
	

	
	@BeforeTest
	public void setConfigReport() {
		/*setando o reporte e enviando a string definindo o nome do arquivo report deste teste*/
		ReportConfig.setReport();
	}
	@BeforeMethod
	public void Inicializa() throws Exception {

		driver = inicializarDriver();

		telaInicial = PageFactory.initElements(driver, TelaInicialPage.class);

		formulario = PageFactory.initElements(driver, TelaFormularioCadastroPage.class);
		ExcelDadosConfig.setExcelFile("Planilha1");
		
		excel = new MassaDeDados();
		
	}

	@Test
	public void testeSucessoCadastrarCliente() throws Exception {


		telaInicial.clicarEmMenuUsuario();
		telaInicial.ClicarEmCriarNovaConta();
		formulario.insereNomeUsuario(excel.getUserName());
		formulario.insereEmail(excel.getEmail());
		formulario.insereSenha(excel.getSenha());
		formulario.confirmaSenha(excel.getConfirmarSenha());
		formulario.insereNome(excel.getNome());
		formulario.insereSobrenome(excel.getSobrenome());
		formulario.insereTelefone(excel.getTelefone());
		formulario.selecionaPais(excel.getPais());
		formulario.insereCidade(excel.getCidade());
		formulario.insereEndereco(excel.getEndereco());
		formulario.insereEstado(excel.getEstado());
		formulario.insereCEP(excel.getCEP());
		formulario.ClicarEmAceitarTermos();
		formulario.ClicarEmRegistrar();
		js = (JavascriptExecutor) driver;
		js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 2000);");
		assertEquals(driver.findElement(By.id("menuUserLink")).getText(), excel.getUserName());
		/*definindo teste para o report*/
		test = ReportConfig.createTest("SucessoCadastrarCliente");
	}

	@Test
	// Teste de validação do botao registrar desabilitado sem dados preenchidos
	public void validarBotaoRegistrarDesabilitadoSemDadosPreenchidos() throws Exception {
		js = (JavascriptExecutor) driver;
		js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 3000);");
		telaInicial.clicarEmMenuUsuario();
		telaInicial.ClicarEmCriarNovaConta();
		js = (JavascriptExecutor) driver;
		js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 3000);");
		formulario.ClicarEmAceitarTermos();
		assertFalse(formulario.verificarSeRegistrarEstaDisponivel());

		/*definindo teste para o report*/
		test = ReportConfig.createTest("validarBotaoRegistrarDesabilitado");
	}

	@AfterMethod
	public void finaliza(ITestResult result) throws IOException {
		/*condição para definir o status do teste no report*/
		ReportConfig.statusReported(test, result, driver);

		/*fechando*/
		fecharDriver();
	}
	
	@AfterTest
	public void finalizaReport() {
		ReportConfig.quitExtent();
	}
}