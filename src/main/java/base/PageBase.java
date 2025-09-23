package base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageBase {

    protected WebDriver driver;
    protected static WebDriverWait wait;
    protected JavascriptExecutor js;

    protected PageBase(WebDriver driver){
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver,Duration.ofSeconds(3));
        js = (JavascriptExecutor) driver;
    }
    protected static void explicitWait(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

}
