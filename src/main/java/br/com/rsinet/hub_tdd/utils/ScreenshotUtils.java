package br.com.rsinet.hub_tdd.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {

	public static String getScreenshot(WebDriver driver, String nomeScreen) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String caminhoDoArquivo = System.getProperty("user.dir") + "/Screenshot/" + nomeScreen + ".png";
		
	
		File destino = new File(caminhoDoArquivo);

		try {
			FileUtils.copyFile(src, destino);
		} catch (IOException e) {
			System.out.println(" O print falhou " + e.getMessage());
		}

		return caminhoDoArquivo;
	}
}