package br.com.rsinet.hub_tdd.suporte;

import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class RelatorioDeValidacoes {

	private RelatorioDeValidacoes() {

	}

	@Test
	public void validacaoTeste() throws IOException {

		ExtentHtmlReporter reporte = new ExtentHtmlReporter("./Reports/projeto.html");

		ExtentReports extensao = new ExtentReports();

		extensao.attachReporter(reporte);

		ExtentTest logger = extensao.createTest("Cadastro realizado com sucesso!");
		logger.log(Status.INFO, "Usuário Cadastrado!");
		logger.log(Status.PASS, "Cadastro verificado");

		extensao.flush();

		ExtentTest logger2 = extensao.createTest("Cadastro nao realizado!");
		logger2.log(Status.FAIL, "Cadastro verificado");

		logger2.fail("Falha em registrar", MediaEntityBuilder
				.createScreenCaptureFromPath("C:\\Users\\angelica.jesus\\Pictures\\Logotipo.jpg").build());

		logger2.pass("Sucesso em registrar", MediaEntityBuilder
				.createScreenCaptureFromPath("C:\\Users\\angelica.jesus\\Pictures\\Logotipo.jpg").build());

		// logger2.addScreenCaptureFromPath("C:\\Users\\angelica.jesus\\Pictures\\Logotipo.jpg");
		extensao.flush();

	}

}
