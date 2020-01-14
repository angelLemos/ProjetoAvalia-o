package report;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class RelatorioDeValidacoes {
	
	private RelatorioDeValidacoes() {

	}

	
	public void validacaoTeste(String nomeHtml, String localImagem ) throws IOException {

		System.out.println("Cadastro realizado com sucesso!");

		ExtentHtmlReporter reporte = new ExtentHtmlReporter(nomeHtml);

		ExtentReports extensao = new ExtentReports();

		extensao.attachReporter(reporte);

		ExtentTest logger = extensao.createTest("Cadastrado com sucesso!");
		logger.log(Status.INFO, "Cadastro realizado com sucesso!");
		logger.log(Status.PASS, "Cadastro verificado");

		extensao.flush();

		ExtentTest logger2 = extensao.createTest("Cadastro nao realizado!");
		logger2.log(Status.FAIL, "Cadastro verificado");

		logger2.fail("Falha em registrar", MediaEntityBuilder.createScreenCaptureFromPath(localImagem).build());
		
		logger2.pass("Sucesso em registrar", MediaEntityBuilder.createScreenCaptureFromPath(localImagem).build());
		
		//logger2.addScreenCaptureFromPath("C:\\Users\\angelica.jesus\\Pictures\\Logotipo.jpg");
		extensao.flush();

	}

}
