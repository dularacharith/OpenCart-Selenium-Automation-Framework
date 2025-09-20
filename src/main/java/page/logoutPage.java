package page;
import base.pageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class logoutPage extends pageBase {
    public logoutPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//h1[normalize-space()='Account Logout']")
    private WebElement accountLogoutMsg;

    @FindBy(xpath = "//div[@class='text-end']//a")
    private WebElement accountLogoutCnt;

    public boolean validateAccountLogout(){
        try {
            return wait.until(ExpectedConditions.visibilityOf(accountLogoutMsg)).isDisplayed();
        }
        catch (Exception e){
            return false;
        }
    }
    public void clickAccountLogoutCnt(){
        js.executeScript("arguments[0].click();",accountLogoutCnt);
    }


}
