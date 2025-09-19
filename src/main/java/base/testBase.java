package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utils.loggerClass;
import utils.extentReportClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.FileReader;
import java.time.Duration;
import java.util.Properties;

public class testBase {
    protected WebDriver driver;
    protected Properties property;
    protected ExtentReports extent;
    protected ExtentTest test;

    @BeforeSuite
    protected void startReport(){
        extent = extentReportClass.getReport();
    }

    @AfterSuite
    protected void flushreport(){
        extent.flush();
    }

    @BeforeClass
    protected void setup() throws Exception{
        loggerClass.logInfo("Driver is Starting...");
        driver = new ChromeDriver();
        property = new Properties();

        loggerClass.logInfo("Loading Property file...");
        FileReader file = new FileReader("./src/test/resources/config.properties");
        property.load(file);

        loggerClass.logInfo("Getting URL...");
        driver.get(property.getProperty("baseURL"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @AfterClass
    protected void tearDown(){
        if(driver!=null){
            loggerClass.logInfo("Driver is Quiting...");
            driver.quit();
            loggerClass.logInfo("************************************************");
        }
    }

}
