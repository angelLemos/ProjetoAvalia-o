package br.com.rsinet.hub_tdd.teste;

import static br.com.rsinet.hub_tdd.driver.DriverFactory.fecharDriver;

import static br.com.rsinet.hub_tdd.driver.DriverFactory.inicializarDriver;

//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.rsinet.hub_tdd.pages.TelaInicialPage;
import br.com.rsinet.hub_tdd.pages.TelaListaProdutosPage;

public class ConsultaProdutoTelaTeste {
	static WebDriver driver;

	TelaInicialPage telaInicial;
	TelaListaProdutosPage telaListaProdutos;

	@BeforeMethod

	public void Inicializa() {

		driver = inicializarDriver();

		telaInicial = PageFactory.initElements(driver, TelaInicialPage.class);
		telaListaProdutos = PageFactory.initElements(driver, TelaListaProdutosPage.class);
	}

	@Test
	public void pesquisaProdutoTela() {
		telaInicial.ClicarProdutoTelaInicial();
		telaListaProdutos.SelecionarProdutoDaTela();
	}
		

	@AfterMethod
	public void finaliza() {
		fecharDriver();
	}

}
