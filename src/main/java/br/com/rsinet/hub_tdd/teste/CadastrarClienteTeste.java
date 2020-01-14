package br.com.rsinet.hub_tdd.teste;

import static br.com.rsinet.hub_tdd.driver.DriverFactory.fecharDriver;
import static br.com.rsinet.hub_tdd.driver.DriverFactory.inicializarDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.rsinet.hub_tdd.pages.TelaFormularioCadastroPage;
import br.com.rsinet.hub_tdd.pages.TelaInicialPage;
import br.com.rsinet.hub_tdd.suporte.ExcelDadosConfig;

public class CadastrarClienteTeste {

	private WebDriver driver;

	TelaInicialPage telaInicial;

	TelaFormularioCadastroPage formulario;

	@BeforeMethod
	public void Inicializa() throws Exception {

		driver = inicializarDriver();

		telaInicial = PageFactory.initElements(driver, TelaInicialPage.class);

		formulario = PageFactory.initElements(driver, TelaFormularioCadastroPage.class);

		ExcelDadosConfig.setExcelFile("C:\\Users\\angelica.jesus\\ExcelDados\\dados.xlsx", "Planilha1");

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
		//formulario.ClicarEmRegistrar();
	}

	@AfterMethod
	public void finaliza() {
		 fecharDriver();
	}
}
