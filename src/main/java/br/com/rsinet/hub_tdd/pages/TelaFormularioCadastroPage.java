package br.com.rsinet.hub_tdd.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class TelaFormularioCadastroPage {

	final WebDriver driver;

	@FindBy(how = How.NAME, using = "usernameRegisterPage")
	public WebElement txtUsuario;

	@FindBy(how = How.NAME, using = "emailRegisterPage")
	public WebElement txtEmail;

	@FindBy(how = How.NAME, using = "passwordRegisterPage")
	public WebElement txtSenha;

	@FindBy(how = How.NAME, using = "confirm_passwordRegisterPage")
	public WebElement txtConfirmaSenha;

	@FindBy(how = How.NAME, using = "first_nameRegisterPage")
	public WebElement txtNome;

	@FindBy(how = How.NAME, using = "last_nameRegisterPage")
	public WebElement txtSobrenome;

	@FindBy(how = How.NAME, using = "phone_numberRegisterPage")
	public WebElement txtTelefone;

	@FindBy(how = How.NAME, using = "countryListboxRegisterPage")
	public WebElement cbxPais;

	@FindBy(how = How.NAME, using = "cityRegisterPage")
	public WebElement txtCidade;

	@FindBy(how = How.NAME, using = "addressRegisterPage")
	public WebElement txtEndereco;

	@FindBy(how = How.NAME, using = "state_/_province_/_regionRegisterPage")
	public WebElement txtEstado;

	@FindBy(how = How.NAME, using = "postal_codeRegisterPage")
	public WebElement txtCEP;

	@FindBy(how = How.NAME, using = "i_agree")
	public WebElement chkAceitarTermos;

	@FindBy(how = How.ID, using = "register_btnundefined")
	public WebElement btnRegistrar;

	public TelaFormularioCadastroPage(WebDriver driver)

	{
		this.driver = driver;

	}

	public void PreencherDetalhesDaConta(String usuario, String email, String senha, String confirmaSenha) {
		txtUsuario.sendKeys(usuario);
		txtEmail.sendKeys(email);
		txtSenha.sendKeys(senha);
		txtConfirmaSenha.sendKeys(confirmaSenha);

	}

	public void PreencherDetalhesPessoais(String nome, String sobrenome, String telefone) {
		txtNome.sendKeys(nome);
		txtSobrenome.sendKeys(sobrenome);
		txtTelefone.sendKeys(telefone);

	}

	public void PreencherEndereco(String cidade, String endereco, String estado, String cep) {

		// Seleciona Pais
		Select select = new Select(cbxPais);
		select.selectByVisibleText("Brazil");

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

}
