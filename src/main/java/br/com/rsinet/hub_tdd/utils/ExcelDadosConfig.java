package br.com.rsinet.hub_tdd.utils;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDadosConfig {

	private static XSSFSheet ExcelWSheet;

	private static XSSFWorkbook ExcelWBook;

	private static XSSFCell Cell;

//Este método é definir o caminho do arquivo e abrir o arquivo do Excel, passar o caminho do Excel e o nome da folha como argumentos para este método

	public static void setExcelFile(String nomeDoArquivo) throws Exception {

		try {

			// Abre o arquivo do Excel

			FileInputStream ExcelFile = new FileInputStream("C:\\Users\\angelica.jesus\\Desktop\\dados.xlsx");

			// Acessa a folha de dados de teste necessária

			ExcelWBook = new XSSFWorkbook(ExcelFile);

			ExcelWSheet = ExcelWBook.getSheet(nomeDoArquivo);

		} catch (Exception e) {

			throw (e);

		}

	}

//Este método é para ler os dados de teste da célula do Excel, neste estamos passando parâmetros como numero da linha e numero da coluna 
	
	public static String getCellData(int numeroDaLinha, int numeroDaColuna) throws Exception {

		try {

			Cell = ExcelWSheet.getRow(numeroDaLinha).getCell(numeroDaColuna);

			String CellData = Cell.getStringCellValue();

			return CellData;

		} catch (Exception e) {

			return "";

		}

	}

}
