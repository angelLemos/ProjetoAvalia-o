package br.com.rsinet.hub_tdd.pages;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class TelaFormularioCadastroPage {
	
	final WebDriver driver;
	JavascriptExecutor js;

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


	public void insereNomeUsuario(String nomeUsuario) throws Exception {

		txtUsuario.sendKeys(nomeUsuario);
	}

	public void insereEmail(String email) throws Exception {
		txtEmail.sendKeys(email);
	}

	public void insereSenha(String senha) throws Exception {
		txtSenha.sendKeys(senha);
	}

	public void confirmaSenha(String confirmSenha) throws Exception {
		txtConfirmaSenha.sendKeys(confirmSenha);

	}

	public void insereNome(String nome) throws IOException {
		txtNome.sendKeys(nome);
	}

	public void insereSobrenome(String sobrenome) throws IOException {

		txtSobrenome.sendKeys(sobrenome);
	}

	public void insereTelefone(String telefone) throws IOException {
		txtTelefone.sendKeys(telefone);

	}

	public void selecionaPais(String pais) throws IOException, InterruptedException {
		js = (JavascriptExecutor) driver;
		js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 2000);");
		cbxPais.sendKeys(pais);
	}

	public void insereCidade(String cidade) throws IOException, InterruptedException {
		txtCidade.sendKeys(cidade);
	}

	public void insereEndereco(String endereco) throws IOException, InterruptedException {
		txtEndereco.sendKeys(endereco);
	}

	public void insereEstado(String estado) throws IOException, InterruptedException {
		txtEstado.sendKeys(estado);
	}

	public void insereCEP(String cep) throws IOException, InterruptedException {
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

