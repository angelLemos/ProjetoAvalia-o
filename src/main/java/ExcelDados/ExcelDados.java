package ExcelDados;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDados {
	
	public static void main(String[] args) throws IOException {
		
		File src = new File("C:\\Users\\angelica.jesus\\ExcelDados\\dados.xlsx");
		
		FileInputStream fis = new FileInputStream(src);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		XSSFSheet sheet1 =  wb.getSheetAt(0);
		String data0 = sheet1.getRow(1).getCell(1).getStringCellValue();
		
		System.out.println("Data from Excel is " + data0);
	}

}
