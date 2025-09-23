package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.*;
import utils.LoggerClass;
import utils.ExtentReportClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileReader;
import java.time.Duration;
import java.util.Properties;

public class TestBase {
    protected WebDriver driver;
    protected Properties property;
    protected ExtentReports extent;
    protected ExtentTest test;

    @BeforeSuite
    protected void startReport(){
        extent = ExtentReportClass.getReport();
    }

    @AfterSuite
    protected void flushreport(){
        extent.flush();
    }

    @BeforeClass
    protected void setup() throws Exception{
        LoggerClass.logInfo("Driver is Starting...");
        driver = new ChromeDriver();
        property = new Properties();

        LoggerClass.logInfo("Loading Property file...");
        FileReader file = new FileReader("./src/test/resources/config.properties");
        property.load(file);

        LoggerClass.logInfo("Getting URL...");
        driver.get(property.getProperty("baseURL"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    @AfterClass
    protected void tearDown(){
        if(driver!=null){
            LoggerClass.logInfo("Driver is Quiting...");
            driver.quit();
            LoggerClass.logInfo("************************************************");
        }
    }
    @AfterMethod
    protected void refresh(){
        driver.navigate().refresh();
    }
}
