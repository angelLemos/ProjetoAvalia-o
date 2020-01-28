package br.com.rsinet.hub_tdd.teste;

import static br.com.rsinet.hub_tdd.utils.DriverFactory.fecharDriver;
import static br.com.rsinet.hub_tdd.utils.DriverFactory.inicializarDriver;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import br.com.rsinet.hub_tdd.pages.TelaFormularioCadastroPage;
import br.com.rsinet.hub_tdd.pages.TelaInicialPage;
import br.com.rsinet.hub_tdd.utils.ExcelDadosConfig;
import br.com.rsinet.hub_tdd.utils.MassaDeDados;
import br.com.rsinet.hub_tdd.utils.ReportConfig;

public class CadastrarClienteTeste {

	private WebDriver driver;
	private ExtentTest test;
	private WebDriverWait wait;
	private TelaInicialPage telaInicial;
	private TelaFormularioCadastroPage formulario;
	private MassaDeDados excel;
	

	
	@BeforeTest
	public void setConfigReport() {
		//setando o reporte 
		ReportConfig.setReport();
	}
	@BeforeMethod
	public void Inicializa() throws Exception {
        //Inicializando o driver
		driver = inicializarDriver();

		telaInicial = PageFactory.initElements(driver, TelaInicialPage.class);

		formulario = PageFactory.initElements(driver, TelaFormularioCadastroPage.class);
		//nome da planilha no excel
		ExcelDadosConfig.setExcelFile("Planilha1");
		// Instanciando a massa de dados
		excel = new MassaDeDados();
		
		wait = new WebDriverWait(driver, 10);
		
	}

	@Test
	public void testeSucessoCadastrarCliente() throws Exception {

		
		telaInicial.clicarEmMenuUsuario();
		telaInicial.ClicarEmCriarNovaConta();
		
		//Enviando dados da massa para formulario
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
		
		wait.until(ExpectedConditions.urlToBe("http://www.advantageonlineshopping.com/#/"));
		WebElement element = driver.findElement(By.xpath("//*[@id=\"menuUserLink\"]/span"));
		wait.until(ExpectedConditions.visibilityOf(element));
		assertEquals(element.getText(), excel.getUserName());
		
		// definindo teste para o report
		test = ReportConfig.createTest("SucessoCadastrarCliente");
	}

	@Test
	// Teste de validação do botao registrar desabilitado sem dados preenchidos
	public void validarBotaoRegistrarDesabilitadoSemDadosPreenchidos() throws Exception {
		telaInicial.clicarEmMenuUsuario();
		telaInicial.ClicarEmCriarNovaConta();
		formulario.ClicarEmAceitarTermos();
		assertFalse(formulario.verificarSeRegistrarEstaDisponivel());

		//definindo teste para o report
		test = ReportConfig.createTest("validarBotaoRegistrarDesabilitado");
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