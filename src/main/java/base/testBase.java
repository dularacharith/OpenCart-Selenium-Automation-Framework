package base;

import utils.loggerClass;

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
