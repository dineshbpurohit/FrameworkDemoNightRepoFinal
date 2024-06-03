package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {
	
	public static ExtentReports getExtentReport() {
		String extentReportPath = System.getProperty("user.dir")+"\\reports\\extentreport.html";
		
		ExtentSparkReporter reporter = new ExtentSparkReporter(extentReportPath);
		reporter.config().setReportName("TutorialNinja Login");
		reporter.config().setDocumentTitle("Test Results");
		
		ExtentReports extentReport = new ExtentReports();
		extentReport.attachReporter(reporter);
		extentReport.setSystemInfo("Operating System", "Window10");
		extentReport.setSystemInfo("Tested By", "Phani");
		
		return extentReport;
		
	}

}
