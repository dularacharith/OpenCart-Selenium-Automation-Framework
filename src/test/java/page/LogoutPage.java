package page;
import base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.elements.LogoutPageElements;

public class LogoutPage extends PageBase {
    public LogoutPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = LogoutPageElements.xpathLogoutMassage)
    private WebElement accountLogoutMsg;

    @FindBy(xpath = LogoutPageElements.xpathLogoutContinue)
    private WebElement accountLogoutCnt;

    public boolean validateAccountLogout(){
        try {
            PageBase.explicitWait(accountLogoutMsg);
            return accountLogoutMsg.isDisplayed();
        }
        catch (Exception e){
            return false;
        }
    }
    public void clickAccountLogoutCnt(){
        PageBase.explicitWait(accountLogoutCnt);
        accountLogoutCnt.click();
//        js.executeScript("arguments[0].click();",accountLogoutCnt);
    }
}
