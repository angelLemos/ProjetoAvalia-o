package br.com.rsinet.hub_tdd.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class TelaFormularioCadastroPage {
	
	final WebDriver driver;

	@FindBy(how = How.NAME, using = "usernameRegisterPage")
	private WebElement txtUsuario;

	@FindBy(how = How.NAME, using = "emailRegisterPage")
	private WebElement txtEmail;

	@FindBy(how = How.NAME, using = "passwordRegisterPage")
	private WebElement txtSenha;

	@FindBy(how = How.NAME, using = "confirm_passwordRegisterPage")
	private WebElement txtConfirmaSenha;

	@FindBy(how = How.NAME, using = "first_nameRegisterPage")
	private WebElement txtNome;

	@FindBy(how = How.NAME, using = "last_nameRegisterPage")
	private WebElement txtSobrenome;

	@FindBy(how = How.NAME, using = "phone_numberRegisterPage")
	private WebElement txtTelefone;

	@FindBy(how = How.NAME, using = "countryListboxRegisterPage")
	private WebElement cbxPais;

	@FindBy(how = How.NAME, using = "cityRegisterPage")
	private WebElement txtCidade;

	@FindBy(how = How.NAME, using = "addressRegisterPage")
	private WebElement txtEndereco;

	@FindBy(how = How.NAME, using = "state_/_province_/_regionRegisterPage")
	private WebElement txtEstado;

	@FindBy(how = How.NAME, using = "postal_codeRegisterPage")
	private WebElement txtCEP;

	@FindBy(how = How.NAME, using = "i_agree")
	private WebElement chkAceitarTermos;

	@FindBy(how = How.ID, using = "register_btnundefined")
	private WebElement btnRegistrar;
	
	public TelaFormularioCadastroPage (WebDriver driver) {
		this.driver = driver;
	}

	public void PreencherDetalhesDaConta(String userName, String email, String senha, String confirmSenha)
			throws Exception {
		
		txtUsuario.sendKeys(userName);
		txtEmail.sendKeys(email);
		txtSenha.sendKeys(senha);
		txtConfirmaSenha.sendKeys(confirmSenha);

	}

	public void PreencherDetalhesPessoais(String nome, String sobrenome, String telefone) throws IOException {
		txtNome.sendKeys(nome);
		txtSobrenome.sendKeys(sobrenome);
		txtTelefone.sendKeys(telefone);

	}

	public void PreencherEndereco(String pais, String cidade, String endereco, String estado, String cep)
			throws IOException, InterruptedException {
		Thread.sleep(1000);
		cbxPais.sendKeys(pais);
		txtCidade.sendKeys(cidade);
		txtEndereco.sendKeys(endereco);
		txtEstado.sendKeys(estado);
		txtCEP.sendKeys(cep);
	}

	public void ClicarEmAceitarTermos() {
		chkAceitarTermos.click();
	}

	public void ClicarEmRegistrar() {
		btnRegistrar.click();
	}
	
	public boolean verificarSeRegistrarEstaDisponivel() {
		new Actions(driver).moveToElement(btnRegistrar).perform();
		return btnRegistrar.isEnabled();
		
	}

}
