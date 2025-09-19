package base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class pageBase {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected JavascriptExecutor js;

    protected pageBase(WebDriver driver){
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        js = (JavascriptExecutor) driver;
    }

}
