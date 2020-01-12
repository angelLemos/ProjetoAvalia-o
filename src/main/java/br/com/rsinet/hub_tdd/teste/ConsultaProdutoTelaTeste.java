package br.com.rsinet.hub_tdd.teste;

import static br.com.rsinet.hub_tdd.driver.DriverFactory.fecharDriver;
import static br.com.rsinet.hub_tdd.driver.DriverFactory.getDriver;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import br.com.rsinet.hub_tdd.pages.TelaInicialPage;
import br.com.rsinet.hub_tdd.pages.TelaListaProdutosPage;

public class ConsultaProdutoTelaTeste {
	static WebDriver driver;

	TelaInicialPage telaInicial;
	TelaListaProdutosPage telaListaProdutos;

	@Before

	public void Inicializa() {

		driver = getDriver();

		telaInicial = PageFactory.initElements(driver, TelaInicialPage.class);
		telaListaProdutos = PageFactory.initElements(driver, TelaListaProdutosPage.class);
	}

	@Test
	public void pesquisaProdutoTela() {
		telaInicial.ClicarProdutoTelaInicial();
		telaListaProdutos.SelecionarProdutoDaTela();
	}
		

	@After
	public void finaliza() {
		fecharDriver();
	}

}
