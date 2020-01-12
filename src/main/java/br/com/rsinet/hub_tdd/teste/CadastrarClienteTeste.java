package br.com.rsinet.hub_tdd.teste;

import static br.com.rsinet.hub_tdd.driver.DriverFactory.fecharDriver;
import static br.com.rsinet.hub_tdd.driver.DriverFactory.getDriver;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import br.com.rsinet.hub_tdd.pages.TelaFormularioCadastroPage;
import br.com.rsinet.hub_tdd.pages.TelaInicialPage;

public class CadastrarClienteTeste {

	static WebDriver driver;

	TelaInicialPage telaInicial;

	TelaFormularioCadastroPage formulario;

	@Before

	public void Inicializa() {

		driver = getDriver();

		telaInicial = PageFactory.initElements(driver, TelaInicialPage.class);

		formulario = PageFactory.initElements(driver, TelaFormularioCadastroPage.class);
	}

	@Test
	public void cadastrarCliente() {
		telaInicial.ClicarEmCriarNovaConta();
		formulario.PreencherDetalhesDaConta("Angelica", "angelica.a@hot.com", "A12345", "A12345");
		formulario.PreencherDetalhesPessoais("Angelica", "Lemos", "1190876545");
		formulario.PreencherEndereco("Santos", "Av.Conselheiro", "Sao Paulo", "90876567");
		formulario.ClicarEmAceitarTermos();
		formulario.ClicarEmRegistrar();
	}

	@After
	public void finaliza() {
		fecharDriver();
	}
}
