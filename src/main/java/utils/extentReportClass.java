package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class extentReportClass {

    private static ExtentTest test;
    private static ExtentReports report;

    public static ExtentReports getReport(){

        if(report==null){
            String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
            String reportPath = "./reports/ExtReport_"+timestamp+".html";
            ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
            reporter.config().setDocumentTitle("Test Report");
            reporter.config().setReportName("Automation Test Execution Report");
            report = new ExtentReports();
            report.attachReporter(reporter);
        }

        return report;
    }

    public static ExtentTest createTest(String testName){
        test = getReport().createTest(testName);
        return test;
    }


}
