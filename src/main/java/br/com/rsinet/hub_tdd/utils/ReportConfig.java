package br.com.rsinet.hub_tdd.utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ReportConfig {


	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;

	public static void setReport() {
		htmlReporter = new ExtentHtmlReporter("./Reports/reportsTestes.html");

		htmlReporter.config().setDocumentTitle("Report");
		htmlReporter.config().setReportName("Report");

		extent = new ExtentReports();

		extent.attachReporter(htmlReporter);
		
	}

	public static ExtentTest createTest(String testName) {
		test = extent.createTest(testName);
		return test;
	}
	
	public static void statusReported(ExtentTest test, ITestResult result, WebDriver driver) throws IOException {
		String screenPath = ScreenshotUtils.getScreenshot(driver, result.getName());
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "Caso de teste FAILED: " + result.getName());
			test.log(Status.FAIL, "Caso de teste FAILED: " + result.getThrowable());
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "Caso de teste SKIPPED: " + result.getName());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "Caso de teste PASSED: " + result.getName());
		}
		test.addScreenCaptureFromPath(screenPath);
	}

	/*fechando*/
	public static void quitExtent() {
		extent.flush();
	}
}
