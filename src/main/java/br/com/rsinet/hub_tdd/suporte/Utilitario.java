package br.com.rsinet.hub_tdd.suporte;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utilitario {

	public static String getScreenshot(WebDriver driver) {
		TakesScreenshot ts = (TakesScreenshot) driver;

		File src = ts.getScreenshotAs(OutputType.FILE);

		String caminhoDoArquivo = System.getProperty("user.dir") + "/Screenshot/" + System.currentTimeMillis() + ".png";

		File destino = new File(caminhoDoArquivo);

		try {
			FileUtils.copyFile(src, destino);
		} catch (IOException e) {
			System.out.println(" O print falhou " + e.getMessage());
		}

		return caminhoDoArquivo;
	}

}