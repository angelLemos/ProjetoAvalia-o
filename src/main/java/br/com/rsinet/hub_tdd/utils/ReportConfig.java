//package br.com.rsinet.hub_tdd.utils;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//
//public class ReportConfig {
//
//	static ExtentReports extensao;
//	static ExtentTest logger;
//
//	public static ExtentReports gerarReport() {
//		ExtentHtmlReporter reporte = new ExtentHtmlReporter("./Reports/formularioTestes.html");
//
//		extensao = new ExtentReports();
//
//		extensao.attachReporter(reporte);
//		return extensao;
//
//	}
//
//	public static ExtentTest criarTeste(String testName) {
//		logger = extensao.createTest(testName);
//		return logger;
//
//	}
//	
//	public static void statusReport(Exten)
//}
